package RevisitingConcepts;

public class isPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindromeMethod("A man, a plan, a canal: Panama"));
    }

    private static boolean isPalindromeMethod(String s) {
        int startPointer = 0;
        int endPointer = s.length() - 1;

        while (startPointer < endPointer) {
            while (!Character.isLetterOrDigit(s.charAt(startPointer)) ) {
                startPointer++;
            }
            while (!Character.isLetterOrDigit(s.charAt(endPointer))) {
                endPointer--;
            }
            if (Character.toLowerCase(s.charAt(startPointer)) != Character.toLowerCase(s.charAt(endPointer))) {
                return false;
            }
            startPointer++;
            endPointer--;
        }
        return true;
    }
}
