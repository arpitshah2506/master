package tree1310;

public class RangeSumBST {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);

        node.left = new TreeNode(5);
        node.right = new TreeNode(15);

        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(7);

        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(18);

        node.left.left.left = new TreeNode(1);
        node.left.right.left = new TreeNode(6);

        System.out.println(rangeSumBST(node, 6, 10, 0));
    }

    private static int rangeSumBST(TreeNode root, int L, int R, int sum) {
        if (root == null) {
            return 0;
        }

        if (root.val >= L && root.val <= R) {
            sum = root.val;
        } else sum = 0;

        if (root.left == null && root.right == null) {
            return sum;
        }

        return sum + rangeSumBST(root.left, L, R, sum) + rangeSumBST(root.right, L, R, sum);
    }
}
