package RevisitingConcepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortArrayWithSquares {
    public static void main(String[] args) {
        System.out.println(sortWithSquares(new ArrayList<Integer>() {{
            add(-6);
            add(-3);
            add(-1);
            add(2);
            add(4);
            add(5);
        }}));
    }

    private static ArrayList<Integer> sortWithSquares(ArrayList<Integer> A) {
        if (A == null || A.size() == 0) return new ArrayList<>();

        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(new Integer[A.size()]));
        Collections.fill(result, 0);

        int leftPointer = 0;
        int rightPointer = A.size() - 1;
        int filledArray = 0;

        while (leftPointer <= rightPointer) {
            if (Math.abs(A.get(leftPointer)) > Math.abs(A.get(rightPointer))) {
                result.set(A.size() - 1 - filledArray, A.get(leftPointer) * A.get(leftPointer));
                leftPointer += 1;
            } else {
                result.set(A.size() - 1 - filledArray, A.get(rightPointer) * A.get(rightPointer));
                rightPointer -= 1;
            }
            filledArray += 1;
        }

        return result;
    }
}
