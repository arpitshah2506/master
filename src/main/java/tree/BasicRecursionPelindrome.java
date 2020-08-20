package tree;

public class BasicRecursionPelindrome {
    public static void main(String[] args) {
        String str = "122321";
        if (findPelindrome(str.toCharArray(), str.length() - 1, "").equalsIgnoreCase(str)) {
            System.out.println("pelindrome");
        } else {
            System.out.println("Not pelindrome");
        }
    }

    private static String findPelindrome(char[] a, int length, String target) {
        if (length == -1) {
            return "";
        }
        return target + a[length] + findPelindrome(a, length - 1, target);

    }
}
