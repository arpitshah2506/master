import java.util.ArrayList;
import java.util.List;

public class LargeGroupPositions {
    public static void main(String[] args) {
        String s = "abbxxxxzzy";
        //System.out.println(largeGroupPositions(s));
        System.out.println(largeGroupPositionsOptimum(s));
    }

    private static List<List<Integer>> largeGroupPositionsOptimum(String S) {
        if (S == null || S.length() < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        int l = 0,r = 0,count = 0;
        while (r < S.length() -1) {
            if (S.charAt(r) != S.charAt(r+1)) {
                if (r - l >= 2) {
                    List<Integer> ints = new ArrayList<>();
                    ints.add(l);
                    ints.add(r);

                    list.add(ints);
                }
                l = r+1;
            }

            r++;
        }

        if (r - l >= 2) {
            List<Integer> ints = new ArrayList<>();
            ints.add(l);
            ints.add(r);

            list.add(ints);
        }
        return list;
    }

    private static List<List<Integer>> largeGroupPositions(String S) {
        if (S == null || S.length() <= 2) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        int count = 0;
        int startIndex = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 0; i < S.length() - 1; i++) {
            if (S.charAt(i) == S.charAt(i + 1)) {
                if (startIndex == Integer.MIN_VALUE) {
                    startIndex = i;
                }
                if (count < 3) {
                    count = count + 1;
                }
            } else {
                if (count >= 2) {
                    int finalStartIndex = startIndex;
                    int finalI = i;

                    list.add(new ArrayList<Integer>() {{
                        add(finalStartIndex);
                        add(finalI);
                    }});
                }
                count = 0;
                startIndex = Integer.MIN_VALUE;
            }
        }

        if (count >= 2) {
            int finalStartIndex1 = startIndex;
            list.add(new ArrayList<Integer>() {{
                add(finalStartIndex1);
                add(S.length() - 1);
            }});
        }
        return list;
    }
}
