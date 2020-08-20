public class MonotonicArray {
    public static void main(String[] args) {
        int[] A = {1, 2, 2, 1};
        System.out.println(isMonotonic(A));
    }

    private static boolean isMonotonic(int[] A) {
        int flg = 0;

        //find first different element
        int index = 0;
        while (index < A.length - 1) {
            if (flg == 0) {
                if (A[index] > A[index + 1]) {
                    flg = 1;
                    break;
                } else if (A[index] < A[index + 1]) {
                    flg = -1;
                    break;
                }
            }
            index++;
        }

        if (flg == 0) {
            return true;
        }

        for (; index < A.length - 1; index++) {
            if (flg == 1 && A[index] < A[index + 1]) {
                return false;
            } else if (flg == -1 && A[index] > A[index + 1]) {
                return false;
            }
        }
        return true;
    }
}
