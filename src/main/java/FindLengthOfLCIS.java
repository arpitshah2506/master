public class FindLengthOfLCIS {
    public static void main(String[] args) {
        int[] nums = {1,3,5,7};

        System.out.println(findLengthOfLCIS(nums));
    }

    private static int findLengthOfLCIS(int[] nums) {
        if (nums == null  || nums.length == 0) {
            return 0;
        }

        int finalResult = 1;
        int maxContiguous = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                maxContiguous = maxContiguous + 1;
            } else {
                maxContiguous = 1;
            }
            finalResult = Math.max(finalResult, maxContiguous);
        }
        return finalResult;
    }
}
