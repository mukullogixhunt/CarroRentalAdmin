package com.carro.admin.api;

import com.carro.admin.api.response.BookingDetailsResponse;
import com.carro.admin.api.response.BookingIdResponse;
import com.carro.admin.api.response.BookingListResponse;
import com.carro.admin.api.response.CountsResponse;
import com.carro.admin.api.response.CustomerListResponse;
import com.carro.admin.api.response.LoginResponse;
import com.carro.admin.api.response.NotificationListResponse;
import com.carro.admin.api.response.RentalResponse;
import com.carro.admin.api.response.SubscriptionResponse;
import com.carro.admin.api.response.VendorListResponse;
import com.carro.admin.api.response.commonResponse.BaseResponse;
import com.carro.admin.model.AdvertiseModel;
import com.carro.admin.model.CheckBlockModel;
import com.carro.admin.model.MarkAllReadResponse;
import com.carro.admin.utils.Constant;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiInterface {

    @FormUrlEncoded
    @POST(Constant.EndPoint.LOGIN)
    Call<LoginResponse> loginAdmin(
            @Field(Constant.ApiKey.USER_EMAIL) String user_email,
            @Field(Constant.ApiKey.USER_PASS) String user_pswd
    );

    @FormUrlEncoded
    @POST(Constant.EndPoint.USER_DETAILS)
    Call<LoginResponse> userDetails(
            @Field(Constant.ApiKey.USER_ID) String user_id
    );

    @Multipart
    @POST(Constant.EndPoint.UPDATE_PROFILE)
    Call<LoginResponse> update_profile(
            @Part(Constant.ApiKey.USER_ID) RequestBody user_id,
            @Part(Constant.ApiKey.USER_NAME) RequestBody user_name,
            @Part(Constant.ApiKey.USER_MOBILE) RequestBody user_mobile,
            @Part(Constant.ApiKey.USER_EMAIL) RequestBody user_email,
            @Part(Constant.ApiKey.USER_PSWD) RequestBody user_pswd,
            @Part MultipartBody.Part user_pic
    );

    @POST(Constant.EndPoint.BOOKING_CAB_SERVICE)
    Call<BookingListResponse> bookingCabService();

    @POST(Constant.EndPoint.BOOKING_SELF_DRIVE)
    Call<RentalResponse> bookingSelfDerive();

    @POST(Constant.EndPoint.SELF_SERVICE_SUBS_BOOKING)
    Call<SubscriptionResponse> subBookingSelfDerive();

    @POST(Constant.EndPoint.BOOKING_LUXURY_CAR)
    Call<BookingListResponse> bookingLuxuryCar();

    @POST(Constant.EndPoint.BOOKING_BUS)
    Call<BookingListResponse> bookingBus();

//    @FormUrlEncoded
//    @POST(Constant.EndPoint.BOOKING_DETAILS)
//    Call<BookingListResponse> bookingDetails(
//            @Field(Constant.ApiKey.BOOKING_ID) String booking_id
//    );

    @FormUrlEncoded
    @POST(Constant.EndPoint.BOOKING_DETAILS)
    Call<BookingDetailsResponse> bookingDetails(
            @Field(Constant.ApiKey.BOOKING_ID) String booking_id
    );

    @POST(Constant.EndPoint.VENDOR)
    Call<VendorListResponse> vendorsList();

    @FormUrlEncoded
    @POST(Constant.EndPoint.UPDATE_VENDOR)
    Call<BaseResponse> updateVendor(
            @Field(Constant.ApiKey.BOOKING_ID) String booking_id,
            @Field(Constant.ApiKey.VENDOR_ID) String vendor_id
    );

    @FormUrlEncoded
    @POST(Constant.EndPoint.UPDATE_BOOKING)
    Call<BaseResponse> updateStatus(
            @Field(Constant.ApiKey.BOOKING_ID) String booking_id,
            @Field(Constant.ApiKey.BOOKING_STATUS) String booking_status
    );

    @POST(Constant.EndPoint.TODAY_BOOKING)
    Call<BookingListResponse> todayBooking();

    @POST(Constant.EndPoint.COUNT_ROW)
    Call<CountsResponse> bookingsCounts();

    @Multipart
    @POST(Constant.EndPoint.ADMIN_NOTIFICATION_LIST)
    Call<NotificationListResponse> adminNotificationList(
            @Part("user_type") RequestBody userType,
            @Part("user_branch") RequestBody userBranch
    );

    @POST(Constant.EndPoint.VENDOR_NOTIFICATION_LIST)
    Call<NotificationListResponse> vendorNotificationList();


    @POST(Constant.EndPoint.CUSTOMER)
    Call<CustomerListResponse> customerList();

    @FormUrlEncoded
    @POST(Constant.EndPoint.INSERT_NOTIFICATION)
    Call<BaseResponse> insertNotification(
            @Field(Constant.ApiKey.NOTIFY_TYPE) String notif_type,
            @Field(Constant.ApiKey.NOTIFY_USER) String m_notif_user,
            @Field(Constant.ApiKey.NOTIFY_BOOKING) String m_notif_booking,
            @Field(Constant.ApiKey.NOTIFY_TITLE) String m_notif_title,
            @Field(Constant.ApiKey.NOTIFY_MESSAGE) String m_notif_message
    );

    @POST(Constant.EndPoint.ALL_PENDING_BOOKING)
    Call<BookingIdResponse> bookingIdList();


    @POST(Constant.EndPoint.ADVERTISE)
    Call<AdvertiseModel> get_advertise();


    @FormUrlEncoded
    @POST(Constant.EndPoint.CHECK_BLOCK_WITH_ID)
    Call<CheckBlockModel> check_block_with_id(
            @Field(Constant.ApiKey.USER_ID) String user_id
    );

    @FormUrlEncoded
    @POST(Constant.EndPoint.UPDATE_FCM)
    Call<BaseResponse> updateFCM(
            @Field(Constant.ApiKey.USER_ID) String user_id,
            @Field(Constant.ApiKey.FCM_TOKEN) String fcmtoken
    );

    //  make changes ,.................
    @FormUrlEncoded
    @POST("notif_mark_as_read") // Add this in your Constant.EndPoint
    Call<MarkAllReadResponse> markAllNotificationsRead(
            @Field(Constant.ApiKey.USER_ID) String user_id
    );

    @FormUrlEncoded
    @POST("notif_mark_as_read") // Add this in your Constant.EndPoint
    Call<MarkAllReadResponse> markItemNotificationsRead(
            @Field(Constant.ApiKey.USER_ID) String user_id,
            @Field("notif_key") String notif_key,
            @Field("notif_id") String notif_id
    );





}
