package com.gl.DSA.lab3.SumInBST;

import java.util.HashSet;

public class Tree {
	Node root;

	public Tree(Node root) {
		this.root = root;
	}

	public static boolean isSum(int sum, Node root) {
		HashSet<Integer> set = new HashSet<>();
		return isSum(set, root, sum);
	}

	public static boolean isSum(HashSet <Integer> set, Node root, int sum) {
		if (root == null) {
			return false;
		}
		if (isSum(set, root.left, sum)) {
			return true;
		}
		if (set.contains(sum - root.data)) {
			System.out.println("Pair is (" + root.data + "," + (sum - root.data) + ")");
			return true;
		} else {
			set.add(root.data);
		}
		return isSum(set, root.right, sum);
	}

	public static void main(String[] args) {
		Node root = new Node(40);
		Tree binaryTree = new Tree(root);
		binaryTree.root.left = new Node(20);
		binaryTree.root.right = new Node(60);
		root.left.left = new Node(10);
		root.left.right = new Node(30);
		root.right.left = new Node(50);
		root.right.right = new Node(70);
		boolean result = isSum(130, root);
		if (result == false) {
			System.out.println("nodes are not found");
		}
	}
}

class Node {
	int data;
	Node left, right;

	Node(int value) {
		data = value;
		left = right = null;
	}
}
