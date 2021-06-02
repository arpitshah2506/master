public class UnivaluePath {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);

        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        inorderTraversal(root, root.val);
    }

    private static void inorderTraversal(TreeNode root, int val) {
        System.out.println(root.val);

        if (root.left != null)
        {
            if (root.left.val == root.val)
            {
                
            }
            inorderTraversal(root.left, root.val);
        }

        if (root.right != null)
        {
            inorderTraversal(root.right, root.val);
        }
    }
}
