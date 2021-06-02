package RevisitingConcepts;

import java.util.Arrays;

public class MaximumProduct {
    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{-4, -3, -2, -1, 60}));
    }

    private static int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        return Math.max(nums[nums.length - 1] * nums[0] * nums[1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
}
