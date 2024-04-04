package com.dsa.s.module7.d76.back_tracking1;

import java.util.Arrays;
/*
Q2. Permutations
Problem Description
	Given an integer array A of size N denoting collection of numbers , return all possible permutations.

NOTE:
	No two entries in the permutation sequence should be the same.
	For the purpose of this problem, assume that all the numbers in the collection are unique.
	Return the answer in any order
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
	Example : next_permutations in C++ / itertools.permutations in python.
	If you do, we will disqualify your submission retroactively and give you penalty points.

Problem Constraints
	1 <= N <= 9

Input Format
	Only argument is an integer array A of size N.

Output Format
	Return a 2-D array denoting all possible permutation of the array.

Example Input
	A = [1, 2, 3]

Example Output
	[ [1, 2, 3]
	  [1, 3, 2]
	  [2, 1, 3]
	  [2, 3, 1]
	  [3, 1, 2]
	  [3, 2, 1] ]

Example Explanation
	All the possible permutation of array [1, 2, 3].
* */
public class Permutations {
	int[][] ans;
	int k = 0;
	public int[][] permute(int[] A) {
		ans = new int[factorial(A.length)][A.length];
		permute(0,A);
		return ans;
	}

	private void permute(int indx, int[] A) {
		if(indx == A.length) {
			ans[k] = Arrays.copyOf(A, A.length);
			k++;
			return;
		}

		for(int i=indx; i<A.length; i++) {
			// DO  swap the A[i] and A[indx]
			swap(A, indx, i);
			permute(indx+1, A);
			//UNDO
			swap(A, i, indx);
		}
	}

	private void swap(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}

	private int factorial(int num) {
		if(num < 2) return 1;
		return num * factorial(num-1);
	}
}
