package tree1310;

public class LeafSimilar {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);

        node.left = new TreeNode(2);

        TreeNode node1 = new TreeNode(1);

        //node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);

        System.out.println(leafSimilar(node, node1));
    }

    private static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return leafSimilarWrapper(root1).equalsIgnoreCase(leafSimilarWrapper(root2));
    }

    private static String leafSimilarWrapper(TreeNode root1) {
        if (root1 == null) {
            return "";
        }

        if (root1.left == null && root1.right == null) {
            return root1.val + ",";
        }

        return leafSimilarWrapper(root1.left) + leafSimilarWrapper(root1.right);
    }
}
