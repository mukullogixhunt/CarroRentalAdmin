package com.carro.admin.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.carro.admin.R;
import com.carro.admin.databinding.RentBkingItemBinding;
import com.carro.admin.model.RentalModel;
import com.carro.admin.ui.activity.RentalDetailsActivity;
import com.carro.admin.utils.Constant;
import com.carro.admin.utils.DateFormater;

import java.util.List;

public class RentalAdapter extends RecyclerView.Adapter<RentalAdapter.ViewHolder> {

    Context context;
    List<RentalModel> items;

    public RentalAdapter(Context context, List<RentalModel> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RentBkingItemBinding binding = RentBkingItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RentalModel item = items.get(holder.getAdapterPosition());

        holder.binding.tvBkingId.setText("#" + item.getmBookingId());
        holder.binding.tvCustomerName.setText(item.getmCustName()+" ("+item.getmCustMobile()+")");

        holder.binding.tvPickup.setText(DateFormater.changeDateFormat(Constant.yyyyMMdd, Constant.ddMMyyyy, item.getmBkingPickup())
                +"\n"+
                DateFormater.changeDateFormat(Constant.HHMMSS, Constant.HHMMSSA, item.getmBkingPickupAt()));
        holder.binding.tvDrop.setText(DateFormater.changeDateFormat(Constant.yyyyMMdd, Constant.ddMMyyyy, item.getmBkingReturn())
                +"\n"+
                DateFormater.changeDateFormat(Constant.HHMMSS, Constant.HHMMSSA, item.getmBkingReturnAt()));

        holder.binding.tvTotalAmt.setText("Rs. "+item.getmBkingTotal() + "/-");
        holder.binding.tvPackage.setText("Rs. "+item.getSdhPrice() + "/ Hr");

        switch (item.getmBkingStatus()) {
            case "1":
                holder.binding.tvStatus.setText("Pending");
                holder.binding.tvStatus.setBackgroundColor(context.getResources().getColor(R.color.yello));
                break;
            case "2":
                holder.binding.tvStatus.setText("Accepted");
                holder.binding.tvStatus.setBackgroundColor(context.getResources().getColor(R.color.green2));
                break;
            case "3":
                holder.binding.tvStatus.setText("Completed");
                holder.binding.tvStatus.setBackgroundColor(context.getResources().getColor(R.color.blue));
                break;
            case "4":
                holder.binding.tvStatus.setText("Cancelled");
                holder.binding.tvStatus.setBackgroundColor(context.getResources().getColor(R.color.red2));
                break;
            default:
                holder.binding.tvStatus.setText("NA");
                holder.binding.tvStatus.setBackgroundColor(context.getResources().getColor(R.color.gray_light));

        }


        holder.binding.getRoot().setOnClickListener(View -> {
            // **MODIFICATION START: Sending data manually**

            // This is the original way
            Intent intent = new Intent(context, RentalDetailsActivity.class);
            intent.putExtra(Constant.BundleExtras.RENT_DATA, new Gson().toJson(item));
            context.startActivity(intent);
                 String tag = "DETAILS";
            // Logging added here
            Log.d(tag, "---- Car Details Clicked & Sent ----");
            Log.d(tag, "Car Name: " + item.getmCtypeTitle());
            Log.d(tag, "Driver Type: " + item.getmCtypeDrivetype());
            Log.d(tag, "Seats: " + item.getmCtypeSeat());
            Log.d(tag, "Car Number: " + item.getmCtypeNumber());
            Log.d(tag, "Luggage: " + item.getmCtypeLuggage());
            Log.d(tag, "Fuel: " + item.getmCtypeFuel());
            Log.d(tag, "------------------------------------");

            // This is the manual way - Uncomment this block and comment the lines above to use it.

            // --- Manually add all data to the intent ---
            intent.putExtra(Constant.BundleExtras.BOOKING_ID, item.getmBkingId());
            intent.putExtra(Constant.BundleExtras.BOOKING_TYPE, item.getmBkingType());
            intent.putExtra(Constant.BundleExtras.BOOKING_TYPE_CAT, item.getmBkingTypeCat());
            // Booking Details
            intent.putExtra("mBkingId", item.getmBkingId());
            intent.putExtra("mBookingId", item.getmBookingId());
            intent.putExtra("mBkingStatus", item.getmBkingStatus());
            intent.putExtra("mBranchTitle", item.getmBranchTitle());
            intent.putExtra("mBkingAddedon", item.getmBkingAddedon());
            intent.putExtra("mBkingPickup", item.getmBkingPickup());
            intent.putExtra("mBkingPickupAt", item.getmBkingPickupAt());
            intent.putExtra("mBkingReturn", item.getmBkingReturn());
            intent.putExtra("mBkingReturnAt", item.getmBkingReturnAt());

            // Customer Details
            intent.putExtra("mCustName", item.getmCustName());
            intent.putExtra("mCustMobile", item.getmCustMobile());
            intent.putExtra("mCustCity", item.getmCustCity());

            // Car Details
            intent.putExtra("mCtypeTitle", item.getmCtypeTitle());
            intent.putExtra("mCtypeDrivetype", item.getmCtypeDrivetype());
            intent.putExtra("mCtypeSeat", item.getmCtypeSeat());
            intent.putExtra("mCtypeNumber", item.getmCtypeNumber());
            intent.putExtra("mCtypeLuggage", item.getmCtypeLuggage());
            intent.putExtra("mCtypeFuel", item.getmCtypeFuel());

            // Payment Details
            intent.putExtra("mBkingKm", item.getmBkingKm());
            intent.putExtra("mBkingFastag", item.getmBkingFastag());
            intent.putExtra("mBkingTotal", item.getmBkingTotal());
            intent.putExtra("mBkingPaidAmt", item.getmBkingPaidAmt());
            intent.putExtra("mBkingRemainAmt", item.getmBkingRemainAmt());
            intent.putExtra("mBkingPaymode", item.getmBkingPaymode());
            intent.putExtra("mBkingPayStatus", item.getmBkingPayStatus());

            // You would need to add ALL other fields from RentalModel here as well...

            context.startActivity(intent);


            // **MODIFICATION END**
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RentBkingItemBinding binding;

        public ViewHolder(RentBkingItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
