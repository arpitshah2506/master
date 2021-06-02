package RevisitingConcepts;

public class CanJump {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{10,9,8,7,6,5,4,3,2,1,1,0}));
//        System.out.println(canJumpOptimally(new int[]{4, 2, 0, 0, 1, 1, 4, 4, 4, 0, 4, 0}));
    }

    private static int canJump(int[] nums) {
        int count = 1;
        if (nums[0] >= nums.length) {
            count = 1;
        }
        if (nums.length == 1) {
            count = 0;
        }
        //4,2,0,0,1,1,4,4,4,0,4,0
        for (int i = 0; i < nums.length - 1; ) {
            if (i + nums[i] >= nums.length - 1) {
                break;
            }

            int end = nums[i] == 1 ? i + 1 : i + nums[i];
            int newPosition = findMax(nums, i + 1, end);
            count = count + 1;
            i = newPosition;
        }
        return count;
    }

    private static int findMax(int[] nums, int start, int end) {
        int max = Integer.MAX_VALUE;
        int postion = 0;

        for (int i = start; i <= end; i++) {
            if (max > nums.length - nums[i] - i) {
                max = nums.length - nums[i] - i;
                postion = i;
            }
        }
        return postion;
    }
}
