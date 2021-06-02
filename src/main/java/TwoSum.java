import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        HashMap<Integer, Integer> association = new HashMap<>();
        int[] nums = {3,2,4};
        int target = 6;
        int[] answer = new int[2];
        for (int index = 0; index < nums.length; index++) {
            association.put(nums[index], index);
        }
        for (int index = 0;index < nums.length; index++) {
            if (association.containsKey(target - nums[index]) && index != association.get(target - nums[index])) {
                answer[0] = index;
                answer[1] = association.get(target - nums[index]);
                break;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}
