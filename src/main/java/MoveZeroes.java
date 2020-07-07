import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {1,0,3,0,12};
        moveZeroes(nums);
    }

    private static void moveZeroes(int[] nums) {
        int count = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == 0) {
                count = count + 1;

            }
        }
    }
}
