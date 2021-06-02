import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDisappearedNumbers {
    public static void main(String[] args) {
        int nums[] = {1,1,2,2};
        System.out.println(findDisappearedNumbers(nums));
    }

    private static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> missingElements = new HashSet<>();
        if (nums.length == 0) {
            return new ArrayList<>(missingElements);
        }

        Arrays.sort(nums);
        int index = 0;
        int currentElement = 0;
        while (index < nums.length)
        {
            if (nums[index] - currentElement == 1 || nums[index] - currentElement == 0)
            {
                currentElement = nums[index];
            }
            else
            {
                currentElement = currentElement + 1;
                while (nums[index] > currentElement) {
                    missingElements.add(currentElement);
                    currentElement = currentElement + 1;
                }
            }
            index = index + 1;
        }

        if (nums[nums.length - 1] != nums.length) {
            int len = nums.length;
            while (len != nums[nums.length - 1])
            {
                missingElements.add(len);
                len = len - 1;
            }
        }
        return new ArrayList<>(missingElements);
    }
}

//4,4,5
//4,4,4,5