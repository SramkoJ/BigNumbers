public class BigNumber {
    private final int[] digits;
    private final boolean isNegative;

    public BigNumber(int[] digits, boolean isNegative) {
        this.digits = digits;
        this.isNegative = isNegative;
    }

    public int[] getDigits() {
        return digits;
    }

    public boolean isNegative() {
        return isNegative;
    }

    @Override
    public String toString() {
        if (digits == null || digits.length == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if (isNegative) sb.append("-");
        for (int i = digits.length - 1; i >= 0; i--) {
            sb.append(digits[i]);
        }
        return sb.toString();
    }
}