package com.carro.admin.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.carro.admin.api.response.commonResponse.BaseResponse;
import com.carro.admin.model.RentalModel;

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
