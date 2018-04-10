package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.Node;
import models.Tree;
import views.WindowTree;

public class Controller implements ActionListener{

	private Tree tree;
	private WindowTree window;

	public Controller() {
		tree = new Tree();
//		tree.add(new Node(10));
//		tree.add(new Node(7));
//		tree.add(new Node(5));
		
		window = new WindowTree(this);
		window.paintTree(tree.getRoot());
	}

	public static void main(String[] args) {
		new Controller();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("ADD")) {
			tree.add(new Node(Integer.valueOf(JOptionPane.showInputDialog("id"))));
			try {
				System.out.println(tree.getDepth(tree.getRoot()) + "<<<<<<<heigt of root");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else{
			tree.balance();
		} 
		System.out.println(tree.getRoot().getInformation()+"  infromacion del nodo cabeza");
		window.paintTree(tree.getRoot());
	}
}