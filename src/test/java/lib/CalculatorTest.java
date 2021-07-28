package lib;

import org.junit.jupiter.api.Test;

import static lib.Utils.arrToString;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void passTest1() {
        shouldPass(
                new Integer[]{1, 2, 3},
                new Integer[]{2, 3, 4}
        );
    }

    @Test
    public void passTest2() {
        shouldPass(
                new Integer[]{0, 9, 0},
                new Integer[]{2, 0, 1}
        );
    }

    @Test
    public void passTest4() {
        shouldPass(
                new Integer[]{9, 0, 0},
                new Integer[]{1, 0, 1, 1}
        );
    }

    @Test
    public void passTest5() {
        shouldPass(
                new Integer[]{9, 9, 9},
                new Integer[]{1, 1, 1, 0}
        );
    }

    @Test
    public void passTest6() {
        shouldPass(
                new Integer[]{9, 9, 9, 9, 9},
                new Integer[]{1, 1, 1, 1, 1, 0}
        );
    }

    @Test
    public void passTest7() {
        shouldPass(
                new Integer[]{9, 9, 9, 9, 9},
                new Integer[]{1, 1, 1, 1, 1, 0}
        );
    }

    @Test
    public void failOnNullInput() {
        shouldThrow(null, "Input should not be null");
    }

    @Test
    public void failOnEmptyInput() {
        shouldThrow(new Integer[]{}, "Input should not be empty");
    }

    @Test
    public void failOnNullElement() {
        shouldThrow(new Integer[]{1, null, 2}, "FOUND: null");
    }

    @Test
    public void failOnElementOutOfRange() {
        shouldThrow(new Integer[]{0, 1, 10}, "FOUND: 10");
        shouldThrow(new Integer[]{1, -1, 5}, "FOUND: -1");
    }


    private void shouldPass(Integer[] input, Integer[] expected) {
        Integer[] actual = Calculator.addOneToEach(input);

        assertEquals(actual.length, expected.length, "Length should be equal");
        assertEquals(arrToString(expected), arrToString(actual), "FAIL for input: " + arrToString(input) + "\n");
    }

    private void shouldThrow(Integer[] input, String containMessage) {
        CalculatorException ex = assertThrows(CalculatorException.class,
                () -> Calculator.addOneToEach(input)
        );

        assertTrue(ex.getMessage().contains(containMessage), "Exception message should contain: " + containMessage + "\nACTUAL is: " + ex.getMessage() + "\n\n");
    }
}