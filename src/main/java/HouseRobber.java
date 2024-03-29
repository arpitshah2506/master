public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,1,3,9,1,10}));
    }

    private static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        nums[2] = nums[0] + nums[2];

        for (int i = 3; i < nums.length; i++) {
            nums[i] = nums[i] + Math.max(nums[i - 2], nums[i - 3]);
        }

        return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
    }
}
