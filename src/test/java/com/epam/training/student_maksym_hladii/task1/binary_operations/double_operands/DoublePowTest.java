package com.epam.training.student_maksym_hladii.task1.binary_operations.double_operands;

import com.epam.training.student_maksym_hladii.task1.AbstractTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DoublePowTest extends AbstractTest {

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(2.5, 0.0, 1),                  // 2.5 ^ 0.0 = 1.0
                Arguments.of(2.5, -0.0, 1),                 // 2.5 ^ (-0.0) = 1.0
                Arguments.of(2.5, 1.0, 2.5),                // 2.5 ^ 1.0 = 2.5
                Arguments.of(2.5, -1.0, 0.4),               // 1.5 ^ (-1.0) = 0.4

                Arguments.of(2, 2, 4.0),                    // 2 ^ 2 = 4.0
                Arguments.of(2, 3, 8.0),                    // 2 ^ 3 = 8.0
                Arguments.of(-2, 4, 16.0),                  // (-2) ^ 4 = 16.0
                Arguments.of(-2, 5, -32.0),                 // (-2) ^ 5 = -32.0

                Arguments.of(0.5, 2, 0.25),                 // 0.5 ^ 2 = 0.25
                Arguments.of(-0.5, 2, 0.25),                // (-0.5) ^ 2 = 0.25
                Arguments.of(0.5, -2, 4.0),                 // 0.5 ^ (-2) = 4.0
                Arguments.of(-0.5, -2, 4.0),                // (-0.5) ^ (-2) = 4.0

                Arguments.of(4.0, 0.5, 2.0),                // 4.0 ^ 0.5 = (-2.0)
                Arguments.of(4.0, -0.5, 0.5),               // 4.0 ^ (-0.5) = 0.5
                Arguments.of(0.1, 0.5, 0.31623),            // 0.1 ^ 0.5 = 0.31623
                Arguments.of(0.1, -0.5, 3.16228),           // 0.1 ^ (-0.5) = 3.16228

                Arguments.of(0.0, 10, 0.0),                             // 0.0 ^ 10 = 0.0
                Arguments.of(0.0, -10, Double.POSITIVE_INFINITY)        // 0.0 ^ (-10) = Infinity
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void doublePowTest(double operand1, double operand2, double expectedResult) {
        assertEquals(expectedResult, calculator.pow(operand1, operand2), EPSILON);
    }

    private static Stream<Arguments> provideInvalidTypeTestData() {
        return Stream.of(
                Arguments.of('2', '6'),
                Arguments.of('c', 'd'),
                Arguments.of("2.0", "6.0"),
                Arguments.of("C", "D"),
                Arguments.of(null, null)
        );
    }

    @ParameterizedTest
    @Disabled
    @MethodSource("provideInvalidTypeTestData")
    public void invalidTypeTest(double operand1, double operand2) {
        assertThrows(IllegalArgumentException.class, () -> calculator.pow(operand1, operand2));
    }

    private static Stream<Arguments> provideInvalidOperationTestData() {
        return Stream.of(
                Arguments.of(-4, 0.5),
                Arguments.of(-4, -0.5)
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidOperationTestData")
    public void invalidOperationTest(double operand1, double operand2) {
        assertThrows(ArithmeticException.class, () -> calculator.pow(operand1, operand2));
    }

}
