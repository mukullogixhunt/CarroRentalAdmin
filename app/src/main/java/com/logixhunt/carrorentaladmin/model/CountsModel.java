package com.logixhunt.carrorentaladmin.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountsModel {

    @SerializedName("TodayBooking")
    @Expose
    private Integer todayBooking;
    @SerializedName("TotalBooking")
    @Expose
    private Integer totalBooking;
    @SerializedName("TotalVendor")
    @Expose
    private Integer totalVendor;
    @SerializedName("TotalCustomer")
    @Expose
    private Integer totalCustomer;

    public Integer getTodayBooking() {
        return todayBooking;
    }

    public void setTodayBooking(Integer todayBooking) {
        this.todayBooking = todayBooking;
    }

    public Integer getTotalBooking() {
        return totalBooking;
    }

    public void setTotalBooking(Integer totalBooking) {
        this.totalBooking = totalBooking;
    }

    public Integer getTotalVendor() {
        return totalVendor;
    }

    public void setTotalVendor(Integer totalVendor) {
        this.totalVendor = totalVendor;
    }

    public Integer getTotalCustomer() {
        return totalCustomer;
    }

    public void setTotalCustomer(Integer totalCustomer) {
        this.totalCustomer = totalCustomer;
    }
}
