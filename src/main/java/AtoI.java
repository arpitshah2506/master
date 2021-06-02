public class AtoI {
    public static void main(String[] args) {
        //testOverflow("9128343291");
        System.out.println(myAtoi("2147483648"));
    }

    private static int myAtoi(String s) {
        if (s.length() == 0) return 0;

        int index = 0;

        int result = 0;
        //while we have null spaces
        while (s.charAt(index) == ' ')
        {
            index++;

            if (index == s.length())
            {
                return 0;
            }
        }

        boolean isNegative = false;

        if (s.charAt(index) == '+' || s.charAt(index) == '-')
        {
            if (s.charAt(index) == '-')
            {
                isNegative = true;
            }
            index++;

            if (index == s.length())
            {
                return 0;
            }
        }

        while (s.charAt(index) == '0')
        {
            index++;

            if (index == s.length())
            {
                return 0;
            }
        }

        int temp;
        for (; index < s.length(); index++)
        {
            if (!Character.isDigit(s.charAt(index)))
            {
                return (isNegative) ? -result : result;
            }
            else
            {
                temp = result;

                result = (result * 10) + Character.getNumericValue(s.charAt(index));

                if ((result < 0 && temp > 0) ||(result - Character.getNumericValue(s.charAt(index))) / 10 != temp)
                {
                    if (isNegative) return Integer.MIN_VALUE;
                    else return Integer.MAX_VALUE;
                }
            }
        }

        return (isNegative) ? -result : result;
    }
}
