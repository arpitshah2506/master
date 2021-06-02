import java.util.Stack;

public class NondecreasingArray {
    public static void main(String[] args) {
        int[] nums = {3,4,2,3};
        //System.out.println(checkPossibility(nums));
        System.out.println(checkPossibilityUsingStack(nums));
    }

    private static boolean checkPossibilityUsingStack(int[] nums) {
        Stack<Integer> arrangeData = new Stack<>();

        if (nums.length <= 1) {
            return true;
        }

        int count = 0;
        for (int i = 2; i < nums.length; i++) {
            if (arrangeData.size() > 0 && arrangeData.pop() > nums[i]) {
                count = count + 1;
            }

            //if (nums[i])
            arrangeData.push(nums[i]);

            if (count == 2) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkPossibility(int[] nums) {
        // check for element
        if (nums.length <= 1) {
            return true;
        }

        int count = 0;

        int maxSoFar = nums[0];

        if (nums[1] < maxSoFar) {
            count = count + 1;
        }
        maxSoFar = nums[1];

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] < maxSoFar) { // nums[i-1] needs to be changed with maxSoFar
                count = count + 1;
                if (nums[i] < nums[i-2]) {
                    nums[i] = maxSoFar;
                } else {
                    nums[i - 1] = nums[i];
                    maxSoFar = nums[i];
                }
            } else {
                maxSoFar = nums[i];
            }

            if (count == 2) {
                return false;
            }
        }
        return true;
    }

}
