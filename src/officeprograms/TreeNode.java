package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {

	int value;

	TreeNode left;

	TreeNode right;

	TreeNode parent;

	int height;

	TreeNode() {

	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public TreeNode getPredessor() {
		return predessor;
	}

	public void setPredessor(TreeNode predessor) {
		this.predessor = predessor;
	}

	TreeNode successor;

	TreeNode predessor;

	public TreeNode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	private static TreeNode next;

	public TreeNode TreeMaximum(TreeNode n) {

		while (n.getRight() != null)
			n = n.getRight();
		return n;
	}

	public TreeNode getInorderPredessor(TreeNode x) {

		if (x.getLeft() != null)
			return TreeMaximum(x.getLeft());
		TreeNode parent = x.getParent();
		while (parent != null && x == parent.getLeft()) {
			x = parent;
			parent = parent.getParent();
		}
		return parent;
	}

	public void populateInorderSuccessor(TreeNode root) {

		if (root != null) {

			populateInorderSuccessor(root.getRight());
			root.setSuccessor(next);
			next = root;
			populateInorderSuccessor(root.getLeft());
		}

	}

	// O(nlogn)
	public static void inorderTraversal(TreeNode n) {

		if (n == null)
			return;
		inorderTraversal(n.getLeft());
//		n.setPredessor(getInorderPredessor(n));
//		if (n.getPredessor() != null) {
//			System.out.println("Predessor of Node n::" + n.getValue() + " is "
//					+ n.getPredessor().getValue());
//		} else
//			System.out.println("Predessor of Node n::" + n.getValue()
//					+ " is  null");
		System.out.println(n.value);
		inorderTraversal(n.getRight());

	}

	public int countNumberOfNodes(TreeNode n) {
		if (n == null)
			return 0;
		return 1 + countNumberOfNodes(n.getLeft())
				+ countNumberOfNodes(n.getRight());

	}

	public static int staticDistance = -1;

	public static void findDistanceOfNodeFromRoot(TreeNode root, TreeNode node,
			int distance) {

		// if (root != null) {
		if (root.getLeft() != null) {
			if (root.getLeft().getValue() == node.getValue()) {
				staticDistance = distance + 1;
				return;
			} else
				findDistanceOfNodeFromRoot(root.getLeft(), node, distance + 1);
		}
		if (root.getRight() != null)
			if (root.getRight().getValue() == node.getValue()) {
				staticDistance = distance + 1;
				return;
			} else
				findDistanceOfNodeFromRoot(root.getRight(), node, distance + 1);
		// }
	}

	public TreeNode getSuccessor() {
		return successor;
	}

	int getHeightOfNode(TreeNode n) {
		if (n == null)
			return 0;
		n.setHeight(1 + Math.max(n.getHeightOfNode(n.getLeft()),
				n.getHeightOfNode(n.getRight())));
		return -1;
	}

	public void setSuccessor(TreeNode successor) {
		this.successor = successor;
	}

	// O(h) = logn
	public TreeNode findSuccessor(TreeNode x) {

		if (x.getRight() != null) {
			return findMinumum(x.getRight());
		}
		TreeNode y = x.getParent();
		while (y != null && x == y.getRight()) {
			x = y;
			y = y.getParent();
		}
		return y;
	}

	// O(h)
	public TreeNode findMinumum(TreeNode x) {
		while (x.getLeft() != null) {
			x = x.getLeft();
		}
		return x;

	}

	public static int heightOfTree;

	public static boolean isTreeBalanced(TreeNode node) {
		int subTreeHeight;
		if (node == null)
			return true;
		heightOfTree = findHeightOfTree(node);
		System.out.println("Height of a tree ::" + heightOfTree);
		subTreeHeight = balanceTree(node.getLeft(), 1);
		if (subTreeHeight != heightOfTree)
			return false;
		subTreeHeight = balanceTree(node.getRight(), 1);
		if (subTreeHeight != heightOfTree)
			return false;
		return true;
	}

	public static int balanceTree(TreeNode node, int count) {
		if (node != null) {
			if (node.getLeft() == null && node.getRight() == null) {
				if (count != heightOfTree - 1)
					return -1;
			}
			int temp = balanceTree(node.getLeft(), count + 1);
			if (temp == -1)
				return -1;
			temp = balanceTree(node.getRight(), count + 1);
			if (temp == -1)
				return -1;
		}
		return heightOfTree;

	}

	public static void createLinkedListAtEachDepth(TreeNode node) {

		Queue<TreeNode> q = new LinkedList<TreeNode>();

		TreeNode delimeter = new TreeNode(-99);

		LinkedList<TreeNode> treeNodeList = new LinkedList<TreeNode>();
		// treeNodeList.add(node);

		ArrayList<LinkedList<TreeNode>> arrayList = new ArrayList<LinkedList<TreeNode>>();

		TreeNode temp = null;

		q.add(node);

		q.add(delimeter);

		// while (!q.isEmpty()) {
		//
		// temp = q.remove();
		// System.out.println(temp.value);
		// treeNodeList.add(temp);
		//
		// if (temp == delimeter) {
		// arrayList.add(treeNodeList);
		// treeNodeList = new LinkedList<TreeNode>();
		// q.add(delimeter);
		// continue;
		// }
		//
		// if (temp.left != null) {
		// q.add(temp.left);
		// }
		// if (temp.right != null) {
		// q.add(temp.right);
		// }
		// }

		while (!q.isEmpty()) {
			temp = q.remove();

			// System.out.println(temp.value);
			if (temp == delimeter) {
				arrayList.add(treeNodeList);
				treeNodeList = new LinkedList<TreeNode>();
				if (q.peek() != null) {
					q.add(delimeter);
					continue;
				}
			}
			treeNodeList.add(temp);

			// level = getLevelOfNode(rootNode, temp);
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		}

		for (int i = 0; i < arrayList.size(); i++) {
			Iterator<TreeNode> tnIter = arrayList.get(i).iterator();
			System.out.println("Linked list at level" + i);
			while (tnIter.hasNext()) {
				TreeNode n = tnIter.next();
				System.out.println(n.value);
			}
		}
	}

	public void breadthFirstTree(TreeNode rootNode) {

		if (rootNode == null)
			return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode temp = null;
		q.add(rootNode);

		while (!q.isEmpty()) {
			temp = q.remove();
			System.out.println(temp.getValue());

			if (temp.getLeft() != null) {
				q.add(temp.getLeft());

			}
			if (temp.getRight() != null) {
				q.add(temp.getRight());
			}

		}

	}

	public static int findHeightOfTree(TreeNode node) {

		if (node == null)
			return 0;
		return 1 + Math.max(findHeightOfTree(node.getLeft()),
				findHeightOfTree(node.getRight()));
	}

	public void BFSUsingQueue(TreeNode n) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		while (n != null) {

		}
	}

	// For each node it calls the method to get the level of the node
	// for n nodes it will call the method n times - O(n*n)
	public static void printAllTheNodesFromLeftHandSide(TreeNode rootNode) {

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Map<Integer, TreeNode> hashMap = new HashMap<Integer, TreeNode>();

		TreeNode temp = null;
		int level;

		if (rootNode == null) {
			return;
		}

		q.add(rootNode);

		while (!q.isEmpty()) {
			temp = q.remove();
			level = getLevelOfNode(rootNode, temp);
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
			if (hashMap.get(level) == null) {
				hashMap.put(level, temp);
				System.out.println(temp.value);
			}
		}

	}

	// This is the optimal code which gets the node and checks whether
	// any of the node from that level has already been printed or not.
	// Uses the delimeter node to check the level change
	public static void printAllTheNodesFromLeftWithDelimeterNode(
			TreeNode rootNode) {

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Map<Integer, TreeNode> hashMap = new HashMap<Integer, TreeNode>();

		TreeNode temp = null;
		int level;

		if (rootNode == null) {
			return;
		}
		TreeNode delimeter = new TreeNode(-1);
		q.add(rootNode);
		q.add(delimeter);
		level = 0;
		while (!q.isEmpty()) {
			temp = q.remove();
			if (temp == delimeter) {
				level = level + 1;
				q.add(delimeter);
				continue;
			}

			// level = getLevelOfNode(rootNode, temp);
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);

			if (hashMap.get(level) == null) {
				hashMap.put(level, temp);
				System.out.println(temp.value);
			}
		}

	}

	public static int getLevelOfNode(TreeNode root, TreeNode node) {
		if (root != null) {
			if (root.value == node.value)
				staticDistance = 0;
			else
				TreeNode.findDistanceOfNodeFromRoot(root, node, 0);
		}
		return staticDistance;
	}

	public static void printKDistanceDown(TreeNode node, int k) {

		if (node == null || k == 0)
			return;
		// System.out.println(node.value);
		list.add(node.value);
		printKDistanceDown(node.left, k - 1);
		printKDistanceDown(node.right, k - 1);

	}

	static int printKDistanceUp(TreeNode root, TreeNode node, int k) {
		if (root == null)
			return -1;
		if (root == node)
			return 0;
		int left = printKDistanceUp(root.left, node, k);
		int right = printKDistanceUp(root.right, node, k);
		if (left >= 0 && left < k) {
			list.add(root.value);
			printKDistanceDown(root.right, k - left - 1);
			return left + 1;
		}
		if (right >= 0 && right < k) {
			list.add(root.value);
			printKDistanceDown(root.left, k - right - 1);
			return right + 1;
		}
		return -1;

	}

	public static List<Integer> list = new ArrayList<Integer>();

	public static void printKDistanceNodes(TreeNode root, TreeNode node, int k) {

		if (root == null)
			return;
		// Print the nodes which are k Distance from left child of a node
		printKDistanceDown(node.left, k);
		// Print the nodes which are k Distance from right child of a node
		printKDistanceDown(node.right, k);
		printKDistanceUp(root, node, k);

	}

	public static void printTheLevelAtWhichTheBinaryTreeIsComplete(TreeNode node) {

		if (node == null) {
			System.out.println("The tree is empty.");
			System.out.println("-1");
		}
		int level = 0;
		TreeNode delimeter = new TreeNode(-1);
		TreeNode temp = null;
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(node);
		q.add(delimeter);

		while (!q.isEmpty()) {
			temp = q.remove();
			if (temp == delimeter) {
				level += 1;
				q.add(delimeter);
				continue;
			}
			if (temp.left != null && temp.right != null) {
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			} else {
				break;
			}

		}
		System.out.println("At level " + level + " the Tree is balanced.");
	}

	static Stack<TreeNode> stack = new Stack<TreeNode>();
	static Stack<TreeNode> temp = new Stack<TreeNode>();
	static int total = 0;

	static void sum(TreeNode n, int sum) {
		if (n.left == null && n.right == null) {
			// System.out.println(n.value + " --" + sum);
			if (sum > total) {
				temp = new Stack<TreeNode>();
				total = sum;
				// System.out.println(stack);
				temp.addAll(stack);
				temp.push(n);
			}
			return;
		}
		stack.push(n);
		if (n.left != null)
			sum(n.left, sum + n.left.value);
		if (n.right != null)
			sum(n.right, sum + n.right.value);
		stack.pop();
	}

	// static Stack<TreeNode> st = new Stack<TreeNode>();
	static int isNodeFound = 0;
	static Stack<TreeNode> pathQueue = new Stack<TreeNode>();

	// static Object[] sourceArr = new Object() ;
	// static Object[] destinationArr;
	public static void findPath(TreeNode n, int value) {

		if (isNodeFound == 0) {
			if (n == null)
				return;

			pathQueue.push(n);
			findPath(n.left, value);
			findPath(n.right, value);
			if (n.value == value) {
				isNodeFound = 1;
				return;
			} else {
				if (isNodeFound == 0)
					pathQueue.pop();
			}

		}

	}

	//
	// public static TreeNode commomAncestor(TreeNode root, TreeNode n1,
	// TreeNode n2) {
	//
	// if (root == null || n1 == null || n2 == null)
	// return null;
	//
	// if (findPath(root, n1) == null)
	// return false;
	//
	// return null;
	//
	// }

	public static TreeNode buildTreeFromPreorderInorder(List<Integer> preOrder,
			List<Integer> inOrder) {

		TreeNode node = null;

		List<Integer> leftPreOrder;

		List<Integer> rightPreOrder;

		List<Integer> leftInorder;

		List<Integer> rightInorder;

		int inorderPos;

		int preorderPos;

		if ((preOrder.size() != 0) && (inOrder.size() != 0)) {
			node = new TreeNode(preOrder.get(0).intValue());

			inorderPos = inOrder.indexOf(preOrder.get(0));
			leftInorder = inOrder.subList(0, inorderPos);
			rightInorder = inOrder.subList(inorderPos + 1, inOrder.size());

			preorderPos = leftInorder.size();
			leftPreOrder = preOrder.subList(1, preorderPos + 1);
			rightPreOrder = preOrder.subList(preorderPos + 1, preOrder.size());
			node.left = buildTreeFromPreorderInorder(leftPreOrder, leftInorder);
			node.right = buildTreeFromPreorderInorder(rightPreOrder,
					rightInorder);
		}

		return node;

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(40);

		TreeNode ln1, ln2, ln3, ln4, ln5, ln6, ln7, ln31;
		TreeNode rn1, rn2, rn3, rn4, rn5, rn6, rn7, rn8;

		ln1 = new TreeNode(30);
		ln2 = new TreeNode(20);
		ln3 = new TreeNode(39);
		ln31 = new TreeNode(40);

		ln4 = new TreeNode(10);
		ln5 = new TreeNode(25);

		ln6 = new TreeNode(37);
		ln7 = new TreeNode(33);

		rn1 = new TreeNode(50);
		rn2 = new TreeNode(47);
		rn3 = new TreeNode(59);
		rn4 = new TreeNode(46);
		rn5 = new TreeNode(51);
		rn6 = new TreeNode(55);
		rn7 = new TreeNode(60);
		rn8 = new TreeNode(90);

		ln1.setParent(root);
		ln1.setLeft(ln2);
		// ln1.setLeft(null);

		ln1.setRight(ln3);
		// ln1.setRight(null);

		ln2.setParent(ln1);
		ln2.setLeft(ln4);
		ln2.setRight(ln5);

		ln3.setParent(ln1);
		ln3.setLeft(ln6);
		// ln3.setRight(null);
		ln3.setRight(ln31);

		ln4.setParent(ln2);
		ln4.setLeft(null);
		ln4.setRight(null);

		ln5.setParent(ln2);
		ln5.setLeft(null);
		ln5.setRight(null);

		ln6.setParent(ln3);
		// ln6.setLeft(ln7);
		ln6.setLeft(null);

		ln6.setRight(null);

		ln7.setRight(null);
		ln7.setLeft(null);

		rn1.setParent(root);
		rn1.setLeft(rn2);
		rn1.setRight(rn3);

		rn2.setParent(rn1);
		rn2.setLeft(null);
		rn2.setRight(null);

		rn3.setParent(rn1);
		rn3.setLeft(null);
		rn3.setRight(null);
		rn2.setLeft(rn4);
		rn2.setRight(rn5);
		rn3.setLeft(rn6);
		rn3.setRight(rn7);

		rn4.setLeft(null);
		rn4.setRight(null);
		rn5.setLeft(null);
		rn5.setRight(null);
		rn6.setLeft(null);
		rn6.setRight(null);
		rn7.setLeft(null);
		// rn7.setRight(null);
		rn7.setRight(rn8);
		rn8.setRight(null);
		rn8.setLeft(null);

		root.setLeft(ln1);
		root.setRight(rn1);
		root.setParent(null);
		Stack<TreeNode> tempStack = new Stack<TreeNode>();
		TreeNode traverseNode = new TreeNode(99);
		// traverseNode.inorderTraversal(root);
		// traverseNode.populateInorderSuccessor(root);
		// traverseNode.inorderTraversal(root);

		// traverseNode.breadthFirstTree(root);
		// int heightOfTree = traverseNode.findHeightOfTree(root) - 1 ;
		// int heightOfNode = traverseNode.findHeightOfTree(ln1) -1 ;
		// int heightFromRootTillNode = heightOfTree - heightOfNode;
		// System.out.println("Heigth of a tree :: " + heightOfTree);
		// System.out.println("Height of a node from Root:: " +
		// heightFromRootTillNode);
		// System.out.println("Number of nodes in a BST ::" +
		// traverseNode.countNumberOfNodes(root));
		// System.out.println(TreeNode.isTreeBalanced(root));

		/*
		 * The following code finds the distance of a node from root hence the
		 * level of a node. This code prints -1 if the root node is null in a
		 * tree. This prints -1 also if the node is not in the Tree.
		 */

		TreeNode node = root;
		// if (root != null) {
		// if (root.value == node.value)
		// staticDistance = 0;
		// else
		// TreeNode.findDistanceOfNodeFromRoot(root, node, 0);
		// }

		// System.out.println("Distance of a node " + node.value
		// + " from root is::" + getLevelOfNode(root, node));

		// printAllTheNodesFromLeftHandSide(root);
		// printAllTheNodesFromLeftWithDelimeterNode(root); //O(n) complexity

		// printTheLevelAtWhichTheBinaryTreeIsComplete(root);

		// printKDistanceNodes(root, rn1, 2);
		// Collections.sort(list);
		// System.out.println(list);
		// Print the maximum sum from root to leaf and also print the path.
		// sum(root, root.value);
		// System.out.println(temp);
		// for (Iterator<TreeNode> iterator = temp.iterator();
		// iterator.hasNext();) {
		// TreeNode treeNode = (TreeNode) iterator.next();
		// System.out.println("value --" + treeNode.value);
		//
		// }
		// System.out.println(total);
		// createLinkedListAtEachDepth(root);

		/*
		 	Below is the code to find the lowest common ancestor of two nodes in a tree.
		*/
//		findPath(root, 46);
//		Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
//		System.out.println(isNodeFound);
//		TreeNode[] arr;
//		if (isNodeFound == 1) {
//
//			TreeNode n = null;
//			while (!pathQueue.isEmpty()) {
//				n = pathQueue.pop();
//				System.out.println(n.value);
//				map.put(n.value, n);
//			}
//			System.out.println("1");
//			//Reset the flag and reset the stack with no values
//			pathQueue = new Stack<TreeNode>();
//			isNodeFound = 0;
//			findPath(root, 51);
//			System.out.println("Stack vakues after searching for ::" + 51);
//			System.out.println(pathQueue.size());
//			while (!pathQueue.isEmpty()) {
//				n = pathQueue.pop();
//				System.out.println(n.getValue());
//				if (map.get(n.value) != null)
//					break;
//			}
//			System.out.println("Lowest common ancestor is ::" + n.value);
//		}else {
//			System.out.println("No least common ancestor..");
//		}
		
		
		System.out.println("Hello/...");
		/*Build tree from Preorder & Inorder traversals*/
		List<Integer> preOrder = new ArrayList<Integer>();
		preOrder.add(new Integer(15));
		preOrder.add(new Integer(10));
		preOrder.add(new Integer(9));
		preOrder.add(new Integer(11));
		preOrder.add(new Integer(20));
		preOrder.add(new Integer(18));
		preOrder.add(new Integer(25));
		
		List<Integer> inOrder = new ArrayList<Integer>();
		inOrder.add(new Integer(9));
		inOrder.add(new Integer(10));
		inOrder.add(new Integer(11));
		inOrder.add(new Integer(15));
		inOrder.add(new Integer(18));
		inOrder.add(new Integer(20));
		inOrder.add(new Integer(25));
		
		TreeNode newNode = buildTreeFromPreorderInorder(preOrder, inOrder);
		inorderTraversal(newNode);
	}
}