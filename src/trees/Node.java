package trees;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private String id; // for node identification
	private List<Node> children = new ArrayList<Node>(); // array of children
	private Node parent; // the parent node

	public Node(Node parent) {
		this.parent = parent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	public Node getParent() {
		return parent;
	}

	// no need for parent setter while creating new node, since constructor
	// takes care of that
	// doesn't it depict real world; for constructing a child, parent is
	// required... LOL
	// here it means parent is passed into the parameterised constructor, for
	// instantiating child
	// Although the below setter is required, when the abandoned children have
	// to be taken care of, when a node is deleted

	public void setParent(Node parent) {
		this.parent = parent;
	}

	// adding below method to trace it back to the root
	public Node getRoot() {
		if (null != parent) {
			return parent.getRoot();
		} else {
			return this;
		}
	}

	// adding below method delete a node
	public void deleteNode() {
		if (null != parent) {
			// getting to know what is the index of the current node in the
			// 'list of the children' of parent
			int idx = this.parent.getChildren().indexOf(this);
			// removing the current node from the parent's 'list of the
			// children'
			this.parent.getChildren().remove(this);
			// now taking care of the abandoned children
			for (Node child : this.getChildren()) {
				child.setParent(this.getParent());
			}
			this.parent.getChildren().addAll(idx, this.getChildren());
			this.getChildren().clear();
		}
	}

	public Node deleteRootNode() throws Exception {
		if (null != this.getParent()) {
			throw new Exception(
					"Root node can only be deleted by the root node itself!");
		}
		Node newRoot = null;
		if (null != this.getChildren() && !this.getChildren().isEmpty()) {
			newRoot = getChildren().get(0);
			newRoot.setParent(null);
			this.getChildren().remove(0);
			for (Node node : this.getChildren()) {
				node.setParent(newRoot);
			}
			newRoot.getChildren().addAll(this.getChildren());
		}
		this.getChildren().clear();
		return newRoot;
	}

}
