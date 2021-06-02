package tree;

public class ConstructTree {
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};

        TreeNode node = null;
        callFunc(nums, 0, nums.length, node);
    }

    private static void callFunc(int[] nums, int startIndex, int endIndex, TreeNode node) {
        int maxPosition = findMax(nums, startIndex, endIndex);

            if (startIndex == maxPosition && startIndex == 0)
            {
                node.left = new TreeNode(nums[0]);
            }
            else
            {
                if (node == null) {
                    node = new TreeNode(nums[maxPosition]);
                    callFunc(nums, startIndex, maxPosition, node);

                    int rightMax = findMax(nums, startIndex + 1, maxPosition);
                    if (maxPosition == rightMax)
                    {
                        node.right = new TreeNode(nums[rightMax]);
                    }
                    else
                    {
                        callFunc(nums, startIndex + 1, rightMax, node);
                    }

                } else {
                    node.left = new TreeNode(nums[maxPosition]);
                    callFunc(nums, startIndex, maxPosition, node.left);

                    int rightMax = findMax(nums, startIndex + 1, maxPosition);
                    if (endIndex == rightMax)
                    {
                        node.right = new TreeNode(nums[rightMax]);
                    }
                    else
                    {
                        callFunc(nums, startIndex + 1, rightMax, node);
                    }

                }
            }
    }

    private static int findMax(int[] nums, int startIndex, int endIndex) {
        int maxPosition = endIndex - 1;
        endIndex = endIndex - 1;
        while(endIndex >= startIndex)
        {
            if (nums[endIndex] > nums[maxPosition])
            {
                maxPosition = endIndex;
            }
            endIndex--;
        }
        return maxPosition;
    }
}

class TreeNode {
    public TreeNode left;
    public TreeNode right;
    private int val;
    public TreeNode(int val) {
        this.val = val;
    }
}