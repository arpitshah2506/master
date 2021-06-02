package RevisitingConcepts;

public class MoveZeroesAndOnes {
    public static void main(String[] args) {
        int[] nums = {1,0,0,2,2,1,1,0,0};
        moveZeroesAndOnes(nums);
    }

    private static void moveZeroesAndOnes(int[] nums) {
        int hi = nums.length-1;
        int lo = 0;
        int mid = 0;

        while (mid <= hi) {
        if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[lo];
                nums[lo] = temp;
                lo++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[hi];
                nums[hi] = temp;
                hi--;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
