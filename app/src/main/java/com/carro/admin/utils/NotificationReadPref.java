package com.carro.admin.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class NotificationReadPref {

    private static final String PREF_NAME = "notification_read_pref";
    private static final String KEY_READ_IDS = "read_notification_ids";

    public static void markAsRead(Context context, String notifId) {
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        Set<String> readIds = new HashSet<>(pref.getStringSet(KEY_READ_IDS, new HashSet<>()));
        readIds.add(notifId);
        pref.edit().putStringSet(KEY_READ_IDS, readIds).apply();
    }

    public static void markAllAsRead(Context context, Set<String> ids) {
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        pref.edit().putStringSet(KEY_READ_IDS, ids).apply();
    }

    public static boolean isRead(Context context, String notifId) {
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return pref.getStringSet(KEY_READ_IDS, new HashSet<>()).contains(notifId);
    }
}
