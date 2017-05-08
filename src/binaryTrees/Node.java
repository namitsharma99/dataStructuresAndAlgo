package binaryTrees;

public class Node implements Comparable<Node>{

	private Node parent, leftChild, rightChild;
	private String id;
	private int value;

	Node(Node parent, int val, String id) {
		this.setParent(parent);
		this.id = id;
		this.leftChild = this.rightChild = null;
		this.setValue(val);
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	// adding below method to trace it back to the root
	public Node getRoot() {
		if (null != parent) {
			return parent.getRoot();
		} else {
			return this;
		}
	}

	@Override
	public int compareTo(Node node) {

		// for ascending order
		return this.getValue() - node.getValue();
	}

}
