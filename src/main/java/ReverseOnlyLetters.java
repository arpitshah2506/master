public class ReverseOnlyLetters {
    public static void main(String[] args) {
        String s = "Test1ng-Leet=code-Q!";
        System.out.println(reverseOnlyLetters(s));
    }

    private static String reverseOnlyLetters(String S) {
        int start = 0;
        int end = S.length() - 1;
        char[] chars = S.toCharArray();

        while (start < end) {
            while ((start < end && Character.isLetter(chars[start])) == false) {
                start++;
            }
            while (start < end && (Character.isLetter(chars[end])) == false) {
                end--;
            }

            char c = chars[start];
            chars[start] = chars[end];
            chars[end] = c;
            start++;
            end--;
        }

        return new String(chars);
    }
}
