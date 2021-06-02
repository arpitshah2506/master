package RevisitingConcepts;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,2,4,2,3}));
    }

    private static int findDuplicate(int[] nums) {
        int slowPointer = nums[0];//1, 2, 4,
        int fastPointer = nums[nums[0]];//2, 3, 4,

        while (slowPointer != fastPointer) {
            System.out.println(slowPointer + " " + fastPointer);
            slowPointer = nums[slowPointer];
            fastPointer = nums[nums[fastPointer]];
        }

        int headPointer = 0;

        while (slowPointer != headPointer) {
            slowPointer = nums[slowPointer];
            headPointer = nums[headPointer];
        }

        return slowPointer;
    }
}
