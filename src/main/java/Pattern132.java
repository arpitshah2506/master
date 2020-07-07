public class Pattern132 {
    public static void main(String[] args) {
        int[] nums = {-1, 3, 2, 0};

        int firstBiggerElementIndex = 0; //5
        int secondBiggerElementIndex = 0; //2
        int traversedIndex = 0;
        int count = 0;
        for (int currentIndex = 0; currentIndex < nums.length - 2; currentIndex++) {
            while (firstBiggerElementIndex != Integer.MIN_VALUE || secondBiggerElementIndex != Integer.MIN_VALUE) {
                firstBiggerElementIndex = findBiggerElement(traversedIndex, currentIndex, nums); //to check how much we accomplished, which element to compare
                if (firstBiggerElementIndex != Integer.MIN_VALUE) {
                    secondBiggerElementIndex = nextBiggerElement(firstBiggerElementIndex, currentIndex, nums);
                    if (secondBiggerElementIndex != Integer.MIN_VALUE) {
                        count = count + 1;
                    }
                    traversedIndex = firstBiggerElementIndex;

                }
            }
        }

        System.out.println(count);
    }

    private static int nextBiggerElement(int firstBiggerElementIndex, int currentIndex, int[] nums) {
        if (firstBiggerElementIndex < nums.length - 2) {
            for (int i = firstBiggerElementIndex + 1; i < nums.length; i++) {
                if (nums[i] < nums[firstBiggerElementIndex] && nums[currentIndex] < nums[i]) {
                    return i;
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    private static int findBiggerElement(int traversedIndex, int currentIndex, int[] num) {
        for (int i = traversedIndex + 1; i < num.length; i++) {
            if (num[currentIndex] < num[i]) {
                return i;
            }
        }

        return Integer.MIN_VALUE;
    }
}
