package TreeDemo;

import java.util.Objects;

public class TreeUtil {
    public void preOrderTraverstal(Node root) {
        System.out.print(root.value + " ");
        if (Objects.nonNull(root.left)) {
            preOrderTraverstal(root.left);
        }

        if (Objects.nonNull(root.right)) {
            preOrderTraverstal(root.right);
        }
    }

    public void postOrdeerTraverstal(Node root) {
        if (Objects.nonNull(root.left)) {
            postOrdeerTraverstal(root.left);
        }

        if (Objects.nonNull(root.right)) {
            postOrdeerTraverstal(root.right);
        }

        System.out.print(root.value + " ");
    }

    public void inOrderTraversal(Node root) {
        if (Objects.nonNull(root.left)) {
            inOrderTraversal(root.left);
        }

        System.out.print(root.value + " ");

        if (Objects.nonNull(root.right)) {
            inOrderTraversal(root.right);
        }
    }

}