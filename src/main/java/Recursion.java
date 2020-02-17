public class Recursion {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        printNumbers(10);
    }

    public static int fibonacci(int number) {
        if (number == 1) {
            return 1;
        } else {
            return number * fibonacci(number - 1);
        }
    }

    public static void printNumbers(int number) {
        System.out.println(number);
        if ((number == 1) == false) {
            printNumbers(number-1);
        }
        System.out.println("Hello moto");
    }
}
