public class CanThreePartsEqualSum {
    public static void main(String[] args) {
        int[] A = {18,12,-18,18,-19,-1,10,10};
        System.out.println(canThreePartsEqualSum(A));
    }

    private static boolean canThreePartsEqualSum(int[] A) {
        int start;
        int end;
        int mid;
        int sumFromMid;
        int sum = 0;
        int sumFromEnd;
        boolean isSumFound = false;
        for (start = 0; start < A.length - 2; start++) {
            if (isSumFound == false) {
                sumFromEnd = 0;
                sumFromMid = 0;
                sum = sum + A[start];
                for (end = A.length - 1; end > 2; end--) {
                    if (end == start) break;
                    sumFromEnd = sumFromEnd + A[end];
                    if (sumFromEnd == sum) {
                        mid = start + 1;
                        while (mid < end) {
                            sumFromMid = sumFromMid + A[mid];
                            mid++;
                        }
                        if (sum != sumFromMid) {
                            break;
                        }
                        return true;
                    }
                }
            } else {
                break;
            }
        }
        return false;
    }
}
