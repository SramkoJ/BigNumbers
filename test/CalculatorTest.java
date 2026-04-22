import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
     void testNullInput() {
        // Testing invalid or empty numbers
        System.out.println("Running testNullInput: Checking if IllegalArgumentException is thrown");
        // Arrange, Act, Assert
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateSum(null, new BigNumber(new int[]{1}, false)));
    }

    @Test
    void testSimpleAddition() {
        // Simple test for addition
        // Arrange
        BigNumber n1 = new BigNumber(new int[]{0, 1}, false);
        BigNumber n2 = new BigNumber(new int[]{0, 2}, false);
        //Act
        BigNumber result = calculator.calculateSum(n1, n2);
        System.out.println("Running testNegativeAddition: (" + n1 + ") + (" + n2 + ") = " + result);
        // Assert
        assertEquals("30", result.toString());
    }

    @Test
    void testCarryAddition() {
        // Simple test for carry handling
        // Arrange
        BigNumber n1 = new BigNumber(new int[]{9, 9}, false);
        BigNumber n2 = new BigNumber(new int[]{1}, false);
        // Act
        BigNumber result = calculator.calculateSum(n1, n2);
        System.out.println("Running testCarryAddition: (" + n1 + ") + (" + n2 + ") = " + result);
        // Assert
        assertEquals("100", result.toString());
    }

    @Test
    void testSameSignAddition() {
        // Testing simple addition of two positive numbers
        // Arrange
        BigNumber n1 = new BigNumber(new int[]{0, 1}, false);
        BigNumber n2 = new BigNumber(new int[]{0, 2}, false);
        // Act
        BigNumber result = calculator.calculateSum(n1, n2);
        System.out.println("Running testSameSignAddition: (" + n1 + ") + (" + n2 + ") = " + result);
        // Assert
        assertEquals("30", result.toString());
    }

    @Test
    void testNegativeAddition() {
        // Testing simple addition of two negative numbers
        // Arrange
        BigNumber n1 = new BigNumber(new int[]{0, 1}, true);
        BigNumber n2 = new BigNumber(new int[]{0, 2}, true);
        // Act
        BigNumber result = calculator.calculateSum(n1, n2);
        System.out.println("Running testNegativeAddition: (" + n1 + ") + (" + n2 + ") = " + result);
        // Assert
        assertEquals("-30", result.toString());
    }

    @Test
    void testDifferentSignsPositiveResult() {
        // Testing numbers with different signs, positive number expected
        // Arrange
        BigNumber n1 = new BigNumber(new int[]{0, 0, 1}, false);
        BigNumber n2 = new BigNumber(new int[]{1}, true);
        // Act
        BigNumber result = calculator.calculateSum(n1, n2);
        System.out.println("Running testDifferentSignsPositiveResult: " + n1 + " + (" + n2 + ") = " + result);
        // Assert
        assertEquals("99", result.toString());
    }

    @Test
    void testDifferentSignsNegativeResult() {
        // Testing numbers with different signs, negative number expected
        // Arrange
        BigNumber n1 = new BigNumber(new int[]{5}, false);
        BigNumber n2 = new BigNumber(new int[]{0, 1}, true);
        // Act
        BigNumber result = calculator.calculateSum(n1, n2);
        System.out.println("Running testDifferentSignsNegativeResult: " + n1 + " + (" + n2 + ") = " + result);
        // Assert
        assertEquals("-5", result.toString());
    }

    @Test
    void testZeroResult() {
        // Zero as result is expected, same numbers but different signs are used
        // Arrange
        BigNumber n1 = new BigNumber(new int[]{0, 5}, false);
        BigNumber n2 = new BigNumber(new int[]{0, 5}, true);
        // Act
        BigNumber result = calculator.calculateSum(n1, n2);
        System.out.println("Running testZeroResult: " + n1 + " + (" + n2 + ") = " + result);
        //Assert
        assertEquals("0", result.toString());
    }

    @Test
    void testSubtractionBorrow() {
        // Testing indirectly through calculateSum with different signs
        //Arrange
        BigNumber n1 = new BigNumber(new int[]{0, 0, 0, 1}, false);
        BigNumber n2 = new BigNumber(new int[]{1}, true);
        // Act
        BigNumber result = calculator.calculateSum(n1, n2);
        System.out.println("Running testSubstractionBorrow: " + n1 + " + (" + n2 + ") = " + result);

        //Assert
        assertEquals("999", result.toString());
    }
}