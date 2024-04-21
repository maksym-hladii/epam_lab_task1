package com.epam.training.student_maksym_hladii.task1.binary_operations.double_operands;

import com.epam.training.student_maksym_hladii.task1.AbstractTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DoubleDivTest extends AbstractTest {

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(1.0, 0.0, Double.POSITIVE_INFINITY),
                Arguments.of(-1.0, 0.0, Double.NEGATIVE_INFINITY),

                Arguments.of(0.0, 1.0, 0.0),            // 0.0 / 1.0 = 0.0
                Arguments.of(0.0, -1.0, -0.0),          // 0.0 / (-1.0) = -0.0

                Arguments.of(5, 2, 2.5),                // 5 / 2 = 2.5
                Arguments.of(1, 5, 0.2),                // 1 / 5 = 0.2
                Arguments.of(5.2, 2.5, 2.08),           // 5.2 / 2.5 = 2.08
                Arguments.of(0.81, -0.9, -0.9),         // 0.81 / (-0.9) = -0.9
                Arguments.of(-10.0, -3.0, 3.333333)     // -10.0 / (-3.0) = 3.333333
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void doubleDivTest(double operand1, double operand2, double expectedResult) {
        assertEquals(expectedResult, calculator.div(operand1, operand2), EPSILON);
    }

    private static Stream<Arguments> provideInvalidTypeTestData() {
        return Stream.of(
                Arguments.of('8', '4'),
                Arguments.of('b', 'a'),
                Arguments.of("8.2", "4.2"),
                Arguments.of("B", "A"),
                Arguments.of(null, null)
        );
    }

    @ParameterizedTest
    @Disabled
    @MethodSource("provideInvalidTypeTestData")
    public void invalidTypeTest(double operand1, double operand2) {
        assertThrows(IllegalArgumentException.class, () -> calculator.div(operand1, operand2));
    }

}
