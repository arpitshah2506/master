package RevisitingConcepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        fourSum(new int[]{1,0,-1,0,-2,2});
    }

    private static void fourSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int target = 0;
        int initTarget = target;
        int hi,lo;
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i+1; j < nums.length - 2; j++) {
                if(j!=i+1 && nums[j]==nums[j-1]) {
                    continue;
                }
                lo = j +1;
                hi = nums.length - 1;
                target = target - (nums[i] + nums[j]);
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == target) {
                        List<Integer> tempResult = new ArrayList<>();
                        tempResult.add(nums[i]);
                        tempResult.add(nums[j]);
                        tempResult.add(nums[lo]);
                        tempResult.add(nums[hi]);

                        result.add(tempResult);
                        lo++;
                        hi--;

                        while (lo < hi && nums[lo] == nums[lo - 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi + 1]) hi--;
                    } else if (nums[lo] + nums[hi] > target) {
                        hi--;
                    } else {
                        lo++;
                    }
                }
                target = initTarget;
            }
        }
        System.out.println(result);
    }
}
