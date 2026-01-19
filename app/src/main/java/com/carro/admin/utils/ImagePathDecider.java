package com.carro.admin.utils;


import com.carro.admin.BuildConfig;

public class ImagePathDecider {
    public static String getUserImagePath(){
        return BuildConfig.BASE_IMAGE_URL+"users/";
    }
    public static String getAdvImagePath(){
        return BuildConfig.BASE_IMAGE_URL+"apps/";
    }
}
