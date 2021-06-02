public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,3,4}));
    }

    private static int removeDuplicates(int[] nums) {
        if (nums == null) return 0;

        int pointer = 1;

        for (int index = 1; index < nums.length; index++) {
            if (nums[index] != nums[index - 1]) {
                nums[pointer] = nums[index];
                pointer++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        return pointer;
    }
}
