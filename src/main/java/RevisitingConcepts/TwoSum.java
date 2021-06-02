package RevisitingConcepts;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{2, 5, 5, 11}, 10)[0] + " " + twoSum(new int[]{2, 5, 5, 11}, 10)[1]);
    }

    public static int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer, Integer> indexWiseNumbers = new HashMap<>();

        int i;

        for (i = 0; i < nums.length; i++)
        {
            Integer numResult = indexWiseNumbers.get(target - nums[i]);

            if (numResult != null)
            {
                break;
            }
            indexWiseNumbers.put(nums[i], i);
        }

        return new int[]{indexWiseNumbers.get(target-nums[i]),i};
    }
}
