package RevisitingConcepts;

public class NumSubarrayProductLessThanK {
    public static void main(String[] args) {
        numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100);
    }

    private static void numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int tempResult;
        for (int index = 0; index < nums.length-1; index++) {
            if (nums[index] < k) {
                count++;
            }
            tempResult = nums[index];
            for (int i = index+1; i < nums.length; i++) {
                tempResult = tempResult * nums[i];
                if (tempResult >= k)
                {
                    break;
                }
                count++;
            }
        }

        if (nums[nums.length-1] < k)
        {
            count++;
        }
        System.out.println(count);
    }
}
