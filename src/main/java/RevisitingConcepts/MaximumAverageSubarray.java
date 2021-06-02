package RevisitingConcepts;

public class MaximumAverageSubarray {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 100}, 4));
    }

    private static double findMaxAverage(int[] nums, int k) {
        double maxSoFar;
        double sum = 0.0;

        for (int index = 0; index < k; index++) {
            sum += nums[index];
        }

        if (nums.length < k) {
            return sum / k;
        }

        maxSoFar = sum;

        for (int index = 1; index < nums.length - (k - 1); index++) {
            sum = sum - nums[index - 1] + nums[index + (k - 1)];
            maxSoFar = Math.max(sum, maxSoFar);
        }
        return maxSoFar / k;
    }
}
