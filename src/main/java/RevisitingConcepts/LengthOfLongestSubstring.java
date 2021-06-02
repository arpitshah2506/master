package RevisitingConcepts;

import java.util.HashMap;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdedzxyqwl"));
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        HashMap<Character, Integer> characterPosition = new HashMap<>();

        int startIndex = 0;
        int deletionIndex;
        int max = 0, index;
        int endDeletionIndex;

        //abcded
        for (index = 0; index < s.length(); index++) {
            if (characterPosition.get(s.charAt(index)) != null) {
                endDeletionIndex = characterPosition.get(s.charAt(index));
                for (deletionIndex = startIndex; deletionIndex <= endDeletionIndex; deletionIndex++) {
                    characterPosition.remove(s.charAt(deletionIndex));
                }
                max = Math.max(max, (index - startIndex));
                startIndex = deletionIndex;
            }
            characterPosition.putIfAbsent(s.charAt(index), index);
        }

        return Math.max(max, (index - startIndex));
    }
}
