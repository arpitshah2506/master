import java.util.HashMap;
import java.util.Map;

public class BalancedString {
    public static void main(String[] args) {
        String s = "WWEQERQWQWWRWWERQWEQ";

        int eachCharOccurence = s.length() / 4;

        int count = 0;

        int index = 0;

        int strIndex = 0;

        Map<Character, Integer> association = new HashMap<>();

        association.put('Q',0);

        association.put('W',0);

        association.put('E',0);

        association.put('R',0);

        while (strIndex < s.length())
        {
            association.put(s.charAt(strIndex), association.get(s.charAt(strIndex)) + 1);

            strIndex = strIndex + 1;
        }

        for (Map.Entry<Character, Integer> associationEntry:association.entrySet())
        {
            if (associationEntry.getValue() > eachCharOccurence)
            {
                count = count + (associationEntry.getValue() - eachCharOccurence);
            }
        }

        System.out.println(count);
    }
}
