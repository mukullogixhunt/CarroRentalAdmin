package com.carro.admin.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.carro.admin.api.response.commonResponse.BaseResponse;
import com.carro.admin.model.CustomerListModel;

import java.util.List;

public class CustomerListResponse extends BaseResponse {

    @SerializedName("data")
    @Expose
    private List<CustomerListModel> data;

    public List<CustomerListModel> getData() {
        return data;
    }

    public void setData(List<CustomerListModel> data) {
        this.data = data;
    }
}
