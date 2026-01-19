package com.carro.admin.ui.activity;

import static android.view.View.GONE;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.canhub.cropper.CropImageContract;
import com.canhub.cropper.CropImageContractOptions;
import com.canhub.cropper.CropImageOptions;
import com.google.gson.Gson;
import com.carro.admin.BuildConfig;
import com.carro.admin.R;
import com.carro.admin.api.ApiClient;
import com.carro.admin.api.ApiInterface;
import com.carro.admin.api.response.LoginResponse;
import com.carro.admin.databinding.ActivityEditProfileBinding;
import com.carro.admin.model.LoginModel;
import com.carro.admin.ui.common.BaseActivity;
import com.carro.admin.utils.Constant;
import com.carro.admin.utils.ImagePathDecider;
import com.carro.admin.utils.PreferenceUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfileActivity extends BaseActivity {

    ActivityEditProfileBinding binding;
    private Uri imageUri;
    private Dialog dialog;
    private String imagePath = "";
    private File uploadImg = null;
    private static final int PERMISSION_CAMERA = 221;
    private static final int PERMISSION_WRITE_EXTERNAL = 222;
    private static final int PERMISSION_READ_MEDIA_IMAGES = 223;
    String userId ="";
    LoginModel loginModel = new LoginModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityEditProfileBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getuserPreference();


    }

    private void getuserPreference() {
        userId = PreferenceUtils.getString(Constant.PreferenceConstant.USER_ID, EditProfileActivity.this);

        String userData = PreferenceUtils.getString(Constant.PreferenceConstant.USER_DATA, EditProfileActivity.this);
        loginModel = new Gson().fromJson(userData, LoginModel.class);

        initiateEditProfile();
    }

    private void initiateEditProfile() {

        setData();

        binding.ivCapture.setOnClickListener(view -> {
            imagePickerDialog();
        });

        binding.btnRegister.setOnClickListener(view -> {
            if (validate()){
                callUpdateProfileApi();
            }
        });

        setUpToolBar(binding.toolbar,this,loginModel.getmAdminImg());
        binding.toolbar.ivUserTool.setVisibility(GONE);

    }

    private void setData() {

        binding.etName.setText(loginModel.getmAdminName());
        binding.etMobile.setText(loginModel.getmAdminContact());
        binding.etEmail.setText(loginModel.getmAdminEmail());
        binding.etPassword.setText(loginModel.getmAdminPass());

        Glide.with(EditProfileActivity.this)
                .load(ImagePathDecider.getUserImagePath()+loginModel.getmAdminImg())
                .error(R.drawable.img_no_profile)
                .into(binding.ivProfile);
    }


    private void callUpdateProfileApi() {

        String userName = binding.etName.getText().toString();
        String userMobile = binding.etMobile.getText().toString();
        String userEmail = binding.etEmail.getText().toString();
        String userPassword = binding.etPassword.getText().toString();



        RequestBody rbUserId = RequestBody.create(MediaType.parse("text/plain"), userId);
        RequestBody rbUserName = RequestBody.create(MediaType.parse("text/plain"), userName);
        RequestBody rbUserEmail = RequestBody.create(MediaType.parse("text/plain"), userEmail);
        RequestBody rbMobile = RequestBody.create(MediaType.parse("text/plain"), userMobile);
        RequestBody rbPassword = RequestBody.create(MediaType.parse("text/plain"), userPassword);

        MultipartBody.Part profileImagePart = null;
        if (uploadImg != null) {
            profileImagePart = MultipartBody.Part.createFormData(Constant.ApiKey.USER_PIC, uploadImg.getPath(), RequestBody.create(MediaType.parse("multipart/form-data"), uploadImg));
        }


        showLoader();

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<LoginResponse> call = apiService.update_profile(rbUserId, rbUserName, rbMobile, rbUserEmail,rbPassword, profileImagePart);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                hideLoader();
                try {
                    if (String.valueOf(response.code()).equalsIgnoreCase(Constant.SUCCESS_RESPONSE_CODE)) {
                        if (response.body().getResult().equalsIgnoreCase(Constant.SUCCESS_RESPONSE)) {

                            PreferenceUtils.setString(Constant.PreferenceConstant.USER_DATA, new Gson().toJson(response.body().getData().get(0)), EditProfileActivity.this);

                            getOnBackPressedDispatcher().onBackPressed();

                        } else {
                            hideLoader();
                            showError(response.message());
                        }
                    } else {
                        hideLoader();
                        showError(response.message());
                    }
                } catch (Exception e) {
                    hideLoader();
                    log_e(this.getClass().getSimpleName(), "onResponse: ", e);
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

        if (binding.etName.getText().toString().isEmpty()) {
            binding.etName.setError("Please enter your Name");
            binding.etName.requestFocus();
            valid = false;
        } else {
            binding.etName.setError(null);
        }

        if(binding.etEmail.getText().toString().isEmpty()){
            binding.etEmail.setError("Please enter your Email");
            valid = false;
        } else {
            String CHECK_EMAIL = "[a-zA-Z0-9._-]+@[a-zA-Z]+\\.[a-zA-Z]+";
            if (!binding.etEmail.getText().toString().matches(CHECK_EMAIL)) {
                binding.etEmail.setError("Please enter a valid Email");
                valid = false;
            } else {
                binding.etEmail.setError(null);
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

        if (binding.etMobile.getText().toString().isEmpty()) {
            binding.etMobile.setError("Please enter your Mobile Number..!");
            valid = false;
        } else {
            if (binding.etMobile.getText().toString().length() !=10) {
                binding.etMobile.setError("Please enter valid Mobile Number..!");
                valid = false;
            } else {
                binding.etMobile.setError(null);
            }
        }
        return valid;
    }



    //TODO/////////////IMAGE PICKER//////////
    private void imagePickerDialog() {
        dialog = new Dialog(EditProfileActivity.this, R.style.my_dialog);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.image_selection_dialog);
        dialog.show();

        ImageView ivCamera = dialog.findViewById(R.id.ivCamera);
        ImageView ivGallery = dialog.findViewById(R.id.ivGallery);
        TextView tvCancel = dialog.findViewById(R.id.tvCancel);
        ivCamera.setOnClickListener(view -> checkCameraPermission());
        ivGallery.setOnClickListener(view -> checkGalleryPermission());
        tvCancel.setOnClickListener(view -> dialog.dismiss());
    }

    private void checkCameraPermission() {

        if (dialog != null) {
            dialog.dismiss();
        }

        if (ContextCompat.checkSelfPermission(EditProfileActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(EditProfileActivity.this, new String[]{Manifest.permission.CAMERA}, PERMISSION_CAMERA);
            openCamera();
        } else {
            openCamera();
        }
    }

    ///////////////////////// check gallery permission///////////
    private void checkGalleryPermission() {
        if (dialog != null) {
            dialog.dismiss();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(EditProfileActivity.this, Manifest.permission.READ_MEDIA_IMAGES) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(EditProfileActivity.this, new String[]{Manifest.permission.READ_MEDIA_IMAGES}, PERMISSION_READ_MEDIA_IMAGES);
                openGallery();
            } else {
                openGallery();
            }
        } else {
            if (ContextCompat.checkSelfPermission(EditProfileActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(EditProfileActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_WRITE_EXTERNAL);
                openGallery();
            } else {
                openGallery();
            }
        }
    }

    /////////////////// for open camera /////////////////////
    private void openCamera() {


        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        String timeStamp = new SimpleDateFormat(Constant.yyyyMMdd_HHmmss, Locale.getDefault()).format(new java.util.Date());
        String imageFileName = "IMG_" + timeStamp + ".jpg";

        try {
            File file = File.createTempFile("IMG_" + timeStamp, ".jpg", EditProfileActivity.this.getExternalFilesDir(Environment.DIRECTORY_PICTURES));
            imageUri = FileProvider.getUriForFile(EditProfileActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            intent.putExtra(Constant.FILENAME, imageFileName);
            cameraActivityResultLauncher.launch(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*"); // Set the MIME type to allow any file type
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        try {
            galleryActivityResultLauncher.launch(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ActivityResultLauncher<Intent> cameraActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == Activity.RESULT_OK) {
            launchImageCropper();
        }
    });

    ActivityResultLauncher<Intent> galleryActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == Activity.RESULT_OK) {
            // File selected successfully
            imageUri = result.getData().getData();
            launchImageCropper();
            // Now you can use the selectedFileUri as needed
        }
    });

    private void launchImageCropper() {
        CropImageOptions cropImageOptions = new CropImageOptions();
        cropImageOptions.imageSourceIncludeGallery = false;
        cropImageOptions.imageSourceIncludeCamera = true;
        cropImageOptions.outputCompressQuality = 60;
        cropImageOptions.aspectRatioX = 1;
        cropImageOptions.aspectRatioY = 1;
        cropImageOptions.fixAspectRatio = true;
        CropImageContractOptions cropImageContractOptions = new CropImageContractOptions(imageUri, cropImageOptions);
        cropImage.launch(cropImageContractOptions);
    }

    ActivityResultLauncher<CropImageContractOptions> cropImage = registerForActivityResult(new CropImageContract(), result -> {
        if (result.isSuccessful()) {
            String croppedImagePath = result.getUriFilePath(EditProfileActivity.this, true);

            uploadImg = new File(croppedImagePath);

            Glide.with(EditProfileActivity.this)
                    .load(uploadImg)
                    .into(binding.ivProfile);

        }
    });


}