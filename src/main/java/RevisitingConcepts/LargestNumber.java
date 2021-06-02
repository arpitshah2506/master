package RevisitingConcepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumber {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<Integer>() {{
            add(0);
            add(0);
            add(0);
            add(0);
            add(0);
        }};

        System.out.println(largestNumber(nums));
        //System.out.println((s1+s2).compareTo(s2+s1));
    }

    private static String largestNumber(List<Integer> A) {
        if (A == null || A.size() == 0) return "";

        Collections.sort(A, (o1, o2) -> {
            String s1 = "" + o1;
            String s2 = "" + o2;

            return (s2 + s1).compareTo(s1 + s2);
        });

        if (A.get(0) == 0 && A.get(A.size() - 1) == 0) return "0";

        StringBuilder s1 = new StringBuilder();
        A.stream().forEach(s1::append);

        return s1.toString();
    }
}
