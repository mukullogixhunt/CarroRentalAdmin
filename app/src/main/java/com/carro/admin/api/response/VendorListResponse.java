package com.carro.admin.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.carro.admin.api.response.commonResponse.BaseResponse;
import com.carro.admin.model.VendorListModel;

import java.util.List;

public class VendorListResponse extends BaseResponse {

    @SerializedName("data")
    @Expose
    private List<VendorListModel> data;

    public List<VendorListModel> getData() {
        return data;
    }

    public void setData(List<VendorListModel> data) {
        this.data = data;
    }
}
