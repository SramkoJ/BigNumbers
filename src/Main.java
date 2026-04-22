public class Main {
    static void main(String[]   args) {
        NumberGenerator generator = new NumberGenerator();
        Calculator calculator = new Calculator();
        BigNumber[] numbers = new BigNumber[50];

        // Generating numbers with increasing digits count
        for (int i = 0; i < 50; i++) {
          numbers[i] = generator.generate(i + 1);
          //System.out.println("Generated Number " + (i + 1) + ": " + numbers[i]);
         }

        // Array for the new number
        BigNumber totalSum = new BigNumber(new int[]{0}, false);

        // Gradually add each number from the array to the total sum
        for (BigNumber number : numbers) {
            totalSum = calculator.calculateSum(totalSum, number);
        }

        // Final number
        //System.out.println(totalSum.toString());
        System.out.println(totalSum.getFirstTenDigits());
    }
}