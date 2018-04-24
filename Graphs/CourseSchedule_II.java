package com.academy.graph;

import java.util.LinkedList;
import java.util.Queue;

/*
 *Course Schedule II
 * 
 */
public class CourseSchedule_II {

	public static void main(String[] args) {
		int courses = 4;
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		int[] orderOfCourses = canFinish(courses, prerequisites);
		for (int i = 0; i < orderOfCourses.length; i++) {
			System.out.print(orderOfCourses[i] + " ");
		}
	}

	public static int[] canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites == null) {
			throw new IllegalArgumentException("illegal prerequisites array");
		}

		int len = prerequisites.length;
		int[] result = new int[numCourses];
		if (numCourses == 0) {
			return result;
		}

		// counter for number of prerequisites
		int[] indegree = initiliazeIndegree(numCourses, prerequisites);

		// store courses that have no prerequisites
		Queue<Integer> queue = initiliazeQueue(numCourses, indegree);

		// number of courses that have no prerequisites
		int index = 0;
		while (!queue.isEmpty()) {
			int top = queue.remove();
			for (int i = 0; i < len; i++) {
				// if a course's prerequisite can be satisfied by a course in queue
				if (prerequisites[i][1] == top) {
					if (--indegree[prerequisites[i][0]] == 0) {

						queue.add(prerequisites[i][0]);
					}
				}
			}
			result[index++] = top;
			// System.out.print(top + " ");
		}
		if (index != numCourses) {
			// Cycle exits. Throw exception
			int[] error = new int[0];
			return error;
		}
		return result;
	}

	private static int[] initiliazeIndegree(int vertex, int[][] preReq) {
		int[] indegree = new int[vertex];
		for (int i = 0; i < preReq.length; i++) {
			indegree[preReq[i][0]]++;
		}
		return indegree;
	}

	private static Queue<Integer> initiliazeQueue(int vertex, int[] indegree) {
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < vertex; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		return queue;
	}

}
