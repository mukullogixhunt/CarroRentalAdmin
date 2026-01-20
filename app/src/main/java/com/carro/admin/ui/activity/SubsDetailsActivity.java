//package com.logixhunt.carrorentaladmin.ui.activity;
//
//import android.os.Bundle;
//
//
//import androidx.activity.EdgeToEdge;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.google.gson.Gson;
//import com.logixhunt.carrorentaladmin.R;
//import com.logixhunt.carrorentaladmin.databinding.ActivitySubsDetailsBinding;
//import com.logixhunt.carrorentaladmin.model.SubscriptionModel;
//import com.logixhunt.carrorentaladmin.ui.common.BaseActivity;
//import com.logixhunt.carrorentaladmin.utils.Constant;
//import com.logixhunt.carrorentaladmin.utils.DateFormater;
//
//public class SubsDetailsActivity extends BaseActivity {
//
//    ActivitySubsDetailsBinding binding;
//    SubscriptionModel subscriptionModel;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding=ActivitySubsDetailsBinding.inflate(getLayoutInflater());
//        EdgeToEdge.enable(this);
//        setContentView(binding.getRoot());
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//
//        getPreferenceData();
//    }
//
//    private void getPreferenceData() {
//        subscriptionModel = new Gson().fromJson(getIntent().getStringExtra(Constant.BundleExtras.SUB_DATA), SubscriptionModel.class);
//
//        initialization();
//    }
//
//    private void initialization() {
//
//        binding.toolbar.setNavigationOnClickListener(View -> {
//            getOnBackPressedDispatcher().onBackPressed();
//        });
//
//        binding.tvBkingId.setText("#" + subscriptionModel.getmBookingId());
//        binding.tvCustomerName.setText(subscriptionModel.getmCustName());
//        binding.tvCMobile.setText(subscriptionModel.getmCustMobile());
//        binding.tvCCity.setText(subscriptionModel.getmBranchTitle());
//        binding.tvStartDate.setText(DateFormater.changeDateFormat(Constant.yyyyMMdd, Constant.ddMMyyyy, subscriptionModel.getmBkingPickup())+"\n"+DateFormater.changeDateFormat(Constant.HHMMSS, Constant.HHMMSSA, subscriptionModel.getmBkingPickupAt()));
//        binding.tvEndDate.setText(DateFormater.changeDateFormat(Constant.yyyyMMdd, Constant.ddMMyyyy, subscriptionModel.getmBkingReturn())+"\n"+DateFormater.changeDateFormat(Constant.HHMMSS, Constant.HHMMSSA, subscriptionModel.getmBkingReturnAt()));
//        binding.tvBkingDate.setText(DateFormater.changeDateFormat(Constant.yyyyMMdd_HHmmss, Constant.ddMMyyyy_HHMMSSA, subscriptionModel.getmBkingAddedon()));
//        binding.tvTotalAmt.setText(subscriptionModel.getmBkingTotal());
//        binding.tvRemainAmount.setText(subscriptionModel.getmBkingRemainAmt());
//        binding.tvAmountPaid.setText(subscriptionModel.getmBkingPaidAmt());
//
//
//        binding.tvAmountPaid.setText(
//                (subscriptionModel.getmBkingPaidAmt() == null || subscriptionModel.getmBkingPaidAmt().trim().isEmpty())
//                        ? "0"
//                        : subscriptionModel.getmBkingPaidAmt()
//        );
//
//        binding.tvFastag.setText(subscriptionModel.getmBkingFastag());
//        binding.tvPaymode.setText(subscriptionModel.getmBkingPaymode());
//        binding.tvDays.setText(subscriptionModel.getmSubsDay());
//        binding.tvPrice.setText(subscriptionModel.getmSubsPrice());
//        binding.tvBasePrice.setText(subscriptionModel.getmSubsPrice());
//
//        switch (subscriptionModel.getmBkingStatus()) {
//            case "1":
//                binding.tvStatus.setText("Pending");
//                binding.tvStatus.setBackgroundColor(this.getResources().getColor(R.color.yello));
//                break;
//            case "2":
//                binding.tvStatus.setText("Accepted");
//                binding.tvStatus.setBackgroundColor(this.getResources().getColor(R.color.green2));
//                break;
//            case "3":
//                binding.tvStatus.setText("Completed");
//                binding.tvStatus.setBackgroundColor(this.getResources().getColor(R.color.blue));
//                break;
//            case "4":
//                binding.tvStatus.setText("Cancelled");
//                binding.tvStatus.setBackgroundColor(this.getResources().getColor(R.color.red2));
//                break;
//            default:
//                binding.tvStatus.setText("Pending");
//                binding.tvStatus.setBackgroundColor(this.getResources().getColor(R.color.gray_light));
//
//        }
//
//        switch (subscriptionModel.getmBkingPayStatus()) {
//            case "0":
//                binding.tvPayment.setText("Unpaid");
//                break;
//            case "1":
//                binding.tvPayment.setText("Paid");
//                break;
//            case "2":
//                binding.tvPayment.setText("Advanced");
//                break;
//            default:
//                binding.tvPayment.setText("Unpaid");
//        }
//    }
//}


