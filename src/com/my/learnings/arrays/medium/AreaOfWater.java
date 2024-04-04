package com.my.learnings.arrays.medium;
// https://leetcode.com/problems/container-with-most-water/description/
// Container With Most Water
// You are given an array of positive integers where each integer represents the height of a
// vertical line on a chart. Find 2 lines which together with the x-axis forms a container that
// would hold the greatest amount of water. Return the area of water it would hold.
public class AreaOfWater {
	public static void main(String[] args) {
		int[] nums = new int[]{7,1,2,3,9};
		System.out.println("Max water area: " + new AreaOfWater().getAreaOfWater(nums));
	}

	private int getAreaOfWater(int[] height) {
		int maxArea = 0;
		for(int i=0, j=height.length-1; i< height.length & j> i; ) {
			int area = (height[i] < height[j] ? height[i] : height[j]) * (j-i);
			maxArea = area > maxArea ? area : maxArea;
			if(height[j] > height[i]) {
				i++;
			}else {
				j--;
			}
		}
		return maxArea;
	}

	//Brute force
	// T: O(n^2)
	// S: O(1)
	private int getAreaOfWaterBF(int[] heights) {
		int maxArea = 0;
		for(int i = 0; i < heights.length; i++) {
			for(int j=i+1; j< heights.length; j++) {
				int area = (heights[i] > heights[j] ? heights[j] : heights[i]) * (j - i);
				maxArea = maxArea >area ? maxArea : area;
			}
		}
		return maxArea;
	}
}
