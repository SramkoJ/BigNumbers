public class Main {
    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();
        Calculator calculator = new Calculator();
        BigNumber[] numbers = new BigNumber[50];
        for (int i = 0; i < 50; i++) {
            numbers[i] = generator.generate(i + 1);
            System.out.println("Number " + (i + 1) + ": " +  numbers[i]);
        }
    }
}