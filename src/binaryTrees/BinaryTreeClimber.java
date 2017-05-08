package binaryTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeClimber {

	static List<Node> ls = new ArrayList<Node>();
	static boolean flag = false;

	public static void main(String[] args) {

		// Populating the node values
		int rootVal = 2;
		int rootLC1 = 4;
		int rootRC2 = 6;
		int rootLC1LC1 = 8;
		int rootLC1RC2 = 10;
		int rootRC2LC1 = 12;
		int rootRC2RC2 = 14;

		// Setting up the tree
		Node rootNode = new Node(null, rootVal, "root");

		Node rootLC1Node = new Node(rootNode, rootLC1, "rootLC1");
		rootNode.setLeftChild(rootLC1Node);

		Node rootLC1LC1Node = new Node(rootLC1Node, rootLC1LC1, "rootLC1LC1");
		rootLC1Node.setLeftChild(rootLC1LC1Node);

		Node rootLC1RC2Node = new Node(rootLC1Node, rootLC1RC2, "rootLC1RC2");
		rootLC1Node.setRightChild(rootLC1RC2Node);

		Node rootRC2Node = new Node(rootNode, rootRC2, "rootRC2");
		rootNode.setRightChild(rootRC2Node);

		Node rootRC2LC1Node = new Node(rootRC2Node, rootRC2LC1, "rootRC2LC1");
		rootRC2Node.setLeftChild(rootRC2LC1Node);

		Node rootRC2RC2Node = new Node(rootRC2Node, rootRC2RC2, "rootRC2RC2");
		rootRC2Node.setRightChild(rootRC2RC2Node);

		// Reading the tree nodes.
		System.out.println("Reading the binary tree now :");
		depthFirstTraversal(rootNode, "-");

		// Checking the array for how it looks now...
		for (Node node : ls) {
			System.out.println("Node Id: " + node.getId() + " & Node Value: "
					+ node.getValue());
		}

		// Checking the array and the tree for how it looks after sorting...
		Node newRoot = balanceTheTree(ls);
		for (Node node : ls) {
			System.out.println("Node Id: " + node.getId() + " & Node Value: "
					+ node.getValue());
		}
		depthFirstTraversal(newRoot, "+");

		// Now the tree has been balanced, search effort has been reduced
		// considerably
		int srchElem = 11;
		boolean elementPresent = searchTheElement(newRoot, srchElem);
		if (elementPresent)
			System.out.println(srchElem + " is present in the BT.");
		else
			System.out.println(srchElem + " is not present in the BT.");

		// Trying to add an element in the tree, and keeping the sorting order
		int newElement = 9;
		Node newNode = new Node(null, newElement, "newNode");
		newRoot = addNewNode(newRoot, newNode);
		depthFirstTraversal(newRoot, "+"); // checking the order, post update
	}

	private static Node addNewNode(Node node, Node newNode) {

		System.out.println("Traversing the tree before adding a new node...");
		depthFirstTraversal(node, "-"); // This method is not only traversing,
										// but updating the list as well

		int index = -1;
		for (int i = 0; i < ls.size(); i++) {
			if (ls.get(i).getValue() > newNode.getValue()) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			ls.add(newNode); // This means that all the elements are small in
								// the list, hence adding the newNode in the end
		} else {
			ls.add(index, newNode);
		}

		System.out.println("Checking the list -- ");
		for (Node node2 : ls) {
			System.out.println(node2.getValue());
		}

		return balanceTheTree(ls);
	}

	private static boolean searchTheElement(Node node, int srchElem) {

		if (node != null) {
			if (srchElem == node.getValue()) {
				flag = true;
			} else {
				if (srchElem < node.getValue()) {
					searchTheElement(node.getLeftChild(), srchElem);
				} else {
					searchTheElement(node.getRightChild(), srchElem);
				}
			}
		}
		return flag;
	}

	private static Node balanceTheTree(List<Node> ls) {
		Collections.sort(ls);
		return buildBalancedTree(ls, 0, ls.size() - 1);

	}

	private static Node buildBalancedTree(List<Node> ls, int start, int end) {

		if (start > end)
			return null;

		int mid = (start + end) / 2;
		Node node = ls.get(mid);

		node.setLeftChild(buildBalancedTree(ls, start, mid - 1));
		node.setRightChild(buildBalancedTree(ls, mid + 1, end));

		return node;

	}

	private static void depthFirstTraversal(Node node, String result) {
		System.out.println(result + node.getValue());
		ls.add(node);

		Node nodeLeftElem = node.getLeftChild();
		if (null != nodeLeftElem)
			depthFirstTraversal(nodeLeftElem, result + result);

		Node nodeRightElem = node.getRightChild();
		if (null != nodeRightElem)
			depthFirstTraversal(nodeRightElem, result + result);
	}

}
