import java.util.Arrays;
import java.util.TreeSet;

public class ThirdMax {
    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{3,2,3,4}));
        System.out.println(thirdMaxII(new int[]{Integer.MIN_VALUE,1,1}));
    }

    private static Integer thirdMax(int[] nums) {
        if (nums == null) return 0;

        TreeSet<Integer> set = new TreeSet<>();

        for (int index = 0; index < nums.length; index++) {
            set.add(nums[index]);
        }

        if (set.size() < 3) return Arrays.stream(nums).max().getAsInt();

        set.pollLast();
        set.pollLast();

        return set.pollLast();

    }

    private static Integer thirdMaxII(int[] nums)
    {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }
}
