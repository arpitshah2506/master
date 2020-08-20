public class DistanceBetweenBusStops {
    public static void main(String[] args) {
        int[] distance = {7,10,1,12,11,14,5,0};
        int start = 7;
        int destination = 2;
        System.out.println(distanceBetweenBusStops(distance, start, destination));
    }

    private static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        for (int i = 0; i < distance.length; i++) {
            sum += distance[i];
        }

        int forwardSum = 0;
        int changeStart = start;
        if (start > destination)
        {
            changeStart = destination;
            destination = start;
        }

        for (int i = changeStart; i < destination; i++)
        {
            forwardSum += distance[i];
        }

        return Math.min(forwardSum, sum- forwardSum);
    }
}
