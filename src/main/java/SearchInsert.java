public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1,2,4,6,8,9,10};
        int target = 10;
        System.out.println(searchInsert(nums, 0, nums.length - 1, target));
        System.out.println(isMonotonic());
    }

    private static int searchInsert(int[] nums, int start, int end, int target) {
        if ((end-start) < 2) {
            if (target <= nums[start]) {
                return start;
            } else if (target <= nums[end]){
                return end;
            } else {
                return end + 1;
            }
        }
        else
        {
            int middle = (start + end) /2;
            if (nums[middle] == target) {
                return middle;
            }
            else if (target < nums[middle]) {
                return searchInsert(nums, 0, middle, target);
            } else {
                return searchInsert(nums, middle + 1, end, target);
            }
        }
    }

    private static boolean isMonotonic() {
        int[] arr = {1,2,3,4,5,6,7,8};

        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i+1]) {
                isDecreasing = false;
            }
            if (arr[i] > arr[i+1]) {
                isIncreasing = false;
            }
        }

        return isIncreasing || isDecreasing;
    }
}
