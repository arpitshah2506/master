package RevisitingConcepts;

import java.util.Arrays;
import java.util.Comparator;

public class CheckStraightLine {
    public static void main(String[] args) {
        System.out.println(checkStraightLine(new int[][]{{2, 1}, {4, 2}, {6, 3}}));
    }

    private static boolean checkStraightLine(int[][] coordinates) {
        if (coordinates[0][0] == coordinates[1][0]) {
            for (int i = 0; i < coordinates.length; i++) {
                if (coordinates[i][0] != coordinates[0][0]) {
                    return false;
                }
            }
            return true;
        }

        if (coordinates[0][1] == coordinates[1][1]) {
            for (int i = 0; i < coordinates.length; i++) {
                if (coordinates[i][1] != coordinates[0][1]) {
                    return false;
                }
            }
            return true;
        }

        double m = (coordinates[1][1] - coordinates[0][1]) / (double)(coordinates[1][0] - coordinates[0][0]);
        int c = (int) (coordinates[0][1] - (m * coordinates[0][0]));

        for (int i = 0; i < coordinates.length; i++) {
            if (m * coordinates[i][0] + c != (double)coordinates[i][1]) {
                return false;
            }
        }
        return true;
    }
}
