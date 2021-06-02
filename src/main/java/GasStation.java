import java.util.HashSet;
import java.util.Set;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {4};
        int[] cost = {5};

        System.out.println(canCompleteCircuit(gas, cost));
    }

    private static int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 1 && gas[0] >= cost[0]) return 0;

        Set<Integer> validPoints = new HashSet<>();
        int diff = 0;
        int notedIndex = Integer.MIN_VALUE;

        for (int index = 0; index < gas.length; index++) {
            if (cost[index] < gas[index]) {
                validPoints.add(index);
                if (gas[index] - cost[index] > diff) {
                    diff = gas[index] - cost[index];
                    notedIndex = index;
                }
            }
        }

        if (notedIndex == Integer.MIN_VALUE) {
            return -1;
        }

        int noOfTraversedNode = 1;
        int startPoint = notedIndex;
        int remainingGas = gas[startPoint] - cost[startPoint];

        while (noOfTraversedNode < gas.length) {
            startPoint += 1;
            if (startPoint == gas.length) {
                startPoint = 0;
            }

            remainingGas = remainingGas + gas[startPoint] - cost[startPoint];
            if (remainingGas < 0) {
                break;
            }

            noOfTraversedNode += 1;
        }

        if (noOfTraversedNode == gas.length) {
            return notedIndex;
        }

        validPoints.remove(notedIndex);
        if (validPoints.size() > 0) {
            for (Integer index:validPoints) {
                noOfTraversedNode = 1;
                startPoint = index;
                remainingGas = gas[startPoint] - cost[startPoint];

                while (noOfTraversedNode < gas.length) {
                    startPoint += 1;
                    if (startPoint == gas.length) {
                        startPoint = 0;
                    }

                    remainingGas = remainingGas + gas[startPoint] - cost[startPoint];
                    if (remainingGas < 0) {
                        break;
                    }

                    noOfTraversedNode += 1;
                }

                if (noOfTraversedNode == gas.length) {
                    return index;
                }
            }
        }

        return -1;
    }
}
