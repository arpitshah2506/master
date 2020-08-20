public class FindNumbers {
    public static void main(String[] args) {
        System.out.println(findNumbers(new int[]{12,345,2,6,7896}));
    }

    private static int findNumbers(int[] nums) {
        int count = 0;
        int divisior = nums[0];

        for (int i = 0; i < nums.length; i++) {
            while (divisior != 0) {
                divisior = nums[i] / 10;
                count++;
            }
            if (count % 2 == 1) {

            }
        }
        return 0;
    }
}
