public class TreeConstruction {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);

        inorderTraversal(root);
        System.out.println("----------dive--------");
        preorderTraversal(root);

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode treeNode = new TreeNode(preorder[0]);
        buildTree(preorder, inorder, 0, inorder.length, 0, treeNode);
    }

    private static int searchInInorder(int element, int[] inorder) {
        for (int index = 0; index < inorder.length; index++) {
            if (inorder[index] == element) {
                return index;
            }
        }
        return 0;
    }

    private static void inorderTraversal(TreeNode root) {
        if (root.left != null) inorderTraversal(root.left);
        System.out.println(root.val);
        if (root.right != null) inorderTraversal(root.right);
    }

    private static void preorderTraversal(TreeNode root) {
        System.out.println(root.val);
        if (root.left != null) preorderTraversal(root.left);
        if (root.right != null) preorderTraversal(root.right);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder, int left, int right, Integer currentPreorderIndex, TreeNode treeNode) {
        if (currentPreorderIndex == 0) {
            treeNode = new TreeNode(preorder[0]);
        }

        if (left == right && currentPreorderIndex != 0) {
            return null;
        }

        TreeNode node = new TreeNode(inorder[searchInInorder(preorder[currentPreorderIndex + 1], inorder)]);
        treeNode.left = buildTree(preorder, inorder, left, searchInInorder(preorder[currentPreorderIndex + 1], inorder), currentPreorderIndex + 1, node);
        if (currentPreorderIndex != 0) {
            treeNode.right = buildTree(preorder, inorder, searchInInorder(preorder[currentPreorderIndex + 1], inorder), searchInInorder(preorder[currentPreorderIndex], inorder), currentPreorderIndex + 1, node);
        }
        else {
            treeNode.right = buildTree(preorder, inorder, searchInInorder(preorder[currentPreorderIndex + 1], inorder), right, currentPreorderIndex + 1, node);
        }

        return treeNode;
    }
}
