package com.cwvermaak.tdd.m3;

public class StringUtils {
    public static String truncateWithCharacters(String input, int limit, String truncateCharacters) {
        if (input == null)
        {
            throw new IllegalArgumentException("String input cannot be null");
        }

        if (input.strip() == "")
        {
            throw new IllegalArgumentException("The input should contain characters and not only whitespace");
        }

        if (limit < 1)
        {
            throw new IllegalArgumentException("Limit should be greater than 0");
        }

        if (inputIsTooShort(input, limit, truncateCharacters))
        {
            return input;
        }

        return input.substring(0, limit) + "...";
    }

    public static String truncateWithEllipses(String input, int limit)
    {
        return truncateWithCharacters(input, limit, "...");
    }

    private static boolean inputIsTooShort(String input, int limit, String ellipsis) {
        return input.length() <= limit || input.length() <= ellipsis.length();
    }
}
