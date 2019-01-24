package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;

import officeprograms.DoublyLinkedList;
import officeprograms.DoublyLinkedNode;

public class TreeNode {

	int value;

	TreeNode left;

	TreeNode right;

	TreeNode parent;

	int height;

	TreeNode successor;

	TreeNode predessor;

	int leftSubTree;

	int rightSubTree;

	public int getLeftSubTree() {
		return leftSubTree;
	}

	public void setLeftSubTree(int leftSubTree) {
		this.leftSubTree = leftSubTree;
	}

	public int getRightSubTree() {
		return rightSubTree;
	}

	public void setRightSubTree(int rightSubTree) {
		this.rightSubTree = rightSubTree;
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

	public TreeNode getSuccessor() {
		return successor;
	}

	public void setSuccessor(TreeNode successor) {
		this.successor = successor;
	}

	/*********************************************** Code related to BST ********************************************/

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

	// Reverse inorder traversal
	private static TreeNode next;

	// O(n)
	public static void populateInorderSuccessor(TreeNode root) {

		if (root == null)
			return;

		populateInorderSuccessor(root.getRight());
		root.setSuccessor(next);
		next = root;
		populateInorderSuccessor(root.getLeft());

	}

	// O(n)
	public static void inorderTraversal(TreeNode n) {

		if (n == null)
			return;

		inorderTraversal(n.getLeft());
		// n.setPredessor(getInorderPredessor(n));
		if (n.getSuccessor() != null) {
			System.out.println("Successor of Node n::" + n.getValue() + " is "
					+ n.getSuccessor().getValue());
		} else
			System.out.println("Successor of Node n::" + n.getValue()
					+ " is  null");
		// System.out.println(n.value);
		inorderTraversal(n.getRight());

	}

	public static void postOrderTraversal(TreeNode n) {
		if (n == null)
			return;

		postOrderTraversal(n.left);
		postOrderTraversal(n.right);
		System.out.println(n.value);
	}

	public static int countNumberOfNodes(TreeNode n) {
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
	}

	public static int distanceOfNodeFromRoot = 0;

	public static void findDistanceOfNodeFromRootUsingBSTProperty(
			TreeNode root, TreeNode node) {

		if (root == null)
			return;
		if (root.value == node.value)
			return;
		if (root.value > node.value) {
			distanceOfNodeFromRoot++;
			findDistanceOfNodeFromRootUsingBSTProperty(root.left, node);
		} else {
			findDistanceOfNodeFromRootUsingBSTProperty(root.right, node);

		}

	}

	public static int getHeightOfNode(TreeNode n) {
		if (n == null)
			return 0;
		return (1 + Math.max(getHeightOfNode(n.getLeft()),
				getHeightOfNode(n.getRight())));
	}

	// O(h) = logn
	public static TreeNode findSuccessor(TreeNode x) {

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

	// O(log n)
	public static TreeNode findMinumum(TreeNode x) {
		while (x.getLeft() != null) {
			x = x.getLeft();
		}
		return x;

	}

	public static int heightOfTree;

	public static boolean isTreeBalanced(TreeNode node) {
		int subTreeHeight;
		if (node == null)
			return false;

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

	// It uses the breadth first search to build the tree at each level
	public static void createLinkedListAtEachDepth(TreeNode node) {

		Queue<TreeNode> q = new LinkedList<TreeNode>();

		TreeNode delimeter = new TreeNode(-99);

		LinkedList<TreeNode> treeNodeList = new LinkedList<TreeNode>();

		ArrayList<LinkedList<TreeNode>> arrayList = new ArrayList<LinkedList<TreeNode>>();

		TreeNode temp = null;

		q.add(node);

		q.add(delimeter);

		while (!q.isEmpty()) {

			temp = q.remove();

			if (temp == delimeter) {
				arrayList.add(treeNodeList);
				treeNodeList = new LinkedList<TreeNode>();
				// This is a special check so that the code doesn't go in
				// recursion loop for ever!!!
				if (q.peek() != null) {
					q.add(delimeter);
				}
				continue;

			}
			treeNodeList.add(temp);

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

	// Breadth first iteration of the list
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

	
	//Print level order traversal 
	  /* function to print level order traversal of tree*/
    public static void printLevelOrder(TreeNode root)
    {
        int h = findHeightOfTree(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }
 
    
	public static void printGivenLevel (TreeNode root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.value + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
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
				if (q.peek() != null) {
					level = level + 1;
					q.add(delimeter);
				}
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

	/* Implementation of Left level of the treeNodes without using hash map */
	public static void printLeftNodes(TreeNode root) {

		if (root == null)
			return;

		Queue<TreeNode> q = new LinkedList<TreeNode>();

		TreeNode temp = new TreeNode(-99);

		System.out.println(root.value);// First print the root value

		q.add(root);
		q.add(temp);

		while (!q.isEmpty()) {

			TreeNode n = q.remove();

			if (n == temp) {
				if (q.peek() != null) {
					q.add(temp);
					System.out.println(q.peek().value);// It peaks the value
														// from the queue and
														// prints in console

				}
				continue;
			}
			if (n.left != null)
				q.add(n.left);
			if (n.right != null)
				q.add(n.right);
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
				if (q.peek() != null)
					q.add(delimeter);
				continue;
			}
			if (temp.left != null && temp.right != null) {
				// if (temp.left != null)
				q.add(temp.left);
				// if (temp.right != null)
				q.add(temp.right);
			} else {
				break;
			}

		}
		System.out.println("At level " + level + " the Tree is balanced.");
	}

	public static int findTheLevelAtWhichTreeIsCompleteRecursively(TreeNode node) {

		if (node == null)
			return -1;// This decrements the value by 1

		int l = 1 + findTheLevelAtWhichTreeIsCompleteRecursively(node.left);
		int r = 1 + findTheLevelAtWhichTreeIsCompleteRecursively(node.right);

		return Math.min(l, r);
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

	/* Find the path using postorder traversal */

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

	public static TreeNode createBSTFromArray(int[] arr, int start, int end) {

		if (end < start)
			return null;
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		n.left = createBSTFromArray(arr, start, mid - 1);
		n.right = createBSTFromArray(arr, mid + 1, end);
		return n;
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode n1,
			TreeNode n2) {

		if (root == null)
			return null;

		if (root.value > n1.value && root.value > n2.value)
			return lowestCommonAncestor(root.left, n1, n2);
		else if (root.value < n1.value && root.value < n2.value)
			return lowestCommonAncestor(root.right, n1, n2);
		else
			return root;
	}

	public static LinkedList<TreeNode> createLinkedListOfNodes(TreeNode root) {

		LinkedList<TreeNode> listOfBinaryTree = new LinkedList<TreeNode>();

		if (root == null)
			return listOfBinaryTree;

		generateList(root, listOfBinaryTree);
		Iterator<TreeNode> iter = listOfBinaryTree.iterator();
		while (iter.hasNext()) {
			TreeNode treeNode = (TreeNode) iter.next();
			System.out.println(treeNode.value);
		}
		return listOfBinaryTree;

	}

	public static void generateList(TreeNode node, LinkedList<TreeNode> list) {

		if (node == null)
			return;
		generateList(node.left, list);
		list.add(node);
		generateList(node.right, list);

	}

	public static void preOrderUsingStacks(TreeNode root) {

		if (root == null)
			return;

		Stack<TreeNode> st = new Stack<TreeNode>();

		st.push(root);

		while (!st.isEmpty()) {
			TreeNode temp = st.pop();

			System.out.println(temp.value);
			if (temp.right != null) {
				st.push(temp.right);
			}

			if (temp.left != null) {
				st.push(temp.left);
			}
		}
	}

	public static void inorderTraversalUsingIteration(TreeNode root) {

		if (root == null)
			return;

		Stack<TreeNode> st = new Stack<TreeNode>();

		st.push(root);

		while (!st.isEmpty()) {

			TreeNode node = st.pop();

			if (node.right != null) {
				if (st.isEmpty() || st.peek() != node.right) {
					st.push(node.right);
					st.push(node);
				} else {
					System.out.println(node.value);
					continue;
				}
			} else {
				System.out.println(node.value);
			}

			if (node.left != null) {
				st.push(node.left);
			}
		}
	}

	public static void postOrderTraversalUsingIterataion(TreeNode root) {

		if (root == null)
			return;

		Stack<TreeNode> st = new Stack<TreeNode>();

		st.push(root);

		TreeNode previous = null;

		while (!st.isEmpty()) {
			TreeNode n = st.pop();

			if (n.right != null) {
				if (previous == null) {
					st.push(n);
					st.push(n.right);
				} else {
					if (previous == n.right) {
						System.out.println(n.value);
						previous = n;
						continue;
					} else {
						st.push(n);
						st.push(n.right);
					}
				}
			} else {
				previous = n;
				System.out.println(n.value);

			}

			if (n.left != null)
				st.push(n.left);
		}
	}

	public static int searchNodeInInorderTree(int[] inOrderTree, int value) {

		for (int i = 0; i < inOrderTree.length; i++) {
			if (inOrderTree[i] == value)
				return i;
		}
		return -1;

	}

	public static TreeNode createBSTFromSortedArray(int[] arr, int start,
			int end) {

		if (start > end)
			return null;

		int mid = (start + end) / 2;

		TreeNode n = new TreeNode(arr[mid]);
		n.left = createBSTFromSortedArray(arr, start, mid - 1);
		n.right = createBSTFromSortedArray(arr, mid + 1, end);

		return n;

	}

	// Basically it uses the reverse inorder traversal to create doubly linked
	// list
	public static TreeNode tailOfDoublyLinkedList = null;

	public static TreeNode previousNodeInReverseInOrderTraversal = null;

	public static void convertBSTtoDoublyLinkedList(TreeNode node) {

		if (node == null)
			return;

		convertBSTtoDoublyLinkedList(node.right);

		if (tailOfDoublyLinkedList == null)
			tailOfDoublyLinkedList = node;

		node.right = previousNodeInReverseInOrderTraversal;

		if (previousNodeInReverseInOrderTraversal != null)
			previousNodeInReverseInOrderTraversal.left = node;
		previousNodeInReverseInOrderTraversal = node;

		convertBSTtoDoublyLinkedList(node.left);

	}

	public static void traverseDoublyLinkedList(TreeNode head) {

		if (head == null)
			return;
		while (head != null) {
			System.out.println("Node :: " + head.value);
			if (head.left != null)
				System.out.println("Previous:: " + head.left.value);
			else
				System.out.println("Previous:: null");
			if (head.right != null)
				System.out.println("Next:: " + head.right.value);
			else
				System.out.println("Next:: null");
			System.out.println("***********************");
			head = head.right;

		}
	}

	public static DoublyLinkedNode dll = null;

	public static TreeNode sortedListToBST(int start, int end) {
		if (start > end)
			return null;

		// same as (start+end)/2, avoids overflow
		int mid = start + (end - start) / 2;

		TreeNode leftChild = sortedListToBST(start, mid - 1);

		TreeNode parent = new TreeNode(dll.key);

		parent.left = leftChild;

		dll = dll.next;

		parent.right = sortedListToBST(mid + 1, end);

		return parent;
	}

	// Print kth smallest element in a tree
	// For this we use inorder traversal
	public static int kSmallest = 3;

	public static void printKSmallestElementInBST(TreeNode node, int k) {

		if (node == null)
			return;

		printKSmallestElementInBST(node.left, k);

		if (kSmallest == 1) {
			System.out.println("Kth smallest Node -->" + node.value);
		}
		kSmallest--;
		printKSmallestElementInBST(node.right, k);
	}

	// Print kth largest element in a BST
	// For this we use reverse inorder traversal
	public static int kLargestInBST = 0; // In case of recursion always use
											// static variables other wise these
											// variables will be lost in
											// recursion

	public static void printKLargestElementInBST(TreeNode node, int k) {

		if (node == null)
			return;
		printKLargestElementInBST(node.right, k);

		if (kLargestInBST == 1) {
			System.out.println("Kth largest Node -->" + node.value);

		}
		kLargestInBST--;
		printKLargestElementInBST(node.left, k);

	}

	public static TreeNode buildBSTFromMatrix(int[][] arr, int m, int n) {

		Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					if (!map.containsKey(i + 1)) {
						TreeNode node = new TreeNode(i + 1);
						addNode(node, j + 1, map);
						map.put(i + 1, node);
					} else {
						addNode(map.get(i + 1), j + 1, map);
					}
				}
			}
		}

		int tempArr[] = new int[map.size()];
		int i = 0;
		for (Map.Entry<Integer, TreeNode> entry : map.entrySet()) {
			int key = entry.getKey().intValue();
			tempArr[i] = key;
			i++;
		}
		Arrays.sort(tempArr);
		int median = (int) Math.floor(tempArr.length / 2);

		inorderTraversal(map.get(tempArr[0]));
		return map.get(tempArr[0]);

	}

	public static void printKSmallestNumberInBSTUsingINformationInEachNode(
			TreeNode n, int k) {

		if (n == null || k > n.leftSubTree + n.rightSubTree + 1) {
			return;
		}
		// System.out.println("Node :: " + n.value + " Left Subtree:: "
		// + n.getLeftSubTree() + " Right Subtree:: "
		// + n.getRightSubTree());
		// printKSmallestNumberInBSTUsingINformationInEachNode(n.left);
		// printKSmallestNumberInBSTUsingINformationInEachNode(n.right);

		if (k == n.leftSubTree + 1) {
			System.out.println("The " + k + " smallest value in BST is "
					+ n.value);
			return;

		}

		if (k <= n.leftSubTree) {
			printKSmallestNumberInBSTUsingINformationInEachNode(n.left, k);
		} else {
			printKSmallestNumberInBSTUsingINformationInEachNode(n.right, k
					- (n.leftSubTree + 1));
		}

	}

	public static void addNode(TreeNode n, int valueOfNode,
			Map<Integer, TreeNode> m) {
		TreeNode node = null;
		if (!m.containsKey(valueOfNode))
			node = new TreeNode(valueOfNode);
		else
			node = m.get(valueOfNode);

		if (valueOfNode < n.value) {
			n.left = node;
		} else {
			n.right = node;
		}
		m.put(valueOfNode, node);

	}

	static int kSmallestInBST = 0;

	public static void printKSmallestNumberInBST(TreeNode n, int k) {
		kSmallest = k;

	}

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

	public static Map<Integer, Integer> inOrderIndexMap = new HashMap<Integer, Integer>();

	public static void buildInorderIndexMap(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			inOrderIndexMap.put(arr[i], i);
		}
	}

	public static TreeNode buildBSTFromInorderPreorder(int[] preOrder,
			int[] inOrder, int preOrderIndex, int inOrderIndex, int length) {

		if (length == 0)
			return null;

		TreeNode root = new TreeNode(preOrder[preOrderIndex]);

		// int rootIndex = 0;
		int rootIndex = inOrderIndexMap.get(preOrder[preOrderIndex])
				- inOrderIndex;
		// for (int count = inOrderIndex; count < inOrder.length; count++)
		// {
		// if(inOrder[count] == preOrder[preOrderIndex]){
		// break;
		// }
		// rootIndex++;
		// }

		root.left = buildBSTFromInorderPreorder(preOrder, inOrder,
				preOrderIndex + 1, inOrderIndex, rootIndex);

		root.right = buildBSTFromInorderPreorder(preOrder, inOrder,
				preOrderIndex + rootIndex + 1, inOrderIndex + rootIndex + 1,
				length - (rootIndex + 1));

		return root;
	}
	//This method calculates the diff of sum of nodes @odd & @even level
	public static int oddEvenDiff(TreeNode root){
		
		if(root == null)
			return -1;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		return 0;
		
		
	}

	public static void main(String[] args) {

		TreeSet<TreeNode> set = new TreeSet<TreeNode>();
		set.pollFirst();
		TreeNode root = new TreeNode(40);

		TreeNode ln1, ln2, ln3, ln4, ln5, ln6, ln7, ln31;
		TreeNode rn1, rn2, rn3, rn4, rn5, rn6, rn7, rn8;

		ln1 = new TreeNode(30);
		ln2 = new TreeNode(20);
		ln3 = new TreeNode(39);
		// ln31 = new TreeNode(40);

		ln4 = new TreeNode(10);
		ln5 = new TreeNode(25);

		ln6 = new TreeNode(37);
		ln7 = new TreeNode(33);

		rn1 = new TreeNode(50);
		rn2 = new TreeNode(47);
		rn3 = new TreeNode(59);
		rn4 = new TreeNode(46);
		rn5 = new TreeNode(49);
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
		ln3.setRight(null);
		// ln3.setRight(ln31);

		ln4.setParent(ln2);
		ln4.setLeft(null);
		ln4.setRight(null);

		ln5.setParent(ln2);
		ln5.setLeft(null);
		ln5.setRight(null);

		ln6.setParent(ln3);
		ln6.setLeft(ln7);
		// ln6.setLeft(null);

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
		// Stack<TreeNode> tempStack = new Stack<TreeNode>();
		// TreeNode traverseNode = new TreeNode(99);
		// System.out.println("Inorder traversal...");
		// traverseNode.inorderTraversal(root);
		// System.out.println("End of Inorder traversal..");
		populateInorderSuccessor(root);
		inorderTraversal(root);

		// traverseNode.breadthFirstTree(root);
		// int heightOfTree = traverseNode.findHeightOfTree(root) - 1 ;
		// int heightOfNode = traverseNode.findHeightOfTree(ln1) -1 ;
		// int heightFromRootTillNode = heightOfTree - heightOfNode;
		// System.out.println("Heigth of a tree :: " + heightOfTree);
		// System.out.println("Height of a node from Root:: " +
		// heightFromRootTillNode);
		System.out.println("Number of nodes in a BST ::"
				+ countNumberOfNodes(root));
		// System.out.println(TreeNode.isTreeBalanced(root));

		/*
		 * The following code finds the distance of a node from root hence the
		 * level of a node. This code prints -1 if the root node is null in a
		 * tree. This prints -1 also if the node is not in the Tree.
		 */

		TreeNode node = root;
		if (root != null) {
			if (root.value == node.value)
				staticDistance = 0;
			else
				// TreeNode.findDistanceOfNodeFromRoot(root, node, 0);
				findDistanceOfNodeFromRootUsingBSTProperty(root, node);
			System.out.println("Distance of Node using BST Property::"
					+ distanceOfNodeFromRoot);
		}

		// System.out.println("Distance of a node " + node.value
		// + " from root is::" + getLevelOfNode(root, node));

		System.out.println("Height of a tree is ::" + getHeightOfNode(root));

		System.out.println("Successor of a specific node ::37 is "
				+ findSuccessor(ln6).value);

		// printAllTheNodesFromLeftHandSide(root);
		// printAllTheNodesFromLeftWithDelimeterNode(root); // O(n) complexity

		System.out.println("Creation of Linked list at each level::");
		createLinkedListAtEachDepth(root);

		printTheLevelAtWhichTheBinaryTreeIsComplete(root);
		System.out.println("Tree is complete at level :: "
				+ findTheLevelAtWhichTreeIsCompleteRecursively(root));

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

		/*
		 * Following is the code to find out the least common ancestor of give
		 * two nodes in a tree.
		 */
		// findPath(root, 46);
		// Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
		// System.out.println(isNodeFound);
		// if (isNodeFound == 1) {
		//
		// TreeNode n = null;
		// while (!pathQueue.isEmpty()) {
		// n = pathQueue.pop();
		// System.out.println(n.value);
		// map.put(n.value, n);
		// }
		// // Reset the flag and reset the stack with no values
		// pathQueue = new Stack<TreeNode>();
		// isNodeFound = 0;
		// findPath(root, 51);
		//
		// while (!pathQueue.isEmpty()) {
		// n = pathQueue.pop();
		// System.out.println(n.getValue());
		// if (map.get(n.value) != null)
		// break;
		// }
		// System.out.println("Lowest common ancestor is ::" + n.value);
		// } else {
		// System.out.println("No least common ancestor..");
		// }
		// // System.out.println(isNodeFound);
		//
		// /*
		// * Following is the code to create linked list of the nodes in a
		// Binary
		// * Tree.
		// */
		// // createLinkedListOfNodes(node);
		// System.out.println("Second left...");
		// printLeftNodes(root);
		int[] arr = { 10, 20, 25, 30, 39, 40, 46, 47, 51, 50, 55, 59, 60, 90,100 };
		TreeNode root1 = createBSTFromArray(arr, 0, arr.length - 1);

		System.out
				.println("Inorder of a tree created from an array traversal2...");

		inorderTraversal(root1);
		System.out
				.println("Below are the output of node when printed using postorder without recursion...");
		preOrderUsingStacks(root);
		// System.out.println("End of Inorder traversal2..");
		// int []inOrderTree = {10,20,25,50,51,55,60};
		// int []preOrderTree = {50,20,10,25,55,51,60};
		// // System.out.println(rootNode.left);

		// int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		//
		// TreeNode rootNode12 = createBSTFromSortedArray(arr, 0, 8);
		// inorderTraversal(rootNode12);

		// convertBSTtoDoublyLinkedList(root);
		// System.out.println("Tail of doubly linked list is ::" +
		// tailOfDoublyLinkedList.value );
		// System.out.println("Head of doubly linked list is ::" +
		// previousNodeInReverseInOrderTraversal.value );
		// traverseDoublyLinkedList(previousNodeInReverseInOrderTraversal);

		DoublyLinkedNode node1 = new DoublyLinkedNode(1);
		DoublyLinkedNode node2 = new DoublyLinkedNode(2);
		DoublyLinkedNode node3 = new DoublyLinkedNode(3);

		DoublyLinkedNode node4 = new DoublyLinkedNode(22);
		DoublyLinkedNode node5 = new DoublyLinkedNode(1);

		node1.setNextNode(node2);
		node2.setNextNode(node3);
		node3.setNextNode(null);

		node1.setPrevNode(null);
		node2.setPrevNode(node1);
		node3.setPrevNode(node2);

		DoublyLinkedList list = new DoublyLinkedList();
		list.HEAD = node1;
		list.TAIL = node3;
		TreeNode.dll = list.HEAD;

		TreeNode newRoot = sortedListToBST(0, 2);
		inorderTraversal(newRoot);
		//
		// TreeNode dummyNode1 = new TreeNode(-90);
		// TreeNode dummyNode2 = new TreeNode(-99);
		// System.out.println("Lowest common Ancestor of " + dummyNode1.value
		// + " and " + dummyNode2.value + " is "
		// + lowestCommonAncestor(root, dummyNode1, dummyNode2));

		printKSmallestElementInBST(root, 3);
		System.out.println("K Larget in BST...");
		kLargestInBST = 1;
		printKLargestElementInBST(root, 2);
		// System.out.println("***");
		// inorderTraversal(root);
		//
		inorderTraversalUsingIteration(root);
		System.out.println("****KARAN****");
		inorderTraversal(root);
		//

		// postOrderTraversalUsingIterataion(root);
		// System.out.println("*****KARAN RATRA******");
		// postOrderTraversal(root);
		//
		// System.out.println("*****2D Matrix to an BST *******");
		// int[][] arr = { { 0, 1, 0 }, { 0, 0, 1 }, { 0, 0, 0 } };
		//
		// TreeNode newRoot = buildBSTFromMatrix(arr, 3, 3);
		// inorderTraversal(newRoot);

		// Printing Kth Largest number using extra information about left sub
		// tree & right sub tree

		root.setLeftSubTree(7);
		root.setRightSubTree(8);

		ln1.setLeftSubTree(3);
		ln1.setRightSubTree(3);

		ln2.setLeftSubTree(1);
		ln2.setRightSubTree(1);

		ln3.setLeftSubTree(2);

		ln4.setLeftSubTree(0);
		ln4.setRightSubTree(0);

		ln5.setLeftSubTree(0);
		ln5.setRightSubTree(0);

		ln6.setLeftSubTree(1);
		ln6.setRightSubTree(0);

		ln7.setLeftSubTree(0);
		ln7.setRightSubTree(0);

		rn1.setLeftSubTree(3);
		rn1.setRightSubTree(4);

		rn2.setLeftSubTree(1);
		rn2.setRightSubTree(1);

		rn3.setLeftSubTree(1);
		rn3.setRightSubTree(2);

		rn7.setRightSubTree(1);

		// printKSmallestNumberInBSTUsingINformationInEachNode(root, 17);

		// InEfficient Way of creating the BST from Inorder & Preorder traversal
		List<Integer> preOrderList = new ArrayList<Integer>();
		preOrderList.add(new Integer(15));
		preOrderList.add(new Integer(10));
		preOrderList.add(new Integer(9));
		preOrderList.add(new Integer(11));
		preOrderList.add(new Integer(20));
		preOrderList.add(new Integer(18));
		preOrderList.add(new Integer(25));
		preOrderList.add(new Integer(26));

		List<Integer> inOrderList = new ArrayList<Integer>();
		inOrderList.add(new Integer(9));
		inOrderList.add(new Integer(10));
		inOrderList.add(new Integer(11));
		inOrderList.add(new Integer(15));
		inOrderList.add(new Integer(18));
		inOrderList.add(new Integer(20));
		inOrderList.add(new Integer(25));
		inOrderList.add(new Integer(26));

		TreeNode newNode = buildTreeFromPreorderInorder(preOrderList,
				inOrderList);
		// System.out.println("Tree created from Preorder & Inorder traversal..");
		// inorderTraversal(newNode);

		// Efficient way of creating the tree from the inorder & preorder
		// traversal
		int[] preorder = { 15, 10, 9, 11, 20, 18, 25 };
		// int[] preorder = { 10, 9, 11};

		int[] inorder = { 9, 10, 11, 15, 18, 20, 25 };
		// int[] inorder = { 9, 10, 11 };

		// buildInorderIndexMap(inorder);
		// TreeNode newRoot = buildBSTFromInorderPreorder(preorder, inorder, 0,
		// 0,
		// preorder.length - 1);

		// inorderTraversal(newRoot);

	}
}
