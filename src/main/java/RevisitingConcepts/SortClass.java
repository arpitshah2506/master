package RevisitingConcepts;

public class SortClass {
    public static void main(String[] args) {
        //sortColors(new int[]{2,0,2,1,1,0});
        sortColorsOptimal(new int[]{2,0,1});
    }

    private static void sortColorsOptimal(int[] nums) {
        int lo = 0, mid = 0;
        int hi = nums.length - 1;

        while (mid <= hi) {
            if (nums[mid] == 0) {
                swap(nums, lo, mid);
                lo++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, hi);
                hi--;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    private static void swap(int[] nums, int indexToReplace, int indexToBeReplaced) {
        int temp = nums[indexToReplace];
        nums[indexToReplace] = nums[indexToBeReplaced];
        nums[indexToBeReplaced] = temp;
    }

    private static void sortColors(int[] nums) {
        int zeroCounter = 0;
        int oneCounter = 0;
        int twoCounter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCounter++;
            } else if (nums[i] == 1) {
                oneCounter++;
            } else {
                twoCounter++;
            }
        }

        for (int i = 0; i < zeroCounter; i++) {
            nums[i] = 0;
        }

        for (int i = zeroCounter; i < zeroCounter + oneCounter; i++) {
            nums[i] = 1;
        }

        for (int i = zeroCounter + oneCounter; i < zeroCounter + oneCounter + twoCounter; i++) {
            nums[i] = 2;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


}
