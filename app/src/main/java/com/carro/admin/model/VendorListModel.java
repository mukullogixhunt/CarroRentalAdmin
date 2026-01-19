package com.carro.admin.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VendorListModel {

    @SerializedName("m_vendor_id")
    @Expose
    private String mVendorId;
    @SerializedName("m_vendor_name")
    @Expose
    private String mVendorName;
    @SerializedName("m_vendor_mobile")
    @Expose
    private String mVendorMobile;

    public VendorListModel(String mVendorId, String mVendorName, String mVendorMobile) {
        this.mVendorId = mVendorId;
        this.mVendorName = mVendorName;
        this.mVendorMobile = mVendorMobile;
    }

    public String getmVendorId() {
        return mVendorId;
    }

    public void setmVendorId(String mVendorId) {
        this.mVendorId = mVendorId;
    }

    public String getmVendorName() {
        return mVendorName;
    }

    public void setmVendorName(String mVendorName) {
        this.mVendorName = mVendorName;
    }

    public String getmVendorMobile() {
        return mVendorMobile;
    }

    public void setmVendorMobile(String mVendorMobile) {
        this.mVendorMobile = mVendorMobile;
    }

    @NonNull
    @Override
    public String toString() {
        return mVendorName;
    }
}
