import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){
        for(int i = start; i < nums.length; i++){
            backtrack(list, tempList, nums, i + 1);
            list.add(new ArrayList<>(tempList));
            tempList.remove(tempList.size() - 1);
            tempList.add(nums[i]);
        }
    }
}
