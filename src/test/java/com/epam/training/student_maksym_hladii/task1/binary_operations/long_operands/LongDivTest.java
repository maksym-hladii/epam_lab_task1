package com.epam.training.student_maksym_hladii.task1.binary_operations.long_operands;

import com.epam.training.student_maksym_hladii.task1.AbstractTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LongDivTest extends AbstractTest {

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(0, 1, 0),          // 0 / 1 = 0
                Arguments.of(0, -1, 0),         // 0 / (-1) = 0

                // the first and the second parameters boundary testing
                Arguments.of(Long.MIN_VALUE, Long.MIN_VALUE, 1),
                Arguments.of(Long.MAX_VALUE, Long.MAX_VALUE, 1),

                // the result boundary testing
                Arguments.of(Long.MIN_VALUE, 1, Long.MIN_VALUE),
                Arguments.of(Long.MAX_VALUE, 1, Long.MAX_VALUE),

                Arguments.of(1, 1, 1),          // 1 / 1 = 1
                Arguments.of(2, 1, 2),          // 2 / 1 = 2
                Arguments.of(6, 2, 3),          // 6 * 2 = 3
                Arguments.of(1, -1, -1),        // 1 / (-1) = -1
                Arguments.of(2, -1, -2),        // 2 / (-1) = -2
                Arguments.of(6, -2, -3),        // 6 * (-2) = -3
                Arguments.of(-1, -1, 1),        // 1 / (-1) = 1
                Arguments.of(-2, -1, 2),        // 2 / (-1) = 2
                Arguments.of(-6, -2, 3)         // 6 * (-2) = 3
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void longDivTest(long operand1, long operand2, long expectedResult) {
        assertEquals(expectedResult, calculator.div(operand1, operand2));
    }

    private static Stream<Arguments> provideInvalidTypeTestData() {
        return Stream.of(
                Arguments.of(8.8, 4.4),
                Arguments.of('8', '4'),
                Arguments.of('b', 'a'),
                Arguments.of("8", "4"),
                Arguments.of("B", "A"),
                Arguments.of(null, null)
        );
    }

    @ParameterizedTest
    @Disabled
    @MethodSource("provideInvalidTypeTestData")
    public void invalidTypeTest(long operand1, long operand2) {
        assertThrows(IllegalArgumentException.class, () -> calculator.div(operand1, operand2));
    }

    private static Stream<Arguments> provideDivisionByZeroTestData() {
        return Stream.of(
                Arguments.of(1, 0),
                Arguments.of(-1, 0),
                Arguments.of(0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideDivisionByZeroTestData")
    public void divisionByZeroTest(long operand1, long operand2) {
        assertThrows(NumberFormatException.class, () -> calculator.div(operand1, operand2),
                "Attempt to divide by zero");
    }

    private static Stream<Arguments> provideUnderflowTestData() {
        return Stream.of(Arguments.of(Long.MIN_VALUE, -1));
    }

    @ParameterizedTest
    @Disabled
    @MethodSource("provideUnderflowTestData")
    public void underflowTest(long operand1, long operand2) {
        assertThrows(ArithmeticException.class, () -> calculator.div(operand1, operand2));
    }

}
