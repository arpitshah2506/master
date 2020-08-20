import java.util.Arrays;

public class SortedSquares {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        System.out.println(sortedSquares(nums));
    }

    private static int[] sortedSquares(int[] A) {
        if (A == null) return new int[]{};

        for (int i = 0; i<A.length;i++) {
            A[i] = (int) Math.pow(A[i],2);
        }

        Arrays.sort(A);
        return A;
    }
}
