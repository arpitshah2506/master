package RevisitingConcepts;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        threeSumClosest(new int[]{1,1,1,0}, 100);
    }

    private static void threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int newTarget;
        int lo;
        int hi;
        int min = Integer.MAX_VALUE;
        int tempI = 0, tempJ = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            newTarget = target - nums[i];
            lo = i + 1;
            tempI = i + 1;
            hi = nums.length - 1;
            tempJ = nums.length - 1;
            while (lo< hi)
            {
                if (newTarget > (nums[hi] - nums[lo]))
                {
                    if (lo < hi - 1)
                    {
                        ++tempI;
                    }
                    ++lo;
                }
                else
                {
                    if (lo < hi - 1)
                    {
                        --tempJ;
                    }
                    --hi;
                }
            }


            min = Math.min(min, target - (target - (nums[tempI] + nums[tempJ] + nums[i])));

        }

        System.out.println(min);
    }
}
