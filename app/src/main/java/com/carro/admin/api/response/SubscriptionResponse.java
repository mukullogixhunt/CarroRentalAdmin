package com.carro.admin.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.carro.admin.api.response.commonResponse.BaseResponse;
import com.carro.admin.model.SubscriptionModel;

import java.util.List;

public class SubscriptionResponse extends BaseResponse {
    @SerializedName("data")
    @Expose
    private List<SubscriptionModel> data;

    public List<SubscriptionModel> getData() {
        return data;
    }

    public void setData(List<SubscriptionModel> data) {
        this.data = data;
    }
}
