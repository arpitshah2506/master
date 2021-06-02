import java.util.Arrays;

public class FindPairs {
    public static void main(String[] args) {
        twoSumWhenArrayIsSorted(new int[]{1, 2, 3, 4, 5, 6, 7}, 10);
        System.out.println(findPairs(new int[]{2,8,6,9,7,4,9,0,5,4}, 1));
    }

    private static int[] twoSumWhenArrayIsSorted(int[] nums, int sum) {
        int leftPointer = 0;
        int rightPointer = nums.length - 1;

        while (rightPointer < nums.length) {
            if (sum > nums[leftPointer] + nums[rightPointer]) {
                leftPointer++;
            } else if (sum < nums[leftPointer] + nums[rightPointer]) {
                rightPointer--;
            } else {
                return new int[]{leftPointer, rightPointer};
            }
        }
        return nums;
    }

    private static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);

        int leftPointer = 0;
        int rightPointer = nums.length - 1;

        int count = 0;


        while (leftPointer < rightPointer ) {
            if (k + nums[leftPointer] > nums[rightPointer]) {
                int i = leftPointer + 1;
                while (i < nums.length && nums[i] == nums[leftPointer]) {
                    i = i + 1;
                }
                leftPointer = i;
                rightPointer = nums.length - 1;
            } else if (k + nums[leftPointer] == nums[rightPointer]) {
                count++;
                int i = leftPointer + 1;
                while (i < nums.length && nums[i] == nums[leftPointer]) {
                    i = i + 1;
                }
                leftPointer = i;
                rightPointer = nums.length - 1;
            } else {
                rightPointer--;
                        if (leftPointer == rightPointer) {
                            leftPointer++;
                            rightPointer = nums.length - 1;
                        }
            }
        }


        return count;
    }
}
