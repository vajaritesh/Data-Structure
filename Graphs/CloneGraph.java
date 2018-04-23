package com.academy.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * Clone Graph
 * Clone an undirected graph. Each node in the graph contains a val and a list of its neighbors.
 */
public class CloneGraph {

	static class GraphNode {
		int val;
		boolean visited;
		List<GraphNode> neighbors;

		GraphNode(int val) {
			this.val = val;
			neighbors = new ArrayList<GraphNode>();
		}

		void addNeighbours(GraphNode node) {
			neighbors.add(node);
		}

		List<GraphNode> getNeighbors() {
			return neighbors;
		}
	}

	public static void main(String[] args) {
		GraphNode A = new GraphNode(1);
		GraphNode B = new GraphNode(2);
		GraphNode C = new GraphNode(3);

		A.addNeighbours(B);
		A.addNeighbours(C);

		B.addNeighbours(A);
		B.addNeighbours(C);

		C.addNeighbours(C);
		System.out.println("Original Graph:");
		printGraph(A);
		GraphNode cloneGraphIterative = cloneGraphIterative(A);
		System.out.println("Clone Iterative Graph:");
		printGraph(cloneGraphIterative);
		GraphNode cloneGraphRecursive = cloneGraphRecursive(A);
		System.out.println("Clone Recursive Graph:");
		printGraph(cloneGraphRecursive);

	}

	// Time O(E+V) Space O(V)
	private static GraphNode cloneGraphIterative(GraphNode a) {
		if (a == null) {
			return null;
		}
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		Map<GraphNode, GraphNode> map = new HashMap<GraphNode, GraphNode>();
		GraphNode cloneNode = new GraphNode(a.val);
		queue.add(a);
		map.put(a, cloneNode);
		while (!queue.isEmpty()) {
			GraphNode top = queue.poll();
			for (GraphNode neighbor : top.getNeighbors()) {
				if (!map.containsKey(neighbor)) {
					GraphNode clonedNeighbor = new GraphNode(neighbor.val);
					map.put(neighbor, clonedNeighbor);
					map.get(top).neighbors.add(clonedNeighbor);
					queue.add(neighbor);
				}
				else {
					map.get(top).neighbors.add(map.get(neighbor));
				}
			}
		}
		return cloneNode;
	}

	// Time O(E+V) Space O(V)
	private static GraphNode cloneGraphRecursive(GraphNode a) {
		if (a == null) {
			return null;
		}
		HashMap<GraphNode, GraphNode> map = new HashMap<GraphNode, GraphNode>();
		return dfs(a, map);
	}

	private static GraphNode dfs(GraphNode node, HashMap<GraphNode, GraphNode> map) {
		if (node == null) {
			return null;
		}
		if (map.containsKey(node)) {
			return map.get(node);
		}
		GraphNode clone = new GraphNode(node.val);
		map.put(node, clone);
		for (GraphNode neighbor : node.getNeighbors()) {
			clone.addNeighbours(dfs(neighbor, map));
		}
		return clone;
	}

	private static void printGraph(GraphNode a) {
		if (a == null) {
			return;
		}
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(a);
		a.visited = true;
		while (!queue.isEmpty()) {
			GraphNode top = queue.poll();
			System.out.print(top.val + " ");
			for (GraphNode neighbor : top.getNeighbors()) {
				if (!neighbor.visited) {
					neighbor.visited = true;
					queue.add(neighbor);
				}
			}
		}
		System.out.println();
	}

}
