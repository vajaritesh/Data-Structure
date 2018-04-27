package com.academy.graph;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.youtube.com/watch?v=lRzbE739Cnw
 * Connected Components
 */
public class ConnectedComponents {

	static class GraphNode {
		int vertex;
		List<Integer> edges[];

		GraphNode(int vertex) {
			this.vertex = vertex;
			this.edges = new ArrayList[vertex];
			for (int i = 0; i < vertex; i++) {
				edges[i] = new ArrayList<Integer>();
			}
		}

		public void addEdge(int v, int e) {
			this.edges[v].add(e);
		}
	}

	public static void main(String[] args) {
		GraphNode graph = new GraphNode(5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(3, 4);
		int connnectedComponents = findConnectedComponents(graph);
		System.out.println("Connected components: " + connnectedComponents);

	}

	// Time : O(V + E)
	private static int findConnectedComponents(GraphNode graph) {

		int connectedComponentCount = 0;
		boolean[] visited = new boolean[graph.vertex];
		int[] componentGroup = new int[graph.vertex];
		for (int i = 0; i < graph.vertex; i++) {
			if (!visited[i]) {
				dfs(i, graph, visited, componentGroup, connectedComponentCount);
				connectedComponentCount++;
			}
		}

		for (int testVertex = 0; testVertex < graph.vertex; testVertex++) {
			System.out.println("Vertex " + testVertex + " Component Group: " + componentGroup[testVertex]);
		}
		return connectedComponentCount;
	}

	private static void dfs(int vertexNode, GraphNode graph, boolean[] visited, int[] componentGroup,
	        int connectedComponentCount) {
		if (visited[vertexNode]) {
			return;
		}
		visited[vertexNode] = true;
		componentGroup[vertexNode] = connectedComponentCount;
		for (int connectedVertex : graph.edges[vertexNode]) {
			if (!visited[connectedVertex]) {
				dfs(connectedVertex, graph, visited, componentGroup, connectedComponentCount);
			}
		}

	}

}