package com.carro.admin.ui.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.carro.admin.utils.ImagePathDecider;
import com.google.gson.Gson;
import com.carro.admin.R;
import com.carro.admin.api.ApiClient;
import com.carro.admin.api.ApiInterface;
import com.carro.admin.api.response.commonResponse.BaseResponse;
import com.carro.admin.databinding.ActivitySubsDetailsBinding;
import com.carro.admin.databinding.SelectStatusDialogBinding;
import com.carro.admin.model.LoginModel;
import com.carro.admin.model.SubscriptionModel;
import com.carro.admin.ui.common.BaseActivity;
import com.carro.admin.utils.Constant;
import com.carro.admin.utils.DateFormater;
import com.carro.admin.utils.PreferenceUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubsDetailsActivity extends BaseActivity {

    ActivitySubsDetailsBinding binding;
    SubscriptionModel subscriptionModel;

    List<String> statusList = new ArrayList<>();

    Dialog dialog;
    String statusId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySubsDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getPreferenceData();
    }

    private void getPreferenceData() {
        String subDataJson = getIntent().getStringExtra(Constant.BundleExtras.SUB_DATA);
        if (subDataJson != null) {
            subscriptionModel = new Gson().fromJson(subDataJson, SubscriptionModel.class);
            setData();
        } else {
            Toast.makeText(this, "Error loading subscription data.", Toast.LENGTH_SHORT).show();
            finish();
        }
        String userData = PreferenceUtils.getString(Constant.PreferenceConstant.USER_DATA, this);
        LoginModel loginModel = new Gson().fromJson(userData, LoginModel.class);
        setUpToolBar(binding.toolbar,this,loginModel.getmAdminImg());
    }

    private void setData() {



        if (subscriptionModel == null) return;

        binding.btnUpdateStatus.setOnClickListener(v -> selectStatusDialog());


        // Booking Details
        setRowData(binding.rowBookingId.getRoot(), "Booking ID", formatValue("#", subscriptionModel.getmBookingId(), ""));
        setRowData(binding.rowBookingService.getRoot(), "Service", "Self Drive Service (Subscription)");
        String bookingStatus = "Pending";
        switch (subscriptionModel.getmBkingStatus()) { case "2": bookingStatus = "Accepted"; break; case "3": bookingStatus = "Completed"; break; case "4": bookingStatus = "Cancelled"; break; }
        setRowDataWithStyling(binding.rowBookingStatus.getRoot(), "Status", bookingStatus, R.drawable.status_pending_background, R.color.brown);
        setRowData(binding.rowBranch.getRoot(), "Branch", subscriptionModel.getmBranchTitle());
        String bookingDateTime = DateFormater.changeDateFormat("yyyy-MM-dd HH:mm:ss", "dd-MM-yyyy hh:mm a", subscriptionModel.getmBkingAddedon());
        setRowData(binding.rowBookingDateTime.getRoot(), "Booking Date & Time", bookingDateTime);

        // Handle Start Date & Time with special case checks
        String startDate = subscriptionModel.getmBkingPickup();
        if (startDate == null || startDate.trim().isEmpty() || "0000-00-00".equals(startDate)) {
            setRowData(binding.rowStartDateTime.getRoot(), "Start Date & Time", null);
        } else {
            String formattedDate = DateFormater.changeDateFormat(Constant.yyyyMMdd, Constant.ddMMyyyy, startDate);
            String startTime = subscriptionModel.getmBkingPickupAt();
            String formattedTime = "";
            if (startTime != null && !startTime.trim().isEmpty() && !"00:00:00".equals(startTime)) {
                formattedTime = " " + DateFormater.changeDateFormat(Constant.HHMMSS, Constant.HHMMSSA, startTime);
            }
            setRowData(binding.rowStartDateTime.getRoot(), "Start Date & Time", formattedDate + formattedTime);
        }

        // Handle End Date & Time with special case checks
        String endDate = subscriptionModel.getmBkingReturn();
        if (endDate == null || endDate.trim().isEmpty() || "0000-00-00".equals(endDate)) {
            setRowData(binding.rowEndDateTime.getRoot(), "End Date & Time", null);
        } else {
            String formattedDate = DateFormater.changeDateFormat(Constant.yyyyMMdd, Constant.ddMMyyyy, endDate);
            String endTime = subscriptionModel.getmBkingReturnAt();
            String formattedTime = "";
            if (endTime != null && !endTime.trim().isEmpty() && !"00:00:00".equals(endTime)) {
                formattedTime = " " + DateFormater.changeDateFormat(Constant.HHMMSS, Constant.HHMMSSA, endTime);
            }
            setRowData(binding.rowEndDateTime.getRoot(), "End Date & Time", formattedDate + formattedTime);
        }

        // Customer Details
        setRowData(binding.rowCustomerName.getRoot(), "Customer Name", subscriptionModel.getmCustName());
        setRowData(binding.rowCustomerMobile.getRoot(), "Mobile No.", formatValue("+91 ", subscriptionModel.getmCustMobile(), ""));
        setRowData(binding.rowCustomerCity.getRoot(), "City", subscriptionModel.getmCustCity());
        checkSectionVisibility(binding.containerCustomerData, binding.tvNoCustomerData,
                binding.rowCustomerName.getRoot(), binding.rowCustomerMobile.getRoot(), binding.rowCustomerCity.getRoot());

        // Car Type Details
        setRowData(binding.rowCarTypeName.getRoot(), "Type", subscriptionModel.getmCtypeTitle());
        setRowData(binding.rowDriveType.getRoot(), "Mode", "1".equals(subscriptionModel.getmCTypeDriveType()) ? "Manual" : "Automatic");
        setRowData(binding.rowSeat.getRoot(), "Seat", subscriptionModel.getmCTypeSeat());
        setRowData(binding.rowCTCarNumber.getRoot(), "Car Number", subscriptionModel.getmCTypeNumber());
        setRowData(binding.rowCtLuggage.getRoot(), "Luggage", subscriptionModel.getmCTypeLuggage());
        setRowData(binding.rowCtFuel.getRoot(), "Fuel", subscriptionModel.getmCTypeFuel());
        checkSectionVisibility(binding.containerCarTypeData, binding.tvNoCarTypeData,
                binding.rowCarTypeName.getRoot(), binding.rowDriveType.getRoot(), binding.rowSeat.getRoot(),binding.rowCTCarNumber.getRoot(),binding.rowCtLuggage.getRoot(),binding.rowCtFuel.getRoot());

        // Subscription Details
        setRowData(binding.rowSubscriptionDays.getRoot(), "Days", formatValue("", subscriptionModel.getmSubsDay(), " Days"));
        setRowData(binding.rowSubscriptionPrice.getRoot(), "Price", formatValue("₹ ", subscriptionModel.getmSubsPrice(), ""));
        checkSectionVisibility(binding.containerSubscriptionData, binding.tvNoSubscriptionData,
                binding.rowSubscriptionDays.getRoot(), binding.rowSubscriptionPrice.getRoot());

        // Payment Details
        setRowData(binding.rowBasePrice.getRoot(), "Base Price", formatValue("₹ ", subscriptionModel.getmSubsPrice(), ""));
        setRowData(binding.rowFastag.getRoot(), "Fastag", formatValue("₹ ", subscriptionModel.getmBkingFastag(), ""));
        setRowData(binding.rowTotal.getRoot(), "Total", formatValue("₹ ", subscriptionModel.getmBkingTotal(), ""));
        String amountPaid = (subscriptionModel.getmBkingPaidAmt() == null || subscriptionModel.getmBkingPaidAmt().trim().isEmpty()) ? "0" : subscriptionModel.getmBkingPaidAmt();
        setRowData(binding.rowAmountPaid.getRoot(), "Amount Paid", formatValue("₹ ", amountPaid, ""));
        setRowData(binding.rowAmountRemains.getRoot(), "Amount Remains", formatValue("₹ ", subscriptionModel.getmBkingRemainAmt(), ""));
        setRowData(binding.rowPaymode.getRoot(), "Paymode", subscriptionModel.getmBkingPaymode());

        // Verification Image Details
          //side images
        setImgData(binding.imgSideV1,  subscriptionModel.getmBkingSideImg1());
        setImgData(binding.imgSideV2,  subscriptionModel.getmBkingSideImg2());
        setImgData(binding.imgSideV3,  subscriptionModel.getmBkingSideImg3());
        setImgData(binding.imgSideV4,  subscriptionModel.getmBkingSideImg4());
          //interior images
        setImgData(binding.imgInteriorV1,  subscriptionModel.getmBkingIntImg1());
        setImgData(binding.imgInteriorV2,  subscriptionModel.getmBkingIntImg2());
        //meter
        setImgData(binding.imgMeterV1,  subscriptionModel.getmBkingMeterImg());
        //toolkit
        setImgData(binding.imgToolkitV1,  subscriptionModel.getmBkingToolkitImg());
        //Sphare Tyre
        setImgData(binding.imgSphareTyre,  subscriptionModel.getmBkingSphareTyre());
        //scratch
        setImgData(binding.imgScratch,  subscriptionModel.getmBkingScratch());
        //remark
        setRowData(binding.rowVRemark.getRoot(), "Remark", subscriptionModel.getmBkingRemark());

        String paymentStatus = "Unpaid";
        if ("1".equals(subscriptionModel.getmBkingPayStatus())) paymentStatus = "Paid";
        if ("2".equals(subscriptionModel.getmBkingPayStatus())) paymentStatus = "Advanced";
        int paymentBg = "Paid".equals(paymentStatus) ? R.drawable.status_pending_background : R.drawable.payment_unpaid_background;
        int paymentColor = "Paid".equals(paymentStatus) ? R.color.green : R.color.red;
        setRowDataWithStyling(binding.rowPaymentStatus.getRoot(), "Payment Status", paymentStatus, paymentBg, paymentColor);
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
    private void setImgData(ImageView img,String imgUrl) {
        if (imgUrl == null || imgUrl.trim().isEmpty() || imgUrl.equalsIgnoreCase("N/A")) {
            img.setVisibility(View.GONE);
            return;
        }
        img.setVisibility(View.VISIBLE);
        Glide.with(img.getContext())
                .load(imgUrl)
                .placeholder(android.R.color.darker_gray)
                .dontTransform()
                .override(Target.SIZE_ORIGINAL)
                .into(img);
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
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
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

        SelectStatusDialogBinding selectStatusDialogBinding;
        selectStatusDialogBinding = SelectStatusDialogBinding.inflate(getLayoutInflater());

        dialog = new Dialog(SubsDetailsActivity.this, R.style.my_dialog);
        dialog.setCancelable(false);
        dialog.setContentView(selectStatusDialogBinding.getRoot());
        dialog.show();

        ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(SubsDetailsActivity.this, R.layout.spinner_item, statusList);
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

    private void updateStatusApi() {
        showLoader();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<BaseResponse> call = apiInterface.updateStatus(subscriptionModel.getmBkingId(), statusId);
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                hideLoader();

                try {
                    if (String.valueOf(response.code()).equalsIgnoreCase(Constant.SUCCESS_RESPONSE_CODE)) {
                        if (response.body().getResult().equalsIgnoreCase(Constant.SUCCESS_RESPONSE)) {

                            Toast.makeText(SubsDetailsActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            subscriptionModel.setmBkingStatus(statusId);
                            setData();
                        } else {
                            hideLoader();
                            Toast.makeText(SubsDetailsActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        hideLoader();
                        Toast.makeText(SubsDetailsActivity.this, "" + response.message(), Toast.LENGTH_SHORT).show();

                    }
                } catch (Exception e) {
                    hideLoader();
                    e.printStackTrace();
                    Toast.makeText(SubsDetailsActivity.this, "" + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                hideLoader();
                Toast.makeText(SubsDetailsActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

}