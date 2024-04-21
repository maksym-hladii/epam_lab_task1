package com.epam.training.student_maksym_hladii.task1.unary_operations;

import com.epam.training.student_maksym_hladii.task1.AbstractTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SqrtTest extends AbstractTest {

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(0.0, 0.0),                     // sqrt(0.0) = 0.0
                Arguments.of(-0.0, -0.0),                   // sqrt(-0.0) = -0.0

                Arguments.of(1, 1.0),                       // sqrt(1.0) = 1.0
                Arguments.of(2, 1.41421),                   // sqrt(2.0) = 1.41421
                Arguments.of(3, 1.73205),                   // sqrt(2.0) = 1.73205

                Arguments.of(4.0, 2),                       // sqrt(4.0) = 2.0
                Arguments.of(0.25, 0.5)                    // sqrt(0.25) = 0.5
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void sqrtTest(double operand, double expectedResult) {
        assertEquals(expectedResult, calculator.sqrt(operand), EPSILON);
    }

    private static Stream<Arguments> provideInvalidTypeTestData() {
        return Stream.of(
                Arguments.of('2'),
                Arguments.of('s'),
                Arguments.of("0.25"),
                Arguments.of("S")
        );
    }

    @ParameterizedTest
    @Disabled
    @MethodSource("provideInvalidTypeTestData")
    public void invalidTypeTest(double operand) {
        assertThrows(IllegalArgumentException.class, () -> calculator.sqrt(operand));
    }

    private static Stream<Arguments> provideInvalidOperationTestData() {
        return Stream.of(
                Arguments.of(-4.0),
                Arguments.of(-0.25)
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidOperationTestData")
    public void invalidOperationTest(double operand) {
        assertThrows(ArithmeticException.class, () -> calculator.sqrt(operand));
    }

}
