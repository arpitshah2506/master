public class MaxSubArray {
    public static void main(String[] args)
    {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        if (nums.length == 0)
        {
            //return 0;
        }
        if (nums.length == 1)
        {
            //return nums[0];
        }
        System.out.println(maxSubArray(nums));
    }

    private static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int result = nums[0];

        for (int index = 1; index < nums.length; index++)
        {
            sum = Math.max(nums[index], sum + nums[index]);
            result = Math.max(result, sum);

            System.out.println(index + " " + sum + " " + result);
        }
        return result;
    }
}
