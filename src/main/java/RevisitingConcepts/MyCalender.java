package RevisitingConcepts;

import java.util.ArrayList;
import java.util.List;

public class MyCalender {
    public static void main(String[] args) {
        List<List<Integer>> startEndTimes = new ArrayList<>();
        System.out.println(book(10, 20, startEndTimes));
        System.out.println(book(15, 25, startEndTimes));
        System.out.println(book(20, 30, startEndTimes));
        /*System.out.println(book(47, 50, startEndTimes));
        System.out.println(book(33, 41, startEndTimes));
        System.out.println(book(39, 45, startEndTimes));
        System.out.println(book(33, 42, startEndTimes));
        System.out.println(book(25, 32, startEndTimes));
        System.out.println(book(26,35, startEndTimes));
        System.out.println(book(19,25, startEndTimes));
        System.out.println(book(3,8, startEndTimes));
        System.out.println(book(8,13, startEndTimes));
        System.out.println(book(18,27, startEndTimes));*/
    }

    public static boolean book(int start, int end, List<List<Integer>> startEndTimes) {
        return search(startEndTimes, start, end);
    }

    private static boolean search(List<List<Integer>> startEndTimes, int start, int end) {
        if (startEndTimes.size() == 0) {
            startEndTimes.add(new ArrayList<Integer>() {{
                add(start);
                add(end);
            }});
            return true;
        }

        if (start >= startEndTimes.get(startEndTimes.size() - 1).get(1)) {
            startEndTimes.add(new ArrayList<Integer>(){{add(start);add(end);}});
            return true;
        }

        if (start < startEndTimes.get(0).get(0) && end <= startEndTimes.get(0).get(0)) {
            startEndTimes.add(0,new ArrayList<Integer>(){{add(start);add(end);}});
            return true;
        }

        int index;
        for (index = 0; index < startEndTimes.size(); index++) {
            if (start >= startEndTimes.get(index).get(1) && startEndTimes.get(index + 1).get(0) >= end) {//initial slot available
                startEndTimes.add(index + 1, new ArrayList<Integer>() {{add(start);add(end);}});
                return true;
            }
        }
        return false;
    }
}
