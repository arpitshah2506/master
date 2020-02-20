package tree;

import TreeDemo.Node;
import TreeDemo.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeToBinarySearchTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        insertNode(2, root);
        insertNode(3, root);
        insertNode(4, root);
        insertNode(5, root);
        insertNode(6, root);
        insertNode(7, root);
        insertNode(10, root);
        insertNode(9, root);

        TreeUtil tree = new TreeUtil();
        tree.inOrderTraversal(root);
        System.out.println("\n\n\n");
        tree.preOrderTraverstal(root);

        binaryTreeToBinarySearchTree(root);
    }

    private static void binaryTreeToBinarySearchTree(Node root) {

    }

    public static void insertNode(int value, Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (queue.isEmpty() == false) {
            Node poll = queue.poll();
            if (poll.left == null) {
                poll.left = new Node(value);
                queue.clear();
                break;
            } else {
                if (poll.right == null) {
                    poll.right = new Node(value);
                    queue.clear();
                    break;
                } else {
                    queue.add(poll.left);
                    queue.add(poll.right);
                }
            }
        }
    }
}