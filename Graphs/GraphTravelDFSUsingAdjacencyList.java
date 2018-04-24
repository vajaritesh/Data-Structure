package com.academy.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 *  Graph Travel - DFS Adjacency list
 */
public class GraphTravelDFSUsingAdjacencyList {

	static class GraphNode {
		int data;
		boolean visited;
		List<GraphNode> neighbours;

		GraphNode(int data) {
			this.data = data;
			this.neighbours = new ArrayList<GraphNode>();
		}

		public void addneighbours(GraphNode node10) {
			this.neighbours.add(node10);
		}

		public List<GraphNode> getNeighbours() {
			return this.neighbours;
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

		node40.addneighbours(node10);
		node40.addneighbours(node20);
		node10.addneighbours(node30);
		node20.addneighbours(node10);
		node20.addneighbours(node30);
		node20.addneighbours(node60);
		node20.addneighbours(node50);
		node30.addneighbours(node60);
		node60.addneighbours(node70);
		node50.addneighbours(node70);

		GraphTravelDFSUsingAdjacencyList dfsArrayListObject = new GraphTravelDFSUsingAdjacencyList();
		System.out.println("The DFS Iterative traversal of the graph using ArrayList as Edge");
		dfsArrayListObject.dfsIteratively(node40);
		System.out.println();
		node10.visited = false;
		node20.visited = false;
		node30.visited = false;
		node40.visited = false;
		node50.visited = false;
		node60.visited = false;
		node70.visited = false;
		System.out.println("The DFS recursive traversal of the graph using ArrayList as Edge");
		dfsArrayListObject.dfsRecursively(node40);
	}

	private void dfsRecursively(GraphNode node) {
		System.out.print(node.data + " ");
		node.visited = true;
		for (GraphNode gnode : node.getNeighbours()) {
			if (!gnode.visited) {
				dfsRecursively(gnode);
			}
		}
	}

	private void dfsIteratively(GraphNode node) {
		Stack<GraphNode> stack = new Stack<GraphNode>();
		stack.add(node);
		node.visited = true;
		while (!stack.isEmpty()) {
			GraphNode top = stack.pop();
			System.out.print(top.data + " ");
			for (GraphNode g : top.getNeighbours()) {
				if (!g.visited) {
					stack.push(g);
					g.visited = true;
				}
			}
		}
	}
}
