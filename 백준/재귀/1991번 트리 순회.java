import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	Node nodes[];

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		nodes = new Node[n];
		for (int i = 0; i < n; i++) {
			nodes[i] = new Node((char) ('A' + i));
		}

		for (int i = 0; i < n; i++) {
			Node node = nodes[scan.next().charAt(0) - 'A'];

			char left = scan.next().charAt(0);
			if (left != '.')
				node.left = nodes[left - 'A'];

			char right = scan.next().charAt(0);
			if (right != '.')
				node.right = nodes[right - 'A'];
		}
		
		preOrder(nodes[0]);
		System.out.println();
		inOrder(nodes[0]);
		System.out.println();
		postOrder(nodes[0]);
		System.out.println();
	}

	public void preOrder(Node node) {
		if (node == null) {
			return;
		}
		
		System.out.print(node.name);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void inOrder(Node node) {
		if (node == null) {
			return;
		}
		
		inOrder(node.left);
		System.out.print(node.name);
		inOrder(node.right);
	}
	
	public void postOrder(Node node) {
		if (node == null) {
			return;
		}
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.name);
	}

	class Node {
		char name;
		Node left;
		Node right;

		Node(char key) {
			this.name = key;
		}
	}
}
