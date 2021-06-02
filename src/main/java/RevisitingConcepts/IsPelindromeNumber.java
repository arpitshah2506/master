package RevisitingConcepts;

public class IsPelindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindromeNumber(1234));
    }

    private static boolean isPalindromeNumber(int x) {
        if (x < 0) return false;

        int copyVal = x;
        int divisor = Integer.MIN_VALUE;
        int result = 0;

        while (divisor != 0) {
            x = x / 10;
            result = result * 10 + (x % 10);
        }

        System.out.println(result);

        return result == copyVal;
    }
}
