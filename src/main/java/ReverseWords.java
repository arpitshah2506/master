public class ReverseWords {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
        System.out.println(swapMethod(s));
    }

    private static String reverseWords(String s) {
        String[] strigns = s.split(" ");
        StringBuilder builder = new StringBuilder();
        StringBuilder reverse = new StringBuilder();
        for (int i = 0;i<strigns.length;i++) {
            reverse.append(strigns[i]).reverse();
            builder.append(reverse).append(" ");
            reverse.setLength(0);
        }
        return builder.toString().trim();
    }

    private static String swapMethod(String s) {
        String[] strings = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0;i<strings.length;i++) {
            int start = 0;
            int end = strings[i].length()-1;
            char[] chars = strings[i].toCharArray();
            while (start < end) {
                char c = chars[start];
                chars[start] = chars[end];
                chars[end] = c;

                start++;
                end--;
            }
            builder.append(chars).append(" ");
        }
        return builder.toString().trim();
    }
}
