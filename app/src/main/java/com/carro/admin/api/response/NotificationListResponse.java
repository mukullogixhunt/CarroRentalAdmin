package com.carro.admin.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.carro.admin.api.response.commonResponse.BaseResponse;
import com.carro.admin.model.NotificationListModel;

import java.util.List;

public class NotificationListResponse extends BaseResponse {

    @SerializedName("data")
    @Expose
    private List<NotificationListModel> data;

    public List<NotificationListModel> getData() {
        return data;
    }

    public void setData(List<NotificationListModel> data) {
        this.data = data;
    }



}
