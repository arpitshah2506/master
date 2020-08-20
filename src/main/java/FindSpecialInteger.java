public class FindSpecialInteger {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        System.out.println(findSpecialInteger(arr));
    }

    private static int findSpecialInteger(int[] arr) {
        if (arr.length == 0) return 0;

        int currentCount = 0;
        int i;
        for (i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                currentCount = 0;
            }
            currentCount++;
            if (currentCount == (arr.length / 4) + 1) {
                return arr[i];
            }
        }
        return arr[i];
    }
}
