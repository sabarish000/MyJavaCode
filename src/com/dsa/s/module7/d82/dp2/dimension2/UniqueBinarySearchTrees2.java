package com.dsa.s.module7.d82.dp2.dimension2;

import java.util.Arrays;

/*
Problem Description
	Given an integer A, how many structurally unique BST's (binary search trees) exist that can store values 1...A?

Problem Constraints
1 <= A <=18

Input Format
	First and only argument is the integer A

Output Format
	Return a single integer, the answer to the problem

Example Input
Input 1:
	 1
Input 2:
	 2

Example Output
Output 1:
	 1
Output 2:
	 2

Example Explanation:
Explanation 1:
	 Only single node tree is possible.
Explanation 2:
	 2 trees are possible, one rooted at 1 and other rooted at 2.

* */
public class UniqueBinarySearchTrees2 {
	int[] dp;
	public int numTrees(int A) {
		dp = new int[A+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		return ways(A);
	}

	private int ways(int A) {
		if(A<=0) return 1;
		if(A == 1) {
			dp[A] = 1;
			return 1;
		}
		if(dp[A] != -1) return dp[A];
		int count = 0;
		for(int i=1; i<=A; i++) {
			// Selecting i as root
			// i-1 nodes can form left Tree(ways(i-1)) and i-th node as root (1 way) and A-i nodes can form right tree ways(A-i)
			// equals ways(i-1) * 1 * ways(A-i)
			// Catalan number: 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796
			count += ways(i-1) * 1 * ways(A-i);
		}
		dp[A] = count;
		// System.out.println(Arrays.toString(dp));
		return dp[A];
	}
}
