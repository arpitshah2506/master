package RevisitingConcepts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MaximumLengthofRepeatedSubarray {
    public static void main(String[] args) {
        findLength(new int[]{0, 1,1,1,1}, new int[]{1,0,1,0,1});
        findLengthOptimal(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7});
    }

    private static void findLength(int[] A, int[] B) {
        HashMap<Integer, List<Integer>> position = new HashMap<>();

        for (int i = 0; i < B.length; i++) {
            if (position.containsKey(B[i])) {
                position.get(B[i]).add(i);
            } else {
                List<Integer> positions = new ArrayList<>();
                positions.add(i);
                position.put(B[i], positions);
            }
        }

        int BstartIdx;
        int count;
        int maxCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (position.containsKey(A[i])) {
                for (int j = 0; j < position.get(A[i]).size(); j++) {
                    BstartIdx = position.get(A[i]).get(j);
                    count = 0;
                    for (int k = 0; k < A.length; k++) {
                        if (BstartIdx + k < B.length && i + k < A.length && B[BstartIdx + k] == A[i + k]) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    maxCount = Math.max(count, maxCount);
                }
            }
        }

        System.out.println(maxCount);
    }

    private static void findLengthOptimal(int[] A, int[] B)
    {
        int m = A.length, n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
            print(dp);
            }

        System.out.println(max);
    }

    private static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
