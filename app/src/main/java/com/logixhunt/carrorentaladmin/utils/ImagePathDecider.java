package com.logixhunt.carrorentaladmin.utils;


import com.logixhunt.carrorentaladmin.BuildConfig;

public class ImagePathDecider {
    public static String getUserImagePath(){
        return BuildConfig.BASE_IMAGE_URL+"users/";
    }
    public static String getAdvImagePath(){
        return BuildConfig.BASE_IMAGE_URL+"apps/";
    }
}
