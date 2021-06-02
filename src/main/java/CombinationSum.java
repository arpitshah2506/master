import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempResult = new ArrayList<>();

        //backTrack(new int[]{2,3,6,7}, 0 , 11, tempResult, result);

        tempResult = new ArrayList<>();
        result = new ArrayList<>();
        subSets(new int[]{1,2,3}, 0, tempResult, result);

        //System.out.println(result);
    }

    private static void backTrack(int[] cand, int start, int target, List<Integer> list, List<List<Integer>> result) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(list));
        }

        for (int index = start; index < cand.length; index++) {
            list.add(cand[index]);
            backTrack(cand, index, target - cand[index], list, result);

            System.out.println(list);
            list.remove(list.size() - 1);
        }
    }

    private static void subSets(int[] cand, int start, List<Integer> tempResult, List<List<Integer>> result)
    {
        for (int index = start; index < cand.length; index++) {
            tempResult.add(cand[index]);
            result.add(new ArrayList<>(tempResult));
            subSets(cand, index + 1, tempResult, result);

            System.out.println(tempResult);
            System.out.println(result);
            System.out.println(index);
            System.out.println("\n");
            tempResult.remove(tempResult.size() - 1);
        }
    }
}
