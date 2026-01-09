package com.logixhunt.carrorentaladmin.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.logixhunt.carrorentaladmin.R;
import com.logixhunt.carrorentaladmin.databinding.CabBookingItemBinding;
import com.logixhunt.carrorentaladmin.model.BookingListModel;
import com.logixhunt.carrorentaladmin.ui.activity.BookingDetailsActivity;
import com.logixhunt.carrorentaladmin.utils.Constant;
import com.logixhunt.carrorentaladmin.utils.DateFormater;

import java.util.List;

public class BookingListAdapter extends RecyclerView.Adapter<BookingListAdapter.ViewHolder> {

    Context context;
    List<BookingListModel> items;


    public BookingListAdapter(Context context, List<BookingListModel> items) {
        this.context = context;
        this.items = items;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CabBookingItemBinding binding = CabBookingItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BookingListModel item = items.get(holder.getAdapterPosition());

        holder.binding.tvBookingId.setText("#" + item.getmBookingId());
        holder.binding.tvNumber.setText(item.getmCustMobile());
        holder.binding.tvName.setText(item.getmCustName());


        String pickupDate = item.getmBkingPickup();
        if (pickupDate == null || pickupDate.trim().isEmpty() || "0000-00-00".equals(pickupDate)) {
            // If date is invalid, hide the entire row
            holder.binding.tvPick.setVisibility(View.GONE);
        } else {
            // Date is valid, format it
            String formattedDate = DateFormater.changeDateFormat(Constant.yyyyMMdd, Constant.ddMMyyyy, pickupDate);

            // Now check and format the time
            String pickupTime = item.getmBkingPickupAt();
            String formattedTime = "";
            if (pickupTime != null && !pickupTime.trim().isEmpty() && !"00:00:00".equals(pickupTime)) {
                formattedTime = " " + DateFormater.changeDateFormat(Constant.HHMMSS, Constant.HHMMSSA, pickupTime);
            }
            holder.binding.tvPick.setVisibility(View.VISIBLE);
            holder.binding.tvPick.setText("Pick Up - " + formattedDate + formattedTime);
        }

//        holder.binding.tvPick.setText("Pick Up - " + DateFormater.changeDateFormat(Constant.yyyyMMdd, Constant.ddMMyyyy, item.getmBkingPickup()) + " at " + DateFormater.changeDateFormat(Constant.HHMMSS, Constant.HHMMSSA, item.getmBkingPickupAt()));


        String returnDate = item.getmBkingReturn();
        if (returnDate == null || returnDate.trim().isEmpty() || "0000-00-00".equals(returnDate)) {
            holder.binding.tvReturn.setVisibility(View.GONE);
        } else {
            // Date is valid, format it
            String formattedDate = DateFormater.changeDateFormat(Constant.yyyyMMdd, Constant.ddMMyyyy, returnDate);

            // Now check and format the time
            String returnTime = item.getmBkingReturnAt();
            String formattedTime = "";
            if (returnTime != null && !returnTime.trim().isEmpty() && !"00:00:00".equals(returnTime)) {
                formattedTime = " " + DateFormater.changeDateFormat(Constant.HHMMSS, Constant.HHMMSSA, returnTime);
            }
            holder.binding.tvReturn.setVisibility(View.VISIBLE);
            holder.binding.tvReturn.setText("Return - " + formattedDate + formattedTime);
        }


//        holder.binding.tvReturn.setText("Return - " + DateFormater.changeDateFormat(Constant.yyyyMMdd, Constant.ddMMyyyy, item.getmBkingReturn()) + " at " + DateFormater.changeDateFormat(Constant.HHMMSS, Constant.HHMMSSA, item.getmBkingReturnAt()));

        holder.binding.tvAddress.setText("Address - " + item.getmBkingPickupAddress());

        holder.binding.tvAmount.setText(item.getmBkingTotal() + "/-");


        // **Hide distance for Luxury bookings**
        if ("3".equals(item.getmBkingType())) { // 3 = Luxury
            holder.binding.tvDistance.setVisibility(View.GONE);
        } else {
            holder.binding.tvDistance.setVisibility(View.VISIBLE);
            holder.binding.tvDistance.setText(item.getmBkingKm() + " KM");
        }


        if (item.getmBkingPaymode().equalsIgnoreCase("1")) {
            holder.binding.tvPayMode.setText("Online");
        } else {
            holder.binding.tvPayMode.setText("Cash");
        }

        switch (item.getmBkingStatus()) {
            case "1":
                holder.binding.tvBookingStatus.setText("Pending");
                holder.binding.tvBookingStatus.setBackgroundColor(context.getResources().getColor(R.color.brown));
                break;
            case "2":
                holder.binding.tvBookingStatus.setText("Accepted");
                holder.binding.tvBookingStatus.setBackgroundColor(context.getResources().getColor(R.color.primary_dark3));
                break;
            case "3":
                holder.binding.tvBookingStatus.setText("Completed");
                holder.binding.tvBookingStatus.setBackgroundColor(context.getResources().getColor(R.color.blue));
                break;
            case "4":
                holder.binding.tvBookingStatus.setText("Cancelled");
                holder.binding.tvBookingStatus.setBackgroundColor(context.getResources().getColor(R.color.red2));
                break;
            default:
                holder.binding.tvBookingStatus.setText("NA");
                holder.binding.tvBookingStatus.setBackgroundColor(context.getResources().getColor(R.color.gray_light));

        }

        switch (item.getmBkingPayStatus()) {
            case "0":
                holder.binding.tvPayStatus.setText("Unpaid");
                break;
            case "1":
                holder.binding.tvPayStatus.setText("Paid");
                break;
            case "2":
                holder.binding.tvPayStatus.setText("Advanced");
                break;
            default:
                holder.binding.tvPayStatus.setText("NA");
        }

        if (item.getmBkingType().equals("1")) {
            switch (item.getmBkingRoadType()) {
                case "1":
                    holder.binding.tvType.setText("Oneway");
                    break;
                case "2":
                    holder.binding.tvType.setText("Round Trip");
                    break;
                case "3":
                    holder.binding.tvType.setText("Hour");
                    break;
                case "4":
                    holder.binding.tvType.setText("Airport");
                    break;
                default:
                    holder.binding.tvType.setText("NA");
            }
        } else {
            holder.binding.tvType.setVisibility(View.GONE);
            holder.binding.tvAddress.setText("Branch - " + item.getmBranchTitle());
        }

        holder.binding.getRoot().setOnClickListener(View -> {
            Intent intent = new Intent(context, BookingDetailsActivity.class);
            intent.putExtra(Constant.BundleExtras.BOOKING_ID, item.getmBkingId());
            intent.putExtra(Constant.BundleExtras.BOOKING_TYPE, item.getmBkingType());
            intent.putExtra(Constant.BundleExtras.BOOKING_TYPE_CAT, item.getmBkingTypeCat());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CabBookingItemBinding binding;

        public ViewHolder(CabBookingItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
