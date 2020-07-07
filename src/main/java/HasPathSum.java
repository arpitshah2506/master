public class HasPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        if (root == null)
        {
            //return true;
        }
        System.out.println(func(root, 22));
        System.out.println(hasPathSum(root, 22));
    }

    private static boolean func(TreeNode root, int target) {
        if (target - root.val == 0 && root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null) {
            return func(root.left, target - root.val);
        }

        if (root.right != null) {
            return func(root.right, target - root.val);
        }
        return false;
    }

    private static boolean hasPathSum(TreeNode node, int sum)
    {
        if (node == null)
            return sum == 0;
        boolean left = hasPathSum(node.left, sum - node.val);
        boolean right = hasPathSum(node.right, sum - node.val);

        System.out.println("node : " + node + ", node.left : " + node.left + "node.right : " + node.right + " val : " + (sum-node.val));
        System.out.println("left : " + left);
        System.out.println("right : " + right);

        return left || right;
    }
}
