package RevisitingConcepts;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class isUnivalTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        /*root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);*/
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(isUnivalTree(root));
        System.out.println(zigZagLevelOrder(root));
    }

    private static List<List<Integer>> zigZagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Stack<TreeNode> leftToRight = new Stack<>();
        Stack<TreeNode> rightToLeft = new Stack<>();

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        leftToRight.push(root);

        List<List<Integer>> result = new ArrayList<>();

        while (!leftToRight.isEmpty() || !rightToLeft.isEmpty()) {
            while (!leftToRight.isEmpty()) {
                if (!right.isEmpty()) {
                    result.add(right);
                    right = new ArrayList<>();
                }

                TreeNode node = leftToRight.pop();
                left.add(node.val);

                if (node.left != null) {
                    rightToLeft.push(node.left);
                }
                if (node.right != null) {
                    rightToLeft.push(node.right);
                }
            }
            while (!rightToLeft.isEmpty()) {
                if (!left.isEmpty()) {
                    result.add(left);
                    left = new ArrayList<>();
                }

                TreeNode node = rightToLeft.pop();
                right.add(node.val);

                if (node.right != null) {
                    leftToRight.push(node.right);
                }
                if (node.left != null) {
                    leftToRight.push(node.left);
                }
            }
        }

        if (!left.isEmpty()) result.add(left);
        if (!right.isEmpty()) result.add(right);

        return result;
    }

    public static boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        return isUniValTree(root, root.val);
    }

    private static boolean isUniValTree(TreeNode root, int val) {
        if (root.val != val) {
            return false;
        }

        return (root.left == null || isUniValTree(root.left, val)) && (root.right == null || isUniValTree(root.right, val));
    }
}
