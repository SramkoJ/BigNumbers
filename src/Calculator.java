public class Calculator {

    public BigNumber calculateSum(BigNumber a, BigNumber b) {
        // Finding the lengths of numbers
        int[] digitsA = a.getDigits();
        int[] digitsB = b.getDigits();

        // Finding which number has more digits
        int maxLength = Math.max(digitsA.length, digitsB.length);
        // Based on this we create new array
        int[] result = new int[maxLength + 1];
        // Stores the carry value for the next digit
        int carry = 0;

        for (int i = 0; i < maxLength || carry > 0; i++) {
            // Get digits from both numbers, or use 0 if we reached the end of a shorter number
            int valA = (i < digitsA.length) ? digitsA[i] : 0;
            int valB = (i < digitsB.length) ? digitsB[i] : 0;

            // Counting them together
            int sum = valA + valB + carry;

            // Checking if overflow occured
            if (sum > 9) {
                // Keeping the last digit
                result[i] = sum - 10;
                carry = 1;
            } else {
                result[i] = sum;
                carry = 0;
            }
        }

        return new BigNumber(trimZeros(result), false);
    }

    private int[] trimZeros(int[] digits) {
        int i = digits.length - 1;
        // Starting from first digit and checking for unnecessary zeros
        while (i > 0 && digits[i] == 0) i--;

        // Making new array for trimmer number
        int[] trimmed = new int[i + 1];
        System.arraycopy(digits, 0, trimmed, 0, i + 1);
        return trimmed;
    }
}