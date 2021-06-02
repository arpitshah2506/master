import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(checkForSymmatricity(root));
    }

    private static boolean checkForSymmatricity(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null)
        {
            return true;
        }

        if (root.left != null && root.right != null)
        {
            if (root.left.val == root.right.val)
            {
                queue.add(root.left);
                queue.add(root.right);
            }
            else
            {
                return false;
            }
        }
        else
        {
            if (root.left != null && root.right == null || root.left == null && root.right != null)
            {
                return false;
            }
        }


        while (queue.size() != 0)
        {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();

            if (leftNode.left != null && rightNode.right != null)
            {
                if (leftNode.left.val == rightNode.right.val)
                {
                    queue.add(leftNode.left);
                    queue.add(rightNode.right);
                }
                else
                {
                    return false;
                }
            }
            else
            {
                if (leftNode.left ==  null && rightNode.right != null || leftNode.left != null && rightNode.right == null)
                {
                    return false;
                }
            }

            if (leftNode.right != null && rightNode.left != null)
            {
                if (leftNode.right.val == rightNode.left.val)
                {
                    queue.add(leftNode.right);
                    queue.add(rightNode.left);
                }
                else
                {
                    return false;
                }
            }
            else
            {
                if (leftNode.right == null && rightNode.left != null || leftNode.right != null && rightNode.left == null)
                {
                    return false;
                }
            }
        }
        return true;
    }
}

class TreeNode {
    public TreeNode left;
    public TreeNode right;
    int val;

    public TreeNode(int value) {
        this.val = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + val +
                '}';
    }
}