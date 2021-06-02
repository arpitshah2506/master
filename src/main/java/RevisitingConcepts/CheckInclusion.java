package RevisitingConcepts;

import java.util.ArrayList;
import java.util.List;

public class CheckInclusion {
    public static void main(String[] args) {
        String s1= "abab";
        String s2 = "ab";

        System.out.println(checkInclusion(s1, s2));
    }

    private static List<Integer> checkInclusion(String s, String p) {
        List<Integer> list = new ArrayList<>();

        int window = p.length();
        int loopToTraverse = s.length();

        int[] windowChar = new int[26];
        int[] loopChar = new int[26];

        for (int index = 0; index < window; index++) {
           windowChar[p.charAt(index) - 97]++;
        }

        int windowsCheck;
        //ab
        //bac
        for (int index = 0; index < loopToTraverse; index++) {
            if (index >= window) {
                for (windowsCheck = 0; windowsCheck < windowChar.length; windowsCheck++) {
                    if (windowChar[windowsCheck] != loopChar[windowsCheck]) {
                        break;
                    }
                }
                if (windowsCheck == windowChar.length) {
                    list.add(index - window);
                }
                loopChar[s.charAt(index - window) - 97]--;
            }
            loopChar[s.charAt(index) - 97]++;
        }

        for (windowsCheck = 0; windowsCheck < windowChar.length; windowsCheck++) {
            if (windowChar[windowsCheck] != loopChar[windowsCheck]) {
                break;
            }
        }

        if (windowsCheck == windowChar.length) {
            list.add(loopToTraverse - window);
        }

        return list;
    }
}
