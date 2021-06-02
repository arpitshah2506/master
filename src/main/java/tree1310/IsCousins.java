package tree1310;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsCousins {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);

        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.right = new TreeNode(4);
        node.right.right = new TreeNode(5);

        System.out.println(isCousins(node, 3, 4));
    }

    private static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> list = new LinkedList<>();

        List<Integer> integerList = new ArrayList<>();
        integerList.add(root.val);

        list.add(root);
        list.add(new TreeNode(Integer.MAX_VALUE));

        int count = 0;
        while (list.size() != 1) {
            root = list.poll();
            if (root.val == Integer.MAX_VALUE) {
                if (count == 1) {
                    return false;
                } else if (count == 2) {
                    return true;
                }
                list.add(new TreeNode(Integer.MAX_VALUE));
            }

            if (root.left != null && root.right != null) {
                if ((root.left.val == x && root.right.val == y) ||
                        (root.left.val == y && root.right.val == x)) {
                    return false;
                }
            }

                if (root.left != null) {
                    if (root.left.val == x || root.left.val == y) {
                        count++;
                    }
                    list.add(root.left);
                }

                if (root.right != null) {
                    if (root.right.val == x || root.right.val == y) {
                        count++;
                    }
                    list.add(root.right);
                }
            }
        return false;
        }
    }
