import java.util.Arrays;
import java.util.Collections;

public class InsertionSort {
    public static void main(String[] args) {
        Integer[] num = {12, 11, 13, 5, 6 };
        Arrays.sort(num, Collections.reverseOrder());
        insertionSort(num);
    }

    private static void insertionSort(Integer[] num) {
        //18,17,16,15,14,13,12,11
        int currentIndex;

        for (int index = 1; index < num.length; index++) {
            currentIndex = index;
            for (int j = currentIndex - 1; j >= 0; j--) {
                if (num[currentIndex] < num[j]) {
                    int temp = num[currentIndex];
                    num[currentIndex] = num[j];
                    num[j] = temp;
                    currentIndex -= 1;
                } else {
                    break;
                }
            }
        }

        Arrays.stream(num).forEach(System.out::println);
    }
}
