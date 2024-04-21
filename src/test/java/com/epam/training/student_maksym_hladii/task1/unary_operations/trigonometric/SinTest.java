package com.epam.training.student_maksym_hladii.task1.unary_operations.trigonometric;

import com.epam.training.student_maksym_hladii.task1.AbstractTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinTest extends AbstractTest {

    private static Stream<Arguments> provide0to180TestData() {
        return Stream.of(
                Arguments.of(0, 0, EPSILON),                                // 0 degrees
                Arguments.of(Math.PI / 6, 0.5, EPSILON),                    // 30 degrees
                Arguments.of(Math.PI / 4, 0.70711, EPSILON),                // 45 degrees
                Arguments.of(Math.PI / 3, 0.86603, EPSILON),                // 60 degrees
                Arguments.of(Math.PI / 2, 1, EPSILON),                      // 90 degrees
                Arguments.of(2 * Math.PI / 3, 0.86603, EPSILON),            // 120 degrees
                Arguments.of(3 * Math.PI / 4, 0.70711, EPSILON),            // 135 degrees
                Arguments.of(5 * Math.PI / 6, 0.5, EPSILON)                 // 150 degrees
        );
    }

    @ParameterizedTest
    @MethodSource("provide0to180TestData")
    public void sin0to180Test(double angle, double expectedResult) {
        assertEquals(expectedResult, calculator.sin(angle), EPSILON);
    }

    private static Stream<Arguments> provide180to360TestData() {
        return Stream.of(
                Arguments.of(0, Math.PI, EPSILON),                              // sin(180) =  sin(0)
                Arguments.of(Math.PI / 6, 7 * Math.PI / 6, EPSILON),            // sin(210) = -sin(30)
                Arguments.of(Math.PI / 4, 5 * Math.PI / 4, EPSILON),            // sin(225) = -sin(45)
                Arguments.of(Math.PI / 3, 4 * Math.PI / 3, EPSILON),            // sin(240) = -sin(60)
                Arguments.of(Math.PI / 2, 3 * Math.PI / 2, EPSILON),            // sin(270) = -sin(90)
                Arguments.of(2 * Math.PI / 3, 5 * Math.PI / 3, EPSILON),        // sin(300) = -sin(120)
                Arguments.of(3 * Math.PI / 4, 7 * Math.PI / 4, EPSILON),        // sin(315) = -sin(135)
                Arguments.of(5 * Math.PI / 6, 11 * Math.PI / 6, EPSILON)        // sin(330) = -sin(150)
        );
    }

    @ParameterizedTest
    @MethodSource("provide180to360TestData")
    public void sin180to360Test(double angle1, double angle2) {
        assertEquals(-calculator.sin(angle1), calculator.sin(angle2), EPSILON);
    }

    private static Stream<Arguments> providePeriodicTestData() {
        return Stream.of(
                Arguments.of(0, 2 * Math.PI, EPSILON),                          // sin(360) = sin(0)
                Arguments.of(Math.PI / 4, 9 * Math.PI / 4, EPSILON),            // sin(405) = sin(45)
                Arguments.of(Math.PI / 2, 5 * Math.PI / 2, EPSILON),            // sin(450) = sin(90)
                Arguments.of(3 * Math.PI / 4, 11 * Math.PI / 4, EPSILON),       // sin(495) = sin(135)
                Arguments.of(Math.PI, 3 * Math.PI, EPSILON),                    // sin(540) = sin(180)
                Arguments.of(5 * Math.PI / 4, 13 * Math.PI / 4, EPSILON),       // sin(585) = sin(225)
                Arguments.of(3 * Math.PI / 2, 7 * Math.PI / 2, EPSILON),        // sin(630) = sin(270)
                Arguments.of(2 * Math.PI, 4 * Math.PI, EPSILON)                 // sin(675) = sin(315)
        );
    }

    @ParameterizedTest
    @MethodSource("providePeriodicTestData")
    public void sinPeriodicTest(double angle1, double angle2) {
        assertEquals(calculator.sin(angle1), calculator.sin(angle2), EPSILON);
    }

}
