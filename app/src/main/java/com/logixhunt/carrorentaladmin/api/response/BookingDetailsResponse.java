package com.logixhunt.carrorentaladmin.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.logixhunt.carrorentaladmin.api.response.commonResponse.BaseResponse;
import com.logixhunt.carrorentaladmin.model.BookingListModel;

import java.util.List;

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
