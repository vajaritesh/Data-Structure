package com.academy.graph;

import java.util.LinkedList;
import java.util.List;

/*
 * Detect Cycle in a Directed Graph
 * 
 */
public class IsCyclicDirectedGraph {

	static class GraphNode {
		int v;
		List<Integer> adj[];

		GraphNode(int v) {
			this.v = v;
			adj = new LinkedList[v];
			for (int i = 0; i < v; i++) {
				adj[i] = new LinkedList<Integer>();
			}
		}

		void addEdge(int v, int w) {
			adj[v].add(w);
		}

		// Time O(O+V)
		public boolean isCyclic() {
			boolean[] visited = new boolean[v];
			boolean[] stack = new boolean[v];
			for (int vertex = 0; vertex < v; vertex++) {
				if (!visited[vertex]) {
					if (cycleFound(vertex, visited, stack)) {
						return true;
					}
				}
			}
			return false;
		}

		public boolean cycleFound(int vertex, boolean[] visited, boolean[] stack) {
			visited[vertex] = true;
			stack[vertex] = true;

			for (int adjVertex : adj[vertex]) {
				if (!visited[adjVertex] && cycleFound(adjVertex, visited, stack)) {
					return true;
				}
				else if (stack[adjVertex]) {
					return true;
				}
			}
			stack[vertex] = false;
			return false;
		}
	}

	public static void main(String[] args) {
		GraphNode g = new GraphNode(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		// g.addEdge(1, 2);
		// g.addEdge(2, 0);
		// g.addEdge(2, 3);
		g.addEdge(3, 3);

		if (g.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contain cycle");
	}

}
