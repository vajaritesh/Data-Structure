package com.academy.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Graph Travel - BFS AdjacencyList
 */
public class GraphTravelBFSUsingAdjacencyList {

	static class GraphNode {
		int data;
		boolean visited;
		List<GraphNode> neighbours;

		GraphNode(int data) {
			this.data = data;
			neighbours = new ArrayList<GraphNode>();
		}

		void addneighbours(GraphNode node) {
			neighbours.add(node);
		}

		List<GraphNode> getNeighbours() {
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
		GraphTravelBFSUsingAdjacencyList bfsArrayListObject = new GraphTravelBFSUsingAdjacencyList();
		System.out.println("The BFS Iterative traversal of the graph using ArrayList as Edge");
		bfsArrayListObject.bfsIteratively(node40);
	}

	private void bfsIteratively(GraphNode node) {
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(node);
		node.visited = true;
		while (!queue.isEmpty()) {
			GraphNode top = queue.poll();
			System.out.print(top.data + " ");
			for (GraphNode connectedNode : top.getNeighbours()) {
				if (!connectedNode.visited) {
					queue.add(connectedNode);
					connectedNode.visited = true;
				}
			}
		}
	}
}
