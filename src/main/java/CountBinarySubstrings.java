public class CountBinarySubstrings {
    public static void main(String[] args) {
        String s = "00110";
        System.out.println(countBinarySubstrings(s));
    }

    private static int countBinarySubstrings(String s) {
        if (s.length() == 1) {
            return 0;
        } else if (s.length() == 2 && s.charAt(s.length() - 1) != s.charAt(s.length() - 2)) {
            return 1;
        }

        int currentCount = 1;
        int previousCount = 0;
        int result = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            currentCount = currentCount + 1;
            if (s.charAt(i) != s.charAt(i + 1)) {
                result = result + Math.min(previousCount, currentCount);
                previousCount = currentCount;
                currentCount = 0;
            }
        }

        if (s.charAt(s.length() - 1) == s.charAt(s.length() - 2)) {
            currentCount = currentCount + 1;
            if (previousCount > 1) {
                result = result + Math.min(previousCount, currentCount);
            }
        }


        return result;
    }
}
