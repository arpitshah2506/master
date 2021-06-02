package tree1310;

public class SumRootToLeaf {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);

        node.left = new TreeNode(0);
        node.right = new TreeNode(1);

        node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(1);

        node.right.left = new TreeNode(0);
        //node.right.right = new TreeNode(1);

        System.out.println(sumRootToLeaf(node, ""));
    }

    private static int sumRootToLeaf(TreeNode root, String s) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return Integer.parseInt(s + root.val, 2);
        }

        return sumRootToLeaf(root.left, s + root.val) + sumRootToLeaf(root.right, s + root.val);
    }
}
