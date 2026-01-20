


package com.carro.admin.ui.activity;

import static com.carro.admin.utils.Utils.formatDate;

import android.app.Dialog;
import android.os.Bundle;
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

import com.carro.admin.R;
import com.google.gson.Gson;
import com.carro.admin.api.ApiClient;
import com.carro.admin.api.ApiInterface;
import com.carro.admin.api.response.BookingDetailsResponse;
import com.carro.admin.api.response.VendorListResponse;
import com.carro.admin.api.response.commonResponse.BaseResponse;
import com.carro.admin.databinding.ActivityBookingDetailsBinding;
import com.carro.admin.databinding.SelectStatusDialogBinding;
import com.carro.admin.databinding.SelectVendorDialogBinding;
import com.carro.admin.model.BookingListModel;
import com.carro.admin.model.LoginModel;
import com.carro.admin.model.VendorListModel;
import com.carro.admin.ui.common.BaseActivity;
import com.carro.admin.utils.Constant;
import com.carro.admin.utils.DateFormater;
import com.carro.admin.utils.PreferenceUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingDetailsActivity extends BaseActivity {

    ActivityBookingDetailsBinding binding;
    BookingListModel bookingListModels = new BookingListModel();
    List<VendorListModel> vendorListModels = new ArrayList<>();
    List<String> statusList = new ArrayList<>();

    String bookingId = "";
    String bookingTypeId = "";
    String bookingTypeCat = "";
    String vendorId = "";
    String statusId = "";
    Dialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookingDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getBookingPreference();
    }

    private void getBookingPreference() {
        bookingId = getIntent().getStringExtra(Constant.BundleExtras.BOOKING_ID);
        bookingTypeId = getIntent().getStringExtra(Constant.BundleExtras.BOOKING_TYPE);
        bookingTypeCat = getIntent().getStringExtra(Constant.BundleExtras.BOOKING_TYPE_CAT);
        initiateBookingDetails();
    }

    /**
     * Safely formats a value with a prefix and suffix, returning null if the value is empty.
     */
    private String formatValue(String prefix, String value, String suffix) {
        if (value == null || value.trim().isEmpty()) {
            return null; // This will cause setRowData to hide the row.
        }
        return prefix + value + suffix;
    }

    /**
     * Checks if any row in a section is visible. If not, it shows the 'no data' message.
     */
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

    private void setData() {
        if (bookingListModels == null) return;

        // 1. Generate and Set Titles
        String serviceName = generateServiceName();
//        binding.toolbar.setTitle(serviceName + " Details");
        setRowData(binding.rowService.getRoot(), "Service", serviceName);

        // 2. Set Booking Details
        setRowData(binding.rowBookingId.getRoot(), "Booking ID", bookingListModels.getmBookingId());






        String pickupDate = bookingListModels.getmBkingPickup();
        if (pickupDate == null || pickupDate.trim().isEmpty() || "0000-00-00".equals(pickupDate)) {
            // If date is invalid, hide the entire row
            setRowData(binding.rowPickupDateTime.getRoot(), "Pickup Date & Time", null);
        } else {
            // Date is valid, format it
            String formattedDate = DateFormater.changeDateFormat(Constant.yyyyMMdd, Constant.ddMMyyyy, pickupDate);

            // Now check and format the time
            String pickupTime = bookingListModels.getmBkingPickupAt();
            String formattedTime = "";
            if (pickupTime != null && !pickupTime.trim().isEmpty() && !"00:00:00".equals(pickupTime)) {
                formattedTime = " " + DateFormater.changeDateFormat(Constant.HHMMSS, Constant.HHMMSSA, pickupTime);
            }

            // Combine and set the final string
            setRowData(binding.rowPickupDateTime.getRoot(), "Pickup Date & Time", formattedDate + formattedTime);
        }











//        String pickupDateTime = DateFormater.changeDateFormat(Constant.yyyyMMdd, Constant.ddMMyyyy, bookingListModels.getmBkingPickup()) + " " +
//                DateFormater.changeDateFormat(Constant.HHMMSS, Constant.HHMMSSA, bookingListModels.getmBkingPickupAt());
//        setRowData(binding.rowPickupDateTime.getRoot(), "Pickup Date & Time", pickupDateTime);


        setRowData(binding.rowBranch.getRoot(), "Branch", bookingListModels.getmBranchTitle());








// Handle Return Date & Time with special case checks
        String returnDate = bookingListModels.getmBkingReturn();
        if (returnDate == null || returnDate.trim().isEmpty() || "0000-00-00".equals(returnDate)) {
            // If date is invalid, hide the entire row
            setRowData(binding.rowReturnDateTime.getRoot(), "Return Date & Time", null);
        } else {
            // Date is valid, format it
            String formattedDate = DateFormater.changeDateFormat(Constant.yyyyMMdd, Constant.ddMMyyyy, returnDate);

            // Now check and format the time
            String returnTime = bookingListModels.getmBkingReturnAt();
            String formattedTime = "";
            if (returnTime != null && !returnTime.trim().isEmpty() && !"00:00:00".equals(returnTime)) {
                formattedTime = " " + DateFormater.changeDateFormat(Constant.HHMMSS, Constant.HHMMSSA, returnTime);
            }

            // Combine and set the final string
            setRowData(binding.rowReturnDateTime.getRoot(), "Return Date & Time", formattedDate + formattedTime);
        }








//        String returnDateTime = DateFormater.changeDateFormat(Constant.yyyyMMdd, Constant.ddMMyyyy, bookingListModels.getmBkingReturn()) + " " +
//                DateFormater.changeDateFormat(Constant.HHMMSS, Constant.HHMMSSA, bookingListModels.getmBkingReturnAt());
//        setRowData(binding.rowReturnDateTime.getRoot(), "Return Date & Time", returnDateTime);






        String bookingDateTime = DateFormater.changeDateFormat("yyyy-MM-dd HH:mm:ss", "dd-MM-yyyy hh:mm a", bookingListModels.getmBkingAddedon());
        setRowData(binding.rowBookingDateTime.getRoot(), "Booking Date & Time", bookingDateTime);

        // Location fields (visibility handled later)
        setRowData(binding.rowPickupLocation.getRoot(), "Pickup Location", bookingListModels.getmBkingPickupAddress());
        setRowData(binding.rowDropLocation.getRoot(), "Drop Location", bookingListModels.getmBkingDropAddress());
        setRowData(binding.rowFromDestination.getRoot(), "From Destination", bookingListModels.getmBkingFrom());
        setRowData(binding.rowToDestination.getRoot(), "To Destination", bookingListModels.getmBkingTo());

        // 3. Set Customer Details
        setRowData(binding.rowCustomerName.getRoot(), "Customer Name", bookingListModels.getmCustName());
        setRowData(binding.rowCustomerMobile.getRoot(), "Mobile No.", formatValue("+91 ", bookingListModels.getmCustMobile(), ""));
        setRowData(binding.rowCustomerCity.getRoot(), "City", bookingListModels.getmCustCity());
        checkSectionVisibility(binding.containerCustomerData, binding.tvNoCustomerData,
                binding.rowCustomerName.getRoot(), binding.rowCustomerMobile.getRoot(), binding.rowCustomerCity.getRoot());

        // 4. Set Vendor Details

            setRowData(binding.rowVendorName.getRoot(), "Vendor Name", bookingListModels.getmVendorName());
            setRowData(binding.rowVendorMobile.getRoot(), "Mobile No.", formatValue("+91 ", bookingListModels.getmVendorMobile(), ""));
            setRowData(binding.rowVendorCity.getRoot(), "City", bookingListModels.getmVendorCity());
            checkSectionVisibility(binding.containerVendorData, binding.tvNoVendorData,
                    binding.rowVendorName.getRoot(), binding.rowVendorMobile.getRoot(), binding.rowVendorCity.getRoot());

        if (bookingTypeId.equals("1")) {
            binding.vendorCard.setVisibility(View.VISIBLE);
        }else{
            binding.vendorCard.setVisibility(View.GONE);
        }


        // 5. Set Dynamic Sections (Car/Bus)
        binding.cardCarDetails.setVisibility(View.GONE);
        binding.cardBusDetails.setVisibility(View.GONE);

        switch (bookingTypeId) {
            case "1": // Cab
                binding.vendorCard.setVisibility(View.VISIBLE);
            case "3": // Luxury
                binding.cardCarDetails.setVisibility(View.VISIBLE);
                setRowData(binding.rowCarTypeName.getRoot(), "Car Type Name", bookingListModels.getmCtypeTitle());
                setRowData(binding.rowDriveType.getRoot(), "Drive Type", "1".equals(bookingListModels.getmCtypeDrivetype()) ? "Manual" : "Automatic");
                setRowData(binding.rowSeat.getRoot(), "Seat", bookingListModels.getmCtypeSeat());
                setRowData(binding.rowCarNumber.getRoot(), "Car Number", bookingListModels.getmCtypeNumber());
                setRowData(binding.rowLuggage.getRoot(), "Luggage", bookingListModels.getmCtypeLuggage());
                setRowData(binding.rowFuel.getRoot(), "Fuel", "1".equals(bookingListModels.getmCtypeFuel()) ? "Petrol" : "Diesel");
                checkSectionVisibility(binding.containerCarData, binding.tvNoCarData,
                        binding.rowCarTypeName.getRoot(), binding.rowDriveType.getRoot(), binding.rowSeat.getRoot(),
                        binding.rowCarNumber.getRoot(), binding.rowLuggage.getRoot(), binding.rowFuel.getRoot());
                break;
            case "4": // Bus
                binding.cardBusDetails.setVisibility(View.VISIBLE);
                setRowData(binding.rowBusName.getRoot(), "Bus Name", bookingListModels.getmBusTitle());
                setRowData(binding.rowBusPrice.getRoot(), "Price", formatValue("₹ ", bookingListModels.getmBusPrice(), ""));
                setRowData(binding.rowBusKm.getRoot(), "KM", bookingListModels.getmBusKm());
                checkSectionVisibility(binding.containerBusData, binding.tvNoBusData,
                        binding.rowBusName.getRoot(), binding.rowBusPrice.getRoot(), binding.rowBusKm.getRoot());
                break;
        }

        // 6. Set Dynamic Payment and Location Details
        setPaymentDetails();
        setLocationDetails();
        setDriverDetails();
        setCarDetails();
        setTripCharges();
    }
    private void setCarDetails() {
        binding.cardCar2Details.setVisibility(View.VISIBLE);
        setRowData(binding.rowCar2Number.getRoot(), "Car Number", bookingListModels.getmCarNumber());
        setRowData(binding.rowFuelType.getRoot(), "Fuel Type", bookingListModels.getmCarFuel());
        setRowData(binding.rowVehicleCategory.getRoot(), "Vehicle Category", bookingListModels.getmCarVehicleCategory());
        setRowData(binding.rowFitUpTo.getRoot(), "Fit Up To",  DateFormater.formatTimestamp( bookingListModels.getmCarFitUpto()));
        setRowData(binding.rowRegistrationDate.getRoot(), "Registration Date", DateFormater.formatTimestamp( bookingListModels.getmCarRegistrationDate()));
        setRowData(binding.rowOwnerName.getRoot(), "Owner Name", bookingListModels.getmCarOwnerName());
        setRowData(binding.rowFatherName.getRoot(), "Father Name", bookingListModels.getmCarFatherName());
        setRowData(binding.rowPresentAddress.getRoot(), "Present Address",bookingListModels.getmCarPresentAddress());
        setRowData(binding.rowPermanentAddress.getRoot(), "Permanent Address", bookingListModels.getmCarPermanentAddress());
        setRowData(binding.rowChassisNumber.getRoot(), "Chassis Number", bookingListModels.getmCarChassisNumber());
        setRowData(binding.rowEngineNumber.getRoot(), "Engine Number", bookingListModels.getmCarEngineNumber());
        setRowData(binding.rowMaker.getRoot(), "Maker", bookingListModels.getmCarMaker());
        setRowData(binding.rowModel.getRoot(), "Model", bookingListModels.getmCarModel());
        setRowData(binding.rowBodyType.getRoot(), "Body Type", bookingListModels.getmCarBodyType());
        setRowData(binding.rowColor.getRoot(), "Color", bookingListModels.getmCarColor());
        setRowData(binding.rowManufacturingDate.getRoot(), "Manufacturing Date", DateFormater.formatTimestamp( bookingListModels.getmCarManufacturingDate()));
        setRowData(binding.rowInsuranceCompany.getRoot(), "Insurance Company", bookingListModels.getmCarInsuranceCompany());
        setRowData(binding.rowPolicyNumber.getRoot(), "Policy Number", bookingListModels.getmCarInsurancePolicyNumber());
        setRowData(binding.rowInsuranceValidUpto.getRoot(), "Insurance Valid Upto", DateFormater.formatTimestamp( bookingListModels.getmCarInsuranceUpto()));
        setRowData(binding.rowTaxValidUpto.getRoot(), "Tax Valid Upto", DateFormater.formatTimestamp( bookingListModels.getmCarTaxUpto()));
        setRowData(binding.rowPuccNumber.getRoot(), "PUCC Number", bookingListModels.getmCarPuccNumber());
        setRowData(binding.rowPuccValidUpto.getRoot(), "PUCC Valid Upto", DateFormater.formatTimestamp( bookingListModels.getmCarPuccUpto()));
        setRowData(binding.rowPermitNumber.getRoot(), "Permit Number", bookingListModels.getmCarPermitNumber());
        setRowData(binding.rowPermitIssueDate.getRoot(), "Permit Issue Date", DateFormater.formatTimestamp( bookingListModels.getmCarPermitIssueDate()));
        setRowData(binding.rowPermitValidFrom.getRoot(), "Permit Valid From", DateFormater.formatTimestamp(bookingListModels.getmCarPermitValidFrom()));
        setRowData(binding.rowPermitValidUpto.getRoot(), "Permit Valid Upto", DateFormater.formatTimestamp( bookingListModels.getmCarPermitValidUpto()));
        setRowData(binding.rowPermitType.getRoot(), "Permit Type", bookingListModels.getmCarPermitType());
        setRowData(binding.rowNonUseStatus.getRoot(), "Non-Use Status", bookingListModels.getmCarNonUseStatus());
        checkSectionVisibility(
                binding.containerCar2Data,
                binding.tvNoCar2Data,
                binding.rowCar2Number.getRoot(),
                binding.rowFuelType.getRoot(),
                binding.rowVehicleCategory.getRoot(),
                binding.rowFitUpTo.getRoot(),
                binding.rowRegistrationDate.getRoot(),
                binding.rowOwnerName.getRoot(),
                binding.rowFatherName.getRoot(),
                binding.rowPresentAddress.getRoot(),
                binding.rowPermanentAddress.getRoot(),
                binding.rowChassisNumber.getRoot(),
                binding.rowEngineNumber.getRoot(),
                binding.rowMaker.getRoot(),
                binding.rowModel.getRoot(),
                binding.rowBodyType.getRoot(),
                binding.rowColor.getRoot(),
                binding.rowManufacturingDate.getRoot(),
                binding.rowInsuranceCompany.getRoot(),
                binding.rowPolicyNumber.getRoot(),
                binding.rowInsuranceValidUpto.getRoot(),
                binding.rowTaxValidUpto.getRoot(),
                binding.rowPuccNumber.getRoot(),
                binding.rowPuccValidUpto.getRoot(),
                binding.rowPermitNumber.getRoot(),
                binding.rowPermitIssueDate.getRoot(),
                binding.rowPermitValidFrom.getRoot(),
                binding.rowPermitValidUpto.getRoot(),
                binding.rowPermitType.getRoot(),
                binding.rowNonUseStatus.getRoot()
        );
    }

    private void setTripCharges() {
//        setRowData(binding.rowDriverName.getRoot(), "Name", bookingListModels.getmDriverName());
//        setRowData(binding.rowDriverMoNo.getRoot(), "Mobile Number",  bookingListModels.getmDriverMobile());
//        setRowData(binding.rowLicExpiry.getRoot(), "Licence Expiry Date",  bookingListModels.getmDriverLicExDate());
//        checkSectionVisibility(binding.containerDriverData,binding.tvNoDriverData,binding.rowDriverName.getRoot(),binding.rowDriverMoNo.getRoot(),binding.rowLicExpiry.getRoot());
//        binding.cardDriverDetails.setVisibility(View.VISIBLE);
    }
    private void setDriverDetails() {
        setRowData(binding.rowDriverName.getRoot(), "Name", bookingListModels.getmDriverName());
        setRowData(binding.rowDriverMoNo.getRoot(), "Mobile Number",  bookingListModels.getmDriverMobile());
        setRowData(binding.rowLicExpiry.getRoot(), "Licence Expiry Date",  bookingListModels.getmDriverLicExDate());
        checkSectionVisibility(binding.containerDriverData,binding.tvNoDriverData,binding.rowDriverName.getRoot(),binding.rowDriverMoNo.getRoot(),binding.rowLicExpiry.getRoot());
        binding.cardDriverDetails.setVisibility(View.VISIBLE);
    }
    private void setPaymentDetails() {
        // Hide all optional fields by default
        binding.rowRentalCharges.getRoot().setVisibility(View.GONE);
        binding.rowDiscount.getRoot().setVisibility(View.GONE);
        binding.rowHour.getRoot().setVisibility(View.GONE);
        binding.rowKm.getRoot().setVisibility(View.GONE);

        // Common payment fields
        setRowData(binding.rowPaymode.getRoot(), "Paymode", "1".equals(bookingListModels.getmBkingPaymode()) ? "Online" : "Cash");
        setRowData(binding.rowTotal.getRoot(), "Total", formatValue("₹ ", bookingListModels.getmBkingTotal(), ""));
        String amountPaid = (bookingListModels.getmBkingPaidAmt() == null || bookingListModels.getmBkingPaidAmt().trim().isEmpty()) ? "0" : bookingListModels.getmBkingPaidAmt();
        setRowData(binding.rowAmountPaid.getRoot(), "Amount Paid", formatValue("₹ ", amountPaid, ""));
        setRowData(binding.rowAmountRemains.getRoot(), "Amount Remains", formatValue("₹ ", bookingListModels.getmBkingRemainAmt(), ""));

        // Styled Status rows
        String paymentStatus = "1".equals(bookingListModels.getmBkingPayStatus()) ? "Paid" : "Un-Paid";
        int paymentBg = "Paid".equals(paymentStatus) ? R.drawable.status_pending_background : R.drawable.payment_unpaid_background;
        int paymentColor = "Paid".equals(paymentStatus) ? R.color.green : R.color.red;
        setRowDataWithStyling(binding.rowPayment.getRoot(), "Payment", paymentStatus, paymentBg, paymentColor);

        String bookingStatus = "Pending";
        switch (bookingListModels.getmBkingStatus()) { case "2": bookingStatus = "Accepted"; break; case "3": bookingStatus = "Completed"; break; case "4": bookingStatus = "Cancelled"; break; }
        setRowDataWithStyling(binding.rowStatus.getRoot(), "Status", bookingStatus, R.drawable.status_pending_background, R.color.brown);

        // Logic for specific fields based on booking type
        switch (bookingTypeId) {
            case "1": // Cab
                String rentalLabel = "Rental Charges (Per Km)";
                if ("1".equals(bookingTypeCat)) { // City Ride
                    rentalLabel = "Rental Charges (Per Hour)";
                    setRowData(binding.rowHour.getRoot(), "Hour", bookingListModels.getmBkingHour());
                }
                setRowData(binding.rowRentalCharges.getRoot(), rentalLabel, formatValue("₹ ", bookingListModels.getmBkingPrice(), ""));
                setRowData(binding.rowKm.getRoot(), "KM", bookingListModels.getmBkingKm());
                break;
            case "3": // Luxury



            case "4": // Bus
                setRowData(binding.rowRentalCharges.getRoot(), "Rental Charges", formatValue("₹ ", bookingListModels.getmBkingPrice(), ""));
                String discountAmount = bookingListModels.getmBkingDamt();
                String discountCode = bookingListModels.getmBkingDis();
                if (discountAmount != null && !discountAmount.trim().isEmpty()) {
                    String discountText = "- ₹ " + discountAmount;
                    if (discountCode != null && !discountCode.trim().isEmpty()){
                        discountText += " (" + discountCode + ")";
                    }
                    setRowData(binding.rowDiscount.getRoot(), "Discount", discountText);
                }
                break;
        }
    }

    private void setLocationDetails(){
        if ("1".equals(bookingTypeId)) {
            binding.rowFromDestination.getRoot().setVisibility(View.GONE);
            binding.rowToDestination.getRoot().setVisibility(View.GONE);
            binding.rowPickupLocation.getRoot().setVisibility(View.VISIBLE);
            binding.rowDropLocation.getRoot().setVisibility(View.VISIBLE);
        } else {
            binding.rowPickupLocation.getRoot().setVisibility(View.GONE);
            binding.rowDropLocation.getRoot().setVisibility(View.GONE);
            binding.rowFromDestination.getRoot().setVisibility(View.VISIBLE);
            binding.rowToDestination.getRoot().setVisibility(View.VISIBLE);
        }
    }

    // --- The rest of your methods (bookingDetailsApi, dialogs, etc.) remain unchanged ---
    private void initiateBookingDetails() {
        bookingDetailsApi();
        vendorListApi();

        binding.btnUpdateVendor.setOnClickListener(v -> selectVendorDialog());
        binding.btnUpdateStatus.setOnClickListener(v -> selectStatusDialog());
        String userData = PreferenceUtils.getString(Constant.PreferenceConstant.USER_DATA, this);
        LoginModel loginModel = new Gson().fromJson(userData, LoginModel.class);
        setUpToolBar(binding.toolbar,this,loginModel.getmAdminImg());
    }

    private void bookingDetailsApi() {
        showLoader();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<BookingDetailsResponse> call = apiInterface.bookingDetails(bookingId);
        call.enqueue(new Callback<BookingDetailsResponse>() {
            @Override
            public void onResponse(Call<BookingDetailsResponse> call, Response<BookingDetailsResponse> response) {
                hideLoader();
                if (response.isSuccessful() && response.body() != null && response.body().getResult().equalsIgnoreCase(Constant.SUCCESS_RESPONSE)) {
                    bookingListModels = response.body().getData();
                    setData();
                } else {
                    Toast.makeText(BookingDetailsActivity.this, "Failed to load details", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BookingDetailsResponse> call, Throwable t) {
                hideLoader();
                Toast.makeText(BookingDetailsActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setRowData(View row, String label, String value) {
        if (value == null || value.trim().isEmpty() || value.equalsIgnoreCase("N/A")) {
            row.setVisibility(View.GONE);
            return;
        }
        row.setVisibility(View.VISIBLE);
        TextView tvLabel = row.findViewById(R.id.tvLabel);
        TextView tvValue = row.findViewById(R.id.tvValue);
        tvLabel.setText(label);
        tvValue.setText(value);
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
    private String generateServiceName() {
        if (bookingTypeId == null) return "Booking Details";

        switch (bookingTypeId) {
            case "2":
                return "Self Drive Service";
            case "3":
                return "Luxury Car Service";
            case "4":
                return "Bus Service";
            case "1":
            default:
                if (bookingTypeCat != null) {
                    switch (bookingTypeCat) {
                        case "1": return "Cab Service - City Ride";
                        case "2": return "Cab Service - One Way";
                        case "3": return "Cab Service - Outstation";
                        case "4": return "Cab Service - Airport";
                    }
                }
                return "Cab Service";
        }
    }
    private void vendorListApi() {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<VendorListResponse> call = apiInterface.vendorsList();
        call.enqueue(new Callback<VendorListResponse>() {
            @Override
            public void onResponse(Call<VendorListResponse> call, Response<VendorListResponse> response) {

                try {
                    if (String.valueOf(response.code()).equalsIgnoreCase(Constant.SUCCESS_RESPONSE_CODE)) {
                        if (response.body().getResult().equalsIgnoreCase(Constant.SUCCESS_RESPONSE)) {

                            vendorListModels.clear();
                            vendorListModels.add(new VendorListModel("", "Select Vendor", ""));
                            vendorListModels.addAll(response.body().getData());


                        } else {

                            Toast.makeText(BookingDetailsActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    } else {

                        Toast.makeText(BookingDetailsActivity.this, "" + response.message(), Toast.LENGTH_SHORT).show();

                    }
                } catch (Exception e) {

                    e.printStackTrace();
                    Toast.makeText(BookingDetailsActivity.this, "" + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<VendorListResponse> call, Throwable t) {
                Toast.makeText(BookingDetailsActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void updateVendorApi() {

        showLoader();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<BaseResponse> call = apiInterface.updateVendor(bookingId, vendorId);
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                hideLoader();
                try {
                    if (String.valueOf(response.code()).equalsIgnoreCase(Constant.SUCCESS_RESPONSE_CODE)) {
                        if (response.body().getResult().equalsIgnoreCase(Constant.SUCCESS_RESPONSE)) {

                            Toast.makeText(BookingDetailsActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();

                            bookingDetailsApi();

                        } else {
                            hideLoader();
                            Toast.makeText(BookingDetailsActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        hideLoader();
                        Toast.makeText(BookingDetailsActivity.this, "" + response.message(), Toast.LENGTH_SHORT).show();

                    }
                } catch (Exception e) {
                    hideLoader();
                    e.printStackTrace();
                    Toast.makeText(BookingDetailsActivity.this, "" + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                hideLoader();
                Toast.makeText(BookingDetailsActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }


    private void updateStatusApi() {
        showLoader();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<BaseResponse> call = apiInterface.updateStatus(bookingId, statusId);
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {

                try {
                    if (String.valueOf(response.code()).equalsIgnoreCase(Constant.SUCCESS_RESPONSE_CODE)) {
                        if (response.body().getResult().equalsIgnoreCase(Constant.SUCCESS_RESPONSE)) {

                            Toast.makeText(BookingDetailsActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            bookingDetailsApi();

                        } else {
                            hideLoader();
                            Toast.makeText(BookingDetailsActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        hideLoader();
                        Toast.makeText(BookingDetailsActivity.this, "" + response.message(), Toast.LENGTH_SHORT).show();

                    }
                } catch (Exception e) {
                    hideLoader();
                    e.printStackTrace();
                    Toast.makeText(BookingDetailsActivity.this, "" + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                hideLoader();
                Toast.makeText(BookingDetailsActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void selectVendorDialog() {
        SelectVendorDialogBinding selectVendorDialogBinding;
        selectVendorDialogBinding = SelectVendorDialogBinding.inflate(getLayoutInflater());

        dialog = new Dialog(BookingDetailsActivity.this, R.style.my_dialog);
        dialog.setCancelable(false);
        dialog.setContentView(selectVendorDialogBinding.getRoot());
        dialog.show();

        ArrayAdapter<VendorListModel> cityAdapter = new ArrayAdapter<>(BookingDetailsActivity.this, R.layout.spinner_item, vendorListModels);
        cityAdapter.setDropDownViewResource(R.layout.spinner_item);
        selectVendorDialogBinding.spVendors.setAdapter(cityAdapter);

        selectVendorDialogBinding.spVendors.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                vendorId = vendorListModels.get(i).getmVendorId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        selectVendorDialogBinding.btnCancel.setOnClickListener(View -> {
            dialog.dismiss();
        });
        selectVendorDialogBinding.btnSave.setOnClickListener(View -> {
            updateVendorApi();
            dialog.dismiss();
        });
    }

    private void selectStatusDialog() {
        statusList.clear();
        statusList.add("Select Status");
        statusList.add("Pending");
        statusList.add("Accepted");
        statusList.add("Completed");
        statusList.add("Cancelled");

        SelectStatusDialogBinding selectStatusDialogBinding;
        selectStatusDialogBinding = SelectStatusDialogBinding.inflate(getLayoutInflater());

        dialog = new Dialog(BookingDetailsActivity.this, R.style.my_dialog);
        dialog.setCancelable(false);
        dialog.setContentView(selectStatusDialogBinding.getRoot());
        dialog.show();

        ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(BookingDetailsActivity.this, R.layout.spinner_item, statusList);
        cityAdapter.setDropDownViewResource(R.layout.spinner_item);
        selectStatusDialogBinding.spStatus.setAdapter(cityAdapter);


        selectStatusDialogBinding.spStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                statusId = String.valueOf(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        selectStatusDialogBinding.btnCancel.setOnClickListener(View -> {
            dialog.dismiss();
        });
        selectStatusDialogBinding.btnSave.setOnClickListener(View -> {
            updateStatusApi();
            dialog.dismiss();
        });
    }
}