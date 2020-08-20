import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {
    public static void main(String[] args) {
        mergeOptimal(new ArrayList<Interval>(){{add(new Interval(1,3));add(new Interval(2,6));add(new Interval(8,10));add(new Interval(15,18));}});
        System.out.println(merge(new int[][]{{1,4},{0,0}}));
    }

    private static List<Interval> mergeOptimal(List<Interval> intervals)
    {
        // sort start&end
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;
    }

    private static int[][] merge(int[][] intervals) {
        if (intervals ==null || intervals.length == 0) {
            return new int[][]{};
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>(){{add(intervals[0][0]);add(intervals[0][1]);}});

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
        }

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i).get(0);
            result[i][1] = list.get(i).get(1);
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
        return result;
    }
}

class Interval
{
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}