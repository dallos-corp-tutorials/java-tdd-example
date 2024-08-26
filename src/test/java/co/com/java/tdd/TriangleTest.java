package co.com.java.tdd;

import co.com.java.tdd.exceptions.TriangleMalformedException;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {


    @ParameterizedTest
    @CsvSource({"2,2,2",
            "3,3,3"})
    void shouldBeEquilateral(int a, int b, int c) {
        //Given
        Triangle triangle = new Triangle(a, b, c);

        //When
        Triangle.TriangleType type = triangle.getType();

        //Then
        assertEquals(Triangle.TriangleType.EQUILATERAL, type);
    }

    @ParameterizedTest
    @CsvSource({"2,2,3",
            "6,6,8"})
    void shouldBeIsosceles(int a, int b, int c) {
        //Given
        Triangle triangle = new Triangle(a, b, c);

        //When
        Triangle.TriangleType type = triangle.getType();

        //Then
        assertEquals(Triangle.TriangleType.ISOSCELES, type);
    }

    @ParameterizedTest
    @CsvSource({"2,3,4",
            "8,6,10"})
    void shouldBeScalene(int a, int b, int c) {
        //Given
        Triangle triangle = new Triangle(a, b, c);

        //When
        Triangle.TriangleType type = triangle.getType();

        //Then
        assertEquals(Triangle.TriangleType.SCALENE, type);
    }

    @ParameterizedTest
    @CsvSource({"1,2,3",
    "2,2,5",
    "-2,2,2"})
    void shouldBeTriangleMalformedException(int a, int b, int c) {
        //When
        Executable executable = () -> new Triangle(a, b, c);

        //Then
        assertThrows(TriangleMalformedException.class, executable);
    }

}
