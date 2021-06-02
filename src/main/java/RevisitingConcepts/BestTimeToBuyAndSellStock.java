package RevisitingConcepts;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,5,4,3,2,1}));
    }

    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxProfit = 0;
        int profitSoFar = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                profitSoFar = Math.max(profitSoFar, prices[i] - min); //0, 4 => 4, 2
            }
        }
        return Math.max(maxProfit, profitSoFar);
    }
}
