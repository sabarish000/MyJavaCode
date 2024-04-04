package com.dsa.s.module7.d82.dp2.dimension2;
/*
Q1. Unique Paths in a Grid
--------------------------
Problem Description
	Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m).
	At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).
	Now consider if some obstacles are added to the grids.
	Return the total number unique paths from (1, 1) to (n, m).

	Note:
	1. An obstacle is marked as 1 and empty space is marked 0 respectively in the grid.
	2. Given Source Point and Destination points are 1-based index.

Problem Constraints
	1 <= n, m <= 100
	A[i][j] = 0 or 1

Input Format
	First and only argument A is a 2D array of size n * m.

Output Format
	Return an integer denoting the number of unique paths from (1, 1) to (n, m).


Example Input
Input 1:
	 A = [
			[0, 0, 0]
			[0, 1, 0]
			[0, 0, 0]
		 ]
Input 2:
	 A = [
			[0, 0, 0]
			[1, 1, 1]
			[0, 0, 0]
		 ]

Example Output:
Output 1:
	 2
Output 2:
	 0

Example Explanation:
Explanation 1:
	 Possible paths to reach (n, m): {(1, 1), (1, 2), (1, 3), (2, 3), (3, 3)} and {(1 ,1), (2, 1), (3, 1), (3, 2), (3, 3)}
	 So, the total number of unique paths is 2.
Explanation 2:
	 It is not possible to reach (n, m) from (1, 1). So, ans is 0.
* */
public class UniquePathsInGrid {
	public int uniquePathsWithObstacles(int[][] A) {
		int M = A[0].length;
		int[] ways = new int[M];
		// Initialize first(0-th) row of ways with 1 untill it encounters an obstacle
		for(int j=0; j<M; j++) {
			if(A[0][j] == 1) {
				break;
			}
			ways[j] = 1;
		}
		for(int i=1; i<A.length; i++) {
			for(int j=0; j<M; j++) {
				if(A[i][j] == 1) {
					ways[j] = 0;
				} else {
					// Num of ways to reach current cell = ways from top + ways from left
					// For 0th col, ways from left is 0 ways
					ways[j] = ways[j] + (j==0 ? 0 : ways[j-1]);
				}
			}
		}
		// System.out.println(Arrays.deepToString(ways));
		return ways[M-1];
	}

	// public int uniquePathsWithObstacles(int[][] A) {
	//     int N = A.length;
	//     int M = A[0].length;
	//     int[][] ways = new int[N][M];
	//     //Initialize first(0-th) col of ways with 1 untill it encounters an obstacle
	//     for(int i=0; i<N; i++) {
	//         if(A[i][0] == 1) {
	//             break;
	//         }
	//         ways[i][0] = 1;
	//     }
	//     //Initialize first(0-th) row of ways with 1 untill it encounters an obstacle
	//     for(int j=0; j<M; j++) {
	//         if(A[0][j] == 1) {
	//             break;
	//         }
	//         ways[0][j] = 1;
	//     }
	//     //
	//     for(int i=1; i<N; i++) {
	//         for(int j=1; j<M; j++) {
	//             // If there is an obstacle, then no ways to reach here is 0;
	//             if(A[i][j] == 1) {
	//                 ways[i][j] = 0;
	//             } else {
	//                 // Num of ways to reach current cell = ways from top + ways from left
	//                 ways[i][j] = ways[i-1][j] + ways[i][j-1];
	//             }
	//         }
	//     }
	//     //System.out.println(Arrays.deepToString(ways));
	//     return ways[N-1][M-1];
	// }
}
