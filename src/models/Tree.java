package models;


import javax.swing.JOptionPane;

public class Tree {

	private Node root;
	private Node newRoot;

	public void add(Node node) {
		if (root != null) {
			add(root, node);
		}else {
			root = node;
		}
	}

	private void add(Node base, Node newNode) {
		if (newNode.getInformation() < base.getInformation()) {
			if (base.getLeft() != null) {
				add(base.getLeft(), newNode);
			}else {
				base.setLeft(newNode);
			}
		}else {
			if (base.getRight() != null) {
				add(base.getRight(), newNode);
			}else {
				base.setRight(newNode);
			}
		}
	}

	public void balanceLL() {
		JOptionPane.showMessageDialog(null, "Balance LL");
		if(root.getLeft() != null) {
			if(root.getLeft().getRight() != null) {
				newRoot = root.getLeft();
				root.setLeft(root.getLeft().getRight());
				root.getLeft().setLeft(newRoot);
				root.getLeft().getLeft().setRight(null);
				root.getLeft().getLeft().setLeft(null);
			}else {
				newRoot = root;
				root = root.getLeft();
				root.setRight(newRoot);
				root.getRight().setLeft(null);
			}
		}else if(root.getRight().getRight() != null) {
			newRoot = root;
			root = root.getRight();
			root.setLeft(newRoot);
			newRoot.setRight(null);
			root.getRight().setRight(null);
			root.getRight().setLeft(null);
		}
	}

	public void balanceRR() {
		JOptionPane.showMessageDialog(null, "Balance RR");
		if(root.getRight() != null) {
			if(root.getRight().getLeft() != null) {
				newRoot = root.getRight();
				root.setRight(root.getRight().getLeft());
				root.getRight().setRight(newRoot);
				root.getRight().getRight().setRight(null);
			}else {
				newRoot = root;
				root = root.getRight();
				root.setLeft(newRoot);
				root.getLeft().setRight(null);

			}
		}else if(root.getLeft().getLeft() != null) {
			newRoot = root;
			root = root.getLeft();
			root.setRight(newRoot);
			newRoot.setRight(null);
			root.getRight().setRight(null);
			root.getRight().setLeft(null);
		}
	}

	public void balance() {
		if(root.getLeft() != null && root.getLeft().getLeft() == null && root.getLeft().getRight() != null) {
			JOptionPane.showMessageDialog(null, "Balance LR");
			balanceLR();
		}else if(root.getRight() != null && root.getRight().getLeft() != null && root.getRight().getRight() == null) {
			JOptionPane.showMessageDialog(null, "Balance RL");
			balanceRL();
		}else if(root.getRight() != null){
			balanceRR();
		}else if(root.getLeft().getLeft() != null) {
			balanceLL();
		}
	}

	private void balanceRL() {
		balanceRR();
		balanceLL();
	}

	public void balanceLR() {
		balanceLL();
		balanceRR();
	}

	public int getDepth(Node root) throws Exception {
		if(getMax(root) > getMin(root)) {
			return getMax(root);
		}else {
			return getMin(root);
		}
	}

	public Node getRoot() {
		return root;
	}
	
	public int getMax(Node node) throws Exception {
		int heigt = 0;
		Node current = node;
		if(root != null) {
			while (current.getRight() != null) {
				current = current.getRight();
				heigt ++;
			}
			return heigt;
		}else {
			throw new Exception("the tree is void");
		}
	}

	public int getMin(Node node) throws Exception {
		int heigt = 0;
		Node current = node;
		if(root != null) {
			while (current.getLeft() != null) {
				current = current.getLeft();
				heigt ++;
			}
			return heigt;
		}else {
			throw new Exception("the tree is void");
		}
	}
}