public class BestTimeToBuyStock {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};

        int min = Integer.MAX_VALUE;

        int max;

        int maxProfit = 0;

        for (int index = 0;index<prices.length - 1;index++)
        {
            if (prices[index] < min)
            {
                min = prices[index];
            }

            for (int j = index + 1; j < prices.length; j++)
            {
                if (prices[j] > prices[index])
                {
                    max = prices[j];

                    if (max - min > maxProfit)
                    {
                        maxProfit = max - min;
                    }
                }
            }
        }

        int result = 0;
        int sum = 0;
        for (int index = 0;index<prices.length;index++) {
            sum = Math.max(sum, sum+prices[index]);
            result = Math.max(result, sum);
        }

        System.out.println(result);

        System.out.println(maxProfit);
    }
}