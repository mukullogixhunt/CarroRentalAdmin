package com.logixhunt.carrorentaladmin.ui.fragment.booking;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
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
import com.logixhunt.carrorentaladmin.api.response.BookingListResponse;
import com.logixhunt.carrorentaladmin.databinding.FragmentLuxuryBookingBinding;
import com.logixhunt.carrorentaladmin.model.BookingListModel;
import com.logixhunt.carrorentaladmin.ui.adapter.BookingListAdapter;
import com.logixhunt.carrorentaladmin.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LuxuryBookingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LuxuryBookingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LuxuryBookingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LuxuryBookingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LuxuryBookingFragment newInstance(String param1, String param2) {
        LuxuryBookingFragment fragment = new LuxuryBookingFragment();
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

    FragmentLuxuryBookingBinding binding;

    BookingListAdapter bookingListAdapter;

    List<BookingListModel> bookingListModels = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentLuxuryBookingBinding.inflate(getLayoutInflater());
        initialization();
        return binding.getRoot();


    }

    private void initialization(){

        bookingLuxuryCarApi();


    }

    private void bookingLuxuryCarApi() {

        binding.lvNoData.setVisibility(View.VISIBLE);
        binding.rvCab.setVisibility(View.GONE);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<BookingListResponse> call = apiInterface.bookingLuxuryCar();
        call.enqueue(new Callback<BookingListResponse>() {
            @Override
            public void onResponse(Call<BookingListResponse> call, Response<BookingListResponse> response) {

                try {
                    if (String.valueOf(response.code()).equalsIgnoreCase(Constant.SUCCESS_RESPONSE_CODE)) {
                        if (response.body().getResult().equalsIgnoreCase(Constant.SUCCESS_RESPONSE)) {
                            // Toast.makeText(getContext(), ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();

                            bookingListModels.clear();
                            bookingListModels.addAll(response.body().getData());

                            binding.lvNoData.setVisibility(View.GONE);
                            binding.rvCab.setVisibility(View.VISIBLE);

                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                            binding.rvCab.setLayoutManager(linearLayoutManager);
                            bookingListAdapter = new BookingListAdapter(getContext(), bookingListModels);
                            binding.rvCab.setAdapter(bookingListAdapter);

                            bookingListAdapter.notifyDataSetChanged();


                        } else {
                            binding.lvNoData.setVisibility(View.VISIBLE);
                            binding.rvCab.setVisibility(View.GONE);
//                            Toast.makeText(getContext(), ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        binding.lvNoData.setVisibility(View.VISIBLE);
                        binding.rvCab.setVisibility(View.GONE);
//                        Toast.makeText(getContext(), ""+response.message(), Toast.LENGTH_SHORT).show();

                    }
                } catch (Exception e) {
                    binding.lvNoData.setVisibility(View.VISIBLE);
                    binding.rvCab.setVisibility(View.GONE);
                    e.printStackTrace();
//                    Toast.makeText(getContext(), ""+response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BookingListResponse> call, Throwable t) {
                binding.lvNoData.setVisibility(View.VISIBLE);
                binding.rvCab.setVisibility(View.GONE);
                Log.e("Failure", t.toString());
//                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }


}