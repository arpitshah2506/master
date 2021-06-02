package RevisitingConcepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetZeroes {
    public static void main(String[] args) {
        setZeroes(new int[][]{
                {1,1,1},{1,0,1},{1,1,1}
        });
    }

    private static void setZeroes(int[][] matrix) {
        List<Integer> zeroRow = new ArrayList<>();
        List<Integer> zeroColumn = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == 0) {
                    zeroRow.add(row);
                    zeroColumn.add(column);
                }
            }
        }

        if (zeroRow.size() > 0) {
            for (int i = 0; i < zeroRow.size(); i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[zeroRow.get(i)][j] = 0;
                }
            }

            for (int i = 0; i < zeroColumn.size(); i++) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][zeroColumn.get(i)] = 0;
                }
            }
        }

        Arrays.stream(matrix).forEach(x -> Arrays.stream(x).forEach(System.out::println));
    }
}
