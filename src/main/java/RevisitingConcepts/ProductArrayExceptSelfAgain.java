package RevisitingConcepts;

public class ProductArrayExceptSelfAgain {
    public static void main(String[] args) {
        productArrayExceptSelf(new int[]{5,6,7,8});
        productArrayExceptSelfWithConstantSpace(new int[]{5,6,7,8});
    }

    private static void productArrayExceptSelfWithConstantSpace(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }

        int R = 1;
        for (int i = nums.length-1; i >=0; i--) {
            result[i] = result[i] * R;
            R = R * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static void productArrayExceptSelf(int[] nums) {
        int[] rightProduct = new int[nums.length];
        int[] leftProduct = new int[nums.length];

        leftProduct[0] = 1;
        rightProduct[nums.length-1] = 1;

        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i-1] * nums[i-1];
        }

        for (int i = nums.length-2; i != -1; i--) {
            rightProduct[i] = rightProduct[i+1] * nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = rightProduct[i] * leftProduct[i];
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


}
