import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

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
}