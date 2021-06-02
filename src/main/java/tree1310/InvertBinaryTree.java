package tree1310;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);

        node.left = new TreeNode(2);
        node.right = new TreeNode(7);

        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);

        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(5);

        invertTree(node);
        System.out.println(node);
    }

    private static TreeNode invertTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        //operation
        if (root.left != null && root.right != null) {
            int swap = root.left.val;
            root.left.val = root.right.val;
            root.right.val = swap;
        }

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
