import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BigNumberTest {

    @Test
    void testFirstTenDigitsLong() {
        // Simple test for displaying 10 first digits
        // Arrange
        int[] digits = {5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        BigNumber n = new BigNumber(digits, false);
        // Act
        String result = n.getFirstTenDigits();
        System.out.println("Running testFirstTenDigitsLong:");
        System.out.println("  Full number: " + n);
        System.out.println("  First 10:    " + result);
        // Assert
        assertEquals("1234567890", result);
    }

    @Test
    void testFirstTenDigitsNegativeLong() {
        // Testing handling negative numbers
        // Arrange
        int[] digits = new int[20];
        for(int i = 0; i < 20; i++) digits[i] = 9;
        digits[19] = 1; digits[18] = 2; digits[17] = 3;
        BigNumber n = new BigNumber(digits, true);
        // Act
        String result = n.getFirstTenDigits();
        System.out.println("Running testFirstTenDigitsNegativeLong:");
        System.out.println("  Full negative: " + n);
        System.out.println("  First 10:      " + result);
        // Assert
        assertTrue(result.startsWith("-123"));
    }

    @Test
    void testFirstTenDigitsShort() {
        // Testing number shorter than 10
        // Arrange
        int[] digits = {3, 2, 1};
        BigNumber n = new BigNumber(digits, false);
        // Act
        String result = n.getFirstTenDigits();
        System.out.println("Running testFirstTenDigitsShort:");
        System.out.println("  Short number: " + n);
        System.out.println("  Result:       " + result);
        // Assert
        assertEquals("123", result);
    }
}