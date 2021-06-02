public class CountCharacters {
    public static void main(String[] args) {
        String[] words = {"hello","world","leetcode"};
        String chars = "welldonehoneyr";

        System.out.println(countCharacters(words, chars));
    }

    private static int countCharacters(String[] words, String chars) {
        char[] charArr = chars.toCharArray();
        int[] charCount = new int[26];
        int[] wordCount;
        int count = 0;
        int j = 0;
        for (int i = 0; i < chars.length(); i++) {
            charCount[charArr[i] - 'a']++;
        }

        for (int i = 0; i < words.length; i++) {
            wordCount = new int[26];
            for (j = 0; j < words[i].length(); j++) {
                wordCount[words[i].charAt(j) - 'a']++;
            }
            for (j = 0; j < 26; j++) {
                if (wordCount[j] > 0 && wordCount[j] > charCount[j]) {
                    break;
                }
            }
            if (j == 26) {
                count = count + words[i].length();
            }
        }
        return count;
    }
}
