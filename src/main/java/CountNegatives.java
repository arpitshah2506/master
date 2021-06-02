public class CountNegatives {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {5,1,0},{-5,-5,-5}
        };

        System.out.println(countNegatives(grid));
    }

    private static int countNegatives(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] < 0) {
                result += grid[i].length;
            } else {
                int left = 0;
                int right = grid[i].length - 1;
                //5,4,3,2,-1,-2,-3,-4,-5,-6,-7
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (grid[i][mid] >= 0) left = mid + 1;
                    else right = mid - 1;
                }
                result += (grid[i].length - 1 - right);
            }

        }

        return result;
    }
}
