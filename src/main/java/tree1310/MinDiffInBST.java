package tree1310;

public class MinDiffInBST {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(27);

        node.right = new TreeNode(34);
        node.right.right = new TreeNode(58);
        node.right.right.left = new TreeNode(50);
        node.right.right.left.right = new TreeNode(44);

        System.out.println(minDiffInBST(node));
    }

    private static int minDiffInBST(TreeNode root) {
        int leftDiff = Integer.MAX_VALUE;
        if (root.left == null) {
            leftDiff = Integer.MAX_VALUE;
        }
        else {
            leftDiff = Math.min(leftDiff, Math.min(Math.abs(root.val - root.left.val),
                    minDiffInBST(root.left)));
        }

        int rightDiff = Integer.MAX_VALUE;
        if (root.right == null) {
            rightDiff = Integer.MAX_VALUE;
        } else {
            rightDiff = Math.min(rightDiff,Math.min(Math.abs(root.val - root.right.val),
                    minDiffInBST(root.right)));
        }

         return Math.min(leftDiff, rightDiff);
    }
}
