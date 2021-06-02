public class test {
    public static void main(String[] args) {
        System.out.println(recursionTest(6, 0));
        int index = 0;

        System.out.println(index++ + " " + index );
    }

    private static int recursionTest(int num, int sum) {
        //if (num == 0) return 0;
        if (num == 3) return 3;

        sum = num + recursionTest(num - 1, sum);
        //System.out.println(sum);

        return sum;
    }
}
