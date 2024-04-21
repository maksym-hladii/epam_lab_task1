package com.epam.training.student_maksym_hladii.task1.binary_operations.double_operands;

import com.epam.training.student_maksym_hladii.task1.AbstractTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DoubleSumTest extends AbstractTest {

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(-2.5, 1.1, -1.4),        // -2.5 + 1.1 = -1.4
                Arguments.of(-1.5, 1.5, 0.0),         // -1.5 + 1.5 = 0.0
                Arguments.of(0.0, 1.5, 1.5),          // 0.0 + 1.5 = 1.5
                Arguments.of(1.1, 1.9, 3.0),          // 1.1 + 1.9 = 3.0

                Arguments.of(-1.1, -1.9, -3.0),       // -1.1 + (-1.9) = -3.0
                Arguments.of(0.0, -1.5, -1.5),        // 0.0 + (-1.5) = -1.5
                Arguments.of(1.5, -1.5, 0.0),         // 1.5 + (-1.5) = 0.0
                Arguments.of(2.5, -1.1, 1.4)          // 2.5 + (-1.1) = 1.4
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void doubleSumTest(double operand1, double operand2, double expectedResult) {
        assertEquals(expectedResult, calculator.sum(operand1, operand2));
    }

    private static Stream<Arguments> provideInvalidTypeTestData() {
        return Stream.of(
                Arguments.of('1', '1'),
                Arguments.of('a', 'b'),
                Arguments.of("2.2", "2.2"),
                Arguments.of("A", "B"),
                Arguments.of(null, null)
        );
    }

    @ParameterizedTest
    @Disabled
    @MethodSource("provideInvalidTypeTestData")
    public void invalidTypeTest(double operand1, double operand2) {
        assertThrows(IllegalArgumentException.class, () -> calculator.sum(operand1, operand2));
    }

}
