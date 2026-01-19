package com.carro.admin.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carro.admin.api.ApiClient;
import com.carro.admin.api.ApiInterface;
import com.carro.admin.databinding.NotificationItemBinding;
import com.carro.admin.model.MarkAllReadResponse;
import com.carro.admin.model.NotificationListModel;
import com.carro.admin.utils.Constant;
import com.carro.admin.utils.DateFormater;

import java.util.List;

import retrofit2.Call;

public class NotificationListAdapter extends RecyclerView.Adapter<NotificationListAdapter.ViewHolder> {

    private final Context context;
    private final List<NotificationListModel> items;
    private final String userId;

    public NotificationListAdapter(Context context, List<NotificationListModel> items, String userId) {
        this.context = context;
        this.items = items;
        this.userId = userId;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NotificationItemBinding binding = NotificationItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NotificationListModel item = items.get(position);

        // Set notification text
        holder.binding.tvMsg.setText(item.getmNotifMessage());
        holder.binding.tvTitle.setText(item.getmNotifTitle());
        holder.binding.tvDate.setText(DateFormater.changeDateFormat(Constant.yyyyMMdd, Constant.ddMMyyyy, item.getmNotifDate()));
        holder.binding.tvTime.setText(DateFormater.changeDateFormat(Constant.HHMMSS, Constant.HHMMSSA, item.getmNotifTime()));

        // Set read/unread style
        if (item.getmNotifStatus().equals("Read")) {
            holder.binding.tvTitle.setTextColor(Color.GRAY);
            holder.binding.tvMsg.setTextColor(Color.GRAY);
            holder.binding.tvTitle.setTypeface(null, Typeface.NORMAL);
        } else {
            holder.binding.tvTitle.setTextColor(Color.BLACK);
            holder.binding.tvMsg.setTextColor(Color.BLACK);
            holder.binding.tvTitle.setTypeface(null, Typeface.BOLD);
        }

        // Click listener for single item
        holder.binding.notificationRoot.setOnClickListener(v -> {
            int adapterPosition = holder.getAdapterPosition();
            if (adapterPosition == RecyclerView.NO_POSITION) return; // item no longer exists

            NotificationListModel clickedItem = items.get(adapterPosition);
            if (!clickedItem.isRead()) {
                // Update UI immediately
                clickedItem.setRead(true);
                notifyItemChanged(adapterPosition);

                // Call API to mark as read
                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                Call<MarkAllReadResponse> call = apiService.markItemNotificationsRead(
                        userId,
                        clickedItem.getmNotifType(),
                        clickedItem.getmNotifId()
                );

                call.enqueue(new retrofit2.Callback<MarkAllReadResponse>() {
                    @Override
                    public void onResponse(Call<MarkAllReadResponse> call, retrofit2.Response<MarkAllReadResponse> response) {
                        if (!(response.isSuccessful() && response.body() != null)) {
                            // API failed → revert UI
                            clickedItem.setRead(false);
                            notifyItemChanged(adapterPosition);
                            Log.d("NotificationListAdapter", "API success");
                           Toast.makeText(context,"single item readed",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<MarkAllReadResponse> call, Throwable t) {
                        // API failed → revert UI
                        clickedItem.setRead(false);
                        notifyItemChanged(adapterPosition);
                        Toast.makeText(context,"single item not",Toast.LENGTH_SHORT).show();
                        Log.d("NotificationListAdapter", "API not success");
                    }
                });
            }
        });
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    // --- Mark all notifications as read ---
    public void markAllRead() {
        for (NotificationListModel n : items) {
            n.setRead(true);
        }
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        NotificationItemBinding binding;

        public ViewHolder(NotificationItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
