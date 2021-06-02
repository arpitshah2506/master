package RevisitingConcepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetTheBest {
    public static void main(String[] args) {
        System.out.println(maximumSwap(5162734));
        maximumSwapMySol(10909091);
    }

    private static void maximumSwapMySol(int num) {
        int modulo;
        int divisor = num;

        List<Integer> integerList = new ArrayList<>();
        while (divisor != 0) {
            modulo = divisor % 10;
            divisor = divisor / 10;

            integerList.add(modulo);
        }

        Collections.reverse(integerList);

        boolean isMaxReversed = false;
        int maxSoFar;
        int jPosition = 0;
        int i;
        int latestPositionOfmaxIndex;

        for (i = 0; i < integerList.size() - 1 && isMaxReversed == false; ) {
            maxSoFar = integerList.get(i);
            for (int j = i + 1; j < integerList.size(); j++) {
                if (integerList.get(j) > maxSoFar) {
                    latestPositionOfmaxIndex = j;
                    for (int k = j; k < integerList.size(); k++) {
                        if (integerList.get(k) == integerList.get(j))
                        {
                            latestPositionOfmaxIndex = k;
                        }
                    }

                    maxSoFar = integerList.get(latestPositionOfmaxIndex);
                    jPosition = latestPositionOfmaxIndex;
                    isMaxReversed = true;
                }
            }
            if (isMaxReversed == false)
            {
                i++;
            }
        }

        if (isMaxReversed) {
            int jElement = integerList.get(jPosition);
            int iElement = integerList.get(i);

            integerList.set(i, jElement);
            integerList.set(jPosition, iElement);
        }

        int finalNumber = 0;
        int count = 0;
        for (int j = integerList.size()-1; j != -1; j--,count++) {
            finalNumber = (int) (finalNumber + Math.pow(10,count) * integerList.get(j));
        }

        System.out.println(finalNumber);
    }

    private static Integer maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        int[] buckets = new int[10];//index at number so seventh index will be having value one, sixth index will have value 2.. buckets[6] = 2;
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }
}
