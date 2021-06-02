package tree1310;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);

        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.right = new TreeNode(5);

        binaryTreePaths(node);
    }

    private static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();

        if (root == null) {
            return paths;
        }

        if (root.left == null && root.right == null) {
            paths.add(String.valueOf(root.val));
        } else {
            binaryTreePathsWrapper(root.left, paths, root.val + "->");
            binaryTreePathsWrapper(root.right, paths, root.val + "->");
        }
        System.out.println(paths);
        return paths;
    }

    private static List<String> binaryTreePathsWrapper(TreeNode root, List<String> paths, String s) {
        if (root != null) {
            s = s.concat(Integer.toString(root.val)).concat("->");

            if (root.left == null && root.right == null) {
                s = s.substring(0, s.length() - 2);
                paths.add(s);
            }

            if (root.left != null) {
                binaryTreePathsWrapper(root.left, paths, s);
            }

            if (root.right != null) {
                binaryTreePathsWrapper(root.right, paths, s);
            }
        }

        return paths;
    }
}
