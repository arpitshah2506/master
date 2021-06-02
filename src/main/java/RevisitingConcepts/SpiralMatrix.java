package RevisitingConcepts;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        }));

        int n = 3;
        int[][] newSpiral = spiraOrderII(21);
    }

    private static int[][] spiraOrderII(int A) {
        int[][] matrix = new int[A][A];
        int topRow = 0, bottomRow = matrix.length - 1, startColumn = 0, endColumn = matrix[0].length - 1;
        int counter = 1;
        while (true) {
            for (int i = startColumn; i <= endColumn; i++) {
                matrix[topRow][i] = counter++;
            }
            topRow++;

            for (int i = topRow; i <= bottomRow; i++) {
                matrix[i][endColumn] = counter++;
            }
            endColumn--;
            if (topRow > bottomRow || endColumn < startColumn ) {
                break;
            }

            for (int i = endColumn; i >= startColumn; i--) {
                matrix[bottomRow][i] = counter++;
            }
            bottomRow--;
            if (topRow > bottomRow || endColumn < startColumn ) {
                break;
            }

            for (int i = bottomRow; i >= topRow; i--) {
                matrix[i][startColumn] = counter++;
            }
            startColumn++;
            if (topRow > bottomRow || endColumn < startColumn ) {
                break;
            }
        }
        //return list;

        ArrayList<ArrayList<Integer>> twoDArray = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            row = new ArrayList<>();
            for (int j = 0; j < matrix.length; j++) {
                row.add(matrix[i][j]);
            }
            twoDArray.add(row);
        }

        return matrix;
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }

        int topRow = 0, bottomRow = matrix.length - 1, startColumn = 0, endColumn = matrix[0].length - 1;
        while (true) {
            for (int i = startColumn; i <= endColumn; i++) {
                list.add(matrix[topRow][i]);
            }
            topRow++;

            for (int i = topRow; i <= bottomRow; i++) {
                list.add(matrix[i][endColumn]);
            }
            endColumn--;
            if (topRow > bottomRow || endColumn < startColumn ) {
                break;
            }

            for (int i = endColumn; i >= startColumn; i--) {
                list.add(matrix[bottomRow][i]);
            }
            bottomRow--;
            if (topRow > bottomRow || endColumn < startColumn ) {
                break;
            }

            for (int i = bottomRow; i >= topRow; i--) {
                list.add(matrix[i][startColumn]);
            }
            startColumn++;
            if (topRow > bottomRow || endColumn < startColumn ) {
                break;
            }
        }
        return list;
    }

}
