package RevisitingConcepts;

public class KthPositive {
    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{1,2,3,4}, 2));
    }

    private static int findKthPositive(int[] arr, int k) {
        int startCounter = 1;
        int missingNumberCounter = 0;

        for (int i = 0; i < arr.length; i++) {
            while (startCounter != arr[i]) {
                missingNumberCounter += 1;
                if (missingNumberCounter == k) {
                    return startCounter;
                }
                startCounter += 1;
            }
            startCounter = startCounter + 1;
        }

        return arr[arr.length - 1] + (k - missingNumberCounter);
    }
}
