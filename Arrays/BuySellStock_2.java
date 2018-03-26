package com.academy.app.array.examples;

/*
 * Best Time to Buy and Sell Stock II
 * You have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BuySellStock_2 {

	public static void main(String[] args) {
		int[] stocks = { 7, 1, 5, 3, 6, 4 };
		int maxProfit = findMaxProfit(stocks);
		System.out.println(maxProfit);
	}

	private static int findMaxProfit(int[] stocks) {
		int maxProfit = 0;
		for (int i = 0; i < stocks.length - 1; i++) {
			if (stocks[i + 1] > stocks[i]) {
				maxProfit += stocks[i + 1] - stocks[i];
			}
		}
		return maxProfit;
	}

}
