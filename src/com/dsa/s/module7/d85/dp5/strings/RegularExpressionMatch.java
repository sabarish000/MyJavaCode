package com.dsa.s.module7.d85.dp5.strings;
/*
* Q3. Regular Expression Match
Problem Description
	Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.
	' ? ' : Matches any single character.
	' * ' : Matches any sequence of characters (including the empty sequence).
	The matching should cover the entire input string (not partial).

Problem Constraints
	1 <= length(A), length(B) <= 104

Input Format
	The first argument of input contains a string A.
	The second argument of input contains a string B.

Output Format
	Return 1 if the patterns match else return 0.

Example Input
Input 1:
	 A = "aaa"
	 B = "a*"
Input 2:
 	A = "acz"
 	B = "a?a"

Example Output:
Output 1:
 	1
Output 2:
 	0

Example Explanation
Explanation 1:
	 Since '*' matches any sequence of characters. Last two 'a' in string A will be match by '*'.
	 So, the pattern matches we return 1.
Explanation 2:
	 '?' matches any single character. First two character in string A will be match.
	 But the last character i.e 'z' != 'a'. Return 0.

* */
public class RegularExpressionMatch {
	// A string of n length
	// B string of m length
	// DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
	public int isMatch(final String A, final String B) {
		int n = A.length();
		int m = B.length();
		boolean[][] dp = new boolean[n+1][m+1];
		// For first column,
		dp[0][0] = true;
		// Fill the first row
		for(int j=1; j<=m; j++ ) {
			if(B.charAt(j-1)=='*') {
				dp[0][j] = true;
			} else {
				break;
			}
		}

		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(B.charAt(j-1) == '?' || A.charAt(i-1) == B.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				} else if(B.charAt(j-1) == '*') {
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
				}
			}
		}
		return dp[n][m] ? 1 : 0;
	}
}
