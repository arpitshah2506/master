package RevisitingConcepts;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }

    private static void threeSum(int[] nums) {
        List<List<Integer>> integers = new ArrayList<>();
        for (int index = 0; index < nums.length - 2; index++) {
            for (int inner = index + 1; inner < nums.length - 1; inner++) {
                for (int innerj = inner + 1; innerj < nums.length; innerj++) {
                    if (nums[index] + nums[inner] + nums[innerj] == 0) {
                        System.out.println(index + " " + inner + " " + innerj);
                        System.out.println(nums[index] + " " + nums[inner] + " " + nums[innerj]);
                        System.out.println("\n");
                    }
                }
            }
        }
    }
}
