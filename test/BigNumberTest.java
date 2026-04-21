import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BigNumberTest {

    @Test
    void testFirstTenDigitsLong() {
        // Simple test for displaying 10 first digits
        int[] digits = {5, 4, 3, 2, 1, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        BigNumber n = new BigNumber(digits, false);
        assertEquals("1234567890", n.getFirstTenDigits());
    }

    @Test
    void testFirstTenDigitsNegativeLong() {
        // Testing handling negative numbers
        int[] digits = new int[20];
        for(int i = 0; i < 20; i++) digits[i] = 9;
        digits[19] = 1; digits[18] = 2; digits[17] = 3;
        BigNumber n = new BigNumber(digits, true);
        assertTrue(n.getFirstTenDigits().startsWith("-123"));
    }

    @Test
    void testFirstTenDigitsShort() {
        // Testing number shorter than 10
        int[] digits = {3, 2, 1};
        BigNumber n = new BigNumber(digits, false);
        assertEquals("123", n.getFirstTenDigits());
    }
}