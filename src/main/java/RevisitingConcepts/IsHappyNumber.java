package RevisitingConcepts;

import java.util.HashSet;
import java.util.Set;

public class IsHappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    private static boolean isHappy(int n) {
        int modulo;
        int divisor = n;
        int divisorResult;
        Set<Integer> loopDetection = new HashSet<>();

        while (true) {
            divisorResult = 0;
            while (divisor != 0) {
                modulo = divisor % 10;
                divisor = divisor / 10;
                divisorResult = divisorResult + modulo * modulo;

                if (divisor < 10) {
                    divisorResult = divisorResult + divisor * divisor;
                    divisor = divisorResult;
                    break;
                }
            }

            if (divisorResult == 1) {
                return true;
            }

            if (loopDetection.add(divisorResult) == false) {
                return false;
            }
        }
    }
}
