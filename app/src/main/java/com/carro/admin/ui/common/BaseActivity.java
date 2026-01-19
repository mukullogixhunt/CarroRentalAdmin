package com.carro.admin.ui.common;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;
import com.carro.admin.BuildConfig;
import com.carro.admin.R;
import com.carro.admin.databinding.LayoutToolbarBinding;
import com.carro.admin.ui.activity.EditProfileActivity;
import com.carro.admin.ui.activity.NotificationActivity;
import com.carro.admin.utils.Constant;
import com.carro.admin.utils.ImagePathDecider;
import com.carro.admin.widgets.CustomProgressDialog;


public class BaseActivity extends AppCompatActivity {

    Dialog mProgressDialog;
    public static BaseActivity baseActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseActivity = this;
        //progress dialog
        mProgressDialog = new CustomProgressDialog(this);

    }

    /**
     * show loader
     */
    public void showLoader() {
        try {
            if (!mProgressDialog.isShowing()) {
                mProgressDialog.show();
            }
        } catch (Exception e) {

        }
    }

    /**
     * Hide Loader
     */
    public void hideLoader() {
        try {
            if (mProgressDialog.isShowing()) {
                mProgressDialog.dismiss();
            }
        } catch (Exception e) {

        }
    }


    /**
     * Show Error
     */
    public void showError(String msg) {
        if (msg == null) return;
        Snackbar.make(findViewById(android.R.id.content), msg, Snackbar.LENGTH_LONG).show();
    }
    /**
     * Setup toolbar
     */
    public void setUpToolBar(LayoutToolbarBinding binding, Activity activity, String image) {

        Glide.with(activity)
                .load(ImagePathDecider.getUserImagePath() + image)
                .error(R.drawable.img_no_profile)
                .into(binding.ivUserTool);

        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getOnBackPressedDispatcher().onBackPressed();
            }
        });
        binding.ivUserTool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, EditProfileActivity.class);
                startActivity(intent);
            }
        });
        binding.ivNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity,NotificationActivity.class);
                intent.putExtra(Constant.BundleExtras.NOTIFICATION_TYPE,"1");
                startActivity(intent);
            }
        });
//        binding.ivNotificationVen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(activity,NotificationActivity.class);
//                intent.putExtra(Constant.BundleExtras.NOTIFICATION_TYPE,"2");
//                startActivity(intent);
//            }
//        });
    }
    /**
     * Show alert
     */
    public void showAlert(String msg) {
        if (msg == null) return;
        Toast toast = Toast.makeText(getApplicationContext(), "" + msg, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void log_d(String className, String message) {
        if (BuildConfig.DEBUG)
            Log.d(className, "" + message);
    }

    public void log_e(String className, String message, Exception e) {
        if (BuildConfig.DEBUG)
            Log.e(className, "" + message, e);
    }


}