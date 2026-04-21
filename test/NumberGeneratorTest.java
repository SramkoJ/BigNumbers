import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {

    private final NumberGenerator generator = new NumberGenerator();

    @Test
    @DisplayName("Should generate array with given length")
    void testLength() {
        int expectedLength = 50;
        BigNumber result = generator.generate(expectedLength);
        assertEquals(expectedLength, result.getDigits().length);
    }

    @RepeatedTest(10)
    @DisplayName("First digit cant be zero")
    void testFirstDigitNotZero() {
        BigNumber result = generator.generate(5);
        int[] digits = result.getDigits();
        int mostSignificantDigit = digits[digits.length - 1];

        assertNotEquals(0, mostSignificantDigit, "First digit was 0");
    }

    @Test
    @DisplayName("Should properly generate single digit number")
    void testSingleDigit() {
        BigNumber result = generator.generate(1);
        assertEquals(1, result.getDigits().length);
        assertTrue(result.getDigits()[0] >= 1 && result.getDigits()[0] <= 9);
    }
}