package trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeClimber {

	static Queue<Node> queue = new LinkedList<Node>();

	public static void main(String[] args) {

		// Once node class is in place, your are good to create a tree
		Node rootNode = new Node(null);
		rootNode.setId("root");

		Node childNode1 = createChild(rootNode, "child 1");
		Node childNode11 = createChild(childNode1, "Child 11");
		createChild(childNode11, "Child 111");
		createChild(childNode11, "Child 112");
		Node childNode12 = createChild(childNode1, "Child 12");
		createChild(childNode12, "Child 121");
		createChild(childNode12, "Child 122");

		Node childNode2 = createChild(rootNode, "child 2");
		Node childNode21 = createChild(childNode2, "Child 21");
		createChild(childNode21, "Child 211");
		createChild(childNode21, "Child 212");
		Node childNode22 = createChild(childNode2, "Child 22");
		createChild(childNode22, "Child 221");
		createChild(childNode22, "Child 222");

		System.out.println("Depth First Traversal --> ");
		depthFirstTraversal(rootNode, "-");

		System.out.println("Breadth First Traversal --> ");
		queue.add(rootNode);
		breadthFirstTraversal();

	}

	private static Node createChild(Node parent, String id) {
		Node node = new Node(parent);
		node.setId(id);
		parent.getChildren().add(node);
		return node;
	}

	// Pending using stack
	private static void depthFirstTraversal(Node node, String result) {
		System.out.println(result + node.getId());
		for (Node nodeElem : node.getChildren()) {
			depthFirstTraversal(nodeElem, result + result);
		}
	}

	private static int breadthFirstTraversal() {

		Queue<Node> tempQueue = new LinkedList<Node>(queue);
		if (tempQueue.isEmpty())
			return 0;
		queue.clear();
		while (!tempQueue.isEmpty()) {
			Node nodeInQueue = tempQueue.poll();
			System.out.print(" - " + nodeInQueue.getId() + " -");
			queue.addAll(nodeInQueue.getChildren());
		}
		System.out.println(" ");
		breadthFirstTraversal();
		return 1;
	}

	// Pending shortest paths
	// Pending find min and max heights
}
