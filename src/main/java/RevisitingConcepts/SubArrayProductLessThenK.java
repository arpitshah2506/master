package RevisitingConcepts;

public class SubArrayProductLessThenK {
    public static void main(String[] args) {
        numSubarrayProductLessThanK(new int[]{1, 1, 1, 6, 1, 1, 1, 7, 1, 1, 1, 1}, 5);
    }

    private static void numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        int j = 0;
        int multiplication = 1;
        for (int i = 0; j < nums.length; ) {
            multiplication = nums[j] * multiplication;
            if (multiplication < k) {
                result = result + (j - i) + 1;
                j++;
            } else {
                if (i < j)
                {
                    multiplication = (multiplication / nums[i]) / nums[j];
                    i++;
                }
                else
                {
                    j++;
                }
            }
        }

        System.out.println(result);
    }
}
