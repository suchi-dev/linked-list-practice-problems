package com.sample.test.practice;

/*
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

	Solution:- We make use of 2 pointers slow and fast. The slow takes 1 step at a time while 
	the fast pointer takes 2 steps at a time. When the slow and fast pointer meet there
	is a cycle. If they do not meet at all, there is no cycle.
	
 */
public class LinkedListCycle {

	public boolean isCycle(ListNode head) {
		if (head == null) {
			return false;
		
		}
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast !=null && fast.next !=null && slow !=null) {
			fast = fast.next.next;
			slow = slow.next;
			
			if(fast == slow) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(3);
		ListNode two = new ListNode(2);
		head.next = two;
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(-4);
		head.next.next.next.next = two;
		
		LinkedListCycle llcycle = new LinkedListCycle();
		System.out.println("Is it a cycle? : " +llcycle.isCycle(head));
		

	}

}
