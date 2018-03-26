package com.academy.app.array.examples;

/*
 * Best Time to Buy and Sell Stock.
 * You have an array for which the ith element is the price of a given stock on day i.
 * input: { 7, 1, 5, 3, 4, 6 } 
 * output: 5
 * input: { 7, 6, 5, 4, 1 }
 * output: 0
 */
public class BuySellStock {

	public static void main(String[] args) {
		int[] stocks = { 7, 1, 5, 3, 4, 6 };
		// int[] stocks = { 7, 6, 5, 4, 1 };
		int maxProfit = maxProfit(stocks);
		System.out.println(maxProfit);
		int maxProfitLeetCode = maxProfitLeetCode(stocks);
		System.out.println(maxProfitLeetCode);
	}

	private static int maxProfit(int[] stocks) {
		int minStock = Integer.MAX_VALUE;
		int maxStock = Integer.MIN_VALUE;
		int maxProfit = Integer.MIN_VALUE;

		for (int i = 0; i < stocks.length - 1; i++) {
			minStock = Math.min(minStock, stocks[i]);
			maxStock = Math.max(minStock, stocks[i + 1]);
			maxProfit = Math.max(maxProfit, maxStock - minStock);
		}
		return maxProfit;
	}

	private static int maxProfitLeetCode(int[] stocks) {
		int maxProfit = 0;
		int minStock = Integer.MAX_VALUE;
		for (int i = 0; i < stocks.length; i++) {
			if (stocks[i] < minStock) {
				minStock = stocks[i];
			}
			else {
				if (maxProfit < stocks[i] - minStock) {
					maxProfit = stocks[i] - minStock;
				}
			}
		}
		return maxProfit;
	}

}
