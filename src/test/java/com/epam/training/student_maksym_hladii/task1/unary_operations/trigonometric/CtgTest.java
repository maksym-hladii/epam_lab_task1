package com.epam.training.student_maksym_hladii.task1.unary_operations.trigonometric;

import com.epam.training.student_maksym_hladii.task1.AbstractTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CtgTest extends AbstractTest {

    private static Stream<Arguments> provide0to180TestData() {
        return Stream.of(
                Arguments.of(Math.PI / 6, 1.73205, EPSILON),                // 30 degrees
                Arguments.of(Math.PI / 4, 1, EPSILON),                      // 45 degrees
                Arguments.of(Math.PI / 3, 0.57735, EPSILON),                // 60 degrees
                Arguments.of(Math.PI / 2, 0, EPSILON),                      // 90 degrees
                Arguments.of(2 * Math.PI / 3, -0.57735, EPSILON),           // 120 degrees
                Arguments.of(3 * Math.PI / 4, -1, EPSILON),                 // 135 degrees
                Arguments.of(5 * Math.PI / 6, -1.73205, EPSILON)            // 150 degrees
        );
    }

    @ParameterizedTest
    @MethodSource("provide0to180TestData")
    public void ctg0to180Test(double angle, double expectedResult) {
        assertEquals(expectedResult, calculator.ctg(angle), EPSILON);
    }

    private static Stream<Arguments> provide180to360TestData() {
        return Stream.of(
                Arguments.of(Math.PI / 6, 7 * Math.PI / 6, EPSILON),            // ctg(210) = ctg(30)
                Arguments.of(Math.PI / 4, 5 * Math.PI / 4, EPSILON),            // ctg(225) = ctg(45)
                Arguments.of(Math.PI / 3, 4 * Math.PI / 3, EPSILON),            // ctg(240) = ctg(60)
                Arguments.of(Math.PI / 2, 3 * Math.PI / 2, EPSILON),            // ctg(270) = ctg(90)
                Arguments.of(2 * Math.PI / 3, 5 * Math.PI / 3, EPSILON),        // ctg(300) = ctg(120)
                Arguments.of(3 * Math.PI / 4, 7 * Math.PI / 4, EPSILON),        // ctg(315) = ctg(135)
                Arguments.of(5 * Math.PI / 6, 11 * Math.PI / 6, EPSILON)        // ctg(330) = ctg(150)
        );
    }

    @ParameterizedTest
    @MethodSource("provide180to360TestData")
    public void ctg180to360Test(double angle1, double angle2) {
        assertEquals(calculator.ctg(angle1), calculator.ctg(angle2), EPSILON);
    }

    private static Stream<Arguments> providePeriodicTestData() {
        return Stream.of(
                Arguments.of(Math.PI / 4, 9 * Math.PI / 4, EPSILON),            // ctg(405) = ctg(45)
                Arguments.of(Math.PI / 2, 5 * Math.PI / 2, EPSILON),            // ctg(450) = ctg(90)
                Arguments.of(3 * Math.PI / 4, 11 * Math.PI / 4, EPSILON),       // ctg(495) = ctg(135)
                Arguments.of(5 * Math.PI / 4, 13 * Math.PI / 4, EPSILON),       // ctg(585) = ctg(225)
                Arguments.of(3 * Math.PI / 2, 7 * Math.PI / 2, EPSILON),        // cos(630) = cos(270)
                Arguments.of(7 * Math.PI / 4, 15 * Math.PI / 4, EPSILON)        // ctg(675) = ctg(315)
        );
    }

    @ParameterizedTest
    @MethodSource("providePeriodicTestData")
    public void ctgPeriodicTest(double angle1, double angle2) {
        assertEquals(calculator.ctg(angle1), calculator.ctg(angle2), EPSILON);
    }

    private static Stream<Arguments> provideCtgUndefinedTestData() {
        return Stream.of(
                Arguments.of(0),                // 0 degrees
                Arguments.of(2 * Math.PI),      // 180 degrees
                Arguments.of(4 * Math.PI),      // 360 degrees
                Arguments.of(6 * Math.PI)       // 540 degrees
        );
    }

    @ParameterizedTest
    @MethodSource("provideCtgUndefinedTestData")
    public void ctgUndefinedTest(double angle) {
        assertThrows(ArithmeticException.class, () -> calculator.ctg(angle));
    }

}
