import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
     void testNullInput() {
        // Testing invalid or empty numbers
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateSum(null, new BigNumber(new int[]{1}, false)));
    }

    @Test
    void testSimpleAddition() {
        // Simple test for addition
        BigNumber n1 = new BigNumber(new int[]{0, 1}, false);
        BigNumber n2 = new BigNumber(new int[]{0, 2}, false);
        BigNumber result = calculator.calculateSum(n1, n2);
        assertEquals("30", result.toString());
    }

    @Test
    void testCarryAddition() {
        // Simple test for carry handling
        BigNumber n1 = new BigNumber(new int[]{9, 9}, false);
        BigNumber n2 = new BigNumber(new int[]{1}, false);
        BigNumber result = calculator.calculateSum(n1, n2);
        assertEquals("100", result.toString());
    }

    @Test
    void testSameSignAddition() {
        // Testing simple addition of two positive numbers
        BigNumber n1 = new BigNumber(new int[]{0, 1}, false);
        BigNumber n2 = new BigNumber(new int[]{0, 2}, false);
        BigNumber result = calculator.calculateSum(n1, n2);
        assertEquals("30", result.toString());
    }

    @Test
    void testNegativeAddition() {
        // Testing simple addition of two negative numbers
        BigNumber n1 = new BigNumber(new int[]{0, 1}, true);
        BigNumber n2 = new BigNumber(new int[]{0, 2}, true);
        BigNumber result = calculator.calculateSum(n1, n2);
        assertEquals("-30", result.toString());
    }

    @Test
    void testDifferentSignsPositiveResult() {
        // Testing numbers with different signs, positive number expected
        BigNumber n1 = new BigNumber(new int[]{0, 0, 1}, false);
        BigNumber n2 = new BigNumber(new int[]{1}, true);
        BigNumber result = calculator.calculateSum(n1, n2);
        assertEquals("99", result.toString());
    }

    @Test
    void testDifferentSignsNegativeResult() {
        // Testing numbers with different signs, negative number expected
        BigNumber n1 = new BigNumber(new int[]{5}, false);
        BigNumber n2 = new BigNumber(new int[]{0, 1}, true);
        BigNumber result = calculator.calculateSum(n1, n2);
        assertEquals("-5", result.toString());
    }

    @Test
    void testZeroResult() {
        // Zero as result is expected, same numbers but different signs are used
        BigNumber n1 = new BigNumber(new int[]{0, 5}, false);
        BigNumber n2 = new BigNumber(new int[]{0, 5}, true);
        BigNumber result = calculator.calculateSum(n1, n2);
        assertEquals("0", result.toString());
    }

    @Test
    void testSubtractionBorrow() {
        // Testing indirectly through calculateSum with different signs
        BigNumber n1 = new BigNumber(new int[]{0, 0, 0, 1}, false);
        BigNumber n2 = new BigNumber(new int[]{1}, true);
        BigNumber result = calculator.calculateSum(n1, n2);
        assertEquals("999", result.toString());
    }
}