package com.my.learnings.strings.easy;
// https://leetcode.com/problems/backspace-string-compare/submissions/829002892/
public class TypedOut {
	private final char backspaceChar = '#';
	public static void main(String[] args) {
		System.out.println("Typed equal: "+new TypedOut().areEqual("a##d","#d"));
	}

	private boolean areEqual(String s, String t) {
		String typedS = "";
		String typedT = "";
		// char[] strArray = s.toCharArray();
		int length = Math.max(s.length(), t.length());
		for(int i = 0; i < length; i++) {
			if(i < s.length()) {
				if(s.charAt(i) == backspaceChar) {
					typedS = (typedS.length() > 0 ? typedS.substring(0, typedS.length() - 1) : "");
				} else {
					typedS = typedS + s.charAt(i);
				}
			}
			if(i < t.length()) {
				if(t.charAt(i) == backspaceChar) {
					typedT = (typedT.length() > 0 ? typedT.substring(0, typedT.length() - 1) : "");
				} else {
					typedT = typedT + t.charAt(i);
				}
			}
			System.out.println("s: " + typedS + ",t: " + typedS);
		}
		System.out.println("*****Final*****");
		System.out.println("s: " + typedS + ",t: " + typedS);
		if(typedS.length() != typedT.length()) {
			return false;
		}
		return typedS.equals(typedT);
	}
}
