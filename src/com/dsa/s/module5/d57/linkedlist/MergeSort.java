package com.dsa.s.module5.d57.linkedlist;

public class MergeSort {
	public Node mergeSort(Node head) {
		if(head == null) {
			return null;
		} else if(head.next == null){
			// if head is the only element
			return head;
		} else {
			Node mid = mid(head);
			Node l = head;
			Node r = mid.next;
			mid.next = null; // breaking the LL at mid
			l = mergeSort(l); // Sort the left half
			r = mergeSort(r); // Sort the right half
			return merge(l, r); // merge the left and right halves
		}
	}
	/*
	* returns the mid-element of the LL
	* */
	private Node mid(Node head) {
		Node f = head;
		Node s = head;

		while(f.next != null && f.next.next != null) {
			s = s.next;
			f = f.next.next;
		}

		return s;
	}
	/*
	 * Merges Two Sorted Lists
	 * returns the head
	 * */
	private Node merge(Node l, Node r) {
		Node h1 = l;
		Node h2 = r;

		Node head = null;
		if(h1.val < h2.val) {
			head = h1;
			h1 = h1.next;
		} else {
			head = h2;
			h2 = h2.next;
		}
		Node p = head;

		while(h1!=null && h2!=null) {
			if(h1.val < h2.val) {
				p.next = h1;
				h1 = h1.next;
			} else {
				p.next = h2;
				h2 = h2.next;
			}
			p = p.next;
		}

		if(h1!=null) {
			p.next = h1;
		}
		if(h2!=null) {
			p.next = h2;
		}
		return head;
	}
}


