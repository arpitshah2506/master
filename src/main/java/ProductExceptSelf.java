public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] ints = productExceptSelf(new int[]{4, 5, 1, 8, 2, 10, 6});
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    private static int[] productExceptSelf(int[] nums) {
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                product = product * nums[i];
            }
        }

        int sum;
        int count;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            count = 1;

            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                while (sum != product) {
                    sum = sum + nums[i];
                    ++count;
                }

                result[i] = count;
            }
        }
        return result;
    }
}
