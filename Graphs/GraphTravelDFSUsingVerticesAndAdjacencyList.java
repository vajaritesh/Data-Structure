package com.academy.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * Graph Travel - DFS Adjacency list array
 */
public class GraphTravelDFSUsingVerticesAndAdjacencyList {

	int v; // No. of vertices
	LinkedList<Integer> adj[]; // Adjacency list array

	GraphTravelDFSUsingVerticesAndAdjacencyList(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int index = 0; index < v; index++) {
			adj[index] = new LinkedList<Integer>();
		}
	}

	void addEdge(int v, int w) {
		this.adj[v].add(w);
	}

	void DFS(int v) {
		boolean[] visited = new boolean[4];
		DFSUtil(v, visited);
	}

	private void DFSUtil(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		LinkedList<Integer> adjList = adj[v];
		Iterator<Integer> list = adjList.listIterator();
		while (list.hasNext()) {
			int node = list.next();
			if (!visited[node]) {
				DFSUtil(node, visited);
			}
		}
	}

	private void DFS() {
		boolean[] visited = new boolean[4];
		for (int index = 0; index < 4; index++) {
			if (!visited[index]) {
				DFSUtil(index, visited);
			}
		}
	}

	private void explore() {
		boolean[] visited = new boolean[4];
		for (int index = 0; index < 4; index++) {
			if (!visited[index]) {
				List<Integer> list = new ArrayList<Integer>();
				dfs(index, list, visited);
				print(list);
			}
		}

	}

	private void print(List<Integer> list) {
		for (Integer num : list) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	private void dfs(int index, List<Integer> list, boolean[] visited) {
		list.add(index);
		visited[index] = true;
		for (Integer num : adj[index]) {
			if (!visited[num]) {
				dfs(num, list, visited);
			}
		}
	}

	public static void main(String[] args) {
		GraphTravelDFSUsingVerticesAndAdjacencyList g = new GraphTravelDFSUsingVerticesAndAdjacencyList(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		System.out.println("Following is DFS Traversal of Full Graph");
		g.DFS();
		System.out.println();
		int v = 2;
		System.out.println("Following is DFS Traversal Starting at Vertex: " + v);
		g.DFS(v);
		System.out.println();
		System.out.println("Explore Graph using DFS Traversal");
		g.explore();

	}

}
