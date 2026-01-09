package com.logixhunt.carrorentaladmin.ui.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.logixhunt.carrorentaladmin.R;
import com.logixhunt.carrorentaladmin.api.ApiClient;
import com.logixhunt.carrorentaladmin.api.ApiInterface;
import com.logixhunt.carrorentaladmin.api.response.LoginResponse;
import com.logixhunt.carrorentaladmin.databinding.FragmentProfileBinding;
import com.logixhunt.carrorentaladmin.model.LoginModel;
import com.logixhunt.carrorentaladmin.ui.activity.EditProfileActivity;
import com.logixhunt.carrorentaladmin.ui.activity.LoginActivity;
import com.logixhunt.carrorentaladmin.ui.activity.MainActivity;
import com.logixhunt.carrorentaladmin.ui.common.BaseFragment;
import com.logixhunt.carrorentaladmin.utils.Constant;
import com.logixhunt.carrorentaladmin.utils.ImagePathDecider;
import com.logixhunt.carrorentaladmin.utils.PreferenceUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    FragmentProfileBinding binding;
    String userId="";
    LoginModel loginModel = new LoginModel();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentProfileBinding.inflate(getLayoutInflater());

        getuserPreference();
        return binding.getRoot();
    }

    private void getuserPreference() {
         userId = PreferenceUtils.getString(Constant.PreferenceConstant.USER_ID, getContext());

        initialization();
    }

    private void initialization(){
        binding.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), EditProfileActivity.class);
                startActivity(intent);
            }
        });
        userDetailsApi();

    }

    private void userDetailsApi() {


        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<LoginResponse> call = apiInterface.userDetails(userId);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                try {
                    if (String.valueOf(response.code()).equalsIgnoreCase(Constant.SUCCESS_RESPONSE_CODE)) {
                        if (response.body().getResult().equalsIgnoreCase(Constant.SUCCESS_RESPONSE)) {
                           // Toast.makeText(getContext(), ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();

                            PreferenceUtils.setString(Constant.PreferenceConstant.USER_DATA, new Gson().toJson(response.body().getData().get(0)), getContext());
                            PreferenceUtils.setString(Constant.PreferenceConstant.USER_ID, response.body().getData().get(0).getmAdminId(), getContext());

                            loginModel = response.body().getData().get(0);

                            setData();

                        } else {

                            Toast.makeText(getContext(), ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    } else {

                        Toast.makeText(getContext(), ""+response.message(), Toast.LENGTH_SHORT).show();

                    }
                } catch (Exception e) {

                    e.printStackTrace();
                    Toast.makeText(requireContext(), ""+response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                Log.e("Failure", t.toString());
                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setData() {

        binding.tvName.setText(loginModel.getmAdminName());
        binding.tvMobile.setText(loginModel.getmAdminContact());
        binding.tvEmail.setText(loginModel.getmAdminEmail());
        binding.tvPassword.setText(loginModel.getmAdminPass());

        Glide.with(requireContext())
                .load(ImagePathDecider.getUserImagePath()+loginModel.getmAdminImg())
                .error(R.drawable.img_no_profile)
                .into(binding.ivUser);


    }

    @Override
    public void onResume() {
        super.onResume();
        getuserPreference();
    }
}