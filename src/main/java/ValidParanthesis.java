import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
        String s = "(())";

        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        Map<Character, Character> openingClosingPair = new HashMap<>();

        openingClosingPair.put('{', '}');
        openingClosingPair.put('[', ']');
        openingClosingPair.put('(', ')');

        Stack<Character> characters = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (openingClosingPair.get(s.charAt(i)) != null) {
                characters.push(s.charAt(i));
            } else if (characters.size() == 0 || s.charAt(i) != openingClosingPair.get(characters.pop())) {
                return false;
            }
        }

        if (characters.size() > 0) {
            return false;
        }
        return true;
    }
}
