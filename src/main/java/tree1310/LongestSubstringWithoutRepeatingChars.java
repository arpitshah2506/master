package tree1310;

import java.util.LinkedList;

public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("jbpnbwwd"));
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s == null || s == "") return 0;

        int left = 0;
        int right = 0;
        int max = 0;

        LinkedList<Character> charSet = new LinkedList<>();
        while (right < s.length()) {
            if (charSet.contains(s.charAt(right))) {
                max = Math.max(max, charSet.size());
                charSet.removeFirst();
                left = left + 1;
            } else {
                charSet.add(s.charAt(right));
                right = right + 1;
            }
        }

        return Math.max(max, charSet.size());
    }
}
