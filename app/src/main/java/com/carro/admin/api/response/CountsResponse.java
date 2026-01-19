package com.carro.admin.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.carro.admin.api.response.commonResponse.BaseResponse;
import com.carro.admin.model.CountsModel;

public class CountsResponse extends BaseResponse {

    @SerializedName("data")
    @Expose
    private CountsModel data;

    public CountsModel getData() {
        return data;
    }

    public void setData(CountsModel data) {
        this.data = data;
    }
}
