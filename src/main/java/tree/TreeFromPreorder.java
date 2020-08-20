package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeFromPreorder {
    private static Integer[] preorder = new Integer[]{25,15,10,4,12,22,18,24,50,35,31,44,70,66,90};
    public static void main(String[] args) {

        Node root = constructBST(preorder, 0, preorder.length - 1);
        Node tree = createTree(preorder, preorder);
    }

    private static Integer[] findLesserElements(Integer element, Integer[] preorder) {
        ArrayList<Integer> greaterElements = new ArrayList<>();
        for (int index = 1;index < preorder.length && preorder[index] < element; index++) {
            greaterElements.add(preorder[index]);
        }

        Integer[] greaterElementsArr = new Integer[greaterElements.size()];
        greaterElements.toArray(greaterElementsArr);
        return greaterElementsArr;
    }

    private static Integer[] findGreaterElements(Integer element, Integer[] preorder) {
        List<Integer> greaterElements = new ArrayList<>();
        for (int index = 1;index < preorder.length && preorder[index] > element; index++) {
            greaterElements.add(preorder[index]);
        }

        Integer[] greaterElementsArr = new Integer[greaterElements.size()];
        greaterElements.toArray(greaterElementsArr);
        return greaterElementsArr;

    }

    static int index = 0;
    private static Node createTree(Integer[] lesserElements, Integer[] greaterElements) {
        if (lesserElements.length == 1) {
            return new Node(lesserElements[0]);
        }

        Node node = new Node(lesserElements[0]);

        Integer[] lesserElementsForNextTraversal = findLesserElements(lesserElements[0], lesserElements);
        Integer[] greaterElementsForNextTraversal = Arrays.copyOfRange(lesserElements, lesserElementsForNextTraversal.length + 1, lesserElements.length);

        index = index + 1;

        node.left = createTree(lesserElementsForNextTraversal, greaterElementsForNextTraversal);
        //root.right = createTree(root, lesserElementsForNextTraversal, greaterElementsForNextTraversal);

        return node;
    }

    public static Node constructBST(Integer[] preorder, int start, int end)
    {
        if (start > end) {
            return null;
        }

        Node node = new Node(preorder[start]);

        int i;
        for (i = start; i <= end; i++) {
            if (preorder[i] > node.value) {
                break;
            }
        }

        node.left = constructBST(preorder, start + 1, i - 1);
        /*node.right = constructBST(preorder, i, end);*/

        return node;
    }


    public static class Node {
        public Integer value;
        Node left;
        Node right;

        Node(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
