public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,1};
        //moveZeroes(nums);
        moveZeroesOptimal(nums);
    }

    private static void moveZeroesOptimal(int[] nums) {
        int leftMostZeroIndex = 0; // The index of the leftmost zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > leftMostZeroIndex) { // There are zero(s) on the left side of the current non-zero number, swap!
                    nums[leftMostZeroIndex] = nums[i];
                    nums[i] = 0;
                }

                leftMostZeroIndex++;
            }
        }
    }

    private static void moveZeroes(int[] nums) {
        int lastZeroIndex = Integer.MIN_VALUE;
        int currentZeroIndex;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                lastZeroIndex = i;
                break;
            }
        }

        if (lastZeroIndex != Integer.MIN_VALUE)
        {
            int count = -1;
            currentZeroIndex = lastZeroIndex;
            for (int i = currentZeroIndex; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[lastZeroIndex] = nums[i];
                    nums[i] = 0;
                    lastZeroIndex = i - count;
                } else {
                    count = count + 1;
                }
            }
        }
    }
}
