package com.academy.graph;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Course Schedule
 * https://www.programcreek.com/2014/05/leetcode-course-schedule-java/ 
 */
public class CourseSchedule {

	public static void main(String[] args) {
		int courses = 2;
		int[][] prerequisites = {};
		if (canFinish(courses, prerequisites)) {
			System.out.println("Course can finish");
		}
		else {
			System.out.println("Course cannot finished");
		}
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites == null) {
			throw new IllegalArgumentException("illegal prerequisites array");
		}

		int len = prerequisites.length;

		if (numCourses == 0) {
			return true;
		}

		// counter for number of prerequisites
		int[] indegree = initiliazeIndegree(numCourses, prerequisites);

		// store courses that have no prerequisites
		Queue<Integer> queue = initiliazeQueue(numCourses, indegree);

		// number of courses that have no prerequisites
		int numNoPre = queue.size();

		while (!queue.isEmpty()) {
			int top = queue.remove();
			for (int i = 0; i < len; i++) {
				// if a course's prerequisite can be satisfied by a course in queue
				if (prerequisites[i][1] == top) {
					if (--indegree[prerequisites[i][0]] == 0) {
						numNoPre++;
						queue.add(prerequisites[i][0]);
					}
				}
			}
			// System.out.print(top + " ");
		}

		return numNoPre == numCourses;
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
