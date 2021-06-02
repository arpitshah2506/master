package RevisitingConcepts;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        maxArea(new int[]{2,3,4,5,18,17,6});
    }

    private static void maxArea(int[] height) {
        //whichever is less increment it by 1
        //whichever is higher calculate the area
        int lo = 0;
        int hi = height.length - 1;
        int area = Integer.MIN_VALUE;
        int currentArea;
        
        while (lo < hi) {
            currentArea = (hi - lo) * Math.min(height[hi], height[lo]);//9*1
            if (currentArea > area) {
                area = currentArea;
            }

            if (height[lo] > height[hi]) {
                hi--;
            } else {
                lo++;
            }
        }

        System.out.println(area);
    }
}
