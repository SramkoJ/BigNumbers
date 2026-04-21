public class Calculator {

    public BigNumber calculateSum(BigNumber a, BigNumber b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Input numbers cannot be null");
        }
        // Check if both numbers are either positive or negative - addition
        if (a.isNegative() == b.isNegative()) {
            int[] resultDigits = addAbs(a.getDigits(), b.getDigits());
            return new BigNumber(resultDigits, a.isNegative());
        }

        // If they are not - substraction
        int cmp = compareAbs(a.getDigits(), b.getDigits());

        // Numbers are same
        if (cmp == 0) {
            return new BigNumber(new int[]{0}, false);
        }

        // First number is bigger
        if (cmp > 0) {
            int[] resultDigits = subtractAbs(a.getDigits(), b.getDigits());
            return new BigNumber(resultDigits, a.isNegative());
        } else {
            // Second number is bigger
            int[] resultDigits = subtractAbs(b.getDigits(), a.getDigits());
            return new BigNumber(resultDigits, b.isNegative());
        }
    }

    private int[] addAbs(int[] digitsA, int[] digitsB) {
        // Finding which number has more digits
        int maxLength = Math.max(digitsA.length, digitsB.length);
        // Based on this we create new array
        int[] result = new int[maxLength + 1];
        // Stores the carry value for the next digit
        int carry = 0;

        for (int i = 0; i < maxLength || carry > 0; i++) {
            // Get digits from both numbers or use 0 if we reached the end of a shorter number
            int valA = (i < digitsA.length) ? digitsA[i] : 0;
            int valB = (i < digitsB.length) ? digitsB[i] : 0;

            // Counting them together
            int sum = valA + valB + carry;

            // Checking if carry occurred
            if (sum > 9) {
                // Keeping the last digit
                result[i] = sum - 10;
                carry = 1;
            } else {
                result[i] = sum;
                carry = 0;
            }
        }
        return trimZeros(result);
    }

    private int[] subtractAbs(int[] a, int[] b) {
        int[] result = new int[a.length];
        int borrow = 0;

        for (int i = 0; i < a.length; i++) {
            int valA = a[i];
            int valB = (i < b.length) ? b[i] : 0;

            // Apply previous debt
            int sub = valA - valB - borrow;

            if (sub < 0) {
                // If result is negative we "borrow" 10 from the next rank
                sub = sub + 10;
                borrow = 1;
            } else {
                // No borrowing needed
                borrow = 0;
            }

            result[i] = sub;
        }

        return trimZeros(result);
    }

    private int compareAbs(int[] a, int[] b) {
        // Comparing lengths of numbers
        if (a.length != b.length) {
            return a.length - b.length;
        }
        // If numbers are same length we decide based on digits
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] != b[i]) {
                return a[i] - b[i];
            }
        }
        // If numbers are same
        return 0;
    }

    private int[] trimZeros(int[] digits) {
        int i = digits.length - 1;
        // Starting from first digit and checking for unnecessary zeros
        while (i > 0 && digits[i] == 0) i--;

        // Making new array for trimmed number
        int[] trimmed = new int[i + 1];
        System.arraycopy(digits, 0, trimmed, 0, i + 1);
        return trimmed;
    }
}