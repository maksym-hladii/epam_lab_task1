package com.epam.training.student_maksym_hladii.task1.unary_operations.trigonometric;

import com.epam.training.student_maksym_hladii.task1.AbstractTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TgTest extends AbstractTest {

    private static Stream<Arguments> provide0to180TestData() {
        return Stream.of(
                Arguments.of(0, 0, EPSILON),                                // 0 degrees
                Arguments.of(Math.PI / 6, 0.57735, EPSILON),                // 30 degrees
                Arguments.of(Math.PI / 4, 1, EPSILON),                      // 45 degrees
                Arguments.of(Math.PI / 3, 1.73205, EPSILON),                // 60 degrees
                Arguments.of(2 * Math.PI / 3, -1.73205, EPSILON),           // 120 degrees
                Arguments.of(3 * Math.PI / 4, -1, EPSILON),                 // 135 degrees
                Arguments.of(5 * Math.PI / 6, -0.57735, EPSILON)            // 150 degrees
        );
    }

    @ParameterizedTest
    @MethodSource("provide0to180TestData")
    public void tg0to180Test(double angle, double expectedResult) {
        assertEquals(expectedResult, calculator.tg(angle), EPSILON);
    }

    private static Stream<Arguments> provide180to360TestData() {
        return Stream.of(
                Arguments.of(0, Math.PI, EPSILON),                              // tg(180) = tg(0)
                Arguments.of(Math.PI / 6, 7 * Math.PI / 6, EPSILON),            // tg(210) = tg(30)
                Arguments.of(Math.PI / 4, 5 * Math.PI / 4, EPSILON),            // tg(225) = tg(45)
                Arguments.of(Math.PI / 3, 4 * Math.PI / 3, EPSILON),            // tg(240) = stg(60)
                Arguments.of(2 * Math.PI / 3, 5 * Math.PI / 3, EPSILON),        // tg(300) = tg(120)
                Arguments.of(3 * Math.PI / 4, 7 * Math.PI / 4, EPSILON),        // tg(315) = tg(135)
                Arguments.of(5 * Math.PI / 6, 11 * Math.PI / 6, EPSILON)        // tg(330) = tg(150)
        );
    }

    @ParameterizedTest
    @MethodSource("provide180to360TestData")
    public void tg180to360Test(double angle1, double angle2) {
        assertEquals(calculator.tg(angle1), calculator.tg(angle2), EPSILON);
    }

    private static Stream<Arguments> providePeriodicTestData() {
        return Stream.of(
                Arguments.of(0, 2 * Math.PI, EPSILON),                          // tg(360) = tg(0)
                Arguments.of(Math.PI / 4, 9 * Math.PI / 4, EPSILON),            // tg(405) = tg(45)
                Arguments.of(3 * Math.PI / 4, 11 * Math.PI / 4, EPSILON),       // tg(495) = tg(135)
                Arguments.of(Math.PI, 3 * Math.PI, EPSILON),                    // tg(540) = tg(180)
                Arguments.of(5 * Math.PI / 4, 13 * Math.PI / 4, EPSILON),       // tg(585) = tg(225)
                Arguments.of(7 * Math.PI / 4, 15 * Math.PI / 4, EPSILON)        // tg(675) = tg(315)
        );
    }

    @ParameterizedTest
    @MethodSource("providePeriodicTestData")
    public void tgPeriodicTest(double angle1, double angle2) {
        assertEquals(calculator.tg(angle1), calculator.tg(angle2), EPSILON);
    }

    private static Stream<Arguments> provideTgUndefinedTestData() {
        return Stream.of(
                Arguments.of(Math.PI / 2),          // 90 degrees
                Arguments.of(3 * Math.PI / 2),      // 270 degrees
                Arguments.of(5 * Math.PI / 2),      // 450 degrees
                Arguments.of(7 * Math.PI / 2)       // 630 degrees
        );
    }

    @ParameterizedTest
    @MethodSource("provideTgUndefinedTestData")
    public void tgUndefinedTest(double angle) {
        assertThrows(ArithmeticException.class, () -> calculator.tg(angle));
    }

}
