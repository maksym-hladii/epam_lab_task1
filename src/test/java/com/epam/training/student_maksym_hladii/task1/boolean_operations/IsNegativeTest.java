package com.epam.training.student_maksym_hladii.task1.boolean_operations;

import com.epam.training.student_maksym_hladii.task1.AbstractTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class IsNegativeTest extends AbstractTest {

    private static Stream<Arguments> provideNegativeTestData() {
        return Stream.of(
                Arguments.of(-1),
                Arguments.of(Long.MIN_VALUE)
        );
    }

    @ParameterizedTest
    @MethodSource("provideNegativeTestData")
    public void isNegativeTest(long value) {
        assertTrue(calculator.isNegative(value));
    }

    private static Stream<Arguments> provideNotNegativeTestData() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideNotNegativeTestData")
    public void isNotNegativeTest(long value) {
        assertFalse(calculator.isNegative(value));
    }

    private static Stream<Arguments> provideInvalidTypeTestData() {
        return Stream.of(
                Arguments.of(1.1),
                Arguments.of('1'),
                Arguments.of('a'),
                Arguments.of("2"),
                Arguments.of("A")
        );
    }

    @ParameterizedTest
    @Disabled
    @MethodSource("provideInvalidTypeTestData")
    public void invalidTypeTest(long value) {
        assertThrows(IllegalArgumentException.class, () -> calculator.isNegative(value));
    }

}
