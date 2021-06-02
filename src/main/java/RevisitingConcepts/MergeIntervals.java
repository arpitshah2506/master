package RevisitingConcepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        System.out.println(merge(new int[][]{{1,3},{2,6},{8,10},{15,18}}));
    }

    private static int[][] merge(int[][] intervals) {
        if (intervals ==null || intervals.length == 0) {
            return new int[][]{};
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        LinkedList<int[]> list = new LinkedList<>();
        list.getLast()[1] = 1;

        /*list.add(new ArrayList<Integer>(){{add(intervals[0][0]);add(intervals[0][1]);}});

        int counter = 1;
        while (counter < intervals.length) {
            if (list.get(list.size()-1).get(1) >= intervals[counter][0]) {
                Integer remove = list.get(list.size() - 1).remove(0);
                list.get(list.size()-1).add(0, Math.min(remove, intervals[counter][0]));

                remove = list.get(list.size() - 1).remove(1);
                list.get(list.size()-1).add(1, Math.max(remove, intervals[counter][1]));
            } else {
                int finalCounter = counter;
                list.add(new ArrayList<Integer>(){{add(intervals[finalCounter][0]);add(intervals[finalCounter][1]);}});
            }
            counter++;
        }*/
        return list.toArray(new int[list.size()][]);
    }
}
