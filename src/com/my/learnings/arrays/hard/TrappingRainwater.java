package com.my.learnings.arrays.hard;

// https://leetcode.com/problems/trapping-rain-water/submissions/825697236/
// Given n non-negative integers representing an elevation map where the width of each bar is 1,
// compute how much water it can trap after raining.
public class TrappingRainwater {
	public static void main(String[] args) {
		System.out.println("Rain water: "+new TrappingRainwater().getTrappedWater(new int[]{5,5,1,7,1,1,5,2,7,6}));
	}
	// complexity
	// Time : O(n^2)
	// Space: O(1)
	public int getTrappedWaterBF(int[] height) {
		int totalWater = 0;
		for(int i=0; i< height.length; i++) {
			int maxL = height[i];
			int maxR = height[i];
			for(int l=i-1; l>=0; l--) {
				maxL = (maxL > height[l]) ? maxL : height[l];
			}
			for(int r=i+1; r<height.length; r++) {
				maxR = (maxR > height[r]) ? maxR : height[r];
			}
			int currentWater = Math.min(maxL, maxR) - height[i];
			if(currentWater > 0) {
				totalWater += currentWater;
			}
			// System.out.println("i: "+i+ ",currentWater: "+currentWater+", Total water"+totalWater);
		}
		return totalWater;
	}

	/*
		1)	Identify pointer with lesser value
		2)	Is this pointer value lesser than or equal to respective max
			Yes -> Update max on that side
			No -> get water for pointer value, add to total
		3)	Move pointer inwards
		4)	Repeat steps 1,2 & 3 for other pointers.
	 */
	// complexity
	// Time : O(n)
	// Space: O(1)
	public int getTrappedWater(int[] height) {
		int totalWtr = 0;
		int maxLeft = height[0];
		int maxRight = height[height.length - 1];
		for(int pL=0, pR= height.length - 1; pR>= pL;){
//			System.out.println("maxLeft: "+maxLeft+",maxRight: "+maxRight +
//					", pL: "+pL +",height[pL]: "+height[pL]+",pR: "+pR+",height[pR]: "+height[pR]);
			if(maxLeft <= maxRight) {
				if(height[pL] > maxLeft) {
					maxLeft = height[pL];
				} else {
					//int currWtr = maxLeft - height[pL];
					totalWtr += maxLeft - height[pL];
					//System.out.println("Curr water: "+ (maxLeft - height[pL]) + ",total water: "+totalWtr);
				}
				pL++;
			} else {
				if(height[pR] > maxRight) {
					maxRight = height[pR];
				} else {
					//int currWtr = maxRight - height[pR];
					totalWtr += maxRight - height[pR];
					//System.out.println("Curr water: "+ (maxRight - height[pR]) + ",total water: "+totalWtr);
				}
				pR--;
			}
		}
		return totalWtr;
	}
}
