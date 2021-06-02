package RevisitingConcepts;

public class SearchRange {
    public static void main(String[] args) {
        System.out.println(searchRange(new int[]{1}, 1)[1]);
    }

    private static int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid;
        int targetIndex = -1;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                targetIndex = mid;
                break;
            } else if (target < nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if (targetIndex == -1) {
            return new int[]{-1,-1};
        }
        int value = 0;
        if (targetIndex != -1) {
            value = nums[targetIndex];
        }
        int startRange = targetIndex;
        int endRange = targetIndex;

        while (endRange < nums.length) {
            if (nums[endRange] != value) {
                break;
            }
            endRange++;
        }

        while (startRange >= 0) {
            if (nums[startRange] != value) {
                break;
            }
            startRange--;
        }

        return new int[]{startRange +1, endRange -1};
    }
}
