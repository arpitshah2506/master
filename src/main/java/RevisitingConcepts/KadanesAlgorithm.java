package RevisitingConcepts;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        kadanesAlgo(new int[]{-2, -3, 4, -1, -2, 1, 5, -3});

        kadanesAlgoWithPositiveNumber(new int[]{-2, -3, 4, -1, -2, 1, 5, -3});
    }

    private static void kadanesAlgoWithPositiveNumber(int[] nums) {
        int currentSoFar = 0;
        int max = 0;

        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSoFar = currentSoFar+nums[i];
            if (currentSoFar < 0) {
                currentSoFar = 0;
                start = i + 1;
            } else if (max < currentSoFar) {
                max = currentSoFar;
                end = i;
            }
        }

        System.out.println(max);

        System.out.println(start + " " + end);
    }

    private static void kadanesAlgo(int[] nums) {
        int currentSoFar = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSoFar = Math.max(nums[i], nums[i]+currentSoFar);
            max = Math.max(currentSoFar, max);
        }

        System.out.println(max);
    }
}
