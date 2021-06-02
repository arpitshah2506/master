import java.util.Arrays;

public class FindUnsortedSubArray {
    public static void main(String[] args) {
        int nums[] = {2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(nums));
        System.out.println(findExactSoution(nums));
    }

    private static int findUnsortedSubarray(int[] nums) {
        int[] copyArray = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copyArray);
        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;
        // todo can be improved to check from starting first element and ending first element rather than traversing the whole loop
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != copyArray[i]) {
                if (start == Integer.MIN_VALUE) {
                    start = i;
                } else {
                    end = i;
                }
            }
        }

        if (start == Integer.MIN_VALUE) {
            return 0;
        } else {
            return (end - start) + 1;
        }
    }

    private static int findExactSoution(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}
