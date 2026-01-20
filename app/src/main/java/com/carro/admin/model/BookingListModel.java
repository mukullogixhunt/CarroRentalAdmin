package com.carro.admin.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BookingListModel implements Serializable {
    // all your existing fields



    @SerializedName("m_bking_id")
    @Expose
    private String mBkingId;
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
    @SerializedName("m_bking_branch")
    @Expose
    private String mBkingBranch;
    @SerializedName("m_bking_package")
    @Expose
    private String mBkingPackage;
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
    @SerializedName("m_bking_km")
    @Expose
    private String mBkingKm;
    @SerializedName("m_bking_price")
    @Expose
    private String mBkingPrice;

    @SerializedName("m_bking_dis")
    @Expose
    private String mBkingDis;

    @SerializedName("m_bking_damt")
    @Expose
    private String mBkingDamt;



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
    @SerializedName("m_vendor_id")
    @Expose
    private String mVendorId;
    @SerializedName("m_vendor_name")
    @Expose
    private String mVendorName;
    @SerializedName("m_vendor_mobile")
    @Expose
    private String mVendorMobile;
    @SerializedName("m_vendor_email")
    @Expose
    private String mVendorEmail;
    @SerializedName("m_vendor_gender")
    @Expose
    private String mVendorGender;
    @SerializedName("m_vendor_dob")
    @Expose
    private String mVendorDob;
    @SerializedName("m_vendor_img")
    @Expose
    private String mVendorImg;
    @SerializedName("m_vendor_otp")
    @Expose
    private String mVendorOtp;
    @SerializedName("m_vendor_adhar_no")
    @Expose
    private String mVendorAdharNo;
    @SerializedName("m_vendor_adhar_front")
    @Expose
    private String mVendorAdharFront;
    @SerializedName("m_vendor_adhar_back")
    @Expose
    private String mVendorAdharBack;
    @SerializedName("m_vendor_lic_no")
    @Expose
    private String mVendorLicNo;
    @SerializedName("m_vendor_lic_img")
    @Expose
    private String mVendorLicImg;
    @SerializedName("m_vendor_pan_no")
    @Expose
    private String mVendorPanNo;
    @SerializedName("m_vendor_pan_img")
    @Expose
    private String mVendorPanImg;
    @SerializedName("m_vendor_vehicle_type")
    @Expose
    private String mVendorVehicleType;
    @SerializedName("m_vendor_vehicle_reg_no")
    @Expose
    private String mVendorVehicleRegNo;
    @SerializedName("m_vendor_state")
    @Expose
    private String mVendorState;
    @SerializedName("m_vendor_city")
    @Expose
    private String mVendorCity;
    @SerializedName("m_vendor_address")
    @Expose
    private String mVendorAddress;
    @SerializedName("m_vendor_bank_holder_name")
    @Expose
    private String mVendorBankHolderName;
    @SerializedName("m_vendor_bank_name")
    @Expose
    private String mVendorBankName;
    @SerializedName("m_vendor_bank_acc_no")
    @Expose
    private String mVendorBankAccNo;
    @SerializedName("m_vendor_bank_ifsc_code")
    @Expose
    private String mVendorBankIfscCode;
    @SerializedName("m_vendor_bank_psbk_img")
    @Expose
    private String mVendorBankPsbkImg;
    @SerializedName("m_vendor_status")
    @Expose
    private String mVendorStatus;
    @SerializedName("m_vendor_fcmtoken")
    @Expose
    private String mVendorFcmtoken;
    @SerializedName("m_vendor_addedon")
    @Expose
    private String mVendorAddedon;
    @SerializedName("m_vendor_updatedon")
    @Expose
    private String mVendorUpdatedon;
    @SerializedName("m_cust_id")
    @Expose
    private String mCustId;
    @SerializedName("m_cust_name")
    @Expose
    private String mCustName;
    @SerializedName("m_cust_mobile")
    @Expose
    private String mCustMobile;
    @SerializedName("m_cust_alt_mobile")
    @Expose
    private String mCustAltMobile;
    @SerializedName("m_cust_email")
    @Expose
    private String mCustEmail;
    @SerializedName("m_cust_gender")
    @Expose
    private String mCustGender;
    @SerializedName("m_cust_dob")
    @Expose
    private String mCustDob;
    @SerializedName("m_cust_otp")
    @Expose
    private String mCustOtp;
    @SerializedName("m_cust_img")
    @Expose
    private String mCustImg;
    @SerializedName("m_cust_state")
    @Expose
    private String mCustState;
    @SerializedName("m_cust_city")
    @Expose
    private String mCustCity;
    @SerializedName("m_cust_address")
    @Expose
    private String mCustAddress;
    @SerializedName("m_cust_status")
    @Expose
    private String mCustStatus;
    @SerializedName("m_cust_fcmtoken")
    @Expose
    private String mCustFcmtoken;
    @SerializedName("m_cust_addedon")
    @Expose
    private String mCustAddedon;
    @SerializedName("m_cust_updatedon")
    @Expose
    private String mCustUpdatedon;
    @SerializedName("m_ctype_id")
    @Expose
    private String mCtypeId;
    @SerializedName("m_ctype_title")
    @Expose
    private String mCtypeTitle;
    @SerializedName("m_ctype_img")
    @Expose
    private String mCtypeImg;
    @SerializedName("m_ctype_seat")
    @Expose
    private String mCtypeSeat;
    @SerializedName("m_ctype_number")
    @Expose
    private String mCtypeNumber;

    @SerializedName("m_ctype_fuel")
    @Expose
    private String mCtypeFuel;

    @SerializedName("m_ctype_luggage")
    @Expose
    private String mCtypeLuggage;
    @SerializedName("m_ctype_AC")
    @Expose
    private String mCtypeAC;
    @SerializedName("m_ctype_price")
    @Expose
    private String mCtypePrice;
    @SerializedName("m_ctype_drivetype")
    @Expose
    private String mCtypeDrivetype;
    @SerializedName("m_ctype_servtype")
    @Expose
    private String mCtypeServtype;
    @SerializedName("m_ctype_branch")
    @Expose
    private String mCtypeBranch;
    @SerializedName("m_ctype_inclusion")
    @Expose
    private String mCtypeInclusion;
    @SerializedName("m_ctype_exclusion")
    @Expose
    private String mCtypeExclusion;
    @SerializedName("m_ctype_tc")
    @Expose
    private String mCtypeTc;
    @SerializedName("m_ctype_status")
    @Expose
    private String mCtypeStatus;
    @SerializedName("m_ctype_addedon")
    @Expose
    private String mCtypeAddedon;
    @SerializedName("m_bus_id")
    @Expose
    private String mBusId;
    @SerializedName("m_bus_title")
    @Expose
    private String mBusTitle;
    @SerializedName("m_bus_img")
    @Expose
    private String mBusImg;
    @SerializedName("m_bus_km")
    @Expose
    private String mBusKm;
    @SerializedName("m_bus_price")
    @Expose
    private String mBusPrice;
    @SerializedName("m_bus_branch")
    @Expose
    private String mBusBranch;
    @SerializedName("m_bus_inclusion")
    @Expose
    private String mBusInclusion;
    @SerializedName("m_bus_exclusion")
    @Expose
    private String mBusExclusion;
    @SerializedName("m_bus_tandc")
    @Expose
    private String mBusTandc;
    @SerializedName("m_bus_status")
    @Expose
    private String mBusStatus;
    @SerializedName("m_bus_addedon")
    @Expose
    private String mBusAddedon;
    @SerializedName("m_bust_updatedon")
    @Expose
    private String mBustUpdatedon;
    @SerializedName("m_driver_id")
    @Expose
    private String mDriverId;
    @SerializedName("m_driver_vendor")
    @Expose
    private String mDriverVendor;
    @SerializedName("m_driver_name")
    @Expose
    private String mDriverName;
    @SerializedName("m_driver_mobile")
    @Expose
    private String mDriverMobile;
    @SerializedName("m_driver_dl_exdate")
    @Expose
    private String mDriverLicExDate;

    public String getmDriverLicExDate() {
        return mDriverLicExDate;
    }

    public void setmDriverLicExDate(String mDriverLicExDate) {
        this.mDriverLicExDate = mDriverLicExDate;
    }

    @SerializedName("m_driver_img")
    @Expose
    private String mDriverImg;
    @SerializedName("m_driver_otp")
    @Expose
    private String mDriverOtp;
    @SerializedName("m_driver_drivelic")
    @Expose
    private String mDriverDrivelic;
    @SerializedName("m_driver_drivelic_expdate")
    @Expose
    private String mDriverDrivelicExpdate;
    @SerializedName("m_driver_police_verify")
    @Expose
    private String mDriverPoliceVerify;
    @SerializedName("m_driver_state")
    @Expose
    private String mDriverState;
    @SerializedName("m_driver_city")
    @Expose
    private String mDriverCity;
    @SerializedName("m_driver_status")
    @Expose
    private String mDriverStatus;
    @SerializedName("m_driver_addedon")
    @Expose
    private String mDriverAddedon;
    @SerializedName("m_driver_updatedon")
    @Expose
    private String mDriverUpdatedon;
    @SerializedName("m_branch_id")
    @Expose
    private String mBranchId;
    @SerializedName("m_branch_title")
    @Expose
    private String mBranchTitle;
    @SerializedName("m_branch_city")
    @Expose
    private String mBranchCity;
    @SerializedName("m_branch_state")
    @Expose
    private String mBranchState;
    @SerializedName("m_branch_order")
    @Expose
    private String mBranchOrder;
    @SerializedName("m_branch_status")
    @Expose
    private String mBranchStatus;
    @SerializedName("m_branch_addedon")
    @Expose
    private String mBranchAddedon;
    @SerializedName("m_branch_updatedon")
    @Expose
    private String mBranchUpdatedon;
    @SerializedName("m_car_id")
    @Expose
    private String mCarId;

    @SerializedName("m_car_name")
    @Expose
    private String mCarName;

    @SerializedName("m_car_number")
    @Expose
    private String mCarNumber;

    @SerializedName("m_car_fuel")
    @Expose
    private String mCarFuel;
    @SerializedName("m_car_fit_up_to")
    @Expose
    private String mCarFitUpto;

    @SerializedName("m_car_registration_date")
    @Expose
    private String mCarRegistrationDate;
    @SerializedName("m_car_Owner_name")
    @Expose
    private String mCarOwnerName;

    @SerializedName("m_car_father_name")
    @Expose
    private String mCarFatherName;

    @SerializedName("m_car_present_address")
    @Expose
    private String mCarPresentAddress;

    @SerializedName("m_car_permanent_address")
    @Expose
    private String mCarPermanentAddress;
    @SerializedName("m_car_vehicle_category")
    @Expose
    private String mCarVehicleCategory;

    @SerializedName("m_car_vehicle_chasi_number")
    @Expose
    private String mCarChassisNumber;

    @SerializedName("m_car_vehicle_engine_number")
    @Expose
    private String mCarEngineNumber;
    @SerializedName("m_car_maker_description")
    @Expose
    private String mCarMaker;

    @SerializedName("m_car_maker_model")
    @Expose
    private String mCarModel;

    @SerializedName("m_car_body_type")
    @Expose
    private String mCarBodyType;

    @SerializedName("m_car_color")
    @Expose
    private String mCarColor;

    @SerializedName("m_car_manufacturing_date")
    @Expose
    private String mCarManufacturingDate;
    @SerializedName("m_car_insurance_company")
    @Expose
    private String mCarInsuranceCompany;

    @SerializedName("m_car_insurance_policy_number")
    @Expose
    private String mCarInsurancePolicyNumber;

    @SerializedName("m_car_insurance_upto")
    @Expose
    private String mCarInsuranceUpto;

    @SerializedName("m_car_tax_upto")
    @Expose
    private String mCarTaxUpto;

    @SerializedName("m_car_pucc_number")
    @Expose
    private String mCarPuccNumber;

    @SerializedName("m_car_pucc_upto")
    @Expose
    private String mCarPuccUpto;
    @SerializedName("m_car_permit_number")
    @Expose
    private String mCarPermitNumber;

    @SerializedName("m_car_permit_issue_date")
    @Expose
    private String mCarPermitIssueDate;

    @SerializedName("m_car_permit_valid_from")
    @Expose
    private String mCarPermitValidFrom;

    @SerializedName("m_car_permit_valid_upto")
    @Expose
    private String mCarPermitValidUpto;

    @SerializedName("m_car_permit_type")
    @Expose
    private String mCarPermitType;

    @SerializedName("m_bking_meal_provide")
    @Expose
    private String mBkingMealProvide;

    @SerializedName("m_bking_toll_tax")
    @Expose
    private String mBkingTollTax;

    @SerializedName("m_bking_toll_tax_img")
    @Expose
    private String mBkingTollTaxImg;

    @SerializedName("m_bking_parking")
    @Expose
    private String mBkingParking;

    public String getmBkingMealProvide() {
        return mBkingMealProvide;
    }

    public void setmBkingMealProvide(String mBkingMealProvide) {
        this.mBkingMealProvide = mBkingMealProvide;
    }

    public String getmBkingTollTax() {
        return mBkingTollTax;
    }

    public void setmBkingTollTax(String mBkingTollTax) {
        this.mBkingTollTax = mBkingTollTax;
    }

    public String getmBkingTollTaxImg() {
        return mBkingTollTaxImg;
    }

    public void setmBkingTollTaxImg(String mBkingTollTaxImg) {
        this.mBkingTollTaxImg = mBkingTollTaxImg;
    }

    public String getmBkingParking() {
        return mBkingParking;
    }

    public void setmBkingParking(String mBkingParking) {
        this.mBkingParking = mBkingParking;
    }

    public String getmBkingParkingImg() {
        return mBkingParkingImg;
    }

    public void setmBkingParkingImg(String mBkingParkingImg) {
        this.mBkingParkingImg = mBkingParkingImg;
    }

    public String getmBkingOtherTitle() {
        return mBkingOtherTitle;
    }

    public void setmBkingOtherTitle(String mBkingOtherTitle) {
        this.mBkingOtherTitle = mBkingOtherTitle;
    }

    public String getmBkingOtherImg() {
        return mBkingOtherImg;
    }

    public void setmBkingOtherImg(String mBkingOtherImg) {
        this.mBkingOtherImg = mBkingOtherImg;
    }

    @SerializedName("m_bking_parking_img")
    @Expose
    private String mBkingParkingImg;

    @SerializedName("m_bking_other_title")
    @Expose
    private String mBkingOtherTitle;

    @SerializedName("m_bking_other_img")
    @Expose
    private String mBkingOtherImg;


    public String getmCarTaxUpto() {
        return mCarTaxUpto;
    }

    public void setmCarTaxUpto(String mCarTaxUpto) {
        this.mCarTaxUpto = mCarTaxUpto;
    }

    public String getmCarId() {
        return mCarId;
    }

    public void setmCarId(String mCarId) {
        this.mCarId = mCarId;
    }

    public String getmCarName() {
        return mCarName;
    }

    public void setmCarName(String mCarName) {
        this.mCarName = mCarName;
    }

    public String getmCarNumber() {
        return mCarNumber;
    }

    public void setmCarNumber(String mCarNumber) {
        this.mCarNumber = mCarNumber;
    }

    public String getmCarFuel() {
        return mCarFuel;
    }

    public void setmCarFuel(String mCarFuel) {
        this.mCarFuel = mCarFuel;
    }

    public String getmCarFitUpto() {
        return mCarFitUpto;
    }

    public void setmCarFitUpto(String mCarFitUpto) {
        this.mCarFitUpto = mCarFitUpto;
    }

    public String getmCarRegistrationDate() {
        return mCarRegistrationDate;
    }

    public void setmCarRegistrationDate(String mCarRegistrationDate) {
        this.mCarRegistrationDate = mCarRegistrationDate;
    }

    public String getmCarOwnerName() {
        return mCarOwnerName;
    }

    public void setmCarOwnerName(String mCarOwnerName) {
        this.mCarOwnerName = mCarOwnerName;
    }

    public String getmCarFatherName() {
        return mCarFatherName;
    }

    public void setmCarFatherName(String mCarFatherName) {
        this.mCarFatherName = mCarFatherName;
    }

    public String getmCarPresentAddress() {
        return mCarPresentAddress;
    }

    public void setmCarPresentAddress(String mCarPresentAddress) {
        this.mCarPresentAddress = mCarPresentAddress;
    }

    public String getmCarPermanentAddress() {
        return mCarPermanentAddress;
    }

    public void setmCarPermanentAddress(String mCarPermanentAddress) {
        this.mCarPermanentAddress = mCarPermanentAddress;
    }

    public String getmCarVehicleCategory() {
        return mCarVehicleCategory;
    }

    public void setmCarVehicleCategory(String mCarVehicleCategory) {
        this.mCarVehicleCategory = mCarVehicleCategory;
    }

    public String getmCarChassisNumber() {
        return mCarChassisNumber;
    }

    public void setmCarChassisNumber(String mCarChassisNumber) {
        this.mCarChassisNumber = mCarChassisNumber;
    }

    public String getmCarEngineNumber() {
        return mCarEngineNumber;
    }

    public void setmCarEngineNumber(String mCarEngineNumber) {
        this.mCarEngineNumber = mCarEngineNumber;
    }

    public String getmCarMaker() {
        return mCarMaker;
    }

    public void setmCarMaker(String mCarMaker) {
        this.mCarMaker = mCarMaker;
    }

    public String getmCarModel() {
        return mCarModel;
    }

    public void setmCarModel(String mCarModel) {
        this.mCarModel = mCarModel;
    }

    public String getmCarBodyType() {
        return mCarBodyType;
    }

    public void setmCarBodyType(String mCarBodyType) {
        this.mCarBodyType = mCarBodyType;
    }

    public String getmCarColor() {
        return mCarColor;
    }

    public void setmCarColor(String mCarColor) {
        this.mCarColor = mCarColor;
    }

    public String getmCarManufacturingDate() {
        return mCarManufacturingDate;
    }

    public void setmCarManufacturingDate(String mCarManufacturingDate) {
        this.mCarManufacturingDate = mCarManufacturingDate;
    }

    public String getmCarInsuranceCompany() {
        return mCarInsuranceCompany;
    }

    public void setmCarInsuranceCompany(String mCarInsuranceCompany) {
        this.mCarInsuranceCompany = mCarInsuranceCompany;
    }

    public String getmCarInsurancePolicyNumber() {
        return mCarInsurancePolicyNumber;
    }

    public void setmCarInsurancePolicyNumber(String mCarInsurancePolicyNumber) {
        this.mCarInsurancePolicyNumber = mCarInsurancePolicyNumber;
    }

    public String getmCarInsuranceUpto() {
        return mCarInsuranceUpto;
    }

    public void setmCarInsuranceUpto(String mCarInsuranceUpto) {
        this.mCarInsuranceUpto = mCarInsuranceUpto;
    }

    public String getmCarPuccNumber() {
        return mCarPuccNumber;
    }

    public void setmCarPuccNumber(String mCarPuccNumber) {
        this.mCarPuccNumber = mCarPuccNumber;
    }

    public String getmCarPuccUpto() {
        return mCarPuccUpto;
    }

    public void setmCarPuccUpto(String mCarPuccUpto) {
        this.mCarPuccUpto = mCarPuccUpto;
    }

    public String getmCarPermitNumber() {
        return mCarPermitNumber;
    }

    public void setmCarPermitNumber(String mCarPermitNumber) {
        this.mCarPermitNumber = mCarPermitNumber;
    }

    public String getmCarPermitIssueDate() {
        return mCarPermitIssueDate;
    }

    public void setmCarPermitIssueDate(String mCarPermitIssueDate) {
        this.mCarPermitIssueDate = mCarPermitIssueDate;
    }

    public String getmCarPermitValidFrom() {
        return mCarPermitValidFrom;
    }

    public void setmCarPermitValidFrom(String mCarPermitValidFrom) {
        this.mCarPermitValidFrom = mCarPermitValidFrom;
    }

    public String getmCarPermitValidUpto() {
        return mCarPermitValidUpto;
    }

    public void setmCarPermitValidUpto(String mCarPermitValidUpto) {
        this.mCarPermitValidUpto = mCarPermitValidUpto;
    }

    public String getmCarPermitType() {
        return mCarPermitType;
    }

    public void setmCarPermitType(String mCarPermitType) {
        this.mCarPermitType = mCarPermitType;
    }

    public String getmCarNonUseStatus() {
        return mCarNonUseStatus;
    }

    public void setmCarNonUseStatus(String mCarNonUseStatus) {
        this.mCarNonUseStatus = mCarNonUseStatus;
    }

    @SerializedName("m_car_non_use_status")
    @Expose
    private String mCarNonUseStatus;


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

    public String getmBkingBranch() {
        return mBkingBranch;
    }

    public void setmBkingBranch(String mBkingBranch) {
        this.mBkingBranch = mBkingBranch;
    }

    public String getmBkingPackage() {
        return mBkingPackage;
    }

    public void setmBkingPackage(String mBkingPackage) {
        this.mBkingPackage = mBkingPackage;
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


    public String getmBkingDis() {
        return mBkingDis;
    }

    public void setmBkingDis(String mBkingDis) {
        this.mBkingDis = mBkingDis;
    }

    public String getmBkingDamt() {
        return mBkingDamt;
    }

    public void setmBkingDamt(String mBkingDamt) {
        this.mBkingDamt = mBkingDamt;
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

    public String getmVendorEmail() {
        return mVendorEmail;
    }

    public void setmVendorEmail(String mVendorEmail) {
        this.mVendorEmail = mVendorEmail;
    }

    public String getmVendorGender() {
        return mVendorGender;
    }

    public void setmVendorGender(String mVendorGender) {
        this.mVendorGender = mVendorGender;
    }

    public String getmVendorDob() {
        return mVendorDob;
    }

    public void setmVendorDob(String mVendorDob) {
        this.mVendorDob = mVendorDob;
    }

    public String getmVendorImg() {
        return mVendorImg;
    }

    public void setmVendorImg(String mVendorImg) {
        this.mVendorImg = mVendorImg;
    }

    public String getmVendorOtp() {
        return mVendorOtp;
    }

    public void setmVendorOtp(String mVendorOtp) {
        this.mVendorOtp = mVendorOtp;
    }

    public String getmVendorAdharNo() {
        return mVendorAdharNo;
    }

    public void setmVendorAdharNo(String mVendorAdharNo) {
        this.mVendorAdharNo = mVendorAdharNo;
    }

    public String getmVendorAdharFront() {
        return mVendorAdharFront;
    }

    public void setmVendorAdharFront(String mVendorAdharFront) {
        this.mVendorAdharFront = mVendorAdharFront;
    }

    public String getmVendorAdharBack() {
        return mVendorAdharBack;
    }

    public void setmVendorAdharBack(String mVendorAdharBack) {
        this.mVendorAdharBack = mVendorAdharBack;
    }

    public String getmVendorLicNo() {
        return mVendorLicNo;
    }

    public void setmVendorLicNo(String mVendorLicNo) {
        this.mVendorLicNo = mVendorLicNo;
    }

    public String getmVendorLicImg() {
        return mVendorLicImg;
    }

    public void setmVendorLicImg(String mVendorLicImg) {
        this.mVendorLicImg = mVendorLicImg;
    }

    public String getmVendorPanNo() {
        return mVendorPanNo;
    }

    public void setmVendorPanNo(String mVendorPanNo) {
        this.mVendorPanNo = mVendorPanNo;
    }

    public String getmVendorPanImg() {
        return mVendorPanImg;
    }

    public void setmVendorPanImg(String mVendorPanImg) {
        this.mVendorPanImg = mVendorPanImg;
    }

    public String getmVendorVehicleType() {
        return mVendorVehicleType;
    }

    public void setmVendorVehicleType(String mVendorVehicleType) {
        this.mVendorVehicleType = mVendorVehicleType;
    }

    public String getmVendorVehicleRegNo() {
        return mVendorVehicleRegNo;
    }

    public void setmVendorVehicleRegNo(String mVendorVehicleRegNo) {
        this.mVendorVehicleRegNo = mVendorVehicleRegNo;
    }

    public String getmVendorState() {
        return mVendorState;
    }

    public void setmVendorState(String mVendorState) {
        this.mVendorState = mVendorState;
    }

    public String getmVendorCity() {
        return mVendorCity;
    }

    public void setmVendorCity(String mVendorCity) {
        this.mVendorCity = mVendorCity;
    }

    public String getmVendorAddress() {
        return mVendorAddress;
    }

    public void setmVendorAddress(String mVendorAddress) {
        this.mVendorAddress = mVendorAddress;
    }

    public String getmVendorBankHolderName() {
        return mVendorBankHolderName;
    }

    public void setmVendorBankHolderName(String mVendorBankHolderName) {
        this.mVendorBankHolderName = mVendorBankHolderName;
    }

    public String getmVendorBankName() {
        return mVendorBankName;
    }

    public void setmVendorBankName(String mVendorBankName) {
        this.mVendorBankName = mVendorBankName;
    }

    public String getmVendorBankAccNo() {
        return mVendorBankAccNo;
    }

    public void setmVendorBankAccNo(String mVendorBankAccNo) {
        this.mVendorBankAccNo = mVendorBankAccNo;
    }

    public String getmVendorBankIfscCode() {
        return mVendorBankIfscCode;
    }

    public void setmVendorBankIfscCode(String mVendorBankIfscCode) {
        this.mVendorBankIfscCode = mVendorBankIfscCode;
    }

    public String getmVendorBankPsbkImg() {
        return mVendorBankPsbkImg;
    }

    public void setmVendorBankPsbkImg(String mVendorBankPsbkImg) {
        this.mVendorBankPsbkImg = mVendorBankPsbkImg;
    }

    public String getmVendorStatus() {
        return mVendorStatus;
    }

    public void setmVendorStatus(String mVendorStatus) {
        this.mVendorStatus = mVendorStatus;
    }

    public String getmVendorFcmtoken() {
        return mVendorFcmtoken;
    }

    public void setmVendorFcmtoken(String mVendorFcmtoken) {
        this.mVendorFcmtoken = mVendorFcmtoken;
    }

    public String getmVendorAddedon() {
        return mVendorAddedon;
    }

    public void setmVendorAddedon(String mVendorAddedon) {
        this.mVendorAddedon = mVendorAddedon;
    }

    public String getmVendorUpdatedon() {
        return mVendorUpdatedon;
    }

    public void setmVendorUpdatedon(String mVendorUpdatedon) {
        this.mVendorUpdatedon = mVendorUpdatedon;
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

    public String getmCustAltMobile() {
        return mCustAltMobile;
    }

    public void setmCustAltMobile(String mCustAltMobile) {
        this.mCustAltMobile = mCustAltMobile;
    }

    public String getmCustEmail() {
        return mCustEmail;
    }

    public void setmCustEmail(String mCustEmail) {
        this.mCustEmail = mCustEmail;
    }

    public String getmCustGender() {
        return mCustGender;
    }

    public void setmCustGender(String mCustGender) {
        this.mCustGender = mCustGender;
    }

    public String getmCustDob() {
        return mCustDob;
    }

    public void setmCustDob(String mCustDob) {
        this.mCustDob = mCustDob;
    }

    public String getmCustOtp() {
        return mCustOtp;
    }

    public void setmCustOtp(String mCustOtp) {
        this.mCustOtp = mCustOtp;
    }

    public String getmCustImg() {
        return mCustImg;
    }

    public void setmCustImg(String mCustImg) {
        this.mCustImg = mCustImg;
    }

    public String getmCustState() {
        return mCustState;
    }

    public void setmCustState(String mCustState) {
        this.mCustState = mCustState;
    }

    public String getmCustCity() {
        return mCustCity;
    }

    public void setmCustCity(String mCustCity) {
        this.mCustCity = mCustCity;
    }

    public String getmCustAddress() {
        return mCustAddress;
    }

    public void setmCustAddress(String mCustAddress) {
        this.mCustAddress = mCustAddress;
    }

    public String getmCustStatus() {
        return mCustStatus;
    }

    public void setmCustStatus(String mCustStatus) {
        this.mCustStatus = mCustStatus;
    }

    public String getmCustFcmtoken() {
        return mCustFcmtoken;
    }

    public void setmCustFcmtoken(String mCustFcmtoken) {
        this.mCustFcmtoken = mCustFcmtoken;
    }

    public String getmCustAddedon() {
        return mCustAddedon;
    }

    public void setmCustAddedon(String mCustAddedon) {
        this.mCustAddedon = mCustAddedon;
    }

    public String getmCustUpdatedon() {
        return mCustUpdatedon;
    }

    public void setmCustUpdatedon(String mCustUpdatedon) {
        this.mCustUpdatedon = mCustUpdatedon;
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

    public String getmCtypeImg() {
        return mCtypeImg;
    }

    public void setmCtypeImg(String mCtypeImg) {
        this.mCtypeImg = mCtypeImg;
    }

    public String getmCtypeSeat() {
        return mCtypeSeat;
    }


    public String getmCtypeNumber() {
        return mCtypeNumber;
    }

    public void setmCtypeNumber(String mCtypeNumber) {
        this.mCtypeNumber = mCtypeNumber;
    }

    public String getmCtypeFuel() {
        return mCtypeFuel;
    }

    public void setmCtypeFuel(String mCtypeFuel) {
        this.mCtypeFuel = mCtypeFuel;
    }

    public void setmCtypeSeat(String mCtypeSeat) {
        this.mCtypeSeat = mCtypeSeat;
    }

    public String getmCtypeLuggage() {
        return mCtypeLuggage;
    }

    public void setmCtypeLuggage(String mCtypeLuggage) {
        this.mCtypeLuggage = mCtypeLuggage;
    }

    public String getmCtypeAC() {
        return mCtypeAC;
    }

    public void setmCtypeAC(String mCtypeAC) {
        this.mCtypeAC = mCtypeAC;
    }

    public String getmCtypePrice() {
        return mCtypePrice;
    }

    public void setmCtypePrice(String mCtypePrice) {
        this.mCtypePrice = mCtypePrice;
    }

    public String getmCtypeDrivetype() {
        return mCtypeDrivetype;
    }

    public void setmCtypeDrivetype(String mCtypeDrivetype) {
        this.mCtypeDrivetype = mCtypeDrivetype;
    }

    public String getmCtypeServtype() {
        return mCtypeServtype;
    }

    public void setmCtypeServtype(String mCtypeServtype) {
        this.mCtypeServtype = mCtypeServtype;
    }

    public String getmCtypeBranch() {
        return mCtypeBranch;
    }

    public void setmCtypeBranch(String mCtypeBranch) {
        this.mCtypeBranch = mCtypeBranch;
    }

    public String getmCtypeInclusion() {
        return mCtypeInclusion;
    }

    public void setmCtypeInclusion(String mCtypeInclusion) {
        this.mCtypeInclusion = mCtypeInclusion;
    }

    public String getmCtypeExclusion() {
        return mCtypeExclusion;
    }

    public void setmCtypeExclusion(String mCtypeExclusion) {
        this.mCtypeExclusion = mCtypeExclusion;
    }

    public String getmCtypeTc() {
        return mCtypeTc;
    }

    public void setmCtypeTc(String mCtypeTc) {
        this.mCtypeTc = mCtypeTc;
    }

    public String getmCtypeStatus() {
        return mCtypeStatus;
    }

    public void setmCtypeStatus(String mCtypeStatus) {
        this.mCtypeStatus = mCtypeStatus;
    }

    public String getmCtypeAddedon() {
        return mCtypeAddedon;
    }

    public void setmCtypeAddedon(String mCtypeAddedon) {
        this.mCtypeAddedon = mCtypeAddedon;
    }

    public String getmBusId() {
        return mBusId;
    }

    public void setmBusId(String mBusId) {
        this.mBusId = mBusId;
    }

    public String getmBusTitle() {
        return mBusTitle;
    }

    public void setmBusTitle(String mBusTitle) {
        this.mBusTitle = mBusTitle;
    }

    public String getmBusImg() {
        return mBusImg;
    }

    public void setmBusImg(String mBusImg) {
        this.mBusImg = mBusImg;
    }

    public String getmBusKm() {
        return mBusKm;
    }

    public void setmBusKm(String mBusKm) {
        this.mBusKm = mBusKm;
    }

    public String getmBusPrice() {
        return mBusPrice;
    }

    public void setmBusPrice(String mBusPrice) {
        this.mBusPrice = mBusPrice;
    }

    public String getmBusBranch() {
        return mBusBranch;
    }

    public void setmBusBranch(String mBusBranch) {
        this.mBusBranch = mBusBranch;
    }

    public String getmBusInclusion() {
        return mBusInclusion;
    }

    public void setmBusInclusion(String mBusInclusion) {
        this.mBusInclusion = mBusInclusion;
    }

    public String getmBusExclusion() {
        return mBusExclusion;
    }

    public void setmBusExclusion(String mBusExclusion) {
        this.mBusExclusion = mBusExclusion;
    }

    public String getmBusTandc() {
        return mBusTandc;
    }

    public void setmBusTandc(String mBusTandc) {
        this.mBusTandc = mBusTandc;
    }

    public String getmBusStatus() {
        return mBusStatus;
    }

    public void setmBusStatus(String mBusStatus) {
        this.mBusStatus = mBusStatus;
    }

    public String getmBusAddedon() {
        return mBusAddedon;
    }

    public void setmBusAddedon(String mBusAddedon) {
        this.mBusAddedon = mBusAddedon;
    }

    public String getmBustUpdatedon() {
        return mBustUpdatedon;
    }

    public void setmBustUpdatedon(String mBustUpdatedon) {
        this.mBustUpdatedon = mBustUpdatedon;
    }

    public String getmDriverId() {
        return mDriverId;
    }

    public void setmDriverId(String mDriverId) {
        this.mDriverId = mDriverId;
    }

    public String getmDriverVendor() {
        return mDriverVendor;
    }

    public void setmDriverVendor(String mDriverVendor) {
        this.mDriverVendor = mDriverVendor;
    }

    public String getmDriverName() {
        return mDriverName;
    }

    public void setmDriverName(String mDriverName) {
        this.mDriverName = mDriverName;
    }

    public String getmDriverMobile() {
        return mDriverMobile;
    }

    public void setmDriverMobile(String mDriverMobile) {
        this.mDriverMobile = mDriverMobile;
    }

    public String getmDriverImg() {
        return mDriverImg;
    }

    public void setmDriverImg(String mDriverImg) {
        this.mDriverImg = mDriverImg;
    }

    public String getmDriverOtp() {
        return mDriverOtp;
    }

    public void setmDriverOtp(String mDriverOtp) {
        this.mDriverOtp = mDriverOtp;
    }

    public String getmDriverDrivelic() {
        return mDriverDrivelic;
    }

    public void setmDriverDrivelic(String mDriverDrivelic) {
        this.mDriverDrivelic = mDriverDrivelic;
    }

    public String getmDriverDrivelicExpdate() {
        return mDriverDrivelicExpdate;
    }

    public void setmDriverDrivelicExpdate(String mDriverDrivelicExpdate) {
        this.mDriverDrivelicExpdate = mDriverDrivelicExpdate;
    }

    public String getmDriverPoliceVerify() {
        return mDriverPoliceVerify;
    }

    public void setmDriverPoliceVerify(String mDriverPoliceVerify) {
        this.mDriverPoliceVerify = mDriverPoliceVerify;
    }

    public String getmDriverState() {
        return mDriverState;
    }

    public void setmDriverState(String mDriverState) {
        this.mDriverState = mDriverState;
    }

    public String getmDriverCity() {
        return mDriverCity;
    }

    public void setmDriverCity(String mDriverCity) {
        this.mDriverCity = mDriverCity;
    }

    public String getmDriverStatus() {
        return mDriverStatus;
    }

    public void setmDriverStatus(String mDriverStatus) {
        this.mDriverStatus = mDriverStatus;
    }

    public String getmDriverAddedon() {
        return mDriverAddedon;
    }

    public void setmDriverAddedon(String mDriverAddedon) {
        this.mDriverAddedon = mDriverAddedon;
    }

    public String getmDriverUpdatedon() {
        return mDriverUpdatedon;
    }

    public void setmDriverUpdatedon(String mDriverUpdatedon) {
        this.mDriverUpdatedon = mDriverUpdatedon;
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

    public String getmBranchCity() {
        return mBranchCity;
    }

    public void setmBranchCity(String mBranchCity) {
        this.mBranchCity = mBranchCity;
    }

    public String getmBranchState() {
        return mBranchState;
    }

    public void setmBranchState(String mBranchState) {
        this.mBranchState = mBranchState;
    }

    public String getmBranchOrder() {
        return mBranchOrder;
    }

    public void setmBranchOrder(String mBranchOrder) {
        this.mBranchOrder = mBranchOrder;
    }

    public String getmBranchStatus() {
        return mBranchStatus;
    }

    public void setmBranchStatus(String mBranchStatus) {
        this.mBranchStatus = mBranchStatus;
    }

    public String getmBranchAddedon() {
        return mBranchAddedon;
    }

    public void setmBranchAddedon(String mBranchAddedon) {
        this.mBranchAddedon = mBranchAddedon;
    }

    public String getmBranchUpdatedon() {
        return mBranchUpdatedon;
    }

    public void setmBranchUpdatedon(String mBranchUpdatedon) {
        this.mBranchUpdatedon = mBranchUpdatedon;
    }
}
