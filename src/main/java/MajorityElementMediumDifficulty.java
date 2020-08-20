import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElementMediumDifficulty {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 1, 3}));
    }

    private static List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> elementCount = new HashMap<>();
        List<Integer> countOfElements = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (elementCount.getOrDefault(nums[i], 0) != nums.length / 3)
                elementCount.put(nums[i], elementCount.getOrDefault(nums[i], 0) + 1);
                if (elementCount.get(nums[i]) == (nums.length / 3) + 1) {
                    countOfElements.add(nums[i]);
                }
            }


        return countOfElements;
    }
}
