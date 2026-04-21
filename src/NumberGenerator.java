import java.util.Random;

public class NumberGenerator {
    private final Random random = new Random();

    /**
     * Generates a BigNumber with a given number of digits.
     */
    public BigNumber generate(int length) {
        if (length < 1) throw new IllegalArgumentException("Length must be > 0");
        int[] digits = new int[length];
        // Second to last digit are 0-9
        for (int i = 0; i < length - 1; i++) {
            digits[i] = random.nextInt(10);
        }
        // First digit cant be zero
        digits[length - 1] = random.nextInt(9) + 1;
        // Generating if number is positive or negative
        boolean isNegative = random.nextBoolean();
        return new BigNumber(digits, isNegative);
    }
}