package com.carro.admin.utils;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public final class RequestBodyUtils {

    private static final MediaType TEXT_PLAIN =
            MediaType.parse("text/plain");

    private RequestBodyUtils() {
        // Prevent instantiation
    }

    public static RequestBody toTextRequestBody(String value) {
        return RequestBody.create(value, TEXT_PLAIN);
    }
}
