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

    public String getFirstTenDigits() {
        // If number is short return the standard string representation
        if (this.digits.length <= 10) {
            return this.toString();
        }

        StringBuilder sb = new StringBuilder();

        // Add sign if the number is negative
        if (this.isNegative) {
            sb.append("-");
        }

        // Displaying 10 first digits
        for (int i = digits.length - 1; i >= digits.length - 10; i--) {
            sb.append(digits[i]);
        }

        return sb.toString();
    }
}