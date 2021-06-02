public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0,0,1,1,1,2,2,3,1,4}, 1)); //{0,0,1,1,1,2,2,3,1,4} --> 1
    }

    private static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)  return 0;

        int pointer = 0;

        for (int num : nums) {
            if (num != val) {
                nums[pointer] = num;
                pointer++;
            }
        }

        return pointer;
    }
}
