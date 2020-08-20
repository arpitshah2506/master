import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingRoom {
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<Interval>() {{
            add(new Interval(1, 2));
            add(new Interval(2, 3));
            add(new Interval(3, 4));
            add(new Interval(1, 3));
        }};

        // 1,1,2,3
        // 2,3,3,4
        System.out.println(meetingRooms(intervals));
    }

    private static int meetingRooms(ArrayList<Interval> intervals) {
        int len = intervals.size();
        int[] starts = new int[len];
        int[] ends = new int[len];

        int count = 0;
        for (Interval interval:intervals) {
            starts[count] = interval.start;
            ends[count] = interval.end;
            count = count + 1;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        List<Interval> result = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < starts.length - 1; i++) {
            if (starts[i+1] < ends[i])  //reached till the end or interval is not overlapping
            {
                counter = counter + 1;
            }
        }

        System.out.println(result);
        return counter;
    }
}
