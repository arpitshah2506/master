package RevisitingConcepts;

public class IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagarm"));
    }

    private static boolean isAnagram(String s, String t) {
        int[] source = new int[26];

        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            source[s.charAt(i)-97]++;
        }

        for (int i = 0; i < t.length(); i++) {
            source[t.charAt(i)-97]--;
        }

        for (int i = 0; i < source.length; i++) {
            if (source[i] != 0) return false;
        }

        return true;
    }
}
