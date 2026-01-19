package com.carro.admin.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;
import com.carro.admin.R;
import com.carro.admin.api.ApiClient;
import com.carro.admin.api.ApiInterface;
import com.carro.admin.api.response.BookingIdResponse;
import com.carro.admin.api.response.CustomerListResponse;
import com.carro.admin.api.response.VendorListResponse;
import com.carro.admin.api.response.commonResponse.BaseResponse;
import com.carro.admin.databinding.ActivityInsertNotificationBinding;
import com.carro.admin.model.BookingIdModel;
import com.carro.admin.model.CustomerListModel;
import com.carro.admin.model.LoginModel;
import com.carro.admin.model.VendorListModel;
import com.carro.admin.ui.common.BaseActivity;
import com.carro.admin.utils.Constant;
import com.carro.admin.utils.PreferenceUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertNotificationActivity extends BaseActivity {

    ActivityInsertNotificationBinding binding;
    String notificationType;
    List<VendorListModel> vendorListModels = new ArrayList<>();
    List<BookingIdModel> bookingIdModels = new ArrayList<>();
    List<CustomerListModel> customerListModels = new ArrayList<>();
    String selectedUserId = "";
    String selectedBookingId = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInsertNotificationBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getNotificationPreference();
    }

    private void getNotificationPreference() {
        notificationType = getIntent().getStringExtra(Constant.BundleExtras.NOTIFICATION_TYPE);


        initiateInsertNotification();
    }

    private void initiateInsertNotification() {

        vendorListApi();
        bookingIdListApi();
        customerListApi();

        String userData = PreferenceUtils.getString(Constant.PreferenceConstant.USER_DATA, this);
        LoginModel loginModel = new Gson().fromJson(userData, LoginModel.class);
        setUpToolBar(binding.toolbar,this,loginModel.getmAdminImg());

        if (notificationType.equals("1")) {
            binding.spCustomer.setVisibility(View.VISIBLE);
            binding.tvCust.setVisibility(View.VISIBLE);
            binding.spVendorsName.setVisibility(View.GONE);
            binding.tvVen.setVisibility(View.GONE);
            binding.spBookingId.setVisibility(View.GONE);
            binding.tvBookId.setVisibility(View.GONE);
        } else {
            binding.spCustomer.setVisibility(View.GONE);
            binding.tvCust.setVisibility(View.GONE);
            binding.spVendorsName.setVisibility(View.VISIBLE);
            binding.tvVen.setVisibility(View.VISIBLE);
            binding.spBookingId.setVisibility(View.VISIBLE);
            binding.tvBookId.setVisibility(View.VISIBLE);
        }

        binding.btnSend.setOnClickListener(View -> {

            if (validate()) {
                insertNotificationApi();
            }
        });
        binding.btnCancel.setOnClickListener(View -> {
            getOnBackPressedDispatcher().onBackPressed();
        });

        binding.spCustomer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedUserId = customerListModels.get(i).getmCustId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.spVendorsName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedUserId = vendorListModels.get(i).getmVendorId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.spBookingId.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedBookingId = bookingIdModels.get(i).getmBkingId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

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


                            ArrayAdapter<VendorListModel> cityAdapter = new ArrayAdapter<>(InsertNotificationActivity.this, R.layout.spinner_item, vendorListModels);
                            cityAdapter.setDropDownViewResource(R.layout.spinner_item);
                            binding.spVendorsName.setAdapter(cityAdapter);


                        } else {

                            Toast.makeText(InsertNotificationActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    } else {

                        Toast.makeText(InsertNotificationActivity.this, "" + response.message(), Toast.LENGTH_SHORT).show();

                    }
                } catch (Exception e) {

                    e.printStackTrace();
                    Toast.makeText(InsertNotificationActivity.this, "" + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<VendorListResponse> call, Throwable t) {

                Log.e("Failure", t.toString());
                Toast.makeText(InsertNotificationActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void bookingIdListApi() {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<BookingIdResponse> call = apiInterface.bookingIdList();
        call.enqueue(new Callback<BookingIdResponse>() {
            @Override
            public void onResponse(Call<BookingIdResponse> call, Response<BookingIdResponse> response) {

                try {
                    if (String.valueOf(response.code()).equalsIgnoreCase(Constant.SUCCESS_RESPONSE_CODE)) {
                        if (response.body().getResult().equalsIgnoreCase(Constant.SUCCESS_RESPONSE)) {

                            bookingIdModels.clear();
                            bookingIdModels.add(new BookingIdModel("", "Select Booking Id"));
                            bookingIdModels.addAll(response.body().getData());


                            ArrayAdapter<BookingIdModel> cityAdapter = new ArrayAdapter<>(InsertNotificationActivity.this, R.layout.spinner_item, bookingIdModels);
                            cityAdapter.setDropDownViewResource(R.layout.spinner_item);
                            binding.spBookingId.setAdapter(cityAdapter);


                        } else {

                            Toast.makeText(InsertNotificationActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    } else {

                        Toast.makeText(InsertNotificationActivity.this, "" + response.message(), Toast.LENGTH_SHORT).show();

                    }
                } catch (Exception e) {

                    e.printStackTrace();
                    Toast.makeText(InsertNotificationActivity.this, "" + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BookingIdResponse> call, Throwable t) {

                Log.e("Failure", t.toString());
                Toast.makeText(InsertNotificationActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void customerListApi() {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<CustomerListResponse> call = apiInterface.customerList();
        call.enqueue(new Callback<CustomerListResponse>() {
            @Override
            public void onResponse(Call<CustomerListResponse> call, Response<CustomerListResponse> response) {

                try {
                    if (String.valueOf(response.code()).equalsIgnoreCase(Constant.SUCCESS_RESPONSE_CODE)) {
                        if (response.body().getResult().equalsIgnoreCase(Constant.SUCCESS_RESPONSE)) {

                            customerListModels.clear();
                            customerListModels.add(new CustomerListModel("", "Select Customer", ""));
                            customerListModels.addAll(response.body().getData());


                            ArrayAdapter<CustomerListModel> cityAdapter = new ArrayAdapter<>(InsertNotificationActivity.this, R.layout.spinner_item, customerListModels);
                            cityAdapter.setDropDownViewResource(R.layout.spinner_item);
                            binding.spCustomer.setAdapter(cityAdapter);


                        } else {

                            Toast.makeText(InsertNotificationActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    } else {

                        Toast.makeText(InsertNotificationActivity.this, "" + response.message(), Toast.LENGTH_SHORT).show();

                    }
                } catch (Exception e) {

                    e.printStackTrace();
                    Toast.makeText(InsertNotificationActivity.this, "" + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CustomerListResponse> call, Throwable t) {

                Log.e("Failure", t.toString());
                Toast.makeText(InsertNotificationActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void insertNotificationApi() {

        String title = binding.etTitle.getText().toString().trim();
        String message = binding.etMessage.getText().toString().trim();

        showLoader();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<BaseResponse> call = apiInterface.insertNotification(notificationType, selectedUserId,selectedBookingId, title, message);
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                hideLoader();
                try {
                    if (String.valueOf(response.code()).equalsIgnoreCase(Constant.SUCCESS_RESPONSE_CODE)) {
                        if (response.body().getResult().equalsIgnoreCase(Constant.SUCCESS_RESPONSE)) {

                            Toast.makeText(InsertNotificationActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();

                            binding.etTitle.getText().clear();
                            binding.etMessage.getText().clear();
                            binding.spCustomer.setSelection(0);
                            binding.spVendorsName.setSelection(0);
                            binding.spBookingId.setSelection(0);

                        } else {
                            hideLoader();
                            Toast.makeText(InsertNotificationActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        hideLoader();
                        Toast.makeText(InsertNotificationActivity.this, "" + response.message(), Toast.LENGTH_SHORT).show();

                    }
                } catch (Exception e) {
                    hideLoader();
                    e.printStackTrace();
                    Toast.makeText(InsertNotificationActivity.this, "" + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                hideLoader();
                Log.e("Failure", t.toString());
                Toast.makeText(InsertNotificationActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }


    private boolean validate() {
        boolean valid = true;

        if (binding.etTitle.getText().toString().isEmpty()) {
            binding.etTitle.setError("Please enter Notification Title");
            binding.etTitle.requestFocus();
            valid = false;
        } else {
            binding.etTitle.setError(null);
        }

        if (binding.etMessage.getText().toString().isEmpty()) {
            binding.etMessage.setError("Please enter Notification Message");
            binding.etMessage.requestFocus();
            valid = false;
        } else {
            binding.etMessage.setError(null);
        }

        if (selectedUserId.isEmpty()) {
            Toast.makeText(this, "Please Select a User.", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        return valid;
    }


}