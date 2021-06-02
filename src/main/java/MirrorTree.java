public class MirrorTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        p.left.left = new TreeNode(4);
        p.left.right = new TreeNode(5);

        TreeNode q = new TreeNode(1);

        isMirror(p, q);
        System.out.println("Hello world");
    }

    private static void isMirror(TreeNode p, TreeNode q) {
        if (p == null) return;

        if (p.left == null && p.right == null) {
            return;
        }

        if (p.left != null) {
            q.right = new TreeNode(p.left.val);
        }

        if (p.right != null) {
            q.left = new TreeNode(p.right.val);
        }

        isMirror(p.left, q.right);
        isMirror(p.right, q.left);
    }
}
