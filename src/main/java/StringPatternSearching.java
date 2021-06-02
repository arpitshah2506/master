public class StringPatternSearching {
    public static void main(String[] args) {
        String text = "AAAAAAAAAAAAAAAAAB";
        String pattern = "AAAAB";
/*

        for (int index = 0; index <= text.length() - pattern.length(); index++)
        {
            if (text.charAt(index) == pattern.charAt(0) &&
                    text.substring(index, index + pattern.length()).equalsIgnoreCase(pattern))
            {
                System.out.println(index);
                index = index + pattern.length();
            }
        }
*/

        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
    }

    public static int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            System.out.println("mid " + nums[mid] + " mid - 1 : " + nums[mid - 1]);
            System.out.println("mid " + nums[mid] + " mid + 1 : " + nums[mid + 1]);
            if (nums[mid] == nums[mid - 1]) {
                System.out.println("mid == mid - 1 condition - right : " + right + " mid : " + mid);
                if ((right - mid) % 2 == 0) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                System.out.println("mid == mid + 1 condition : " + (right - mid));
                if ((right - mid) % 2 == 0) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else {
                return nums[mid];
            }
        }

        return nums[left];

    }
}
