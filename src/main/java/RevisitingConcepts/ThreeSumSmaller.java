package RevisitingConcepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumSmaller {
    public static void main(String[] args) {
        threeSumSmaller(new int[]{5, 1, 3, 4, 7}, 12);
    }

    private static void threeSumSmaller(int[] nums, int sum) {
        Arrays.sort(nums);

        int hi;

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                hi = nums.length - 1;
                while (j < hi) {
                    if (nums[j] + nums[hi] + nums[i] < sum) {
                        List<Integer> iterativeResult = new ArrayList<>();
                        iterativeResult.add(nums[i]);
                        iterativeResult.add(nums[j]);
                        iterativeResult.add(nums[hi]);

                        result.add(iterativeResult);
                        hi--;

                        if (nums[hi] == nums[hi + 1]) hi--;
                    } else {
                        hi--;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
