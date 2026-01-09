package com.logixhunt.carrorentaladmin.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotificationListModel {

    @SerializedName("m_notif_id")
    @Expose
    private String mNotifId;
    @SerializedName("m_notif_type")
    @Expose
    private String mNotifType;
    @SerializedName("m_notif_title")
    @Expose
    private String mNotifTitle;
    @SerializedName("m_notif_image")
    @Expose
    private String mNotifImage;
    @SerializedName("m_notif_message")
    @Expose
    private String mNotifMessage;
    @SerializedName("m_notif_user")
    @Expose
    private String mNotifUser;
    @SerializedName("m_notif_date")
    @Expose
    private String mNotifDate;
    @SerializedName("m_notif_time")
    @Expose
    private String mNotifTime;
    @SerializedName("m_cust_id")
    @Expose
    private String mCustId;
    @SerializedName("m_cust_name")
    @Expose
    private String mCustName;
    @SerializedName("m_vendor_id")
    @Expose
    private String mVendorId;
    @SerializedName("m_vendor_name")
    @Expose
    private String mVendorName;
    @SerializedName("m_bking_id")
    @Expose
    private String mBkingId;






    @SerializedName("m_booking_id")
    @Expose
    private String mBookingId;
    // inside NotificationListModel class

    // Local field to track if notification is read
    private boolean isRead = false; // default false

    // Getter
    public boolean isRead() {
        return isRead;
    }

    // Setter
    public void setRead(boolean read) {
        isRead = read;
    }












    public String getmNotifId() {
        return mNotifId;
    }

    public void setmNotifId(String mNotifId) {
        this.mNotifId = mNotifId;
    }

    public String getmNotifType() {
        return mNotifType;
    }

    public void setmNotifType(String mNotifType) {
        this.mNotifType = mNotifType;
    }

    public String getmNotifTitle() {
        return mNotifTitle;
    }

    public void setmNotifTitle(String mNotifTitle) {
        this.mNotifTitle = mNotifTitle;
    }

    public String getmNotifImage() {
        return mNotifImage;
    }

    public void setmNotifImage(String mNotifImage) {
        this.mNotifImage = mNotifImage;
    }

    public String getmNotifMessage() {
        return mNotifMessage;
    }

    public void setmNotifMessage(String mNotifMessage) {
        this.mNotifMessage = mNotifMessage;
    }

    public String getmNotifUser() {
        return mNotifUser;
    }

    public void setmNotifUser(String mNotifUser) {
        this.mNotifUser = mNotifUser;
    }

    public String getmNotifDate() {
        return mNotifDate;
    }

    public void setmNotifDate(String mNotifDate) {
        this.mNotifDate = mNotifDate;
    }

    public String getmNotifTime() {
        return mNotifTime;
    }

    public void setmNotifTime(String mNotifTime) {
        this.mNotifTime = mNotifTime;
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

    public String getmBkingId() {
        return mBkingId;
    }

    public void setmBkingId(String mBkingId) {
        this.mBkingId = mBkingId;
    }

    public String getmBookingId() {
        return mBookingId;
    }

    public void setmBookingId(String mBookingId) {
        this.mBookingId = mBookingId;
    }
}
