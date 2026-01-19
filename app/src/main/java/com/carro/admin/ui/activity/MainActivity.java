package com.carro.admin.ui.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.carro.admin.R;
import com.carro.admin.api.ApiClient;
import com.carro.admin.api.ApiInterface;
import com.carro.admin.databinding.ActivityMainBinding;
import com.carro.admin.model.AdvertiseModel;
import com.carro.admin.model.LoginModel;
import com.carro.admin.utils.Constant;
import com.carro.admin.utils.ImagePathDecider;
import com.carro.admin.utils.PreferenceUtils;
import com.carro.admin.utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private AppBarConfiguration appBarConfiguration;
    public  NavController navController = null;
    public static MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0);
            return insets;
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.nav_view), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(0,0,0, systemBars.bottom);
            return insets;
        });

        mainActivity = this;

        initialization();
    }

    private void initialization() {
        getAdvertise();
        NavHostFragment navHost = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.bottom_nav_fragment);
        assert navHost != null;
        navController = navHost.getNavController();
         NavigationUI.setupWithNavController(binding.navBottom, navController);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        navController = Navigation.findNavController(this, R.id.bottom_nav_fragment);
       /* appBarConfiguration = new AppBarConfiguration.Builder(
                navController.getGraph()
        ).setDrawerLayout(drawer).build();

        NavigationUI.setupWithNavController(navigationView, navController);*/


        binding.navView.setNavigationItemSelectedListener(item -> {

            int id = item.getItemId();

            if (id == R.id.nav_dashboard) {
                navController.navigate(R.id.nav_dashboard);
            } else if (id == R.id.nav_bookings) {
                navController.navigate(R.id.nav_bookings);
            }else if (id == R.id.nav_profile) {
                navController.navigate(R.id.nav_profile);
            }
            // notification menu items already handled separately
            // DO NOT let NavigationUI handle anything

            binding.drawerLayout.closeDrawer(GravityCompat.END);
            return true;
        });


        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {


          /*  ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    MainActivity.this, drawer, binding.toolbar,
                    R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            // change drawer icon
            toggle.setDrawerIndicatorEnabled(false);
            Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_baseline_menu_24, getTheme());
            toggle.setHomeAsUpIndicator(drawable);
            toggle.setToolbarNavigationClickListener(v -> {
                if (drawer.isDrawerVisible(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            });*/
        });


        binding.navView.getMenu().findItem(R.id.nav_notification_cus).setOnMenuItemClickListener(menuItem -> {
            Intent intent=new Intent(MainActivity.this,NotificationActivity.class);
            intent.putExtra(Constant.BundleExtras.NOTIFICATION_TYPE,"1");
            startActivity(intent);
            return false;
        });
        binding.navView.getMenu().findItem(R.id.nav_notification_ven).setOnMenuItemClickListener(menuItem -> {
            Intent intent=new Intent(MainActivity.this,NotificationActivity.class);
            intent.putExtra(Constant.BundleExtras.NOTIFICATION_TYPE,"2");
            startActivity(intent);
            return false;
        });
        binding.navView.getMenu().findItem(R.id.nav_notification_cus_insert).setOnMenuItemClickListener(menuItem -> {
            Intent intent=new Intent(MainActivity.this,InsertNotificationActivity.class);
            intent.putExtra(Constant.BundleExtras.NOTIFICATION_TYPE,"1");
            startActivity(intent);
            return false;
        });
        binding.navView.getMenu().findItem(R.id.nav_notification_ven_insert).setOnMenuItemClickListener(menuItem -> {
            Intent intent=new Intent(MainActivity.this,InsertNotificationActivity.class);
            intent.putExtra(Constant.BundleExtras.NOTIFICATION_TYPE,"2");
            startActivity(intent);
            return false;
        });

        binding.navView.getMenu().findItem(R.id.nav_notification_logout).setOnMenuItemClickListener(menuItem -> {
            PreferenceUtils.removeKey(Constant.PreferenceConstant.USER_DATA,this);
            PreferenceUtils.removeKey(Constant.PreferenceConstant.USER_ID, this);
            PreferenceUtils.removeKey(Constant.PreferenceConstant.IS_LOGIN, this);
            showAlert("LoggedOut Successfully");
            Intent intent=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
            finishAffinity();
            return false;
        });




        String userData = PreferenceUtils.getString(Constant.PreferenceConstant.USER_DATA, MainActivity.this);
        LoginModel loginModel = new Gson().fromJson(userData, LoginModel.class);

        if (!loginModel.getmAdminImg().isEmpty()){
            Glide.with(MainActivity.this)
                    .load(ImagePathDecider.getUserImagePath()+loginModel.getmAdminImg())
                    .error(R.drawable.img_no_profile)
                    .into(binding.ivUser);
        }

        binding.ivUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, EditProfileActivity.class);
                startActivity(intent);
            }
        });

        binding.ivNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NotificationActivity.class);
                intent.putExtra(Constant.BundleExtras.NOTIFICATION_TYPE,"1");
                startActivity(intent);

            }
        });

