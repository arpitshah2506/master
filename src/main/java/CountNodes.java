public class CountNodes {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);

        System.out.println(countNodes(node));
    }

    private static int countNodes(TreeNode node) {
        if (node == null) return 0;

        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}
