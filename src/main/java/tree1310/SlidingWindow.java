package tree1310;

public class SlidingWindow {
    public static void main(String[] args) {
        int window = 2;
        System.out.println(slidingWindow(new int[]{100,200,300,400}, window));
    }

    private static int slidingWindow(int[] nums, int window) {
        int result = 0;
        int sum = 0;
        for (int index = 0; index < nums.length; index++) {
            sum = sum + nums[index];
            if (index >= window) {
                sum = sum - nums[index - window];
                result = Math.max(result, sum);
            }
        }

        return result;
    }
}
