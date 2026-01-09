package com.logixhunt.carrorentaladmin.ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.logixhunt.carrorentaladmin.api.ApiClient;
import com.logixhunt.carrorentaladmin.api.ApiInterface;
import com.logixhunt.carrorentaladmin.databinding.ActivitySplashBinding;
import com.logixhunt.carrorentaladmin.model.CheckBlockModel;
import com.logixhunt.carrorentaladmin.model.LoginModel;
import com.logixhunt.carrorentaladmin.utils.Constant;
import com.logixhunt.carrorentaladmin.utils.PreferenceUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        startSplash();

    }


    private void startSplash() {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (PreferenceUtils.getBoolean(Constant.PreferenceConstant.IS_LOGIN, SplashActivity.this)) {
                        checkBlock();
                    } else {
                        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }, 1000);

    }


    private void showBlockAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this, AlertDialog.THEME_DEVICE_DEFAULT_DARK);
        builder.setMessage("You are blocked by admin");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setCancelable(false);
        AlertDialog dialog = builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }).create();
        dialog.show();
    }


    private void checkBlock() {

        String userData = PreferenceUtils.getString(Constant.PreferenceConstant.USER_DATA, this);
        LoginModel loginModel = new Gson().fromJson(userData, LoginModel.class);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<CheckBlockModel> call = apiService.check_block_with_id(loginModel.getmAdminId());
        call.enqueue(new Callback<CheckBlockModel>() {
            @Override
            public void onResponse(Call<CheckBlockModel> call, Response<CheckBlockModel> response) {
                try {
                    if (String.valueOf(response.code()).equalsIgnoreCase(Constant.SUCCESS_RESPONSE_CODE)) {
                        if (response.body().getUser().get(0).getmAdminStatus().equalsIgnoreCase("3")) {
                            showBlockAlertDialog();

                        } else {
                            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }

                    }

                } catch (Exception e) {


                }

            }

            @Override
            public void onFailure(Call<CheckBlockModel> call, Throwable t) {
                // Log error here since request failed
                Log.e("Failure", t.toString());

//                showError("Something went wrong");
            }
        });
    }
}