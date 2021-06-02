package RevisitingConcepts;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1}));
    }

    private static int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];

        int candidate = nums[0];
        int count = 1;

        for (int index = 1; index < nums.length; index++) {
            if (nums[index] == candidate) {
                count += 1;
            } else {
                count -= 1;

                if (count == 0) {
                    candidate = nums[index];
                    count = 1;
                }
            }
        }

        int result = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == candidate) {
                result += 1;
                if (result == nums.length / 2) {
                    return candidate;
                }
            }
        }

        return -1;
    }
}
