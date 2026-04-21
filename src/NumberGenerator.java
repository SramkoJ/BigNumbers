import java.util.Random;

public class NumberGenerator {
    private final Random random = new Random();

    public BigNumber generate(int length) {
        int[] digits = new int[length];
        digits[length - 1] = random.nextInt(9) + 1;
        for (int i = 0; i < length - 1; i++) {
            digits[i] = random.nextInt(10);
        }
        boolean isNegative = random.nextBoolean();
        return new BigNumber(digits, isNegative);
    }
}