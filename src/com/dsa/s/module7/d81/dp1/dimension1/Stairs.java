package com.dsa.s.module7.d81.dp1.dimension1;

import java.util.Arrays;

/*
* Q1. Stairs
Problem Description
	You are climbing a staircase and it takes A steps to reach the top.
	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	Return the number of distinct ways modulo 1000000007

Problem Constraints
	1 <= A <= 105

Input Format
	The first and the only argument contains an integer A, the number of steps.

Output Format
	Return an integer, representing the number of ways to reach the top.

Example Input
Input 1:
	A = 2
Input 2:
	A = 3

Example Output:
Output 1:
	2
Output 2:
	3

Example Explanation:
Explanation 1:
	Distinct ways to reach top: [1, 1], [2].
Explanation 2:
	Distinct ways to reach top: [1 1 1], [1 2], [2 1].
* */
public class Stairs {
	long[] dp;
	int mod = 1000000007;

	public int climbStairs(int A) {
		dp = new long[A+1];
		Arrays.fill(dp, -1);
		return (int)(ways(A)%mod);
	}

	private long ways(int A) {
		// For 0th step -> 0 ways
		// For 1st step -> 1 way
		// For 2nd step -> 2 ways
		if(A < 3) {
			dp[A] = A;
		} else if(dp[A] == -1)
			// For Ath step, there
			dp[A] = (ways(A-1)%mod + ways(A-2)%mod)%mod;
		return dp[A];
	}
}
