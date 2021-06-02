package tree1310;

public class MaxDepth
{
    private static final int UNBALANCED = -99;

    public static void main(String[] args)
    {
        TreeNode node = new TreeNode(1);

        node.left = new TreeNode(2);
        node.right = new TreeNode(2);

        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(3);

        node.left.left.left = new TreeNode(4);
        node.left.left.right = new TreeNode(4);

        System.out.println(isBalanced(node));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getHeight(root) != UNBALANCED;
    }

    private static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = getHeight(root.left);
        int r = getHeight(root.right);

        return 1 + Math.max(l,r);
    }}

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val)
    {
        this.val = val;
    }

    public TreeNode() {

    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}