package RevisitingConcepts;

public class MooreAlgoForMajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 3, 4};

        System.out.println(verify(nums, findMajorityElement(nums)));
    }

    private static int verify(int[] nums, int element) {
        int count = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == element)
            {
                count++;
                if (count == nums.length /2)
                {
                    return element;
                }
            }
        }

        return -1;
    }

    private static int findMajorityElement(int[] nums) {
        int count = 1;
        int majorityElement = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == majorityElement)
            {
                count++;
            }
            else
            {
                count--;
                if (count == 0)
                {
                    majorityElement = nums[i];
                    count = 1;
                }
            }
        }

        return majorityElement;
    }
}
