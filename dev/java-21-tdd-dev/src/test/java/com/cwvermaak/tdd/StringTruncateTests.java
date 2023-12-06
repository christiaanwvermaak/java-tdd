package com.cwvermaak.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTruncateTests {
    @Test
    public void limitExceeded_StringTruncated()
    {
        String input = "The economy is about to collapse";
        int limit = 11;

        Assertions.assertEquals("The economy...", StringUtils.truncate(input, limit));
    }

    @Test
    public void limitNotReached_StringUnchanged()
    {
        String input = "The economy is about to collapse";
        int limit = 32;

        Assertions.assertEquals("The economy is about to collapse", StringUtils.truncate(input, limit));
    }
}
