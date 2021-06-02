public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        String s = "abaabc";
        System.out.println(repeatedSubstringPattern(s));

        String a = "3876620623801494171";
        String b = "6529364523802684779";

        System.out.println(returnNum(a,b));
    }

    private static boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    private static String returnNum(String num1, String num2) {
        int length = Math.max(num1.length(), num2.length()) - 1; //9th char

        int stringOneLen = num1.length() - 1; //9th char
        int stringTwoLen = num2.length() - 1; //7th char
        int carry = 0;
        int divisor = 0;
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index <= length) {
            int numOne = stringOneLen - index > -1? Integer.parseInt(String.valueOf(num1.charAt(stringOneLen - index))) : 0; //9-9
            int numTwo = stringTwoLen - index > -1? Integer.parseInt(String.valueOf(num2.charAt(stringTwoLen - index))) : 0;

            carry = (numOne + numTwo + divisor) >= 10 ? (numOne + numTwo + divisor) % 10 : numOne + numTwo + divisor; //4

            divisor = (numOne + numTwo + divisor) >= 10 ? (numOne + numTwo + divisor) / 10 : 0;//1

            result.append(carry);
            index++;
        }

        if (divisor != 0) {
            result.append(divisor);
        }

        return result.reverse().toString();
    }
}
