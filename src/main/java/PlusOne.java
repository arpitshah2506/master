import java.util.ArrayList;
import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //0, 3, 7, 6, 4, 0, 5, 5, 5
        list.add(0);

        System.out.println(plusOneInterviewbit(list));
        Arrays.stream(plusOne(new int[]{9, 9, 9, 9})).forEach(System.out::println);
    }

    private static ArrayList<Integer> plusOneInterviewbit(ArrayList<Integer> A) {
        while (A.size() > 0 && A.get(0) == 0) {
            A.remove(0);
        }

        if (A.size() == 0) {
            return new ArrayList<Integer>() {{
                add(1);
            }};
        }

        if (A.get(A.size() - 1) == 9) {
            for (int index = A.size() - 1; index != -1; index--) {
                if (A.get(index) != 9) {
                    A.set(index, A.get(index) + 1);
                    return A;
                } else {
                    A.set(index, 0);
                }
            }
        } else {
            A.set(A.size() - 1, A.get(A.size() - 1) + 1);
            return A;
        }

        int[] newDigits = new int[A.size() + 1];
        newDigits[0] = 1;

        ArrayList<Integer> arr = new ArrayList<>();
        Arrays.stream(newDigits).forEach(arr::add);

        return arr;
    }

    private static int[] plusOne(int[] digits) {
        for (int index = digits.length - 1; index != -1; index--) {
            if (digits[index] != 9) {
                digits[index] += 1;
                return digits;
            }

            digits[index] = 0;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;

        return newDigits;

    }
}
