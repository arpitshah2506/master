public class ArrayRankTransform {
    public static void main(String[] args) {
        arrayRankTransform(new int[]{37,12,28,9,100,56,80,5,12});
    }

    private static int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0)  return arr;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int n : arr) {
            minVal = Math.min(minVal, n);
            maxVal = Math.max(maxVal, n);
        }
        int[] ranks = new int[maxVal - minVal + 1];
        for (int n : arr)
            ranks[n - minVal] = 1;
        int sum = 0;
        for (int i = 0; i < ranks.length; i++) {
            sum += ranks[i];
            ranks[i] = sum;
        }
        for (int i = arr.length - 1; i >= 0; i--)
            arr[i] = ranks[arr[i] - minVal];
        return arr;
    }
}
