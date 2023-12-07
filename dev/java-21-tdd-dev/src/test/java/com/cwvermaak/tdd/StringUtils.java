package com.cwvermaak.tdd;

public class StringUtils {
    public static String truncate(String input, int limit) {
        if (input.length() < limit)
        {
            return input;
        }
        return input.substring(0, limit) + "...";
    }
}
