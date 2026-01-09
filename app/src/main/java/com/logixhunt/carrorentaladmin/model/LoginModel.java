package com.logixhunt.carrorentaladmin.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginModel {
    @SerializedName("m_admin_id")
    @Expose
    private String mAdminId;
    @SerializedName("m_admin_type")
    @Expose
    private String mAdminType;
    @SerializedName("m_admin_name")
    @Expose
    private String mAdminName;
    @SerializedName("m_admin_email")
    @Expose
    private String mAdminEmail;
    @SerializedName("m_admin_contact")
    @Expose
    private String mAdminContact;
    @SerializedName("m_admin_pass")
    @Expose
    private String mAdminPass;
    @SerializedName("m_admin_whatsapp")
    @Expose
    private String mAdminWhatsapp;
    @SerializedName("m_admin_address")
    @Expose
    private String mAdminAddress;
    @SerializedName("m_admin_img")
    @Expose
    private String mAdminImg;
    @SerializedName("m_admin_status")
    @Expose
    private String mAdminStatus;
    @SerializedName("m_admin_addedon")
    @Expose
    private String mAdminAddedon;
    @SerializedName("m_admin_updatedon")
    @Expose
    private String mAdminUpdatedon;

    public String getmAdminId() {
        return mAdminId;
    }

    public void setmAdminId(String mAdminId) {
        this.mAdminId = mAdminId;
    }

    public String getmAdminType() {
        return mAdminType;
    }

    public void setmAdminType(String mAdminType) {
        this.mAdminType = mAdminType;
    }

    public String getmAdminName() {
        return mAdminName;
    }

    public void setmAdminName(String mAdminName) {
        this.mAdminName = mAdminName;
    }

    public String getmAdminEmail() {
        return mAdminEmail;
    }

    public void setmAdminEmail(String mAdminEmail) {
        this.mAdminEmail = mAdminEmail;
    }

    public String getmAdminContact() {
        return mAdminContact;
    }

    public void setmAdminContact(String mAdminContact) {
        this.mAdminContact = mAdminContact;
    }

    public String getmAdminPass() {
        return mAdminPass;
    }

    public void setmAdminPass(String mAdminPass) {
        this.mAdminPass = mAdminPass;
    }

    public String getmAdminWhatsapp() {
        return mAdminWhatsapp;
    }

    public void setmAdminWhatsapp(String mAdminWhatsapp) {
        this.mAdminWhatsapp = mAdminWhatsapp;
    }

    public String getmAdminAddress() {
        return mAdminAddress;
    }

    public void setmAdminAddress(String mAdminAddress) {
        this.mAdminAddress = mAdminAddress;
    }

    public String getmAdminImg() {
        return mAdminImg;
    }

    public void setmAdminImg(String mAdminImg) {
        this.mAdminImg = mAdminImg;
    }

    public String getmAdminStatus() {
        return mAdminStatus;
    }

    public void setmAdminStatus(String mAdminStatus) {
        this.mAdminStatus = mAdminStatus;
    }

    public String getmAdminAddedon() {
        return mAdminAddedon;
    }

    public void setmAdminAddedon(String mAdminAddedon) {
        this.mAdminAddedon = mAdminAddedon;
    }

    public String getmAdminUpdatedon() {
        return mAdminUpdatedon;
    }

    public void setmAdminUpdatedon(String mAdminUpdatedon) {
        this.mAdminUpdatedon = mAdminUpdatedon;
    }
}
