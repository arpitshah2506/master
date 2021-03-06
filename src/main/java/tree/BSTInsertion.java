package tree;

import TreeDemo.Node;
import TreeDemo.TreeUtil;

/*
                            10
             5                               20
        4       7
                    8
*/
public class BSTInsertion {
    public static void main(String[] args) {
        TreeDemo.Node root = new TreeDemo.Node(10);

        insertElement(root, 20);
        insertElement(root, 5);
        insertElement(root, 4);
        insertElement(root, 7);
        insertElement(root, 8);
        insertElement(root, 9);

        TreeUtil treeUtil = new TreeUtil();
        System.out.println("\nInorder traversal : left root right");
        treeUtil.inOrderTraversal(root);
        System.out.println("\nPost order traversal : left right root");
        treeUtil.postOrdeerTraverstal(root);
        System.out.println("\nPreOrder traversal : root left right");
        treeUtil.preOrderTraverstal(root);

        findNodeWithMinimumValues(root);
        findNodeWithMinimumValuesUsingRecursion(root);
        //findNoOfSubTrees(root);
    }

    private static void findNodeWithMinimumValuesUsingRecursion(Node node) {
        if (node.left != null) {
            findNodeWithMinimumValuesUsingRecursion(node.left);
        } else {
            System.out.println("\n\n Min value using recursion: " + node.value);
        }
    }

    private static void findNodeWithMinimumValues(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        System.out.println("\n\n Min value : " + node.value);
    }

    private static void insertElement(TreeDemo.Node root, int value) {
        if (root.getValue() > value) {
            TreeDemo.Node node = new TreeDemo.Node(value);
            if (root.getLeft() != null) {
                insertElement(root.getLeft(), value);
            } else {
                root.setLeft(node);
            }
        } else {
            TreeDemo.Node node = new TreeDemo.Node(value);
            if (root.getRight() != null) {
                insertElement(root.getRight(), value);
            } else {
                root.setRight(node);
            }
        }
    }
}
