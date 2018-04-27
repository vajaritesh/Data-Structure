package com.academy.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Detect cycle in an undirected graph
 */
public class IsCyclicUnDirectedGraph {
	static class GraphNode {
		int v;
		List<Integer> adj[];

		GraphNode(int v) {
			this.v = v;
			adj = new ArrayList[v];
			for (int i = 0; i < v; i++) {
				adj[i] = new ArrayList<Integer>();
			}
		}

		void addEdge(int v, int w) {
			adj[v].add(w);
			adj[w].add(v);
		}

		List<Integer> getEdges() {
			return adj[v];
		}

		// Time O(O+V)
		public boolean isCyclic() {
			boolean[] visited = new boolean[v];

			for (int i = 0; i < v; i++) {
				if (!visited[i]) {
					// if (foundCycle(i, -1, visited)) {
					if (cycleHelper(i, -1, visited)) {
						return true;
					}
				}
			}
			return false;
		}

		private boolean cycleHelper(int currentVertex, int parent, boolean[] visited) {
			visited[currentVertex] = true;

			for (int adjVertex : adj[currentVertex]) {
				if (!visited[adjVertex]) {
					if (cycleHelper(adjVertex, currentVertex, visited)) {
						return true;
					}
				}
				else if (adjVertex != parent) {
					return true;
				}
			}
			return false;
		}

		private boolean foundCycle(int node, int parent, boolean[] visited) {
			visited[node] = true;
			Integer connectedNode;
			Iterator<Integer> it = adj[node].iterator();
			while (it.hasNext()) {
				connectedNode = it.next();
				if (!visited[connectedNode]) {
					if (foundCycle(connectedNode, node, visited)) {
						return true;
					}
				}
				else if (connectedNode != parent) {
					return true;
				}
			}
			return false;
		}
	}

	public static void main(String[] args) {
		GraphNode g = new GraphNode(5);
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 0);
		g.addEdge(0, 3);
		g.addEdge(3, 4);
		System.out.print("Graph G: ");
		if (g.isCyclic()) {
			System.out.println("Cycle detected");
		}
		else {
			System.out.println("No Cycle detected");
		}
		System.out.print("Graph G1: ");
		GraphNode g1 = new GraphNode(3);
		g1.addEdge(0, 1);
		g1.addEdge(1, 2);
		if (g1.isCyclic()) {
			System.out.println("Cycle detected");
		}
		else {
			System.out.println("No Cycle detected");
		}
	}

}
