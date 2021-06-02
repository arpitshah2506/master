package RevisitingConcepts;

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 7, 6, 3, 5, 8}));
    }

    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }

        int profitSoFar = 0;
        int profitForEachInterval = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i-1]) {
                min = prices[i];
                profitSoFar = profitSoFar + profitForEachInterval;
                profitForEachInterval = 0;
            } else {
                profitForEachInterval = prices[i] - min;
            }
        }
        return profitSoFar + profitForEachInterval;
    }
}
