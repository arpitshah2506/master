package tree1310;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeBasicRecursion {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);

        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.right.right = new TreeNode(5);

        System.out.println(reinOrderTraversal(node));

        /*node.left.left.left = new TreeNode(6);
*/

        TreeNode node1 = new TreeNode(1);

        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);

        node1.left.left = new TreeNode(4);
        node1.left.right = new TreeNode(5);

        node1.left.left.left = new TreeNode(6);
        //node.left.left.right = new TreeNode(7);
        System.out.println(isSameTree(node, node1));
        System.out.println(inOrderTraversal(node));

        int[] nums = {1,2,3,4,5};
        System.out.println(sortedArrayToBST(nums));
    }

    private static List<Integer> reinOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) return list;
        recursionInorder(root, list);
        return list;
    }

    private static void recursionInorder(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            recursionInorder(root.left, list);
        }

        list.add(root.val);

        if (root.right != null) {
            recursionInorder(root.right, list);
        }
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return new TreeNode();

        int mid = nums.length / 2;

        TreeNode node = new TreeNode(nums[mid]);
        buildLeftTree(nums, 0, mid-1, node);
        buildRightTree(nums, mid+1, nums.length - 1, node);

        return node;
    }

    private static TreeNode buildRightTree(int[] nums, int start, int end, TreeNode node) {
        if (end < start) {
            return node;
        }

        node.right = new TreeNode(nums[start++]);
        return buildRightTree(nums, start, end, node.right);
    }

    private static TreeNode buildLeftTree(int[] nums, int start, int end, TreeNode node) {
        if (end < start) {
            return node;
        }

        node.left = new TreeNode(nums[end--]);
        return buildLeftTree(nums, start, end, node.left);
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null)
            return false;
        if (q == null && p != null)
            return false;
        if (p == null)
            return true;
        if (p.val != q.val)
            return false;

        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

    private static int findNumberOfNodes(TreeNode node) {
        return node == null ? 0 : 1 + findNumberOfNodes(node.left) + findNumberOfNodes(node.right);
    }

    private static int getMaximum(TreeNode node, int val) {
        return (node.left == null || node.right == null) ? val : Math.max(getMaximum(node.left, node.left.val), getMaximum(node.right, node.right.val));
    }

    private static List<List<Integer>> inOrderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> list = new LinkedList<>();
        List<List<Integer>> nodeList = new LinkedList<>();

        List<Integer> integerList = new ArrayList<>();
        integerList.add(root.val);
        nodeList.add(integerList);

        list.add(root);
        list.add(new TreeNode(Integer.MAX_VALUE));

        List<Integer> placeHolder = null;
        while (list.size() != 1) {
            root = list.poll();
            if (root.val == Integer.MAX_VALUE) {
                nodeList.add(placeHolder);
                placeHolder = new ArrayList<>();
                list.add(new TreeNode(Integer.MAX_VALUE));
            }

            if (root.left != null) {
                if (placeHolder == null) {
                    placeHolder = new ArrayList<>();
                }
                placeHolder.add(root.left.val);
                list.add(root.left);
            }

            if (root.right != null) {
                if (placeHolder == null) {
                    placeHolder = new ArrayList<>();
                }
                placeHolder.add(root.right.val);
                list.add(root.right);
            }
        }

        Collections.reverse(nodeList);

        return nodeList;
    }

    private static int countLeafNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return node.val;
        }
        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }
}