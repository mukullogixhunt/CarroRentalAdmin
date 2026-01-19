package com.carro.admin.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.carro.admin.api.response.commonResponse.BaseResponse;
import com.carro.admin.model.BookingListModel;

public class BookingDetailsResponse extends BaseResponse {
    @SerializedName("data")
    @Expose
    private BookingListModel data;

    public BookingListModel getData() {
        return data;
    }

    public void setData(BookingListModel data) {
        this.data = data;
    }
}
