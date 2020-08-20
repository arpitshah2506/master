package RevisitingConcepts;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {7,8,1,2,3,4,5,6};

        int target = 8;

        if(nums == null || nums.length == 0){
            System.out.println(-1);
        }
        if(nums.length == 1){
            System.out.println(nums[0] == target ? 0 : -1);
        }

        if (nums[0] < nums[nums.length-1])
        {
            System.out.println(findElement(nums, 0, nums.length - 1, target));
        }
        else
        {
            int pivotIndex = findPivotIndex(nums, 0, nums.length - 1);

            if (target == nums[pivotIndex])
            {
                System.out.println(pivotIndex);
            }
            else
            {
                if (nums[0] > target)
                {
                    System.out.println(findElement(nums, pivotIndex, nums.length - 1, target));
                }
                else
                {
                    System.out.println(findElement(nums, 0, pivotIndex, target));
                }
            }
        }
    }

    private static int findElement(int[] nums, int start, int end, int key)
    {
        int mid = (start + end) / 2;

        if (start > end)
        {
            return -1;
        }

        if (nums[mid] == key)
        {
            return mid;
        }
        else if (key < nums[mid])
        {
            return findElement(nums, start, mid - 1, key);
        }
        else
        {
            return findElement(nums, mid + 1, end, key);
        }
    }

    private static int findPivotIndex(int[] nums, int start, int end)
    {
        int mid = (start + end) / 2;

        if (nums[mid] > nums[mid+1])
        {
            return mid + 1;
        }
        else if (nums[mid] < nums[0])
        {
            return findPivotIndex(nums, 0, mid);
        }
        else
        {
            return findPivotIndex(nums, mid, end);
        }
    }
}
