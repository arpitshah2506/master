import java.util.Stack;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {

        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String finalResult = null;

        Stack<Character> characters;

        if (s.length() < 2) {
            //return s;
        }

        for (int i = 0; i < s.length(); i++) {


            int search = search(s.charAt(i), s.length() - 1, i, s);

            if (search == Integer.MIN_VALUE) {
                continue;
            }

            int initialSearch = search;
            StringBuilder iterationWiseResult = new StringBuilder();
            characters = new Stack<>();
            for (int j = i; j <= search; j++) { // change search to half
                System.out.println(" j : " + j + " val : " + s.charAt(j) + " search : " + search + " val : " + s.charAt(search));
                if (s.charAt(j) != s.charAt(search)) {
                    search = initialSearch - 1;
                    iterationWiseResult = new StringBuilder();
                    characters = new Stack<>();
                    j = i;
                    search = search(s.charAt(i), search, i, s);
                    initialSearch = search;

                    if (search == Integer.MIN_VALUE) {
                        break;
                    }
                    iterationWiseResult.append(s.charAt(j)); //change it to int
                } else {
                    iterationWiseResult.append(s.charAt(j)); //change it to int
                }

                if (j != search) {
                    characters.push(s.charAt(j));
                }

                search--;
            }

            String tempResult = iterationWiseResult.toString();
            if (tempResult != null && tempResult.length() > 0) {
                while (characters.size() > 0)
                {
                    tempResult = tempResult + characters.pop();
                }
            }

            if (tempResult.length() == s.length())
            {
                System.out.println(tempResult);
            }

            if (finalResult == null) {
                finalResult = tempResult;
            } else {
                if (finalResult.length() < tempResult.length()) {
                    finalResult = tempResult;
                }
            }
        }

        if (finalResult == null || finalResult.length() == 0) {
            finalResult = String.valueOf(s.charAt(0));
        }

        System.out.println(finalResult);
    }

    private static int search(char charAt, int startPoint, int endPoint, String s) {
        for (int j = startPoint; j > endPoint; j--) {
            if (s.charAt(j) == charAt) {
                return j;
            }
        }
        return Integer.MIN_VALUE;
    }}
