package RevisitingConcepts;

public class SubArraySum {
    public static void main(String[] args) {
        subarraySum(new int[]{1,1,1},2);
    }

    private static void subarraySum(int[] nums, int k) {
        int sum = nums[0];
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = nums[i] - sum;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if(sum==k) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
