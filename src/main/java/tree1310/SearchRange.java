package tree1310;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {3,5,8,10};
        int x = 15;
        int k = 2;
        int index = searchRange(nums, x);
        System.out.println(getRange(nums, x, index, k));
    }

    private static List<Integer> getRange(int[] nums, int x, int index, int k) {
        int count = 0;

        List<Integer> result = new ArrayList<>();
        if (index == 0) {
            for (int i = 0; i < k; i++) {
                result.add(nums[i]);
            }
            return result;
        }

        if (index == nums.length) {
            for (int i = nums.length -k; i < nums.length ; i++) {
                result.add(nums[i]);
            }
            return result;
        }

        int rightPointer = index;
        int leftPointer = index - 1;

        Stack<Integer> leftList = new Stack<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        while (count < k) {
            if (Math.abs(nums[leftPointer] - x) <= Math.abs(nums[rightPointer] - x)) {
                leftList.add(nums[leftPointer]);
                count++;
                if (leftPointer == 0) nums[0] = Integer.MAX_VALUE;
                else leftPointer = leftPointer - 1;
            } else {
                rightList.add(nums[rightPointer]);
                count++;
                if (rightPointer == nums.length - 1) nums[rightPointer] = Integer.MAX_VALUE;
                else rightPointer = rightPointer + 1;
            }
        }

        while (leftList.isEmpty() == false) {
            result.add(leftList.pop());
        }

        result.addAll(rightList);

        return result;
    }

    private static int searchRange(int[] nums, int x) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == x) return mid;
            else if (x > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }

        return left;
    }
}
;