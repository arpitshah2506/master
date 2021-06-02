package tree1310;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);

        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
/*
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);*/

        System.out.println(diameterOfBinaryTree(node, 0));
    }

    private static int diameterOfBinaryTree(TreeNode root, int count) {
        if (root.left != null) {
            ++count;
            diameterOfBinaryTree(root.left, count);
        }

        if (root.right != null) {
            ++count;
            diameterOfBinaryTree(root.right, count);
        }

        return count;
    }
}
