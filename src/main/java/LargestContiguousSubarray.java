public class LargestContiguousSubarray {
    public static void main(String[] args) {
        int[] arr = {-2,-3,4,-1,-2,1,5,-3};

        int sum = arr[0];

        int ans = arr[0];

        int start = 0,end = 0,i = 0;
        for (int index = 0;index < arr.length - 1; index++)
        {
            sum = sum + arr[index];

            if (sum < 0) {
                sum = 0;
                i = i + 1;
            } else if (ans < sum) {
                ans = sum;
                start = i;
                end = index;
            }
        }

        System.out.println(ans);

        System.out.println(start + " " + end);
    }
}
