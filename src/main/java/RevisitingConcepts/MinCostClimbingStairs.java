package RevisitingConcepts;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1,2,3,1}));
    }

    private static int minCostClimbingStairs(int[] cost) {
        if (cost.length < 4 && cost[0] + cost[2] > cost[1]) {
                return cost[1];
        }

        int startIndex;
        int expectedSoFar;
        int secondaryResultSoFar;

        if (cost[0] > cost[1])
        {
            startIndex = 1;
            expectedSoFar = cost[1];
            secondaryResultSoFar = cost[0];
        }
        else
        {
            startIndex = 0;
            expectedSoFar = cost[0];
            secondaryResultSoFar = cost[1];
        }

        int temp1;
        int temp2;

        int endIndex = cost.length;
        int result = 0;

        while (startIndex + 1 < endIndex && startIndex + 2 < endIndex) {
            if (expectedSoFar + cost[startIndex + 1] > expectedSoFar + cost[startIndex + 2])
            {
                temp1 = expectedSoFar + cost[startIndex + 2];
                startIndex = startIndex + 2;
            }
            else
            {
                temp1 = expectedSoFar + cost[startIndex + 1];
                startIndex = startIndex + 1;
            }

            if (secondaryResultSoFar + cost[startIndex + 1] > secondaryResultSoFar + cost[startIndex + 2])
            {
                temp2 = secondaryResultSoFar + cost[startIndex + 2];
                startIndex = startIndex + 2;
            }
            else
            {
                temp2 = secondaryResultSoFar + cost[startIndex + 1];
                startIndex = startIndex + 1;
            }
            result = result + Math.min(temp1, temp2);
        }

        return result + cost[startIndex];
    }
}
