package com.dsa.s.module7.d85.dp5.strings;
/*
* Q1. Edit Distance
Problem Description
	Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)
	You have the following 3 operations permitted on a word:
	Insert a character
	Delete a character
	Replace a character

Problem Constraints
	1 <= length(A), length(B) <= 450

Input Format
	The first argument of input contains a string, A.
	The second argument of input contains a string, B.

Output Format
	Return an integer, representing the minimum number of steps required.

Example Input:
Input 1:
	 A = "abad"
	 B = "abac"
Input 2:
	 A = "Anshuman"
	 B = "Antihuman

Example Output:
Output 1:
 	1
Output 2:
 	2


Example Explanation
Exlanation 1:
 A = "abad" and B = "abac"
 After applying operation: Replace d with c. We get A = B.
Explanation 2:
 A = "Anshuman" and B = "Antihuman"
 After applying operations: Replace s with t and insert i before h. We get A = B.
 * */
public class EditDistance {
	public int minDistance(String A, String B) {
		int n = A.length();
		int m = B.length();
		int[][] dp = new int[n+1][m+1];
		// first row
		for(int j=1; j<=m; j++) {
			dp[0][j] = j;
		}
		// first col
		for(int i=1; i<=n; i++) {
			dp[i][0] = i;
		}

		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(A.charAt(i-1) == B.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					int delete = dp[i-1][j];
					int replace = dp[i-1][j-1];
					int insert = dp[i][j-1];
					int min = Math.min(delete, replace);
					dp[i][j] = 1 + Math.min(min, insert);
				}
			}
		}
		return dp[n][m];
	}
}
