package com.carro.admin.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerListModel {

    @SerializedName("m_cust_id")
    @Expose
    private String mCustId;
    @SerializedName("m_cust_name")
    @Expose
    private String mCustName;
    @SerializedName("m_cust_mobile")
    @Expose
    private String mCustMobile;


    public CustomerListModel(String mCustId, String mCustName, String mCustMobile) {
        this.mCustId = mCustId;
        this.mCustName = mCustName;
        this.mCustMobile = mCustMobile;
    }

    public String getmCustId() {
        return mCustId;
    }

    public void setmCustId(String mCustId) {
        this.mCustId = mCustId;
    }

    public String getmCustName() {
        return mCustName;
    }

    public void setmCustName(String mCustName) {
        this.mCustName = mCustName;
    }

    public String getmCustMobile() {
        return mCustMobile;
    }

    public void setmCustMobile(String mCustMobile) {
        this.mCustMobile = mCustMobile;
    }

    @NonNull
    @Override
    public String toString() {
        return mCustName;
    }
}
