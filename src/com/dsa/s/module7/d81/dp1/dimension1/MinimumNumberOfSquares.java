package com.dsa.s.module7.d81.dp1.dimension1;

import java.util.Arrays;
/*
* Q3. Minimum Number of Squares
Problem Description
	Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.

Problem Constraints
	1 <= A <= 105



Input Format
	First and only argument is an integer A.



Output Format
	Return an integer denoting the minimum count.



Example Input
Input 1:
	A = 6
Input 2:
	A = 5

Example Output
Output 1:
	3
Output 2:
	2

Example Explanation:
Explanation 1:
	Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
	Minimum count of numbers, sum of whose squares is 6 is 3.
Explanation 2:
	We can represent 5 using only 2 numbers i.e. 12 + 22 = 5
* */
public class MinimumNumberOfSquares {
	int[] res;
	public int countMinSquares(int A) {
		res = new int[A+1];
		Arrays.fill(res, -1);
		return cms(A);
	}

	private int cms(int N) {
		if(N<3) res[N] = N;
		else if(res[N] == -1){
			int minValue = Integer.MAX_VALUE;
			for(int i=1; i*i <= N; i++) {
				if(i*i == N) {
					minValue = 1;
					break;
				} else {
					minValue = Math.min(minValue, 1 + cms(N-(i*i)));
				}
			}
			res[N] = minValue;
		}
		//System.out.println(Arrays.toString(res) + " : " + N);
		return res[N];
	}
}
