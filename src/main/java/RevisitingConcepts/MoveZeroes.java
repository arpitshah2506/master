package RevisitingConcepts;

public class MoveZeroes {
    public static void main(String[] args) {
        moveZeroes(new int[]{0, 0, 1, 2, 3, 4});
    }

    private static void moveZeroes(int[] nums) {
        int fastPointer = 0;
        int slowPointer = 0;

        while (fastPointer < nums.length) {
            if (nums[slowPointer] == 0) {
                //skipping positions
                while (fastPointer < nums.length-1 && nums[fastPointer] == 0) {
                    fastPointer++;
                }
                if (fastPointer < nums.length) {
                    nums[slowPointer] = nums[fastPointer];
                    nums[fastPointer] = 0;
                }
            }
            slowPointer++;
            fastPointer++;
        }


        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
