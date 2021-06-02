import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{186, 419, 83, 408},6249));
    }

    private static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        ArrayList<Integer> coinList = new ArrayList<>(coins.length);
        Arrays.stream(coins).forEach(coinList::add);
        coinList.sort(Comparator.reverseOrder());

        int tempAmount;
        int totalCoins;

        for (int pos = 0; pos < coins.length; pos++) {
            totalCoins = 0;
            tempAmount = amount;
            if (coinList.get(pos) > tempAmount) continue;
            totalCoins += tempAmount / coinList.get(pos);
            tempAmount = tempAmount % coinList.get(pos);

            if (tempAmount == 0) {
                return totalCoins;
            }
            for (int index = pos + 1; index < coins.length; index++) {
                if (coinList.get(index) > tempAmount) continue;
                totalCoins += tempAmount / coinList.get(index);
                tempAmount = tempAmount % coinList.get(index);

                if (tempAmount == 0) {
                    return totalCoins;
                }
            }
        }
        return -1;
    }
}
