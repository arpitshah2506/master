public class NumPairsDivisibleBy60 {
    public static void main(String[] args) {
        int[] time = {15, 63, 451, 213, 37, 209, 343, 319};
        System.out.println(numPairsDivisibleBy60(time));
    }

    private static int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        int resMul;
        int j;
        for (int i = 0; i < time.length - 1; i++) {
            resMul = 60 - time[i];
            if (time[i] > 60) {
                resMul = ((time[i] / 60) + 1) - time[i];
            }
            for (j = i + 1; resMul < 500; j++) {
                if (time[j] == resMul + 60 * j) {
                    count = count + 1;
                }
                resMul = resMul + (j * 60);
            }

        }
        return count;
    }
}
