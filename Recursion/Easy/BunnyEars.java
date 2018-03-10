package com.academy.recursion;

public class BunnyEars {

	public static void main(String[] args) {
		int bunnies = 6;
		int ans = bunnyEars(bunnies);
		System.out.println(ans);
	}

	public static int bunnyEars(int bunnies) {
		if (bunnies == 0) {
			return 0;
		}
		return 2 + bunnyEars(bunnies - 1);
	}
}
