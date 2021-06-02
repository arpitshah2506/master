package RevisitingConcepts;

public class MinCostClimbingStairsRepeat {
    public static void main(String[] args) {
        minCostClimbingStairs(new int[]{99, 100, 2, 3, 5, 5, 4});

    }

    private static void minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = cost[i] + Math.min(cost[i - 1], cost[i - 2]);
        }

        for (int i = 0; i < cost.length; i++) {
            System.out.println(cost[i]);
        }
    }
}
