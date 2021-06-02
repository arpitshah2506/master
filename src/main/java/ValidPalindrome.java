public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "tebbem";
        System.out.println(validPalindrome(s));
    }

    private static boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        int count = 0;

        if (s.length() == 3) {
            if (s.charAt(0) != s.charAt(s.length() - 1)) {
                return false;
            }
            return true;
        }

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                count = count + 1;
                if (count > 1) {
                    return false;
                }
            }
            start++;
            end--;
        }
        return true;
    }
}
