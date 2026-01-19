package com.carro.admin.ui.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;
import com.carro.admin.R;
import com.carro.admin.api.ApiClient;
import com.carro.admin.api.ApiInterface;
import com.carro.admin.api.response.BookingDetailsResponse;
import com.carro.admin.api.response.commonResponse.BaseResponse;
import com.carro.admin.databinding.ActivityRentalDetailsBinding;
import com.carro.admin.databinding.SelectStatusDialogBinding;
import com.carro.admin.model.BookingListModel;
import com.carro.admin.model.LoginModel;
import com.carro.admin.ui.common.BaseActivity;
import com.carro.admin.utils.Constant;
import com.carro.admin.utils.DateFormater;
import com.carro.admin.utils.PreferenceUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RentalDetailsActivity extends BaseActivity {
    private static final String TAG = "RentalDetailsActivity"; // Added for logging

    String bookingId = "";
    String statusId = "";
    Dialog dialog;

    private ActivityRentalDetailsBinding binding;
    private BookingListModel rentalModel;

    private List<String> statusList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRentalDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Hide the main content view initially until data is loaded
        binding.main.setVisibility(View.INVISIBLE);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // The new entry point for fetching data
        getIntentDataAndSetupToolbar();
    }

    private void getIntentDataAndSetupToolbar() {
        // Step 1: Get the Booking ID passed from the adapter
        bookingId = getIntent().getStringExtra(Constant.BundleExtras.BOOKING_ID);

        if (bookingId != null && !bookingId.isEmpty()) {
            Log.d(TAG, "Received Booking ID: " + bookingId);
            // Step 2: Fetch the full details from the API using the ID
            bookingDetailsApi();
        } else {
           // Toast.makeText(this, "Error: Booking ID not found.", Toast.LENGTH_SHORT).show();
            finish();
        }

        // Setup toolbar using user preference data
        String userData = PreferenceUtils.getString(Constant.PreferenceConstant.USER_DATA, this);
        if (userData != null && !userData.isEmpty()) {
            LoginModel loginModel = new Gson().fromJson(userData, LoginModel.class);
            setUpToolBar(binding.toolbar, this, loginModel.getmAdminImg());
        }
    }

    private void bookingDetailsApi() {
        showLoader();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        // Assuming your ApiInterface has a method named 'bookingDetails'
        Call<BookingDetailsResponse> call = apiInterface.bookingDetails(bookingId);
        call.enqueue(new Callback<BookingDetailsResponse>() {
            @Override
            public void onResponse(Call<BookingDetailsResponse> call, Response<BookingDetailsResponse> response) {
                hideLoader();
                if (response.isSuccessful() && response.body() != null && response.body().getResult().equalsIgnoreCase(Constant.SUCCESS_RESPONSE)) {
                    // Step 3: Get the complete RentalModel from the response
                    rentalModel = response.body().getData();
                    Log.d(TAG, "Successfully fetched full details. Car Name from API: " + rentalModel.getmCtypeTitle());
                    // Step 4: Populate the entire UI with the complete data
                    setData();
                } else {
                    Toast.makeText(RentalDetailsActivity.this, "Failed to load booking details.", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "API response was not successful or body was null.");
                }
            }

            @Override
            public void onFailure(Call<BookingDetailsResponse> call, Throwable t) {
                hideLoader();
                Toast.makeText(RentalDetailsActivity.this, "Something went wrong: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "API call failed.", t);
            }
        });
    }

    private void setData() {
        if (rentalModel == null) {
            Log.e(TAG, "setData called, but rentalModel is null. Cannot populate UI.");
            return;
        }
        // Make the main layout visible now that we have data
        binding.main.setVisibility(View.VISIBLE);

        binding.btnUpdateStatus.setOnClickListener(v -> selectStatusDialog());

        // Booking Details
        setRowData(binding.rowBookingId.getRoot(), "Booking ID", formatValue("#", rentalModel.getmBookingId(), ""));

        String bookingStatus;
        switch (rentalModel.getmBkingStatus()) {
            case "2": bookingStatus = "Accepted"; break;
            case "3": bookingStatus = "Completed"; break;
            case "4": bookingStatus = "Cancelled"; break;
            default: bookingStatus = "Pending"; break;
        }
        setRowDataWithStyling(binding.rowBookingStatus.getRoot(), "Status", bookingStatus, R.drawable.status_pending_background, R.color.brown);

        setRowData(binding.rowBranch.getRoot(), "Branch", rentalModel.getmBranchTitle());
        String bookingDateTime = DateFormater.changeDateFormat("yyyy-MM-dd HH:mm:ss", "dd-MM-yyyy hh:mm a", rentalModel.getmBkingAddedon());
        setRowData(binding.rowBookingDateTime.getRoot(), "Booking Date & Time", bookingDateTime);

        setPickupReturn(binding.rowPickupDateTime.getRoot(), "Pickup Date & Time", rentalModel.getmBkingPickup(), rentalModel.getmBkingPickupAt());
        setPickupReturn(binding.rowReturnDateTime.getRoot(), "Return Date & Time", rentalModel.getmBkingReturn(), rentalModel.getmBkingReturnAt());

        // Customer Details
        setRowData(binding.rowCustomerName.getRoot(), "Customer Name", rentalModel.getmCustName());
        setRowData(binding.rowCustomerMobile.getRoot(), "Mobile No.", formatValue("+91 ", rentalModel.getmCustMobile(), ""));
        setRowData(binding.rowCustomerCity.getRoot(), "City", rentalModel.getmCustCity());
        checkSectionVisibility(binding.containerCustomerData, binding.tvNoCustomerData, binding.rowCustomerName.getRoot(), binding.rowCustomerMobile.getRoot(), binding.rowCustomerCity.getRoot());

        // Car Details
        Log.d(TAG, "Populating Car Details section. Car Name: " + rentalModel.getmCtypeTitle());
        setRowData(binding.rowCarTypeName.getRoot(), "Car Name", rentalModel.getmCtypeTitle());
        setRowData(binding.rowDriveType.getRoot(), "Drive Type", "1".equals(rentalModel.getmCtypeDrivetype()) ? "Manual" : "Automatic");
        setRowData(binding.rowSeat.getRoot(), "Seats", rentalModel.getmCtypeSeat());
        setRowData(binding.rowCarNumber.getRoot(), "Car Number", rentalModel.getmCtypeNumber());
        setRowData(binding.rowLuggage.getRoot(), "Luggage", rentalModel.getmCtypeLuggage());
        setRowData(binding.rowFuel.getRoot(), "Fuel", "1".equals(rentalModel.getmCtypeFuel()) ? "Diesel" : "Petrol");
       // setRowData(binding.rowFuel.getRoot(), "Fuel", "1".equals(rentalModel.getmCtypeFuel()) ? "Diesel" : "Petrol");
        checkSectionVisibility(binding.containerCarData, binding.tvNoCarData, binding.rowCarTypeName.getRoot(), binding.rowDriveType.getRoot(), binding.rowSeat.getRoot(), binding.rowCarNumber.getRoot(), binding.rowLuggage.getRoot(), binding.rowFuel.getRoot());

        // Payment & Package Details
        setRowData(binding.rowKm.getRoot(), "KM Limit", formatValue("", rentalModel.getmBkingKm(), " KM"));
        //setRowData(binding.rowFastag.getRoot(), "Fastag", formatValue("₹ ", rentalModel.getmBkingFastag(), ""));
        setRowData(binding.rowTotal.getRoot(), "Total", formatValue("₹ ", rentalModel.getmBkingTotal(), ""));
        String amountPaid = (rentalModel.getmBkingPaidAmt() == null || rentalModel.getmBkingPaidAmt().trim().isEmpty()) ? "0" : rentalModel.getmBkingPaidAmt();
        setRowData(binding.rowAmountPaid.getRoot(), "Amount Paid", formatValue("₹ ", amountPaid, ""));
        setRowData(binding.rowAmountRemains.getRoot(), "Amount Remains", formatValue("₹ ", rentalModel.getmBkingRemainAmt(), ""));
        setRowData(binding.rowPaymode.getRoot(), "Paymode", "1".equals(rentalModel.getmBkingPaymode()) ? "Online" : "Cash");

        // Payment Status
        String paymentStatus;
        switch (rentalModel.getmBkingPayStatus()) {
            case "1": paymentStatus = "Paid"; break;
            case "2": paymentStatus = "Advanced"; break;
            default: paymentStatus = "Unpaid"; break;
        }
        int paymentBg = "Paid".equals(paymentStatus) ? R.drawable.status_pending_background : R.drawable.payment_unpaid_background;
        int paymentColor = "Paid".equals(paymentStatus) ? R.color.green : R.color.red;
        setRowDataWithStyling(binding.rowPaymentStatus.getRoot(), "Payment Status", paymentStatus, paymentBg, paymentColor);
    }

    // --- All Helper Methods Below Are Correct and Unchanged ---

    private void setPickupReturn(View row, String label, String date, String time) {
        if (date == null || date.trim().isEmpty() || "0000-00-00".equals(date)) {
            setRowData(row, label, null);
        } else {
            String formattedDate = DateFormater.changeDateFormat(Constant.yyyyMMdd, Constant.ddMMyyyy, date);
            String formattedTime = "";
            if (time != null && !time.trim().isEmpty() && !"00:00:00".equals(time)) {
                formattedTime = " " + DateFormater.changeDateFormat(Constant.HHMMSS, Constant.HHMMSSA, time);
            }
            setRowData(row, label, formattedDate + formattedTime);
        }
    }

    private void setRowData(View row, String label, String value) {
        row.setVisibility(View.VISIBLE);
        TextView tvLabel = row.findViewById(R.id.tvLabel);
        TextView tvValue = row.findViewById(R.id.tvValue);
        tvLabel.setText(label);
        tvValue.setText((value == null || value.trim().isEmpty()) ? "N/A" : value);
    }

    private void setRowDataWithStyling(View row, String label, String value, int backgroundRes, int textColor) {
        if (value == null || value.trim().isEmpty() || value.equalsIgnoreCase("N/A")) {
            row.setVisibility(View.GONE);
            return;
        }
        row.setVisibility(View.VISIBLE);
        TextView tvLabel = row.findViewById(R.id.tvLabel);
        TextView tvValue = row.findViewById(R.id.tvValue);
        tvLabel.setText(label);
        tvValue.setText(value);
        tvValue.setBackgroundResource(backgroundRes);
        tvValue.setTextColor(ContextCompat.getColor(this, textColor));
        tvValue.setPadding(16, 8, 16, 8);
    }

    private String formatValue(String prefix, String value, String suffix) {
        if (value == null || value.trim().isEmpty()) return null;
        return prefix + value + suffix;
    }

    private void checkSectionVisibility(LinearLayout dataContainer, TextView noDataTextView, View... rows) {
        boolean hasVisibleRow = false;
        for (View row : rows) {
            if (row.getVisibility() == View.VISIBLE) {
                hasVisibleRow = true;
                break;
            }
        }
        dataContainer.setVisibility(hasVisibleRow ? View.VISIBLE : View.GONE);
        noDataTextView.setVisibility(hasVisibleRow ? View.GONE : View.VISIBLE);
    }

    private void selectStatusDialog() {
        statusList.clear();
        statusList.add("Select Status");
        statusList.add("Pending");
        statusList.add("Accepted");
        statusList.add("Completed");
        statusList.add("Cancelled");

        SelectStatusDialogBinding selectStatusDialogBinding = SelectStatusDialogBinding.inflate(getLayoutInflater());
        dialog = new Dialog(RentalDetailsActivity.this, R.style.my_dialog);
        dialog.setCancelable(false);
        dialog.setContentView(selectStatusDialogBinding.getRoot());
        dialog.show();

        ArrayAdapter<String> statusAdapter = new ArrayAdapter<>(RentalDetailsActivity.this, R.layout.spinner_item, statusList);
        statusAdapter.setDropDownViewResource(R.layout.spinner_item);
        selectStatusDialogBinding.spStatus.setAdapter(statusAdapter);

        selectStatusDialogBinding.spStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                statusId = String.valueOf(i);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });

        selectStatusDialogBinding.btnCancel.setOnClickListener(View -> dialog.dismiss());
        selectStatusDialogBinding.btnSave.setOnClickListener(View -> {
            if (!statusId.equals("0")) {
                updateStatusApi();
                dialog.dismiss();
            } else {
                Toast.makeText(this, "Please select a valid status.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateStatusApi() {
        if (rentalModel == null) return;
        showLoader();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<BaseResponse> call = apiInterface.updateStatus(rentalModel.getmBkingId(), statusId);
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                hideLoader();
                try {
                    if (response.isSuccessful() && response.body() != null) {
                        if (response.body().getResult().equalsIgnoreCase(Constant.SUCCESS_RESPONSE)) {
                            Toast.makeText(RentalDetailsActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            // Re-fetch the details to ensure UI is perfectly in sync with server
                            bookingDetailsApi();
                        } else {
                            Toast.makeText(RentalDetailsActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RentalDetailsActivity.this, "Failed to update status", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(RentalDetailsActivity.this, "An error occurred.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                hideLoader();
                Toast.makeText(RentalDetailsActivity.this, "Something went wrong: "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
