package com.carro.admin.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.carro.admin.api.response.commonResponse.BaseResponse;
import com.carro.admin.model.BookingIdModel;

import java.util.List;

public class BookingIdResponse extends BaseResponse {
    @SerializedName("data")
    @Expose
    private List<BookingIdModel> data;

    public List<BookingIdModel> getData() {
        return data;
    }

    public void setData(List<BookingIdModel> data) {
        this.data = data;
    }
}
