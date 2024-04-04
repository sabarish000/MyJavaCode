package com.dsa.s.module5.d57.linkedlist;

public class RemoveLoopFromLinkedList {
	public Node solve(Node A) {
		Node f = A;
		Node s = A;
		while(f!=null && f.next!=null) {
			s=s.next;
			f=f.next.next;
			if(s==f){
				break;
			}
		}
		// System.out.println("s==f at"+s.val);
		Node s1 = A;
		Node s2 = s;
		Node prevS2 = s2;
		while(s1!=s2) {
			s1 = s1.next;
			prevS2 = s2;
			s2 = s2.next;
		}
		prevS2.next = null;
		return A;
	}
}


