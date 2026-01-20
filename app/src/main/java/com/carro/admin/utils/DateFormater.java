package com.carro.admin.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateFormater {

    public static String getDate(long milliSeconds, String outputFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(outputFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

    public static String changeDateFormat(String fromFormat, String toFormat, String dateStr) {

        SimpleDateFormat sdfIn = new SimpleDateFormat(fromFormat, Locale.US);
        Date date = null;
        try {
            date = sdfIn.parse(dateStr);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        SimpleDateFormat sdfOut = new SimpleDateFormat(toFormat, Locale.US);
        String formattedTime = sdfOut.format(date);

        return formattedTime;

    }

    public static String formatTime(long timeInMillis, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        return sdf.format(calendar.getTime());
    }

    public static String formatTo24Hour(String timeIn12Hour) {
        try {
            // Define the input format (12-hour format)
            SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
            // Define the output format (24-hour format)
            SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());

            // Parse the input time and format it into 24-hour time
            Date date = inputFormat.parse(timeIn12Hour);
            return outputFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String formatTimestamp(String value) {

        if (value == null) return "";

        value = value.trim();

        // Empty or invalid values
        if (value.isEmpty()
                || value.equalsIgnoreCase("null")
                || value.equals("0")
                || value.equals("0000-00-00")
                || value.equals("0000-00-00 00:00:00")) {
            return "";
        }

        try {
            // 1️⃣ Milliseconds timestamp (13 digit)
            if (value.matches("\\d{13}")) {
                long millis = Long.parseLong(value);
                return new SimpleDateFormat(
                        "dd-MM-yyyy hh:mm a",
                        Locale.getDefault()
                ).format(new Date(millis));
            }

            // 2️⃣ Seconds timestamp (10 digit)
            if (value.matches("\\d{10}")) {
                long millis = Long.parseLong(value) * 1000;
                return new SimpleDateFormat(
                        "dd-MM-yyyy hh:mm a",
                        Locale.getDefault()
                ).format(new Date(millis));
            }

            // 3️⃣ Date only → yyyy-MM-dd
            if (value.length() == 10) {
                return changeDateFormat(
                        "yyyy-MM-dd",
                        "dd-MM-yyyy",
                        value
                );
            }

            // 4️⃣ DateTime → yyyy-MM-dd HH:mm:ss
            return changeDateFormat(
                    "yyyy-MM-dd HH:mm:ss",
                    "dd-MM-yyyy hh:mm a",
                    value
            );

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


}
