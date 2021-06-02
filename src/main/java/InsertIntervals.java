import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervals {
    public static void main(String[] args) {
        insert(new int[][]{{1,5}}, new int[]{6,7});
    }

    private static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        boolean isStartPointFound = false;
        boolean isInsertionCompleted = false;
        int startPoint = 0;
        int endPoint;

        for (int[] interval : intervals) {
            if (isInsertionCompleted) {
                result.add(interval);
            } else {
                if (!isStartPointFound) {
                    if (newInterval[0] >= interval[0] &&
                        newInterval[1] <= interval[1]) { //ending withing existing interval like 1-5 and new interval 2-4
                        result.add(interval);
                        isInsertionCompleted = true;
                    } else if (newInterval[0] < interval[0] &&
                            newInterval[1] < interval[0]) { //ending before next interval like 4-7 and new interval 1-3
                        result.add(newInterval);
                        result.add(interval);
                        isInsertionCompleted = true;
                    } else if (newInterval[0] <= interval[1] &&
                            interval[1] < newInterval[1]) { //starting pointer found but ending not yet fixed like existing interval -> 4-7 and new interval -> 5-9
                        isStartPointFound = true;
                        startPoint = Math.min(interval[0], newInterval[0]);
                    } else if (newInterval[0] <= interval[1] &&
                            newInterval[1] <= interval[1]) { //starting before next interval and ending within it like 4-9 and new interval is 2-7 then result => 2-9
                        result.add(new int[]{Math.min(newInterval[0], interval[0]), interval[1]});
                        isInsertionCompleted = true;
                    }else {
                        result.add(interval);
                    }
                } else {
                    if (interval[0] > newInterval[1]) { //this is for condition 3 if new interval higher than ending point of existing index like 11 - 15 then insertion be like
                                                        //4-9 and 11-15
                        endPoint = newInterval[1];
                        result.add(new int[]{startPoint, endPoint});
                        result.add(new int[]{interval[0], interval[1]});
                        isStartPointFound = false;
                        isInsertionCompleted = true;
                    } else if (newInterval[1] <= interval[1]) {//if new interval within that specific interval like 8 - 10 then merge it like 4-10
                        endPoint = interval[1];
                        result.add(new int[]{startPoint, endPoint});
                        isStartPointFound = false;
                        isInsertionCompleted = true;
                    }
                }
            }
        }

        if (!isInsertionCompleted) { //if compeletely out of the box
            if (isStartPointFound) {
                result.add(new int[]{startPoint, newInterval[1]});
            } else {
                result.add(newInterval);
            }
        }
        int[][] answer = new int[result.size()][2];
        for (int index = 0; index < result.size(); index++) {
            answer[index][0] = result.get(index)[0];
            answer[index][1] = result.get(index)[1];
        }

        Arrays.stream(answer).forEach(x -> Arrays.stream(x).forEach(System.out::println));
        return answer;
    }
}
