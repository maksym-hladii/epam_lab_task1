package com.epam.training.student_maksym_hladii.task1.boolean_operations;

import com.epam.training.student_maksym_hladii.task1.AbstractTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class IsPositiveTest extends AbstractTest {

    private static Stream<Arguments> providePositiveTestData() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(Long.MAX_VALUE)
        );
    }

    @ParameterizedTest
    @MethodSource("providePositiveTestData")
    public void isPositiveTest(long value) {
        assertTrue(calculator.isPositive(value));
    }

    private static Stream<Arguments> provideNotPositiveTestData() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(-1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideNotPositiveTestData")
    public void isNotPositiveTest(long value) {
        assertFalse(calculator.isPositive(value));
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
        assertThrows(IllegalArgumentException.class, () -> calculator.isPositive(value));
    }

}
