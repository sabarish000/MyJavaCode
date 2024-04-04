package com.dsa.s.module7.d83.dp3.knapsack;

import java.util.Arrays;

/*
* Q2. Unbounded Knapsack
* ----------------------
Problem Description
	Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], we need to calculate maximum amount that could fit in this quantity.
	This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.

Problem Constraints
	1 <= A <= 1000
	1 <= |B| <= 1000
	1 <= B[i] <= 1000
	1 <= C[i] <= 1000

Input Format
	First argument is the Weight of knapsack A
	Second argument is the vector of values B
	Third argument is the vector of weights C

Output Format
	Return the maximum value that fills the knapsack completely

Example Input
Input 1:
	A = 10
	B = [5]
	C = [10]
Input 2:
	A = 10
	B = [6, 7]
	C = [5, 5]

Example Output
Output 1:
	5
Output 2:
	14


Example Explanation
Explanation 1:
	Only valid possibility is to take the given item.
Explanation 2:
	Take the second item twice.
* */
public class UnboundedKnapsack {
	public static void main(String[] args) {
		int cap = 80;
		int[] vals =  {14,13,7,5,5,7,13,16,17,1};
		int[] wts = {10,20,9,4,15,4,4,1,15,2};
		int ans = new UnboundedKnapsack().solve(cap, vals, wts);
		System.out.println(ans);
	}
	public int solve(int A, int[] B, int[] C) {
		int[][] dp = new int[B.length+1][A+1];
		for(int i=1; i<=B.length; i++) {
			for(int j=1; j<=A; j++) {
				//
				int ans1 = dp[i-1][j]; // Don't take i-th element, so reduce i by 1, don't add value to ans
				int ans2 = 0;
				// i -> the num of items
				// j -> the capacity of bag
				if(j-C[i-1] >= 0) {
					ans2 = B[i-1]+dp[i][j-C[i-1]]; // Take i-th element and repetition is allowed so don't reduce N i.e i here, so it is dp[i]
				}
				System.out.println("i & j: "+i + ", " + j +", ans1 & ans2: "+ans1 + ", " + ans2 + ", exp: "+ (j-C[i-1]));
				dp[i][j]=Math.max(ans1, ans2);
			}
		}
		System.out.println("DP: "+ Arrays.deepToString(dp));
		return dp[B.length][A];
	}
}
