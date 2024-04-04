package com.dsa.s.module5.d50.binary.search3;

public class AthMagicalNumber {
	long mod = 1000000007;

	public int solve(int A, int B, int C) {
		long start=Math.min(B,C);
		long end=A*start;
		long lcm=(B*C)/gcd(B,C);
		long result=0;
		while(start<=end)
		{
			long mid=start+(end-start)/2;
			long index=(mid/B+mid/C-mid/lcm);
			if(index>=A)
			{
				result=mid;
				end=mid-1;
			}
			else start=mid+1;
		}
		return (int)(result%(1000000007));
	}
//
//	public int hcf(int a,int b)
//	{
//		if(b==0)
//			return a;
//		return hcf(b,a%b);
//	}
	// search space is min(B,C) to A*min(B,C)
//	public int solve(int A, int B, int C) {
//		int min = Math.min(B,C);
//		long lcm = lcm(B,C);
//		long l = min;
//		long r = A*min;
//		long ans = r;
//		System.out.println("LCM : " + lcm );
//		while(l<=r) {
//			long mid = l + (r-l)/2;
//			long nof = mid/B + mid/C - mid/lcm;
//			System.out.print("l & r: " + l + ", "+r + ", mid: " + mid );
//			System.out.println(", mid/B + mid/C - mid/lcm = nof " + mid/B +" + "+ mid/C +" - "+ mid/lcm+ " = " + nof);
//			if(nof == A) {
//				ans = mid;
//				r = mid-1; // GO LEFT for better ans
//			}
//			else if(nof < A) { // GO RIGHT
//				l = mid+1;
//			} else { // GO LEFT
//				r = mid-1;
//			}
//		}
//		return (int) (ans%mod);
//	}

	private long lcm(int a, int b) {
		return (a*(long)b) / gcd(a,b);
	}

	private int gcd(int a, int b) {
		if(b==0) return a;
		return a>b ? gcd(b, a%b) : gcd(a, b%a);
	}

	public static void main(String[] args) {
		System.out.println(new AthMagicalNumber().solve(807414236, 3788, 38141)); // 238134151
		// System.out.println(new AthMagicalNumber().solve(7, 6, 4)); // 238134151
	}
}
