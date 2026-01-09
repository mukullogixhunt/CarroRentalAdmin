package com.logixhunt.carrorentaladmin.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;
import com.logixhunt.carrorentaladmin.R;
import com.logixhunt.carrorentaladmin.api.ApiClient;
import com.logixhunt.carrorentaladmin.api.ApiInterface;
import com.logixhunt.carrorentaladmin.api.response.LoginResponse;
import com.logixhunt.carrorentaladmin.databinding.ActivityLoginBinding;
import com.logixhunt.carrorentaladmin.ui.common.BaseActivity;
import com.logixhunt.carrorentaladmin.utils.Constant;
import com.logixhunt.carrorentaladmin.utils.PreferenceUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initialization();

    }

    private void initialization(){
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validate()){
                    loginApi();
                }

            }
        });

        binding.ivPasswordEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.etPassword.getTransformationMethod() == PasswordTransformationMethod.getInstance()) {
                    binding.etPassword.setTransformationMethod(null);
                    binding.ivPasswordEye.setImageResource(R.drawable.img_hide_password);
                } else {
                    binding.etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    binding.ivPasswordEye.setImageResource(R.drawable.icn_password_eye);
                }
                // Move cursor to the end of the text
                binding.etPassword.setSelection(binding.etPassword.getText().length());

            }
        });
    }

    private void loginApi() {

        String email = binding.etMail.getText().toString().trim();
        String password = binding.etPassword.getText().toString().trim();
        showLoader();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<LoginResponse> call = apiInterface.loginAdmin(email,password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                hideLoader();
                try {
                    if (String.valueOf(response.code()).equalsIgnoreCase(Constant.SUCCESS_RESPONSE_CODE)) {
                        if (response.body().getResult().equalsIgnoreCase(Constant.SUCCESS_RESPONSE)) {

                            showAlert(response.body().getMessage());

                            PreferenceUtils.setString(Constant.PreferenceConstant.USER_DATA, new Gson().toJson(response.body().getData().get(0)), LoginActivity.this);
                            PreferenceUtils.setString(Constant.PreferenceConstant.USER_ID, response.body().getData().get(0).getmAdminId(), LoginActivity.this);

                            PreferenceUtils.setBoolean(Constant.PreferenceConstant.IS_LOGIN, true, LoginActivity.this);

                            Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            startActivity(intent);
                            finish();


                        } else {
                            hideLoader();
                            showError(response.body().getMessage());
                        }
                    } else {
                        hideLoader();
                        showError(response.message());
                    }
                } catch (Exception e) {
                    hideLoader();
                    e.printStackTrace();
                    showError(response.message());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                hideLoader();
                Log.e("Failure", t.toString());
                showError("Something went wrong");
            }
        });
    }

    private boolean validate() {
        boolean valid = true;

        if(binding.etMail.getText().toString().isEmpty()){
            binding.etMail.setError("Please enter your Email");
            valid = false;
        } else {
            String CHECK_EMAIL = "[a-zA-Z0-9._-]+@[a-zA-Z]+\\.[a-zA-Z]+";
            if (!binding.etMail.getText().toString().matches(CHECK_EMAIL)) {
                binding.etMail.setError("Please enter a valid Email");
                valid = false;
            } else {
                binding.etMail.setError(null);
            }
        }

        if (binding.etPassword.getText().toString().isEmpty()) {
            binding.etPassword.setError("Please enter your Password..!");
            valid = false;
        } else {
            if (binding.etPassword.getText().toString().length() < 6) {
                binding.etPassword.setError("Please enter valid Password..!");
                valid = false;
            } else {
                binding.etPassword.setError(null);
            }
        }
        return valid;
    }

}