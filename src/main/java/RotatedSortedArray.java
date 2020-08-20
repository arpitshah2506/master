public class RotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,3};
        int pivotIndex = findPivot(nums, 0, nums.length - 1);
        int target = 3;
        if (nums[pivotIndex] == target) System.out.println(nums[pivotIndex]);
        if (target > nums[0] && target < nums[pivotIndex]) {
            System.out.println(binarySearch(nums, 0, pivotIndex, target) != -1 ? binarySearch(nums, 0, pivotIndex, target) : -1);
        } else {
            System.out.println(binarySearch(nums, pivotIndex + 1, nums.length - 1, target) != -1 ? nums[binarySearch(nums, pivotIndex + 1, nums.length - 1, target)] : -1);
        }
    }

    private static int binarySearch(int[] nums, int startIndex, int endIndex, int target) {
        int mid = startIndex - (startIndex - endIndex) / 2;
        if (startIndex >= endIndex ) return -1;
        if (nums[mid] == target) {
            return mid;
        } else if (target < nums[mid]) {
            return binarySearch(nums, startIndex, mid, target);
        } else {
            return binarySearch(nums, mid + 1, endIndex, target);
        }

    }

    private static int findPivot(int[] nums, int startIndex, int endIndex) {
        int mid = startIndex - (startIndex - endIndex) / 2;
        if (nums.length == 1) return 0;
        if (nums[startIndex] < nums[nums.length - 1]) return 0;
        if (nums[mid] > nums[mid + 1])
        {
            return mid + 1;
        }
        else if (nums[startIndex] > nums[mid])
        {
            return findPivot(nums, startIndex, mid);
        }
        else
        {
            return findPivot(nums, mid + 1, endIndex);
        }
    }
}
