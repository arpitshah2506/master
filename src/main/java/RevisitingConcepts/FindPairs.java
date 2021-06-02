package RevisitingConcepts;

import java.util.ArrayList;
import java.util.List;

public class FindPairs {
    public static void main(String[] args) {
        findPairs(new int[]{1, 2, 3, 1, 5}, 0);
    }

    private static void findPairs(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(Integer.valueOf(Math.abs(k - nums[i])))) {
                count++;
            }
        }

        System.out.println(count);
    }
}
