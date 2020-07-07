import java.util.HashMap;

public class MajorityElement
{
    public static void main(String[] args) {
        int[] nums = {6,5,5};
        System.out.println(majorityElement(nums));
    }

    private static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> numberAndFrequency = new HashMap<>();
        int maxSoFar = Integer.MIN_VALUE;
        for (int index = 0; index < nums.length; index++) {
            if (numberAndFrequency.get(nums[index]) != null) {
                numberAndFrequency.put(nums[index],numberAndFrequency.get(nums[index])+1);
            } else {
                numberAndFrequency.put(nums[index], 1);
            }
            if (maxSoFar < numberAndFrequency.get(nums[index])) {
                maxSoFar = numberAndFrequency.get(nums[index]);
            }
            if (maxSoFar > nums.length / 2) {
                return nums[index];
            }
        }
        return nums[0];
    }
}
