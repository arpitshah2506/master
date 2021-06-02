public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        //binarySearch(nums);
        binarySearchWithDuplicates(new int[]{5,7,7,8,8,10});
    }

    private static void binarySearch(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int key = 8;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == key) {
                System.out.println("found : " + mid);
                break;
            } else if (key < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    private static void binarySearchWithDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int target = 10;

        int left = 0;
        int right = nums.length - 1;
        int mid;
        int leftIndex = -1, rightIndex = -1;

        while (left <= right && nums[right] >= target) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                leftIndex = mid;
                right = mid - 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        left = 0;
        right = nums.length - 1;
        while (left <= right && nums[left] <= target) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                rightIndex = mid;
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(leftIndex + " " + rightIndex);
    }
}
