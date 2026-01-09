package com.logixhunt.carrorentaladmin.utils;

public class Constant {

    public static final String CARRO_RENTAL = "carrorental";

    public static final String ddMMyyyy = "dd-MM-yyyy";
    public static final String yyyyMMdd = "yyyy-MM-dd";
    public static final String yyyyMMdd_HHmmss = "yyyy-MM-dd HH:mm:ss";
    public static final String ddMMyyyy_HHMMSSA = "dd-MM-yyyy hh:mm a";

    public static final String HHMMSSA = "hh:mm a";
    public static final String HHMMSS = "hh:mm:ss";
    public static final String SUCCESS_RESPONSE_CODE = "200";
    public static final String SUCCESS_RESPONSE = "success";

    public static String WEBVIEW_TITLE = "";
    public static String WEBVIEW_URL = "";

    public static String FILENAME = "file";
    public static String DRIVING_MODE = "driving";
    public static String GOOGLE_MAP_API_KEY = "AIzaSyBgiv49mgm6XjZjSVjJesafwhZMHQsj-DM";

    public interface BundleExtras {
        String BOOKING_ID = "booking_id";
        String BOOKING_TYPE = "booking_type";
        String BOOKING_TYPE_CAT = "booking_type_cat";
        String NOTIFICATION_TYPE = "notificationType";
        String RENT_DATA = "rentData";
        String SUB_DATA = "subData";

    }

    public interface PreferenceConstant {

        String IS_LOGIN = "isLogin";

        String USER_DATA = "user_data";
        String USER_ID = "userType";
       // String USER_TYPE = "user_id";
        String PICKUP_LOCATION = "pickup_location";
        String DROP_LOCATION = "drop_location";

        String PICK_LAT = "pickLat";
        String PICK_LNG = "pickLng";
        String DROP_LAT = "dropLat";
        String DROP_LNG = "DropLng";
        String MAP_DISTANCE = "mapDistance";
        String KM_PRICE = "km_price";
        String HOUR_TYPE = "hour_type";

        String WEBVIEW_INC = "webIC";
        String WEBVIEW_EXC = "webExc";
        String WEBVIEW_TC = "webTc";
        String BRANCH_ID = "branch_id";
        String PACKAGE_ID = "package_id";



    }

    public interface ApiKey {

        String USER_EMAIL = "user_email";
        String USER_PASS = "user_pswd";
        String USER_ID = "user_id";
        String USER_NAME = "user_name";
        String USER_MOBILE = "user_mobile";
        String USER_PSWD = "user_pswd";
        String USER_PIC = "user_pic";
        String BOOKING_ID = "booking_id";
        String VENDOR_ID = "vendor_id";
        String BOOKING_STATUS = "booking_status";
        String NOTIFY_TYPE = "notif_type";
        String NOTIFY_USER = "m_notif_user";
        String NOTIFY_BOOKING = "m_notif_booking";
        String NOTIFY_TITLE = "m_notif_title";
        String NOTIFY_MESSAGE = "m_notif_message";
       // String USER_TYPE = "user_type";


    }

    public interface EndPoint {

        String LOGIN = "login";
        String USER_DETAILS = "user_details";
        String UPDATE_PROFILE = "update_profile";
        String BOOKING_CAB_SERVICE = "booking_cab_service";
        String BOOKING_SELF_DRIVE = "booking_self_drive";
        String BOOKING_LUXURY_CAR = "booking_luxury_car";
        String BOOKING_BUS = "booking_bus";
        String BOOKING_DETAILS = "booking_details";
        String VENDOR = "vendor";
        String UPDATE_VENDOR = "update_vendor";
        String UPDATE_BOOKING = "update_booking";
        String TODAY_BOOKING = "today_booking";
        String COUNT_ROW = "count_row";
        String CUSTOMER_NOTIFICATION_LIST = "customer_notification_list";
        String VENDOR_NOTIFICATION_LIST = "vendor_notification_list";
        String CUSTOMER = "customer";
        String INSERT_NOTIFICATION = "insert_notification_dtl";
        String ALL_PENDING_BOOKING = "all_pending_booking";
        String SELF_SERVICE_SUBS_BOOKING = "self_service_subs_booking";
        String ADVERTISE = "advertise";
        String CHECK_BLOCK_WITH_ID = "check_block_with_id";
       // String NOTIFICATION_LIST = "notification_list";

    }
}
