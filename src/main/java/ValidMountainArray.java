public class ValidMountainArray {
    public static void main(String[] args) {
        int[] A = {5,6,7,8,9};
        System.out.println(validaMountainArray(A));
    }

    private static boolean validaMountainArray(int[] A) {
        if (A.length <3) {
            return false;
        }
        int i = 1;
        for (; i<A.length; i++) {
            if (A[i-1] > A[i]) {
                break;
            } else if (A[i-1] == A[i]) {
                return false;
            }
        }

        if (i == 1 || i == A.length) {
            return false; //mountain not decreasing
        }

        for (; i < A.length - 1;i++) {
            if (A[i] <= A[i+1]) {
                return false;
            }
        }
        return true;
    }
}
