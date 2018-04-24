package com.academy.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Graph Travel - DFS AdjacencyMatrix
 */
public class GraphTravelDFSUsingAdjacencyMatrix {
	static List<GraphNode> nodes = new ArrayList<GraphNode>();

	static class GraphNode {
		int data;
		boolean visited;

		GraphNode(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		GraphNode node40 = new GraphNode(40);
		GraphNode node10 = new GraphNode(10);
		GraphNode node20 = new GraphNode(20);
		GraphNode node30 = new GraphNode(30);
		GraphNode node50 = new GraphNode(50);
		GraphNode node60 = new GraphNode(60);
		GraphNode node70 = new GraphNode(70);
		nodes.add(node40);
		nodes.add(node10);
		nodes.add(node20);
		nodes.add(node30);
		nodes.add(node60);
		nodes.add(node50);
		nodes.add(node70);
		int adjacency_matrix[][] = { { 0, 1, 1, 0, 0, 0, 0 }, // Node 1: 40
		        { 0, 0, 0, 1, 0, 0, 0 }, // Node 2 :10
		        { 0, 1, 0, 1, 1, 1, 0 }, // Node 3: 20
		        { 0, 0, 0, 0, 1, 0, 0 }, // Node 4: 30
		        { 0, 0, 0, 0, 0, 0, 1 }, // Node 5: 60
		        { 0, 0, 0, 0, 0, 0, 1 }, // Node 6: 50
		        { 0, 0, 0, 0, 0, 0, 0 }, // Node 7: 70
		};

		GraphTravelDFSUsingAdjacencyMatrix dfsAdjacencyMatrix = new GraphTravelDFSUsingAdjacencyMatrix();
		System.out.println("The DFS Iteratively traversal of graph using Adjancency Matrix as Edge");
		dfsAdjacencyMatrix.dfsIteratively(adjacency_matrix, node40);
		System.out.println();
		node10.visited = false;
		node20.visited = false;
		node30.visited = false;
		node40.visited = false;
		node50.visited = false;
		node60.visited = false;
		node70.visited = false;
		System.out.println("The DFS Recursively traversal of graph using Adjancency Matrix as Edge");
		dfsAdjacencyMatrix.dfsRecursively(adjacency_matrix, node40);
	}

	private void dfsRecursively(int[][] adjacency_matrix, GraphNode node) {
		System.out.print(node.data + " ");
		node.visited = true;
		List<GraphNode> neighbours = findNeighbours(adjacency_matrix, node);
		for (GraphNode neighbour : neighbours) {
			if (!neighbour.visited) {
				dfsRecursively(adjacency_matrix, neighbour);
			}
		}
	}

	private void dfsIteratively(int[][] adjacency_matrix, GraphNode node) {
		Stack<GraphNode> stack = new Stack<GraphNode>();
		stack.add(node);
		node.visited = true;
		while (!stack.isEmpty()) {
			GraphNode top = stack.pop();
			System.out.print(top.data + " ");
			List<GraphNode> neighbours = findNeighbours(adjacency_matrix, top);
			for (GraphNode neighbourNode : neighbours) {
				if (!neighbourNode.visited) {
					stack.push(neighbourNode);
					neighbourNode.visited = true;
				}
			}
		}
	}

	private List<GraphNode> findNeighbours(int[][] adjacency_matrix, GraphNode top) {
		int nodeIndex = -1;
		List<GraphNode> neighbours = new ArrayList<GraphNode>();
		for (int index = 0; index < nodes.size(); index++) {
			if (nodes.get(index).equals(top)) {
				nodeIndex = index;
			}
		}
		if (nodeIndex != -1) {
			for (int j = 0; j < adjacency_matrix[nodeIndex].length; j++) {
				if (adjacency_matrix[nodeIndex][j] == 1) {
					neighbours.add(nodes.get(j));
				}
			}
		}
		return neighbours;
	}
}
