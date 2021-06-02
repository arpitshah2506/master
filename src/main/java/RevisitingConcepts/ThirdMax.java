package RevisitingConcepts;

public class ThirdMax {
    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{2, 1, 3}));
    }

    private static int thirdMax(int[] nums) {
        int thirdCounter = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length && thirdCounter != 3; i++) {
            if (nums[i] < max) {
                max = nums[i];
                thirdCounter = thirdCounter + 1;
            }

            if (nums[i] > min) {
                min = nums[i];
            }
        }
        return thirdCounter != 3 ? min : max;
    }
}
