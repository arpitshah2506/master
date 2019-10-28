package TreeDemo;

import java.util.Objects;

public class InOrderTraversal {
//												25
//									15							50
//							10			22				35				70
//						4		12	18		24		31		44		66		90
// output : 4 12 10 18 24 22 15 31 44 35 66 90 70 50 25
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
		
		System.out.println("Inorder traversal");
		inOrderTraversal(root);
		System.out.println("\nPostOrder traversal");
		postOrdeerTraverstal(root);
		System.out.println("\nPreOrder traversal");
		preOrderTraverstal(root);
	}

	private static void preOrderTraverstal(Node root) {
		System.out.print(root.value + " ");
		if (Objects.nonNull(root.left)) {			
			preOrderTraverstal(root.left);
		}
		
		if (Objects.nonNull(root.right)) {
			preOrderTraverstal(root.right);
		}
	}

	private static void postOrdeerTraverstal(Node root) {
		if (Objects.nonNull(root.left)) {			
			postOrdeerTraverstal(root.left);
		}
		
		if (Objects.nonNull(root.right)) {
			postOrdeerTraverstal(root.right);
		}

		System.out.print(root.value + " ");
	}

	private static void inOrderTraversal(Node root) {
		if (Objects.nonNull(root.left)) {			
			inOrderTraversal(root.left);
		}
		
		System.out.print(root.value + " ");
		
		if (Objects.nonNull(root.right)) {
			inOrderTraversal(root.right);
		}
	}

}
