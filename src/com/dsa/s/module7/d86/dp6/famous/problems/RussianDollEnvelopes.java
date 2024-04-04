package com.dsa.s.module7.d86.dp6.famous.problems;

import java.util.Arrays;

/*
* Q1. Russian Doll Envelopes
Problem Description
	Given a matrix of integers A of size N x 2 describing dimensions of N envelopes, where A[i][0] denotes the height of the ith envelope and A[i][1] denotes the width of the ith envelope.
	One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
	Find the maximum number of envelopes you can put one inside other.

Problem Constraints
	1 <= N <= 1000
	1 <= A[i][0], A[i][1] <= 109

Input Format
	The only argument given is the integer matrix A.

Output Format
	Return an integer denoting the maximum number of envelopes you can put one inside other.

Example Input
Input 1:
 A = [
         [5, 4]
         [6, 4]
         [6, 7]
         [2, 3]
     ]
Input 2:
 A = [     '
         [8, 9]
         [8, 18]
     ]

Example Output
Output 1:
 3
Output 2:
 1

Example Explanation
Explanation 1:
 Step 1: put [2, 3] inside [5, 4]
 Step 2: put [5, 4] inside [6, 7]
 3 envelopes can be put one inside other.
Explanation 2:
 No envelopes can be put inside any other so answer is 1.
* */
public class RussianDollEnvelopes {
	public int solve(int[][] A) {
		Envelope[] envelopes = new Envelope[A.length];
		for(int i=0; i<A.length; i++) {
			envelopes[i] = new Envelope(A[i][0], A[i][1]);
		}
		Arrays.sort(envelopes, (e1,e2) -> e1.height - e2.height);
		// System.out.println(Arrays.toString(envelopes));
		int[] dp = new int[A.length];
		dp[0] = 1;
		int ans = 1;
		for(int i=1; i<envelopes.length; i++) {
			int maxLIS = 0;
			for(int j=0; j<i; j++) {
				if(envelopes[j].height < envelopes[i].height && envelopes[j].width < envelopes[i].width) {
					maxLIS = Math.max(maxLIS, dp[j]);
				}
			}
			dp[i] = maxLIS + 1;
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}

	private class Envelope{
		int width;
		int height;
		Envelope(int width, int height) {
			this.width = width;
			this.height = height;
		}
		public String toString() {
			return "["+this.height+"," + this.width + "]";
		}
	}
}
