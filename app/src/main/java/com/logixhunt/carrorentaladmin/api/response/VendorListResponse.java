package com.logixhunt.carrorentaladmin.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.logixhunt.carrorentaladmin.api.response.commonResponse.BaseResponse;
import com.logixhunt.carrorentaladmin.model.VendorListModel;

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
