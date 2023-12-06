package com.cwvermaak.tdd;

public class StringUtils {
    public static String truncate(String input, int limit) {
        return input.substring(0, limit) + "...";
    }
}
