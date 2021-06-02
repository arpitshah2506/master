package RevisitingConcepts;

public class FindPivotInRotatedArray {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1,2,3,4,5,6,7,8,9}, 9));
        System.out.println(findPivot(new int[]{3,1,2}));//1,2,3,4,5,6,7,8,9 ==> 8,9,1,2,3,4,5,6,7 ==> 5,6,7,8,9,1,2,3,4 ==> 3,4,5,6,7,8,9,1,2
    }

    private static int binarySearch(int[] nums, int element) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == element) {
                return mid;
            } else if (nums[mid] < element) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return 0;
    }

    private static int findPivot(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) return 0;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid+1]) {
                return mid + 1;
            } else if (nums[mid] < nums[left]) {
                //rotation happened at the left part
                right = mid - 1;
            } else {
                //rotation happened at the right part
                left = mid + 1;
            }
        }

        return -1;
    }
}
