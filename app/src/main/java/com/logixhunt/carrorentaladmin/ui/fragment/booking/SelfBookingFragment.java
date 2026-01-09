package com.logixhunt.carrorentaladmin.ui.fragment.booking;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.logixhunt.carrorentaladmin.R;
import com.logixhunt.carrorentaladmin.api.ApiClient;
import com.logixhunt.carrorentaladmin.api.ApiInterface;
import com.logixhunt.carrorentaladmin.api.response.RentalResponse;
import com.logixhunt.carrorentaladmin.api.response.RentalResponse;
import com.logixhunt.carrorentaladmin.api.response.SubscriptionResponse;
import com.logixhunt.carrorentaladmin.databinding.FragmentSelfBookingBinding;
import com.logixhunt.carrorentaladmin.model.BookingListModel;
import com.logixhunt.carrorentaladmin.model.RentalModel;
import com.logixhunt.carrorentaladmin.model.SubscriptionModel;
import com.logixhunt.carrorentaladmin.ui.adapter.BookingListAdapter;
import com.logixhunt.carrorentaladmin.ui.adapter.RentalAdapter;
import com.logixhunt.carrorentaladmin.ui.adapter.SubscriptionAdapter;
import com.logixhunt.carrorentaladmin.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SelfBookingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelfBookingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SelfBookingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SelfBookingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SelfBookingFragment newInstance(String param1, String param2) {
        SelfBookingFragment fragment = new SelfBookingFragment();
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

    FragmentSelfBookingBinding binding;
    RentalAdapter rentalAdapter;
    SubscriptionAdapter subscriptionAdapter;

    List<RentalModel> rentalList = new ArrayList<>();
    List<SubscriptionModel> subList = new ArrayList<>();
    String bookType="rent";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentSelfBookingBinding.inflate(getLayoutInflater());
        initialization();
        return binding.getRoot();
    }

    private void initialization(){

        rentBookingSelfApi();
        subBookingSelfApi();

        binding.cardRental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookType="rent";
                binding.cardRental.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.primary));
                binding.cardSubscribe.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
                binding.tvRent.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                binding.tvSub.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                binding.llRent.setVisibility(View.VISIBLE);
                binding.llSub.setVisibility(View.GONE);

            }
        });
        binding.cardSubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookType="sub";
                binding.cardRental.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
                binding.cardSubscribe.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.primary));
                binding.tvRent.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                binding.tvSub.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                binding.llRent.setVisibility(View.GONE);
                binding.llSub.setVisibility(View.VISIBLE);
            }
        });

    }
    private void rentBookingSelfApi() {
        binding.lvNoDataRent.setVisibility(View.VISIBLE);
        binding.rvRent.setVisibility(View.GONE);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<RentalResponse> call = apiInterface.bookingSelfDerive();
        call.enqueue(new Callback<RentalResponse>() {
            @Override
            public void onResponse(Call<RentalResponse> call, Response<RentalResponse> response) {

                try {
                    if (String.valueOf(response.code()).equalsIgnoreCase(Constant.SUCCESS_RESPONSE_CODE)) {
                        if (response.body().getResult().equalsIgnoreCase(Constant.SUCCESS_RESPONSE)) {
                            // Toast.makeText(getContext(), ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();

                            rentalList.clear();
                            rentalList.addAll(response.body().getData());

                            binding.lvNoDataRent.setVisibility(View.GONE);
                            binding.rvRent.setVisibility(View.VISIBLE);

                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                            binding.rvRent.setLayoutManager(linearLayoutManager);
                            rentalAdapter = new RentalAdapter(getContext(), rentalList);
                            binding.rvRent.setAdapter(rentalAdapter);

                            rentalAdapter.notifyDataSetChanged();

                        } else {
                            binding.lvNoDataRent.setVisibility(View.VISIBLE);
                            binding.rvRent.setVisibility(View.GONE);
//                            Toast.makeText(getContext(), ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        binding.lvNoDataRent.setVisibility(View.VISIBLE);
                        binding.rvRent.setVisibility(View.GONE);
//                        Toast.makeText(getContext(), ""+response.message(), Toast.LENGTH_SHORT).show();

                    }
                } catch (Exception e) {
                    binding.lvNoDataRent.setVisibility(View.VISIBLE);
                    binding.rvRent.setVisibility(View.GONE);
                    e.printStackTrace();
//                    Toast.makeText(getContext(), ""+response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RentalResponse> call, Throwable t) {
                binding.lvNoDataRent.setVisibility(View.VISIBLE);
                binding.rvRent.setVisibility(View.GONE);
                Log.e("Failure", t.toString());
//                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void subBookingSelfApi() {
        binding.lvNoDataSub.setVisibility(View.VISIBLE);
        binding.rvSub.setVisibility(View.GONE);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<SubscriptionResponse> call = apiInterface.subBookingSelfDerive();
        call.enqueue(new Callback<SubscriptionResponse>() {
            @Override
            public void onResponse(Call<SubscriptionResponse> call, Response<SubscriptionResponse> response) {

                try {
                    if (String.valueOf(response.code()).equalsIgnoreCase(Constant.SUCCESS_RESPONSE_CODE)) {
                        if (response.body().getResult().equalsIgnoreCase(Constant.SUCCESS_RESPONSE)) {
                            // Toast.makeText(getContext(), ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();

                            subList.clear();
                            subList.addAll(response.body().getData());

                            binding.lvNoDataSub.setVisibility(View.GONE);
                            binding.rvSub.setVisibility(View.VISIBLE);

                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                            binding.rvSub.setLayoutManager(linearLayoutManager);
                            subscriptionAdapter = new SubscriptionAdapter(getContext(), subList);
                            binding.rvSub.setAdapter(subscriptionAdapter);

                            subscriptionAdapter.notifyDataSetChanged();

                        } else {
                            binding.lvNoDataSub.setVisibility(View.VISIBLE);
                            binding.rvSub.setVisibility(View.GONE);
//                            Toast.makeText(getContext(), ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        binding.lvNoDataSub.setVisibility(View.VISIBLE);
                        binding.rvSub.setVisibility(View.GONE);
//                        Toast.makeText(getContext(), ""+response.message(), Toast.LENGTH_SHORT).show();

                    }
                } catch (Exception e) {
                    binding.lvNoDataSub.setVisibility(View.VISIBLE);
                    binding.rvSub.setVisibility(View.GONE);
                    e.printStackTrace();
//                    Toast.makeText(getContext(), ""+response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SubscriptionResponse> call, Throwable t) {
                binding.lvNoDataSub.setVisibility(View.VISIBLE);
                binding.rvSub.setVisibility(View.GONE);
                Log.e("Failure", t.toString());
//                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }

}