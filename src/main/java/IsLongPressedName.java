public class IsLongPressedName {
    public static void main(String[] args) {
        String name = "pyplrz";
        String typed = "ppyypllr";
        System.out.println(isLongPressedName(name, typed));
    }

    private static boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) return false;

        char nameChar;

        int i = 0;
        int j = 0;

        int nameCharCount = 0;
        int typedCharCount = 0;

        while (i < name.length()) {
            nameChar = name.charAt(i);

            nameCharCount = nameCharCount + 1;
            while (i < name.length() - 1 && name.charAt(i) == name.charAt(i + 1)) {
                nameCharCount = nameCharCount + 1;
                i = i + 1;
            }

            while (j < typed.length() && typed.charAt(j) == nameChar) {
                typedCharCount = typedCharCount + 1;
                j = j + 1;
            }

            if (j < i) {
                return false;
            }

            nameCharCount = 0;
            typedCharCount = 0;

            i++;
        }

        while (j < typed.length()) {
            if (name.charAt(name.length() - 1) != typed.charAt(j)) {
                return false;
            }
            j++;
        }

        return true;
    }
}
