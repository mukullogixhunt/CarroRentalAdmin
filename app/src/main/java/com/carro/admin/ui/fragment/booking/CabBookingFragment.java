//package com.logixhunt.carrorentaladmin.ui.fragment.booking;
//
//import android.content.DialogInterface;
//import android.os.Bundle;
//
//import androidx.appcompat.app.AlertDialog;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.LinearLayoutManager;
//
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Toast;
//
//import com.google.gson.Gson;
//import com.logixhunt.carrorentaladmin.R;
//import com.logixhunt.carrorentaladmin.api.ApiClient;
//import com.logixhunt.carrorentaladmin.api.ApiInterface;
//import com.logixhunt.carrorentaladmin.api.response.BookingListResponse;
//import com.logixhunt.carrorentaladmin.api.response.LoginResponse;
//import com.logixhunt.carrorentaladmin.databinding.FragmentCabBookingBinding;
//import com.logixhunt.carrorentaladmin.model.BookingListModel;
//import com.logixhunt.carrorentaladmin.ui.adapter.BookingListAdapter;
//import com.logixhunt.carrorentaladmin.utils.Constant;
//import com.logixhunt.carrorentaladmin.utils.PreferenceUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
///**
// * A simple {@link Fragment} subclass.
// * Use the {@link CabBookingFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
//public class CabBookingFragment extends Fragment {
//
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public CabBookingFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment CabBookingFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static CabBookingFragment newInstance(String param1, String param2) {
//        CabBookingFragment fragment = new CabBookingFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    FragmentCabBookingBinding binding;
//    BookingListAdapter bookingListAdapter;
//
//    List<BookingListModel> bookingListModels = new ArrayList<>();
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        binding=FragmentCabBookingBinding.inflate(getLayoutInflater());
//        initialization();
//        return binding.getRoot();
//    }
//
//    private void initialization(){
//        bookingCabApi();
//    }
//
//    private void bookingCabApi() {
//        binding.lvNoData.setVisibility(View.VISIBLE);
//        binding.rvCab.setVisibility(View.GONE);
//        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
//        Call<BookingListResponse> call = apiInterface.bookingCabService();
//        call.enqueue(new Callback<BookingListResponse>() {
//            @Override
//            public void onResponse(Call<BookingListResponse> call, Response<BookingListResponse> response) {
//
//                try {
//                    if (String.valueOf(response.code()).equalsIgnoreCase(Constant.SUCCESS_RESPONSE_CODE)) {
//                        if (response.body().getResult().equalsIgnoreCase(Constant.SUCCESS_RESPONSE)) {
//                            // Toast.makeText(getContext(), ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
//
//                            bookingListModels.clear();
//                            bookingListModels.addAll(response.body().getData());
//
//                            binding.lvNoData.setVisibility(View.GONE);
//                            binding.rvCab.setVisibility(View.VISIBLE);
//
//                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//                            binding.rvCab.setLayoutManager(linearLayoutManager);
//                            bookingListAdapter = new BookingListAdapter(getContext(), bookingListModels);
//                            binding.rvCab.setAdapter(bookingListAdapter);
//
//                            bookingListAdapter.notifyDataSetChanged();
//
//
//                        } else {
//                            binding.lvNoData.setVisibility(View.VISIBLE);
//                            binding.rvCab.setVisibility(View.GONE);
////                            Toast.makeText(getContext(), ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
//
//                        }
//                    } else {
//                        binding.lvNoData.setVisibility(View.VISIBLE);
//                        binding.rvCab.setVisibility(View.GONE);
////                        Toast.makeText(getContext(), ""+response.message(), Toast.LENGTH_SHORT).show();
//
//                    }
//                } catch (Exception e) {
//                    binding.lvNoData.setVisibility(View.VISIBLE);
//                    binding.rvCab.setVisibility(View.GONE);
//                    e.printStackTrace();
////                    Toast.makeText(getContext(), ""+response.message(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<BookingListResponse> call, Throwable t) {
//                binding.lvNoData.setVisibility(View.VISIBLE);
//                binding.rvCab.setVisibility(View.GONE);
//                Log.e("Failure", t.toString());
////                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }
//
//}



package com.carro.admin.ui.fragment.booking;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.carro.admin.R;
import com.carro.admin.api.ApiClient;
import com.carro.admin.api.ApiInterface;
import com.carro.admin.api.response.BookingListResponse;
import com.carro.admin.databinding.FragmentCabBookingBinding;
import com.carro.admin.model.BookingListModel;
import com.carro.admin.ui.adapter.BookingListAdapter;
import com.carro.admin.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CabBookingFragment extends Fragment {

    // (Your existing newInstance, etc. code remains unchanged)
    // ...

    private FragmentCabBookingBinding binding;
    private BookingListAdapter bookingListAdapter;

    // Master list to hold all data from the API
    private final List<BookingListModel> fullBookingList = new ArrayList<>();
    // List that is passed to the adapter, its content will be filtered
    private final List<BookingListModel> filteredBookingList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCabBookingBinding.inflate(inflater, container, false);
        initialization();
        return binding.getRoot();
    }

    private void initialization() {
        setupRecyclerView();
        setupTabListeners();
        bookingCabApi();
    }

    private void setupRecyclerView() {
        binding.rvCab.setLayoutManager(new LinearLayoutManager(getContext()));
        // Initialize adapter with the filterable list
        bookingListAdapter = new BookingListAdapter(getContext(), filteredBookingList);
        binding.rvCab.setAdapter(bookingListAdapter);
    }

    private void setupTabListeners() {
        binding.cardCityRide.setOnClickListener(v -> filterAndDisplayList("1"));
        binding.cardOneWay.setOnClickListener(v -> filterAndDisplayList("2"));
        binding.cardOutstation.setOnClickListener(v -> filterAndDisplayList("3"));
        binding.cardAirport.setOnClickListener(v -> filterAndDisplayList("4"));
    }

    private void updateTabUI(String selectedType) {
        // Reset all tabs to default state
        binding.cardCityRide.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
        binding.tvCityRide.setTextColor(ContextCompat.getColor(getContext(), R.color.black));

        binding.cardOneWay.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
        binding.tvOneWay.setTextColor(ContextCompat.getColor(getContext(), R.color.black));

        binding.cardOutstation.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
        binding.tvOutstation.setTextColor(ContextCompat.getColor(getContext(), R.color.black));

        binding.cardAirport.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
        binding.tvAirport.setTextColor(ContextCompat.getColor(getContext(), R.color.black));

        // Set the selected tab to the active state
        switch (selectedType) {
            case "1":
                binding.cardCityRide.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.primary));
                binding.tvCityRide.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                break;
            case "2":
                binding.cardOneWay.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.primary));
                binding.tvOneWay.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                break;
            case "3":
                binding.cardOutstation.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.primary));
                binding.tvOutstation.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                break;
            case "4":
                binding.cardAirport.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.primary));
                binding.tvAirport.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                break;
        }
    }

    private void filterAndDisplayList(String bookingType) {
        updateTabUI(bookingType);

        // Clear previous filter results
        filteredBookingList.clear();

        // Filter the full list based on the booking type
        for (BookingListModel booking : fullBookingList) {
            if (booking.getmBkingTypeCat() != null && booking.getmBkingTypeCat().equals(bookingType)) {
                filteredBookingList.add(booking);
            }
        }

        // Update the adapter
        bookingListAdapter.notifyDataSetChanged();

        // Show/hide the "no data" view
        if (filteredBookingList.isEmpty()) {
            binding.rvCab.setVisibility(View.GONE);
            binding.lvNoData.setVisibility(View.VISIBLE);
        } else {
            binding.rvCab.setVisibility(View.VISIBLE);
            binding.lvNoData.setVisibility(View.GONE);
        }
    }

    private void bookingCabApi() {
        binding.lvNoData.setVisibility(View.VISIBLE);
        binding.rvCab.setVisibility(View.GONE);
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<BookingListResponse> call = apiInterface.bookingCabService();
        call.enqueue(new Callback<BookingListResponse>() {
            @Override
            public void onResponse(Call<BookingListResponse> call, Response<BookingListResponse> response) {
                try {
                    if (String.valueOf(response.code()).equals(Constant.SUCCESS_RESPONSE_CODE) &&
                            response.body() != null &&
                            response.body().getResult().equalsIgnoreCase(Constant.SUCCESS_RESPONSE)) {

                        fullBookingList.clear();
                        fullBookingList.addAll(response.body().getData());

                        // By default, display the first tab's content
                        filterAndDisplayList("1");

                    } else {
                        // Handle cases like success=false or empty data
                        binding.lvNoData.setVisibility(View.VISIBLE);
                        binding.rvCab.setVisibility(View.GONE);
                    }
                } catch (Exception e) {
                    binding.lvNoData.setVisibility(View.VISIBLE);
                    binding.rvCab.setVisibility(View.GONE);
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<BookingListResponse> call, Throwable t) {
                binding.lvNoData.setVisibility(View.VISIBLE);
                binding.rvCab.setVisibility(View.GONE);
                Log.e("Failure", t.toString());
            }
        });
    }
}