//        binding.ivNotificationVendor.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,NotificationActivity.class);
//                intent.putExtra(Constant.BundleExtras.NOTIFICATION_TYPE,"2");
//                startActivity(intent);
//
//            }
//        });
        binding.ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.drawerLayout.isDrawerOpen(GravityCompat.END)) {
                    binding.drawerLayout.closeDrawer(GravityCompat.END);
                } else {
                    binding.drawerLayout.openDrawer(GravityCompat.END);
                }
            }
        });
    }

    public void navigateToFragment(int id) {
        navController.navigate(id);
    }

    public void navigateToFragment(int id, Bundle bundle) {
        navController.navigate(id, bundle);
    }

    public void removeFromBackStack(int fragmentCard) {
        navController.popBackStack(fragmentCard, true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.bottom_nav_fragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }



    private void getAdvertise() {

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<AdvertiseModel> call = apiService.get_advertise();
        call.enqueue(new Callback<AdvertiseModel>() {
            @Override
            public void onResponse(Call<AdvertiseModel> call, Response<AdvertiseModel> response) {
                try {
                    if (String.valueOf(response.code()).equalsIgnoreCase(Constant.SUCCESS_RESPONSE_CODE)) {
                        if (response.body().getData().get(0).getMAdvBranch().equalsIgnoreCase("1")&& Utils.isAdvShow)
                            showAdvertiseDialog(MainActivity.this, response.body().getData().get(0));
                    }

                } catch (Exception e) {


                }

            }

            @Override
            public void onFailure(Call<AdvertiseModel> call, Throwable t) {
                // Log error here since request failed
                Log.e("Failure", t.toString());

//                showError("Something went wrong");
            }
        });
    }


    public static void showAdvertiseDialog(
            Context context,
            AdvertiseModel.AdvertiseDataItem item
    ) {
        Utils.isAdvShow=false;
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_advertise);
        dialog.setCancelable(false);

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(
                    new ColorDrawable(Color.TRANSPARENT)
            );
            dialog.getWindow().setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
        }

        ImageView imgAdvertise = dialog.findViewById(R.id.imgAdvertise);
        ImageView imgClose = dialog.findViewById(R.id.imgClose);

        // Load image from m_adv_image
        Glide.with(context)
                .load(ImagePathDecider.getAdvImagePath() + item.getMAdvImage())
                .placeholder(android.R.color.darker_gray)
                .dontTransform()
                .override(Target.SIZE_ORIGINAL)
                .into(imgAdvertise);

        // Close dialog
        imgClose.setOnClickListener(v -> dialog.dismiss());



        dialog.show();
    }

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.END)) {
            binding.drawerLayout.closeDrawer(GravityCompat.END);
        } else {
            if (navController.getCurrentDestination().getId() == R.id.nav_dashboard) {
              /*  if (DashBoardFragment.bottomNavController != null)
                    if (DashBoardFragment.bottomNavController.getCurrentDestination().getId() == R.id.nav_one_way) {

                    } else {
                        DashBoardFragment dashboardFragment = new DashBoardFragment();
                        dashboardFragment.navigateToFragment(R.id.nav_one_way);
                    }*/

            } else {
                super.onBackPressed();
            }
        }
    }

    public void showAlert(String msg) {
        if (msg == null) return;
        Toast toast = Toast.makeText(getApplicationContext(), "" + msg, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}