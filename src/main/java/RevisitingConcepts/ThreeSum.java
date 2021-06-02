package RevisitingConcepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }

    private static void threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int lo;
        int hi;
        int target = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            lo = i + 1;
            hi = nums.length - 1;
            target =- nums[i];
            while (lo < hi) {
                if (nums[lo] + nums[hi] == target) {
                    List<Integer> iterativeResult = new ArrayList<>();
                    iterativeResult.add(nums[i]);
                    iterativeResult.add(nums[lo]);
                    iterativeResult.add(nums[hi]);

                    result.add(iterativeResult);
                    lo++;
                    hi--;
                    while(lo < hi && nums[lo] == nums[lo-1]) lo++;
                    while(lo < hi && nums[hi] == nums[hi+1]) hi--;
                } else if (nums[lo] + nums[hi] > target) {
                    hi--;
                } else {
                    lo++;
                }
            }
        }
        System.out.println(result);
    }
}
