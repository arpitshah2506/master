public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
        System.out.println(leetcodeIndex(nums));
    }

    private static int leetcodeIndex(int[] nums) {
        int s = 0;
        for (int i = 0; i < nums.length; i++){
            s += nums[i];
        }
        int A = 0;
        for (int i = 0; i < nums.length; i++){
            int x = nums[i];
            if (2*A + x == s){
                return i;
            }
            A += x;
        }
        return -1;
    }

    private static int pivotIndex(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return -1;
        }

        int leftLoopSum = 0;
        int rightLoopSum = 0;

        for (int i = 0; i < nums.length; i++) {
            rightLoopSum = rightLoopSum + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                leftLoopSum = leftLoopSum + nums[i-1];
            }

            rightLoopSum = rightLoopSum - nums[i];
            if (leftLoopSum == rightLoopSum) {
                return i;
            }
        }
        return -1;
    }
}
