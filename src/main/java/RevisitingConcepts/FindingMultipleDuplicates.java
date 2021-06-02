package RevisitingConcepts;

public class FindingMultipleDuplicates {
    public static void main(String[] args) {
        findMultipleDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        //4,3,2,7,8,2,3,1 => 4,3,2,-7,8,2,3,1 => 0
        //4,3,2,-7,8,2,3,1 => 4,3,-2,-7,8,2,3,1 => 1
        //4,3,-2,-7,8,2,3,1 => 4,-3,-2,-7,8,2,3,1 => 2
        //4,-3,-2,-7,8,2,3,1 => 4,-3,-2,-7,8,2,-3,1 => 3
        //4,-3,-2,-7,8,2,-3,1 => 4,-3,-2,-7,8,2,-3,-1 => 4
        //4,-3,-2,-7,8,2,-3,-1 => 4,-3,-2,-7,8,2,-3,-1 => 5 =>
        //4,-3,-2,-7,8,2,-3,-1 =>
    }

    private static void findMultipleDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i])-1] < 0) {
                System.out.println(Math.abs(nums[i]));
            } else {
                nums[Math.abs(nums[i]) - 1] = nums[Math.abs(nums[i]) - 1] * -1;
            }
        }
    }
}
