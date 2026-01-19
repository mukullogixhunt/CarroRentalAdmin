package com.carro.admin.ui.activity;

import static android.view.View.GONE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.carro.admin.api.request.NotificationRequest;
import com.carro.admin.utils.RequestBodyUtils;
import com.google.gson.Gson;
import com.carro.admin.R;
import com.carro.admin.api.ApiClient;
import com.carro.admin.api.ApiInterface;
import com.carro.admin.api.response.NotificationListResponse;
import com.carro.admin.databinding.ActivityNotificationBinding;
import com.carro.admin.model.LoginModel;
import com.carro.admin.model.MarkAllReadResponse;
import com.carro.admin.model.NotificationListModel;
import com.carro.admin.ui.adapter.NotificationListAdapter;
import com.carro.admin.ui.common.BaseActivity;
import com.carro.admin.utils.Constant;
import com.carro.admin.utils.PreferenceUtils;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationActivity extends BaseActivity {
    private SharedPreferences pr;
    ActivityNotificationBinding binding;

    List<NotificationListModel> notificationListModels = new ArrayList<>();

    String userId;
    NotificationListAdapter notificationListAdapter;
    String notificationType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityNotificationBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        userId = PreferenceUtils.getString(Constant.PreferenceConstant.USER_ID, this);

        getNotifyPref();

        binding. tvMarksRead.setOnClickListener(v -> {
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<MarkAllReadResponse> call = apiService.markAllNotificationsRead(userId);

            call.enqueue(new Callback<MarkAllReadResponse>() {
                @Override
                public void onResponse(Call<MarkAllReadResponse> call, Response<MarkAllReadResponse> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        MarkAllReadResponse res = response.body();
                        if (res.getResponse().equalsIgnoreCase("success")) {
                            Toast.makeText(NotificationActivity.this, res.getMessage(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(NotificationActivity.this, "mark all readed", Toast.LENGTH_SHORT).show();


                           notificationListAdapter.markAllRead(); // visually mark all notifications as read
                        } else {
                            Toast.makeText(NotificationActivity.this, "Failed: " + res.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<MarkAllReadResponse> call, Throwable t) {
                    Toast.makeText(NotificationActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });

    }

    private void getNotifyPref() {

         notificationType=getIntent().getStringExtra(Constant.BundleExtras.NOTIFICATION_TYPE);
        initiateNotification();

    }

    private void initiateNotification() {

        String userData = PreferenceUtils.getString(Constant.PreferenceConstant.USER_DATA, this);
        LoginModel loginModel = new Gson().fromJson(userData, LoginModel.class);
        setUpToolBar(binding.toolbar,this,loginModel.getmAdminImg());


        if (notificationType.equals("1")){
            customerNotificationListApi();
            binding.toolbar.ivNotification.setVisibility(GONE);
        }else {
            vendorNotificationListApi();
           // binding.toolbar.ivNotificationVen.setVisibility(GONE);
        }



    }

    private void customerNotificationListApi() {
        binding.lvNoData.setVisibility(View.VISIBLE);
        binding.rvNotification.setVisibility(GONE);
       LoginModel loginModel= new Gson().fromJson(
                PreferenceUtils.getString(Constant.PreferenceConstant.USER_DATA, this),
                LoginModel.class
        );
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<NotificationListResponse> call = apiInterface.adminNotificationList(
                RequestBodyUtils.toTextRequestBody(loginModel.getmAdminType()),
                RequestBodyUtils.toTextRequestBody(loginModel.getmAdminBranch())
        );
        call.enqueue(new Callback<NotificationListResponse>() {
            @Override
            public void onResponse(Call<NotificationListResponse> call, Response<NotificationListResponse> response) {

                try {
                    if (String.valueOf(response.code()).equalsIgnoreCase(Constant.SUCCESS_RESPONSE_CODE)) {
                        if (response.body().getResult().equalsIgnoreCase(Constant.SUCCESS_RESPONSE)) {
                            notificationListModels.clear();
                            notificationListModels.addAll(response.body().getData());

                            binding.lvNoData.setVisibility(GONE);
                            binding.rvNotification.setVisibility(View.VISIBLE);

                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(NotificationActivity.this, LinearLayoutManager.VERTICAL, false);
                            binding.rvNotification.setLayoutManager(linearLayoutManager);
                            notificationListAdapter = new NotificationListAdapter(NotificationActivity.this, notificationListModels,userId);
                            binding.rvNotification.setAdapter(notificationListAdapter);
                            notificationListAdapter.notifyDataSetChanged();


                        } else {
                            binding.lvNoData.setVisibility(View.VISIBLE);
                            binding.rvNotification.setVisibility(GONE);
                            Toast.makeText(NotificationActivity.this, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        binding.lvNoData.setVisibility(View.VISIBLE);
                        binding.rvNotification.setVisibility(GONE);
                        Toast.makeText(NotificationActivity.this, ""+response.message(), Toast.LENGTH_SHORT).show();

                    }
                } catch (Exception e) {
                    binding.lvNoData.setVisibility(View.VISIBLE);
                    binding.rvNotification.setVisibility(GONE);
                    e.printStackTrace();
                    Toast.makeText(NotificationActivity.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NotificationListResponse> call, Throwable t) {
                binding.lvNoData.setVisibility(View.VISIBLE);
                binding.rvNotification.setVisibility(GONE);
                Log.e("Failure", t.toString());
                Toast.makeText(NotificationActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void vendorNotificationListApi() {

        binding.lvNoData.setVisibility(View.VISIBLE);
        binding.rvNotification.setVisibility(GONE);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<NotificationListResponse> call = apiInterface.vendorNotificationList();
        call.enqueue(new Callback<NotificationListResponse>() {
            @Override
            public void onResponse(Call<NotificationListResponse> call, Response<NotificationListResponse> response) {

                try {
                    if (String.valueOf(response.code()).equalsIgnoreCase(Constant.SUCCESS_RESPONSE_CODE)) {
                        if (response.body().getResult().equalsIgnoreCase(Constant.SUCCESS_RESPONSE)) {
                            notificationListModels.clear();
                            notificationListModels.addAll(response.body().getData());

                            binding.lvNoData.setVisibility(GONE);
                            binding.rvNotification.setVisibility(View.VISIBLE);

                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(NotificationActivity.this, LinearLayoutManager.VERTICAL, false);
                            binding.rvNotification.setLayoutManager(linearLayoutManager);
                            notificationListAdapter = new NotificationListAdapter(NotificationActivity.this, notificationListModels,userId);
                            binding.rvNotification.setAdapter(notificationListAdapter);
                            notificationListAdapter.notifyDataSetChanged();


                        } else {
                            binding.lvNoData.setVisibility(View.VISIBLE);
                            binding.rvNotification.setVisibility(GONE);
                            Toast.makeText(NotificationActivity.this, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        binding.lvNoData.setVisibility(View.VISIBLE);
                        binding.rvNotification.setVisibility(GONE);
                        Toast.makeText(NotificationActivity.this, ""+response.message(), Toast.LENGTH_SHORT).show();

                    }
                } catch (Exception e) {
                    binding.lvNoData.setVisibility(View.VISIBLE);
                    binding.rvNotification.setVisibility(GONE);
                    e.printStackTrace();
                    Toast.makeText(NotificationActivity.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NotificationListResponse> call, Throwable t) {
                binding.lvNoData.setVisibility(View.VISIBLE);
                binding.rvNotification.setVisibility(GONE);
                Log.e("Failure", t.toString());
                Toast.makeText(NotificationActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }





}