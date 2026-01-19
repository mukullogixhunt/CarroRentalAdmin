package com.carro.admin.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubscriptionModel {
    @SerializedName("m_bking_id")
    @Expose
    private String mBkingId;
    @SerializedName("m_bking_tc")
    @Expose
    private String mBkingTc;
    @SerializedName("m_booking_id")
    @Expose
    private String mBookingId;
    @SerializedName("m_bking_vendor")
    @Expose
    private String mBkingVendor;
    @SerializedName("m_bking_user")
    @Expose
    private String mBkingUser;
    @SerializedName("m_bking_username")
    @Expose
    private String mBkingUsername;
    @SerializedName("m_bking_useremail")
    @Expose
    private String mBkingUseremail;
    @SerializedName("m_bking_usermobile")
    @Expose
    private String mBkingUsermobile;
    @SerializedName("m_bking_type")
    @Expose
    private String mBkingType;
    @SerializedName("m_bking_type_cat")
    @Expose
    private String mBkingTypeCat;
    @SerializedName("m_bking_road_type")
    @Expose
    private String mBkingRoadType;
    @SerializedName("m_bking_hour")
    @Expose
    private String mBkingHour;
    @SerializedName("m_bking_inside_outside_state")
    @Expose
    private String mBkingInsideOutsideState;
    @SerializedName("m_bking_inside_outside_state_amt")
    @Expose
    private String mBkingInsideOutsideStateAmt;
    @SerializedName("m_bking_pick_drop_both")
    @Expose
    private String mBkingPickDropBoth;
    @SerializedName("m_bking_pick_drop_both_amt")
    @Expose
    private String mBkingPickDropBothAmt;
    @SerializedName("m_bking_branch")
    @Expose
    private String mBkingBranch;
    @SerializedName("m_bking_package")
    @Expose
    private Object mBkingPackage;
    @SerializedName("m_bking_subs")
    @Expose
    private String mBkingSubs;
    @SerializedName("m_bking_service_type")
    @Expose
    private String mBkingServiceType;
    @SerializedName("m_bking_from")
    @Expose
    private String mBkingFrom;
    @SerializedName("m_bking_to")
    @Expose
    private String mBkingTo;
    @SerializedName("m_bking_pickup_address")
    @Expose
    private String mBkingPickupAddress;
    @SerializedName("m_bking_drop_address")
    @Expose
    private String mBkingDropAddress;
    @SerializedName("m_bking_pickup")
    @Expose
    private String mBkingPickup;
    @SerializedName("m_bking_pickup_at")
    @Expose
    private String mBkingPickupAt;
    @SerializedName("m_bking_return")
    @Expose
    private String mBkingReturn;
    @SerializedName("m_bking_return_at")
    @Expose
    private String mBkingReturnAt;
    @SerializedName("m_bking_flight")
    @Expose
    private String mBkingFlight;
    @SerializedName("m_bking_car_type")
    @Expose
    private String mBkingCarType;
    @SerializedName("m_bking_car")
    @Expose
    private String mBkingCar;
    @SerializedName("m_bking_bus")
    @Expose
    private String mBkingBus;
    @SerializedName("m_bking_driver")
    @Expose
    private String mBkingDriver;
    @SerializedName("m_bking_fastag")
    @Expose
    private String mBkingFastag;
    @SerializedName("m_bking_km")
    @Expose
    private String mBkingKm;
    @SerializedName("m_bking_price")
    @Expose
    private String mBkingPrice;
    @SerializedName("m_bking_total")
    @Expose
    private String mBkingTotal;
    @SerializedName("m_bking_paid_amt")
    @Expose
    private String mBkingPaidAmt;
    @SerializedName("m_bking_remain_amt")
    @Expose
    private String mBkingRemainAmt;
    @SerializedName("m_bking_paymode")
    @Expose
    private String mBkingPaymode;
    @SerializedName("m_bking_pay_status")
    @Expose
    private String mBkingPayStatus;
    @SerializedName("m_bking_status")
    @Expose
    private String mBkingStatus;
    @SerializedName("m_bking_trans_id")
    @Expose
    private String mBkingTransId;
    @SerializedName("m_bking_addedon")
    @Expose
    private String mBkingAddedon;
    @SerializedName("m_bking_updatedon")
    @Expose
    private String mBkingUpdatedon;
    @SerializedName("m_cust_id")
    @Expose
    private String mCustId;
    @SerializedName("m_cust_name")
    @Expose
    private String mCustName;
    @SerializedName("m_cust_mobile")
    @Expose
    private String mCustMobile;
    @SerializedName("m_cust_city")
    @Expose
    private String mCustCity;
    @SerializedName("m_branch_id")
    @Expose
    private String mBranchId;
    @SerializedName("m_branch_title")
    @Expose
    private String mBranchTitle;
    @SerializedName("m_ctype_id")
    @Expose
    private String mCtypeId;
    @SerializedName("m_ctype_title")
    @Expose
    private String mCtypeTitle;
    @SerializedName("m_subs_id")
    @Expose
    private String mSubsId;
    @SerializedName("m_subs_day")
    @Expose
    private String mSubsDay;
    @SerializedName("m_subs_price")
    @Expose
    private String mSubsPrice;

    public String getmBkingId() {
        return mBkingId;
    }

    public void setmBkingId(String mBkingId) {
        this.mBkingId = mBkingId;
    }

    public String getmBkingTc() {
        return mBkingTc;
    }

    public void setmBkingTc(String mBkingTc) {
        this.mBkingTc = mBkingTc;
    }

    public String getmBookingId() {
        return mBookingId;
    }

    public void setmBookingId(String mBookingId) {
        this.mBookingId = mBookingId;
    }

    public String getmBkingVendor() {
        return mBkingVendor;
    }

    public void setmBkingVendor(String mBkingVendor) {
        this.mBkingVendor = mBkingVendor;
    }

    public String getmBkingUser() {
        return mBkingUser;
    }

    public void setmBkingUser(String mBkingUser) {
        this.mBkingUser = mBkingUser;
    }

    public String getmBkingUsername() {
        return mBkingUsername;
    }

    public void setmBkingUsername(String mBkingUsername) {
        this.mBkingUsername = mBkingUsername;
    }

    public String getmBkingUseremail() {
        return mBkingUseremail;
    }

    public void setmBkingUseremail(String mBkingUseremail) {
        this.mBkingUseremail = mBkingUseremail;
    }

    public String getmBkingUsermobile() {
        return mBkingUsermobile;
    }

    public void setmBkingUsermobile(String mBkingUsermobile) {
        this.mBkingUsermobile = mBkingUsermobile;
    }

    public String getmBkingType() {
        return mBkingType;
    }

    public void setmBkingType(String mBkingType) {
        this.mBkingType = mBkingType;
    }

    public String getmBkingTypeCat() {
        return mBkingTypeCat;
    }

    public void setmBkingTypeCat(String mBkingTypeCat) {
        this.mBkingTypeCat = mBkingTypeCat;
    }

    public String getmBkingRoadType() {
        return mBkingRoadType;
    }

    public void setmBkingRoadType(String mBkingRoadType) {
        this.mBkingRoadType = mBkingRoadType;
    }

    public String getmBkingHour() {
        return mBkingHour;
    }

    public void setmBkingHour(String mBkingHour) {
        this.mBkingHour = mBkingHour;
    }

    public String getmBkingInsideOutsideState() {
        return mBkingInsideOutsideState;
    }

    public void setmBkingInsideOutsideState(String mBkingInsideOutsideState) {
        this.mBkingInsideOutsideState = mBkingInsideOutsideState;
    }

    public String getmBkingInsideOutsideStateAmt() {
        return mBkingInsideOutsideStateAmt;
    }

    public void setmBkingInsideOutsideStateAmt(String mBkingInsideOutsideStateAmt) {
        this.mBkingInsideOutsideStateAmt = mBkingInsideOutsideStateAmt;
    }

    public String getmBkingPickDropBoth() {
        return mBkingPickDropBoth;
    }

    public void setmBkingPickDropBoth(String mBkingPickDropBoth) {
        this.mBkingPickDropBoth = mBkingPickDropBoth;
    }

    public String getmBkingPickDropBothAmt() {
        return mBkingPickDropBothAmt;
    }

    public void setmBkingPickDropBothAmt(String mBkingPickDropBothAmt) {
        this.mBkingPickDropBothAmt = mBkingPickDropBothAmt;
    }

    public String getmBkingBranch() {
        return mBkingBranch;
    }

    public void setmBkingBranch(String mBkingBranch) {
        this.mBkingBranch = mBkingBranch;
    }

    public Object getmBkingPackage() {
        return mBkingPackage;
    }

    public void setmBkingPackage(Object mBkingPackage) {
        this.mBkingPackage = mBkingPackage;
    }

    public String getmBkingSubs() {
        return mBkingSubs;
    }

    public void setmBkingSubs(String mBkingSubs) {
        this.mBkingSubs = mBkingSubs;
    }

    public String getmBkingServiceType() {
        return mBkingServiceType;
    }

    public void setmBkingServiceType(String mBkingServiceType) {
        this.mBkingServiceType = mBkingServiceType;
    }

    public String getmBkingFrom() {
        return mBkingFrom;
    }

    public void setmBkingFrom(String mBkingFrom) {
        this.mBkingFrom = mBkingFrom;
    }

    public String getmBkingTo() {
        return mBkingTo;
    }

    public void setmBkingTo(String mBkingTo) {
        this.mBkingTo = mBkingTo;
    }

    public String getmBkingPickupAddress() {
        return mBkingPickupAddress;
    }

    public void setmBkingPickupAddress(String mBkingPickupAddress) {
        this.mBkingPickupAddress = mBkingPickupAddress;
    }

    public String getmBkingDropAddress() {
        return mBkingDropAddress;
    }

    public void setmBkingDropAddress(String mBkingDropAddress) {
        this.mBkingDropAddress = mBkingDropAddress;
    }

    public String getmBkingPickup() {
        return mBkingPickup;
    }

    public void setmBkingPickup(String mBkingPickup) {
        this.mBkingPickup = mBkingPickup;
    }

    public String getmBkingPickupAt() {
        return mBkingPickupAt;
    }

    public void setmBkingPickupAt(String mBkingPickupAt) {
        this.mBkingPickupAt = mBkingPickupAt;
    }

    public String getmBkingReturn() {
        return mBkingReturn;
    }

    public void setmBkingReturn(String mBkingReturn) {
        this.mBkingReturn = mBkingReturn;
    }

    public String getmBkingReturnAt() {
        return mBkingReturnAt;
    }

    public void setmBkingReturnAt(String mBkingReturnAt) {
        this.mBkingReturnAt = mBkingReturnAt;
    }

    public String getmBkingFlight() {
        return mBkingFlight;
    }

    public void setmBkingFlight(String mBkingFlight) {
        this.mBkingFlight = mBkingFlight;
    }

    public String getmBkingCarType() {
        return mBkingCarType;
    }

    public void setmBkingCarType(String mBkingCarType) {
        this.mBkingCarType = mBkingCarType;
    }

    public String getmBkingCar() {
        return mBkingCar;
    }

    public void setmBkingCar(String mBkingCar) {
        this.mBkingCar = mBkingCar;
    }

    public String getmBkingBus() {
        return mBkingBus;
    }

    public void setmBkingBus(String mBkingBus) {
        this.mBkingBus = mBkingBus;
    }

    public String getmBkingDriver() {
        return mBkingDriver;
    }

    public void setmBkingDriver(String mBkingDriver) {
        this.mBkingDriver = mBkingDriver;
    }

    public String getmBkingFastag() {
        return mBkingFastag;
    }

    public void setmBkingFastag(String mBkingFastag) {
        this.mBkingFastag = mBkingFastag;
    }

    public String getmBkingKm() {
        return mBkingKm;
    }

    public void setmBkingKm(String mBkingKm) {
        this.mBkingKm = mBkingKm;
    }

    public String getmBkingPrice() {
        return mBkingPrice;
    }

    public void setmBkingPrice(String mBkingPrice) {
        this.mBkingPrice = mBkingPrice;
    }

    public String getmBkingTotal() {
        return mBkingTotal;
    }

    public void setmBkingTotal(String mBkingTotal) {
        this.mBkingTotal = mBkingTotal;
    }

    public String getmBkingPaidAmt() {
        return mBkingPaidAmt;
    }

    public void setmBkingPaidAmt(String mBkingPaidAmt) {
        this.mBkingPaidAmt = mBkingPaidAmt;
    }

    public String getmBkingRemainAmt() {
        return mBkingRemainAmt;
    }

    public void setmBkingRemainAmt(String mBkingRemainAmt) {
        this.mBkingRemainAmt = mBkingRemainAmt;
    }

    public String getmBkingPaymode() {
        return mBkingPaymode;
    }

    public void setmBkingPaymode(String mBkingPaymode) {
        this.mBkingPaymode = mBkingPaymode;
    }

    public String getmBkingPayStatus() {
        return mBkingPayStatus;
    }

    public void setmBkingPayStatus(String mBkingPayStatus) {
        this.mBkingPayStatus = mBkingPayStatus;
    }

    public String getmBkingStatus() {
        return mBkingStatus;
    }

    public void setmBkingStatus(String mBkingStatus) {
        this.mBkingStatus = mBkingStatus;
    }

    public String getmBkingTransId() {
        return mBkingTransId;
    }

    public void setmBkingTransId(String mBkingTransId) {
        this.mBkingTransId = mBkingTransId;
    }

    public String getmBkingAddedon() {
        return mBkingAddedon;
    }

    public void setmBkingAddedon(String mBkingAddedon) {
        this.mBkingAddedon = mBkingAddedon;
    }

    public String getmBkingUpdatedon() {
        return mBkingUpdatedon;
    }

    public void setmBkingUpdatedon(String mBkingUpdatedon) {
        this.mBkingUpdatedon = mBkingUpdatedon;
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

    public String getmCustCity() {
        return mCustCity;
    }

    public void setmCustCity(String mCustCity) {
        this.mCustCity = mCustCity;
    }

    public String getmBranchId() {
        return mBranchId;
    }

    public void setmBranchId(String mBranchId) {
        this.mBranchId = mBranchId;
    }

    public String getmBranchTitle() {
        return mBranchTitle;
    }

    public void setmBranchTitle(String mBranchTitle) {
        this.mBranchTitle = mBranchTitle;
    }

    public String getmCtypeId() {
        return mCtypeId;
    }

    public void setmCtypeId(String mCtypeId) {
        this.mCtypeId = mCtypeId;
    }

    public String getmCtypeTitle() {
        return mCtypeTitle;
    }

    public void setmCtypeTitle(String mCtypeTitle) {
        this.mCtypeTitle = mCtypeTitle;
    }

    public String getmSubsId() {
        return mSubsId;
    }

    public void setmSubsId(String mSubsId) {
        this.mSubsId = mSubsId;
    }

    public String getmSubsDay() {
        return mSubsDay;
    }

    public void setmSubsDay(String mSubsDay) {
        this.mSubsDay = mSubsDay;
    }

    public String getmSubsPrice() {
        return mSubsPrice;
    }

    public void setmSubsPrice(String mSubsPrice) {
        this.mSubsPrice = mSubsPrice;
    }
}
