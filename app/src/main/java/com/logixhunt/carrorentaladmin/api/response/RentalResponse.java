package com.logixhunt.carrorentaladmin.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.logixhunt.carrorentaladmin.api.response.commonResponse.BaseResponse;
import com.logixhunt.carrorentaladmin.model.RentalModel;

import java.util.List;

public class RentalResponse extends BaseResponse {
    @SerializedName("data")
    @Expose
    private List<RentalModel> data;

    public List<RentalModel> getData() {
        return data;
    }

    public void setData(List<RentalModel> data) {
        this.data = data;
    }
}
