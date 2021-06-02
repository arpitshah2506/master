import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfBalloons {
    public static void main(String[] args) {
        String s = "mbetypbpefxvviadqaodrbjeoacfomepmzymiudltgnvnpbowwmjgpzzhtiismearuwocsgbiimiqqzaozgeizikrlxmupfzjzmlfttqqbpfblqfkecsdfbsceqjhubfxksivrfwvukapxmuciybfhzlmpeamdxziptxregymqtmgcsujmugissgnlbhxbcxxeoumcqyulvahuianbaaxgzrtmshjguqdaxvxndzoqvwmcjfhpevavnrciqbymnlylbrfkkiceienoarfrzzxtuaqapaeqeqolozadmtgjyhfqzpuaskjuawxqkdqyjqcmbxtvshzrquvegcuyuckznspmrxvqdassidcmrajedsnuuumfwqzvasljlyvfefktiqgvzvdzojtjegsyhbepdkuwvgrfscezvswywmdavpxlekbrlkfnbyvlobazmvgulxrfdranuhomkrlpbfeagfxxxuhjuqhbkhznixquxrxngwimdxdhqbdaouitsvcdmbwxbbaomkgxsqwnexbjjyhtxvkjfqkrrxjghvzqsattubphryqxxdyjkihfnzvjhohnhdlfwoqiwtmwzfgcyhyqtcketvgnbchcxvnhcsoosirfqgdgcsitegzlxdfijzmxnvhrulmgvoqfpzesootscnxenokmmozmoxpaverydbsnimwacjqhrtxkqtvghjyushoctxphxzztukgmnoeycqaeukymvwxcsyvvctflqjhtcvjtxncuvhkptkjnzaetwbzkwnseovewuhpkaxiphdicgacszzdturzgjkzwgkmzzavykancvvzaafgzjhcyicorrblmhsnnkhfkujttbkuuedhwguuaapojmnjdfytdhrepjwcddzsoeutlbbljlikghxefgbqenwamanikmynjcupqpdjnhldaixwygcvsgdkzszmsptqqnroflgozblygtiyaxudwmooiviqcosjfksnevultrf";
        System.out.println(maxNumberOfBalloons(s));
        System.out.println(maxNumberOfBalloonsOptimal(s));
    }

    private static int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> characterOccurence = new HashMap<>();

        characterOccurence.put('b',0);
        characterOccurence.put('a',0);
        characterOccurence.put('l',0);
        characterOccurence.put('o',0);
        characterOccurence.put('n',0);

        for (int i = 0;i<text.length();i++) {
            if (characterOccurence.containsKey(text.charAt(i))) {
                characterOccurence.put(text.charAt(i), characterOccurence.get(text.charAt(i)) + 1);
            }
        }

        characterOccurence.put('l',characterOccurence.get('l') / 2);
        characterOccurence.put('o',characterOccurence.get('o') / 2);

        int currentMin = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> single : characterOccurence.entrySet()) {
                if (single.getValue() == 0) {
                    return 0;
                }
                currentMin = Math.min(currentMin, single.getValue());
        }

        for (Map.Entry<Character, Integer> single : characterOccurence.entrySet()) {
            if (single.getValue() < currentMin) {
                return 0;
            }
        }
        return currentMin;
    }

    private static int maxNumberOfBalloonsOptimal(String text) {
        int[] chars = new int[26]; //count all letters
        for (char c : text.toCharArray()) {
            chars[c - 'a']++;
        }
        int min = chars[1];//for b
        min = Math.min(min, chars[0]);//for a
        min = Math.min(min, chars[11] / 2);// for l /2
        min = Math.min(min, chars[14] / 2);//similarly for o/2
        min = Math.min(min, chars[13]);//for n
        return min;
    }
}
