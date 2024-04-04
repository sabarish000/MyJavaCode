package com.dsa.s.module7.d76.back_tracking1;

import java.util.ArrayList;
import java.util.Collections;

public class Subset {
	/*
	**********
	Q1. Subset
	**********
	Problem Description
	Given a set of distinct integers A, return all possible subsets.

	NOTE:
		Elements in a subset must be in non-descending order.
		The solution set must not contain duplicate subsets.
		Also, the subsets should be sorted in ascending ( lexicographic ) order.
		The initial list is not necessarily sorted.

	Problem Constraints
		1 <= |A| <= 16
		INTMIN <= A[i] <= INTMAX

	Input Format
		First and only argument of input contains a single integer array A.

	Output Format
		Return a vector of vectors denoting the answer.
	_____________________________________________________________________
	Example Input:
	---------------------------------------------------------------------
	Input 1:
	A = [1]

	Input 2:
	A = [1, 2, 3]

	----------------
	Example Output
	----------------
	Output 1:
		[
			[]
			[1]
		]
	Output 2:
		[
			[]
			[1]
			[1, 2]
			[1, 2, 3]
			[1, 3]
			[2]
			[2, 3]
			[3]
		]

	Example Explanation
	Explanation 1:

	You can see that these are all possible subsets.
			Explanation 2:

	You can see that these are all possible subsets.
	*/
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Collections.sort(A);
		subset(new ArrayList<Integer>(), 0, A, res);
		Collections.sort(res, (a,b)-> {
			for(int i=0; i<Math.min(a.size(), b.size()); i++) {
				if(a.get(i) != b.get(i)) return a.get(i) - b.get(i);
			}
			return a.size()-b.size();
		});
		return res;
	}

	private void subset(ArrayList<Integer> ans, int index, ArrayList<Integer> A, ArrayList<ArrayList<Integer>> res) {
		if(A.size() == index) {
			//System.out.println("Adding: " + ans);
			res.add(new ArrayList<Integer>(ans));
			return;
		}
		// Add A[index]
		//System.out.println(ans + "," + A.get(index));
		ans.add(A.get(index));
		subset(ans, index+1, A, res);
		ans.remove(ans.size()-1);
		subset(ans, index+1, A, res);
	}
}
