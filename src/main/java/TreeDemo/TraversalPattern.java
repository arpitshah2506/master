package TreeDemo;

public class TraversalPattern {
//												25
//									15							50
//							10			22				35				70
//						4		12	18		24		31		44		66		90
	public static void main(String[] args) {
		Node root = new Node(25);
		root.left = new Node(15);
		root.right = new Node(50);

		root.left.left = new Node(10);
		root.left.right = new Node(22);

		root.right.left = new Node(35);
		root.right.right = new Node(70);

		root.left.left.left = new Node(4);
		root.left.left.right = new Node(12);
		
		root.left.right.left = new Node(18);
		root.left.right.right = new Node(24);
		
		root.right.left.left = new Node(31);
		root.right.left.right = new Node(44);

		root.right.right.left = new Node(66);
		root.right.right.right = new Node(90);

		TreeUtil treeUtil = new TreeUtil();
		System.out.println("\nInorder traversal : left root right");
		treeUtil.inOrderTraversal(root);
		System.out.println("\nPost order traversal : left right root");
		treeUtil.postOrdeerTraverstal(root);
		System.out.println("\nPreOrder traversal : root left right");
		treeUtil.preOrderTraverstal(root);
	}
}