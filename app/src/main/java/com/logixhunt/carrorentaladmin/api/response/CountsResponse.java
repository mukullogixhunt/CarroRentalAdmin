package com.logixhunt.carrorentaladmin.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.logixhunt.carrorentaladmin.api.response.commonResponse.BaseResponse;
import com.logixhunt.carrorentaladmin.model.CountsModel;

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
