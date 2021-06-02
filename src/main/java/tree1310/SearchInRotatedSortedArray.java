package tree1310;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        search(new int[]{1,1,1,1,1,1,0,0,0}, 0); //4,5,6,7,8,9,1,2 //8,9,1,2,3,4,5,6,7
    }

    private static void search(int[] nums, int target) {
        System.out.println(findPivotIndex(nums));
    }

    private static int findPivotIndex(int[] nums) {
        if (nums.length == 1 || nums[0] <= nums[nums.length - 1]) return nums[0];

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) /2;

            if (nums[mid] > nums[mid + 1]) return nums[mid+1];
            else if (nums[mid] > nums[left]) left = mid;//rotation happened in the right side
            else right = mid;
        }
        return -1;
    }
}
