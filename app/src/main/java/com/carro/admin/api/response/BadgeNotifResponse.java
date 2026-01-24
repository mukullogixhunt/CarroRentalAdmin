package com.carro.admin.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BadgeNotifResponse {

        @SerializedName("response")
        @Expose
        private String result;
        @SerializedName("data")
        @Expose
        private String notification;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }
}
