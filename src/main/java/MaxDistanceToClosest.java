public class MaxDistanceToClosest {
    public static void main(String[] args) {
        int[] nums = {0,1};
        System.out.println(maxDistanceToClosest(nums));
    }

    private static int maxDistanceToClosest(int[] seats) {
        // find max distance between two seats
        int r = 0, l = 0;
        boolean isFirstDistanceSet = false;
        int distance = 0;
        while (r < seats.length) {
            if (seats[r] == 1) {
                if (isFirstDistanceSet == false) {
                    distance = r;
                    isFirstDistanceSet = true;
                } else if ((r - l) / 2 > distance) {
                    distance = Math.max(distance, (r - l) / 2);
                }

                l = r;
            }
            r++;
        }

        if (seats.length - 1 - l > distance) {
            return seats.length - 1 - l;
        }
        return distance;

    }
}
