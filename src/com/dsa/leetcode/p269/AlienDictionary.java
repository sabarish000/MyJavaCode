package com.dsa.leetcode.p269;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.

You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted lexicographically by the rules of this new language.

Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.



Example 1:

Input: words = ["wrt","wrf","er","ett","rftt"]
Output: "wertf"
Example 2:

Input: words = ["z","x"]
Output: "zx"
Example 3:

Input: words = ["z","x","z"]
Output: ""
Explanation: The order is invalid, so return "".


Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of only lowercase English letters.
*/
public class AlienDictionary {
	public static void main(String[] args) {
		String[] words = new String[] { "wrtt", "wrt", "wrf", "er", "ett", "tr", "rftt", "trt" };
		System.out.println(new AlienDictionary().alienOrder(words));
	}

	private String alienOrder(String[] words) {
		// Construct the trie graph.
		Node root = new Node('*');
		boolean isValidTrie = constructTrie(words, root);
		//System.out.println(root);
		StringBuilder ans = new StringBuilder();
		if(isValidTrie) {
			//BFS trie
			boolean[] visited = new boolean[26];
			Queue<Node> q = new LinkedList<Node>();
			// add root to queue
			q.add(root); // added
			while(q.size()>0) {
				Node rm = q.remove();
				// System.out.println("Removed: "+ rm);
				if(rm.val != '*' && !visited[rm.val -'a']){ // Do not append root node value '*'
					ans.append(rm.val);
					visited[rm.val -'a'] = true;
				}
				for(Node adj: rm.children) {
					if(adj!=null) {
						q.add(adj);
					}
				}
				//System.out.println("Queue" + q);
			}
		}
		return ans.toString();
	}

	private boolean constructTrie(String[] words, Node root) {
		for(String word: words) {
			Node curr = root;
			for(char ch: word.toCharArray()){
				int ind = curr.getChildIndex(ch);
				//System.out.println(ch + ": " + ind );
				if(ind == -1) {
					curr = curr.addChild(ch);
				} else  {
					curr = curr.children.get(ind);
					if(curr.isEOW) {// Invalid lexicographically sorted order,
						return false;
					}
				}
			}
			curr.isEOW = true;
		}
		return true;
	}

	private class Node {
		char val;
		List<Node> children;
		private Map<Character, Integer> indices = new HashMap<Character, Integer>();
		boolean isEOW = false;
		Node(char val) {
			this.val = val;
			this.children = new ArrayList<Node>();
		}
		public Node addChild(char ch ) {
			indices.put(ch, children.size());
			Node nn = new Node(ch);
			children.add(nn);
			return nn;
		}

		public int getChildIndex(char ch) {
			return this.indices.getOrDefault(ch, -1);
		}

		public String toString() {
			// return val + "";
			return val + children.toString() + indices;
		}
	}
}


