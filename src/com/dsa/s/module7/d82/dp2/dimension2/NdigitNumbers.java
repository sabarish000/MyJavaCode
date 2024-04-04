package com.dsa.s.module7.d82.dp2.dimension2;

import java.util.Arrays;

/*
* Q2. N digit numbers
Problem Description
	Find out the number of A digit positive numbers, whose digits on being added equals to a given number B.
	Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.
	Since the answer can be large, output answer modulo 1000000007

Problem Constraints
	1 <= A <= 1000
	1 <= B <= 10000

Input Format
	First argument is the integer A
	Second argument is the integer B

Output Format
	Return a single integer, the answer to the problem

Example Input
Input 1:
	 A = 2
	 B = 4
Input 2:
	 A = 1
	 B = 3

Example Output
Output 1:
	 4
Output 2:
	 1

Example Explanation
Explanation 1:
	 Valid numbers are {22, 31, 13, 40}
	 Hence output 4.
Explanation 2:
	 Only valid number is 3
* */
public class NdigitNumbers {
	int[][] dp;
	public int solve(int A, int B) {
		dp = new int[A+1][B+1];
		for(int i=0; i<dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		return ways(A, B);
	}

	private int ways(int dgts, int sum) {
		int mod = 1000000007;
		if(dgts == 0 && sum == 0) return 1;
		else if(dgts<=0 || sum<=0) return 0;
		if(dp[dgts][sum] != -1) return dp[dgts][sum];
		if(dgts == 1 && sum <=9) {
			dp[dgts][sum] = 1;
			return 1;
		}
		int count = 0;
		for(int j=0; j<=9; j++) {
			count = (count%mod + ways(dgts-1, sum-j)%mod)%mod;
		}
		dp[dgts][sum] = count;
		return count;
	}
}
