package RevisitingConcepts;

public class KadanesAlgo {
    public static void main(String[] args) {
        maxSubArray(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(nthFibonacciNumber(4));
        System.out.println(rotateString("arpait", "rpaita"));
    }

    private static boolean rotateString(String A, String B) {
        String temp = A;

        for (int index = 0; index <= A.length(); index++) {
            temp = temp.substring(0, A.length() - index); //5-1-1=3, 5-2-1=2, 5-3-1=1, 5-4-1=0
            if (B.indexOf(temp) != -1) {
                if (A.equals(B.substring(B.indexOf(temp)) + B.substring(0, B.indexOf(temp)))) {
                    return true;
                }
                return false;
            }
        }

        return false;
    }

    private static int nthFibonacciNumber(int n) {
        if (n == 1 || n == 2) return 1;

        int secondPrevious = 1;
        int previous = 1;
        int result = 0;

        for (int i = 3; i <= n; i++) {
            result = previous + secondPrevious;
            secondPrevious = previous;
            previous = result;
        }
        return result;
    }

    private static void maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxFinal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSoFar = Math.max(nums[i], nums[i] + maxSoFar);
            maxFinal = Math.max(maxFinal, maxSoFar);
        }

        System.out.println(maxFinal);
    }
}
