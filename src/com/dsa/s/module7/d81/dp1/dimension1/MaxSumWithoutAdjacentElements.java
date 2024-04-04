package com.dsa.s.module7.d81.dp1.dimension1;

import java.util.Arrays;

/*
Q4. Max Sum Without Adjacent Elements
-------------------------------------
Problem Description
	Given a 2 x N grid of integers, A, your task is to choose numbers from the grid such that sum of these numbers is maximized.
	However, you cannot choose two numbers that are adjacent horizontally, vertically, or diagonally.
	Return the maximum possible sum.

	Note: You are allowed to choose more than 2 numbers from the grid.

Problem Constraints
	1 <= N <= 20000
	1 <= A[i] <= 2000

Input Format
	The first and the only argument of input contains a 2d matrix, A.

Output Format
	Return an integer, representing the maximum possible sum.

Example Input
Input 1:
	 A = [
			[1]
			[2]
		 ]
Input 2:
	 A = [
			[1, 2, 3, 4]
			[2, 3, 4, 5]
		 ]

Example Output
Output 1:
	 2
Output 2:
	 8

Example Explanation:
Explanation 1:
	 We will choose 2 (From 2nd row 1st column).
Explanation 2:
	 We will choose 3 (From 2nd row 2nd column) and 5 (From 2nd row 4th column).
*
*/
public class MaxSumWithoutAdjacentElements {
	int[] res;
	public int adjacent(int[][] A) {
		res = new int[A[0].length];
		Arrays.fill(res, -1);
		return mss(A[0].length-1, A);
	}

	private int mss(int N, int[][] A) {
		if(N==0) {
			res[N] = Math.max(A[0][0], A[1][0]);
		} else if(N==1) {
			int ans0 = mss(0, A);
			int ans1 = Math.max(A[0][1], A[1][1]);
			res[N] = Math.max(ans0, ans1);
		} else if(res[N] == -1) {
			int ans1 = mss(N-1, A);
			int ans2 = mss(N-2, A) + Math.max(A[0][N], A[1][N]);
			res[N] = Math.max(ans1, ans2);
		}
		// System.out.println("For N: "+ N + ", " + Arrays.toString(res));
		return res[N];
	}
}
