package com.epam.training.student_maksym_hladii.task1.unary_operations.trigonometric;

import com.epam.training.student_maksym_hladii.task1.AbstractTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CosTest extends AbstractTest {

    private static Stream<Arguments> provide0to180TestData() {
        return Stream.of(
                Arguments.of(0, 1, EPSILON),                                // 0 degrees
                Arguments.of(Math.PI / 6, 0.86603, EPSILON),                // 30 degrees
                Arguments.of(Math.PI / 4, 0.70711, EPSILON),                // 45 degrees
                Arguments.of(Math.PI / 3, 0.5, EPSILON),                    // 60 degrees
                Arguments.of(Math.PI / 2, 0, EPSILON),                      // 90 degrees
                Arguments.of(2 * Math.PI / 3, -0.5, EPSILON),               // 120 degrees
                Arguments.of(3 * Math.PI / 4, -0.70711, EPSILON),           // 135 degrees
                Arguments.of(5 * Math.PI / 6, -0.86603, EPSILON)            // 150 degrees
        );
    }

    @ParameterizedTest
    @MethodSource("provide0to180TestData")
    public void cos0to180Test(double angle, double expectedResult) {
        assertEquals(expectedResult, calculator.cos(angle), EPSILON);
    }

    private static Stream<Arguments> provide180to360TestData() {
        return Stream.of(
                Arguments.of(0, Math.PI, EPSILON),                              // cos(180) = -cos(0)
                Arguments.of(Math.PI / 6, 7 * Math.PI / 6, EPSILON),            // cos(210) = -cos(30)
                Arguments.of(Math.PI / 4, 5 * Math.PI / 4, EPSILON),            // cos(225) = -cos(45)
                Arguments.of(Math.PI / 3, 4 * Math.PI / 3, EPSILON),            // cos(240) = -cos(60)
                Arguments.of(Math.PI / 2, 3 * Math.PI / 2, EPSILON),            // cos(270) =  cos(90)
                Arguments.of(2 * Math.PI / 3, 5 * Math.PI / 3, EPSILON),        // cos(300) = -cos(120)
                Arguments.of(3 * Math.PI / 4, 7 * Math.PI / 4, EPSILON),        // cos(315) = -cos(135)
                Arguments.of(5 * Math.PI / 6, 11 * Math.PI / 6, EPSILON)        // cos(330) = -cos(150)
        );
    }

    @ParameterizedTest
    @MethodSource("provide180to360TestData")
    public void cos180to360Test(double angle1, double angle2) {
        assertEquals(-calculator.cos(angle1), calculator.cos(angle2), EPSILON);
    }

    private static Stream<Arguments> providePeriodicTestData() {
        return Stream.of(
                Arguments.of(0, 2 * Math.PI, EPSILON),                          // cos(360) = cos(0)
                Arguments.of(Math.PI / 4, 9 * Math.PI / 4, EPSILON),            // cos(405) = cos(45)
                Arguments.of(Math.PI / 2, 5 * Math.PI / 2, EPSILON),            // cos(450) = cos(90)
                Arguments.of(3 * Math.PI / 4, 11 * Math.PI / 4, EPSILON),       // cos(495) = cos(135)
                Arguments.of(Math.PI, 3 * Math.PI, EPSILON),                    // cos(540) = cos(180)
                Arguments.of(5 * Math.PI / 4, 13 * Math.PI / 4, EPSILON),       // cos(585) = cos(225)
                Arguments.of(3 * Math.PI / 2, 7 * Math.PI / 2, EPSILON),        // cos(630) = cos(270)
                Arguments.of(2 * Math.PI, 4 * Math.PI, EPSILON)                 // cos(675) = cos(315)
        );
    }

    @ParameterizedTest
    @MethodSource("providePeriodicTestData")
    public void cosPeriodicTest(double angle1, double angle2) {
        assertEquals(calculator.cos(angle1), calculator.cos(angle2), EPSILON);
    }

}
