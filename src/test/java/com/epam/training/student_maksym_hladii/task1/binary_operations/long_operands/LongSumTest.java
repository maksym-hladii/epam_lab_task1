package com.epam.training.student_maksym_hladii.task1.binary_operations.long_operands;

import com.epam.training.student_maksym_hladii.task1.AbstractTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LongSumTest extends AbstractTest {

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(-2, 1, -1),        // -2 + 1 = -1
                Arguments.of(-1, 1, 0),         // -1 + 1 = 0
                Arguments.of(0, 1, 1),          // 0 + 1 = 1
                Arguments.of(1, 1, 2),          // 1 + 1 = 2

                Arguments.of(-1, -1, -2),       // -1 + (-1) = -2
                Arguments.of(0, -1, -1),        // 0 + (-1) = -1
                Arguments.of(1, -1, 0),         // 1 + (-1) = 0
                Arguments.of(2, -1, 1),         // 2 + (-1) = 1

                // the first parameter boundary testing
                Arguments.of(Long.MIN_VALUE, 1, Long.MIN_VALUE + 1),
                Arguments.of(Long.MAX_VALUE, -1, Long.MAX_VALUE - 1),

                // the second parameter boundary testing
                Arguments.of(1, Long.MIN_VALUE, Long.MIN_VALUE + 1),
                Arguments.of(-1, Long.MAX_VALUE, Long.MAX_VALUE - 1),

                // the result boundary testing
                Arguments.of(Long.MIN_VALUE + 1, -1, Long.MIN_VALUE),
                Arguments.of(Long.MAX_VALUE - 1, 1, Long.MAX_VALUE)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void longSumTest(long operand1, long operand2, long expectedResult) {
        assertEquals(expectedResult, calculator.sum(operand1, operand2));
    }

    private static Stream<Arguments> provideInvalidTypeTestData() {
        return Stream.of(
                Arguments.of(1.1, 1.1),
                Arguments.of('1', '1'),
                Arguments.of('a', 'b'),
                Arguments.of("2", "2"),
                Arguments.of("A", "B"),
                Arguments.of(null, null)
        );
    }

    @ParameterizedTest
    @Disabled
    @MethodSource("provideInvalidTypeTestData")
    public void invalidTypeTest(long operand1, long operand2) {
        assertThrows(IllegalArgumentException.class, () -> calculator.sum(operand1, operand2));
    }

    private static Stream<Arguments> provideOverflowTestData() {
        return Stream.of(Arguments.of(Long.MAX_VALUE, 1));
    }

    @ParameterizedTest
    @Disabled
    @MethodSource("provideOverflowTestData")
    public void overflowTest(long operand1, long operand2) {
        assertThrows(ArithmeticException.class, () -> calculator.sum(operand1, operand2));
    }

    private static Stream<Arguments> provideUnderflowTestData() {
        return Stream.of(Arguments.of(Long.MIN_VALUE, -1));
    }

    @ParameterizedTest
    @Disabled
    @MethodSource("provideUnderflowTestData")
    public void underflowTest(long operand1, long operand2) {
        assertThrows(ArithmeticException.class, () -> calculator.sum(operand1, operand2));
    }

}
