import java.util.HashMap;

public class IsIsomorphic {
    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";

        int[] m1 = new int[256];
        int m2[] = new int[256];
        int n = s.length();

        for (int i = 0; i < n; ++i) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)])
                System.out.println( false);
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        //return true;
    }
}
