package com.my.learnings.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static void main(String[] args) {
		int[] resp = new TwoSum().getSumofTwoHash(new int[]{1,5,2,7,9}, 12);
		if(resp != null) {
			System.out.println("Resp: " + resp[0] + ","+ resp[1]);
		} else {
			System.out.println("No matches found");
		}
	}

	private int[] getSumofTwoHash(int[] nums, int target) {
		Map<Integer, Integer> hashMap = new HashMap<>();
		for(int i=0; i< nums.length; i++) {
			int numToFind = target-nums[i];
			Integer mapVal = hashMap.get(numToFind);
			if(mapVal != null) {
				return new int[] {mapVal,i };
			} else {
				hashMap.put(nums[i], i);
			}
		}
		return null;
	}

	//Brute force
	// T: O(n^2)
	// S: O(1)
	private int[] getSumofTwoBF(int[] array, int target) {
		if(array.length > 1) {
			for(int i = 0; i < array.length; i++) {
				int numToFind = target - array[i];
				for( int j=i+1; j< array.length; j++) {
					if(array[j] == numToFind) {
						return new int[]{i,j};
					}
				}
			}
		}
		return null;
	}
}
