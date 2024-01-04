package com.cwvermaak.tdd.m3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class StringTruncateTests {
/*
    @Test
    public void limitExceeded_StringTruncated()
    {
        String input = "The economy is about to collapse";
        int limit = 11;

        Assertions.assertEquals("The economy...", StringUtils.truncate(input, limit));
    }
*/

    @ParameterizedTest
    @MethodSource("validTruncateLimitProvider")
    public void limitReached_StringTruncates(int limit, String expectedOutput)
    {
        String input = "The economy is about to collapse";
        Assertions.assertEquals(expectedOutput, StringUtils.truncateWithEllipses(input, limit));
    }

    @ParameterizedTest
    @MethodSource("inputOutputLimitProvider")
    public void limitNotReached_StringUnchanged(String input, int limit)
    {
        Assertions.assertEquals("The economy is about to collapse", StringUtils.truncateWithEllipses(input, limit));
    }

//    @Test
//    public void invalidInput_ThrowsException()
//    {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> StringUtils.truncate(null, 5));
//    }
//
//    @Test
//    public void InvalidLimit_ThrowsExeption()
//    {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> StringUtils.truncate("Some input", 0));
//    }
    @ParameterizedTest
    @MethodSource("invalidArgumentProvider")
    public void invalidInput_ThrowsException(String input, int limit)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> StringUtils.truncateWithEllipses(input, limit));
    }

    @ParameterizedTest
    @MethodSource("shortInputLessOrEqualToEllipses")
    public void inputShorterOrEqualToEllipses_StringNotChanged(String input, int limit)
    {
        Assertions.assertEquals(input, StringUtils.truncateWithEllipses(input, limit));
    }

    @ParameterizedTest
    @MethodSource("blankOrEmptyInput")
    public void inputBlankOrEmpty(String input, int limit)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> StringUtils.truncateWithEllipses(input, limit));
    }

    public static Stream<Arguments> invalidArgumentProvider()
    {
        return Stream.of(
                Arguments.of(null, 5),
                Arguments.of("Some input", 0)
        );

    }

    public static Stream<Arguments> inputOutputLimitProvider()
    {
        String input = "The economy is about to collapse";
        return Stream.of(
                Arguments.of(input, 50),
                Arguments.of(input, input.length()) // At the border, input length == limit
        );
    }

    public static Stream<Arguments> validTruncateLimitProvider()
    {
        return Stream.of(
                Arguments.of(1, "T..."),
                Arguments.of(11, "The economy...")
        );
    }

    public static Stream<Arguments> shortInputLessOrEqualToEllipses()
    {
        return Stream.of(
                Arguments.of("The", 2),
                Arguments.of("The", 3)
        );
    }

    public static Stream<Arguments> blankOrEmptyInput()
    {
        return Stream.of(
                Arguments.of("", 4),
            Arguments.of("    ", 5)
        );
    }
}
