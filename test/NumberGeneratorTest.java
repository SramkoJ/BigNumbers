import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {

    private final NumberGenerator generator = new NumberGenerator();

    @Test
    void testLength() {
        //Should generate array with given length
        int expectedLength = 50;
        BigNumber result = generator.generate(expectedLength);
        assertEquals(expectedLength, result.getDigits().length);
    }

    @RepeatedTest(10)
    void testFirstDigitNotZero() {
        //First digit cant be zero
        BigNumber result = generator.generate(5);
        int[] digits = result.getDigits();
        int mostSignificantDigit = digits[digits.length - 1];

        assertNotEquals(0, mostSignificantDigit, "First digit was 0");
    }

    @Test
    void testSingleDigit() {
        //Should properly generate single digit number
        BigNumber result = generator.generate(1);
        assertEquals(1, result.getDigits().length);
        assertTrue(result.getDigits()[0] >= 1 && result.getDigits()[0] <= 9);
    }

    @Test
    void testZeroLength() {
        // IllegalArgumentException expected when length is 0
        assertThrows(IllegalArgumentException.class, () -> generator.generate(0), "IllegalArgumentException was thrown");
    }

    @Test
    void testNegativeLength() {
        // IllegalArgumentException also expected when length is 0
        assertThrows(IllegalArgumentException.class, () -> generator.generate(-5), "IllegalArgumentException was thrown");
    }
}