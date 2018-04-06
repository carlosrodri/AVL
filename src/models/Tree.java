package models;

public class Tree {

	private Node root;

	public void add(Node node) {
		if (root != null) {
			add(root, node);
		}else {
			root = node;
		}
	}

	public Node getRoot() {
		return root;
	}
}