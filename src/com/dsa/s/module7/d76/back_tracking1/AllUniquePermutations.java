package com.dsa.s.module7.d76.back_tracking1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Q3. All Unique Permutations
***************************
Problem Description
	Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.

NOTE: No 2 entries in the permutation sequence should be the same.

WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
	Example : next_permutations in C++ / itertools.permutations in python.
	If you do, we will disqualify your submission retroactively and give you penalty points.

Problem Constraints
	1 <= |A| <= 9
	0 <= A[i] <= 10

Input Format
	Only argument is an integer array A of size N.

Output Format
	Return a 2-D array denoting all possible unique permutation of the array.

Example Input
Input 1:
	A = [1, 1, 2]
Input 2:
	A = [1, 2]

Example Output
Output 1:
	[ [1,1,2]
	  [1,2,1]
	  [2,1,1] ]
Output 2:
	[ [1, 2]
	  [2, 1] ]
*/
public class AllUniquePermutations {
	private ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
		Map<Integer,Integer> freqs = new HashMap<>();
		// Construct freqs map.
		for(int a: A) {
			freqs.put(a, freqs.getOrDefault(a, 0)+1);
		}
		permute(0, freqs,new ArrayList<Integer>(), A);
		return res;
	}

	private void permute(int indx, Map<Integer,Integer> freqs, ArrayList<Integer> ans, ArrayList<Integer> A) {
		if(indx == A.size()) {
			res.add(new ArrayList<Integer>(ans));
		}
		// For every number in freq key
		for(int key: freqs.keySet()) {
			int freq = freqs.get(key);
			if(freq > 0) {
				// DO Add the key to ans at indx
				ans.add(key);
				freqs.put(key, freq-1);
				permute(indx+1, freqs, ans, A);

				// UNDO
				ans.remove(ans.size()-1);
				freqs.put(key, freq);
			}
		}
	}
}
