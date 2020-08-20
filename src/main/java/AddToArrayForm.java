import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AddToArrayForm {
    public static void main(String[] args) {
        int[] A = {0};
        int K = 10000;
        System.out.println(addToArrayForm(A, K));
    }

    private static List<Integer> addToArrayForm(int[] A, int K) {
        int carry = 0;

        int result = 0;

        List<Integer> integers = new LinkedList<>();
        for (int i = A.length - 1; i > -1; i--) {
            result = (K + carry) % 10;

            integers.add((result + A[i]) % 10 >= 0 ? ((result + A[i]) % 10) : result + A[i]);

            carry = (result + A[i]) / 10;

            K = K / 10;
        }

        if (carry > 0)
        {
            integers.add(carry);
        }

        if (K > 0)
        {
            integers.add(K);
        }
        Collections.reverse(integers);
        return integers;
    }
}
