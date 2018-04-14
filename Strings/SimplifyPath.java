package com.academy.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * Simplify Path
 * Given an absolute path for a file (Unix-style), simplify it.
 */
public class SimplifyPath {

	public static void main(String[] args) {
		String path = "/a/./b/../../c/";
		// String path = "/../";
		// String path = "/home//abc/";
		String simplify = simplifyPath(path);
		System.out.println(simplify);
	}

	private static String simplifyPath(String path) {
		Queue<String> queue = new LinkedList<String>();
		Set<String> skip = new HashSet<String>(Arrays.asList("..", ".", ""));
		String[] dirs = path.split("/");
		for (String dir : dirs) {
			if (dir.equals("..") && !queue.isEmpty()) {
				queue.poll();
			}
			else if (!skip.contains(dir)) {
				queue.add(dir);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			sb.append("/").append(queue.poll());
		}
		return sb.length() == 0 ? "/" : sb.toString();
	}

}
