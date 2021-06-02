import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MergeIntervals {
    public static void main(String[] args) {
        Arrays.stream(merge(new int[][]{{1, 10}, {2,9}})).forEach(x -> Arrays.stream(x).forEach(System.out::println));

     /*   ArrayList<Interval> intervals = new ArrayList<Interval>() {{
            add(new Interval());
        }};*/
    }

    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        TreeMap<Integer, Integer> result = new TreeMap<>();
        result.put(intervals[0][0], intervals[0][1]);

        Map.Entry<Integer, Integer> lastEntry;
        for (int index = 1; index < intervals.length; index++) {
            lastEntry = result.lastEntry();
            if (lastEntry.getKey() <= intervals[index][0]
                && lastEntry.getValue() >= intervals[index][1]) {
                continue;
            }

            if (lastEntry.getValue() >= intervals[index][0]) {
                result.put(result.lastKey(), intervals[index][1]);
            } else {
                result.put(intervals[index][0], intervals[index][1]);
            }
        }

        int[][] answer = new int[result.size()][2];
        int index = 0;

        for (Map.Entry<Integer, Integer> traverse :
                result.entrySet()) {
            answer[index][0] = traverse.getKey();
            answer[index][1] = traverse.getValue();

            index += 1;
        }
        return answer;
    }
}
/*

class Interval {
    public int start;
    public int end;
}
*/
