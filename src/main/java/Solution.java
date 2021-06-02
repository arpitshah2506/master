import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(findMultiplication(new int[]{1,2,3,4,5,6,7,8,9,10,11,12}, 12));
    }

    private static int[] findMultiplication(int[] nums, int answer) {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            numbers.put(nums[index], index);
        }

        ArrayList<ArrayList<Integer>> holder = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if (numbers.containsKey(answer / nums[index]) && numbers.get(answer / nums[index]) > index) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(nums[index]);
                temp.add(answer / nums[index]);
                holder.add(temp);
            }
        }

        return new int[0];
    }
}

// select name from (select * from students order by marks desc) where rownum = 5;
