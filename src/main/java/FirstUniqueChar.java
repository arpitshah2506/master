import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstUniqueChar {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    private static Integer firstUniqChar(String s) {
        Set<Character> characterSet = new HashSet<>();

        Map<Character, Integer> characterPosition = new LinkedHashMap<>();
        int i = 0;
        for (; i< s.length(); i++) {
            if (characterPosition.get(s.charAt(i)) < 3) {
                characterPosition.put(s.charAt(i), i);
            }
        }

        return characterPosition.keySet().size() > 0 ? characterPosition.get(characterPosition.keySet().iterator().next()) : -1;
    }
}
