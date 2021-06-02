package RevisitingConcepts;

public class ReshapeMatrix {
    public static void main(String[] args) {
        matrixReshape(new int[][]{{1,2},{3,4}},1,4);
    }

    private static int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r * c != nums.length * nums[0].length) return nums;

        int[][] newMatrix = new int[r][c];

        int newR = 0;
        int newC = 0;
        int totalElementInserted = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                newMatrix[newR][newC] = nums[i][j];
                totalElementInserted = totalElementInserted + 1;
                newC = newC + 1;
                if (totalElementInserted % c == 0) {
                    newR = newR + 1;
                    newC = 0;
                }
            }
        }

        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[0].length; j++) {
                System.out.println(newMatrix[i][j]);
            }
        }
        return newMatrix;
    }
}
