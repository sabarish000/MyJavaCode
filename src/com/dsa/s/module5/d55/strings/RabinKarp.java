package com.dsa.s.module5.d55.strings;
/*
* Q2. Rabin Karp

Problem Description
Given two string A and B of length N and M respectively consisting of lowercase letters. Find the number of occurrences of B in A.

Problem Constraints
1 <= M <= N <= 105

Input Format
Two argument A and B are strings

Output Format
Return an integer denoting the number of occurrences of B in A

Example Input
Input 1:
A = "acbac"
B = "ac"
Input 2:
A = "aaaa"
B = "aa"

Example Output
Output 1:
2
Output 2:
3
* */
public class RabinKarp {
	public int solve(String A, String B) {
		int mod = 1000000007;
		int N=A.length();
		int M=B.length();
		int ans=0;
		int bHash = hashOfSubstring(B, 0, B.length()-1);
		int oldHash = hashOfSubstring(A, 0, B.length()-1);
		if(bHash == oldHash) {
			ans++;
		}
		int power26 = power(26, M-1);
		for(int i=1; i<=N-M; i++) {
			int prevHash = (A.charAt(i-1)%mod * power26%mod)%mod;
			int nextHash = A.charAt(M+i-1);
			//System.out.println("prevHash: "+prevHash);
			int newHash = (((oldHash%mod - prevHash%mod)*26)%mod + nextHash%mod)%mod;
			//System.out.println("bHash, oldHash, newHash: "+bHash+", "+oldHash +", "+newHash);
			if(newHash == bHash) {
				ans++;
			}
			oldHash = newHash;
		}
		return ans;
	}

	private int hashOfSubstring(String A, int start, int end) {
		int mod = 1000000007;
		int hash = 0;
		int power = 1;
		int p =26;
		for(int i=end; i>=start; i--) {
			hash = (hash%mod + (A.charAt(i)%mod*power%mod)%mod)%mod;
			power=(p%mod*power%mod)%mod;
		}
		return hash%mod;
	}

	private int power(int num, int power) {
		int mod = 1000000007;
		if(power==0) {
			return 1;
		} else if(power==1){
			return num;
		}
		int hp = power(num, power/2)%mod;
		if((power&1)==1) { //ODD
			return ((hp*hp)%mod * num%mod)%mod;
		} else { //EVEN
			return (hp*hp)%mod;
		}
	}
}
