package com.academy.app.array.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Merge Overlapping Intervals using Interval Class
 * Input: { { 1, 3 }, { 2, 4 }, { 5, 7 }, { 6, 8 } }
 * Output: {{1,4},{5,8}}
 */
public class MergeOverlappingIntervals_V1 {
	static class Interval {
		int start;
		int end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "{" + start + "," + end + "}";
		}
	}

	static class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval a, Interval b) {
			return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
		}
	}

	public static void main(String[] args) {
		// { 6, 8 }, { 1, 9 }, { 2, 4 }, { 4, 7 }
		List<Interval> intervals = new ArrayList<Interval>();
		// intervals.add(new Interval(6, 8));
		// intervals.add(new Interval(1, 9));
		// intervals.add(new Interval(2, 4));
		// intervals.add(new Interval(4, 7));

		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 4));
		intervals.add(new Interval(5, 7));
		intervals.add(new Interval(6, 8));
		System.out.println("Intervals:");
		print(intervals);
		List<Interval> result = merge(intervals);
		System.out.println("Merged Intervals:");
		print(result);
	}

	private static List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 1) {
			return intervals;
		}
		// Collections.sort(intervals, new IntervalComparator());
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval x, Interval y) {
				if (x.start != y.start) {
					return x.start - y.start;
				}
				else {
					return x.end - y.end;
				}
			}
		});

		Interval pre = intervals.get(0);
		for (int i = 0; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (curr.start > pre.end) {
				result.add(pre);
				pre = curr;
			}
			else {
				Interval merged = new Interval(pre.start, Math.max(pre.end, curr.end));
				pre = merged;
			}
		}
		result.add(pre);
		return result;
	}

	private static void print(List<Interval> intervals) {
		for (Interval interval : intervals) {
			System.out.print(interval + ",");
		}
		System.out.println();
	}

}
