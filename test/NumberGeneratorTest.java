import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {

    private final NumberGenerator generator = new NumberGenerator();

    @Test
    void testLength() {
        //Should generate array with given length
        // Arrange
        int expectedLength = 50;
        // Act
        BigNumber result = generator.generate(expectedLength);
        System.out.println("Running testLength:");
        System.out.println("  Requested length: " + expectedLength);
        System.out.println("  Generated length: " + result.getDigits().length);
        // Assert
        assertEquals(expectedLength, result.getDigits().length);
    }

    @RepeatedTest(10)
    void testFirstDigitNotZero() {
        //First digit cant be zero
        // Arrange
        int length = 5;
        // Act
        BigNumber result = generator.generate(length);
        int[] digits = result.getDigits();
        int mostSignificantDigit = digits[digits.length - 1];
        System.out.println("Running testFirstDigitNotZero:");
        System.out.println("  Generated number: " + result);
        System.out.println("  First digit: " + mostSignificantDigit);
        // Assert
        assertNotEquals(0, mostSignificantDigit, "First digit was 0");
    }

    @Test
    void testSingleDigit() {
        //Should properly generate single digit number
        // Arrange
        int length = 1;
        // Act
        BigNumber result = generator.generate(length);
        int generatedDigit = result.getDigits()[0];
        System.out.println("Running testSingleDigit:");
        System.out.println("  Generated single digit: " + generatedDigit);
        // Assert
        assertEquals(1, result.getDigits().length);
        assertTrue(generatedDigit >= 1 && generatedDigit <= 9);
    }

    @Test
    void testZeroLength() {
        // IllegalArgumentException expected when length is 0
        System.out.println("Running testZeroLength: Checking for IllegalArgumentException");
        // Arrange, Act, Assert
        assertThrows(IllegalArgumentException.class, () -> generator.generate(0), "IllegalArgumentException was thrown");
    }

    @Test
    void testNegativeLength() {
        // IllegalArgumentException also expected when length is 0
        System.out.println("Running testNegativeLength: Checking for IllegalArgumentException");
        // Arrange, Act, Assert
        assertThrows(IllegalArgumentException.class, () -> generator.generate(-5), "IllegalArgumentException was thrown");
    }
}