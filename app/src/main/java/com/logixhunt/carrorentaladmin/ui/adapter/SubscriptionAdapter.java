package com.logixhunt.carrorentaladmin.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.logixhunt.carrorentaladmin.R;
import com.logixhunt.carrorentaladmin.databinding.SubBkingItemBinding;
import com.logixhunt.carrorentaladmin.databinding.SubBkingItemBinding;
import com.logixhunt.carrorentaladmin.model.RentalModel;
import com.logixhunt.carrorentaladmin.model.SubscriptionModel;
import com.logixhunt.carrorentaladmin.ui.activity.BookingDetailsActivity;
import com.logixhunt.carrorentaladmin.ui.activity.SubsDetailsActivity;
import com.logixhunt.carrorentaladmin.utils.Constant;
import com.logixhunt.carrorentaladmin.utils.DateFormater;

import java.util.List;

public class SubscriptionAdapter extends RecyclerView.Adapter<SubscriptionAdapter.ViewHolder> {

    Context context;
    List<SubscriptionModel> items;

    public SubscriptionAdapter(Context context, List<SubscriptionModel> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SubBkingItemBinding binding = SubBkingItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SubscriptionModel item = items.get(holder.getAdapterPosition());

        holder.binding.tvBkingId.setText("#" + item.getmBookingId());
        holder.binding.tvCustomerName.setText(item.getmCustName()+" ("+item.getmCustMobile()+")");

        holder.binding.tvTotal.setText("Rs. "+item.getmSubsPrice() + "/-");
        holder.binding.tvSub.setText(item.getmSubsDay());

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
            Intent intent = new Intent(context, SubsDetailsActivity.class);
            intent.putExtra(Constant.BundleExtras.SUB_DATA, new Gson().toJson(item));
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SubBkingItemBinding binding;

        public ViewHolder(SubBkingItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
