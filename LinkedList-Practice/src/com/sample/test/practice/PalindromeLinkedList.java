package com.sample.test.practice;

import java.util.Stack;

/*
 * Problem Statement - Given the head of a singly linked list, return true if it is a palindrome.
 * 
 * Solution:- We created a new ListNode temp which points to the head of the Linked List
 * Create a stack and push all the nodes.
 * 
 * Pop from the stack and check if the popped value is same as head data.
 * If it is equal then we set the palindrome flag as true and move to the next value
 * If they are unequal, we set the palindrome flag as false and break out of the loop
 * 
 * 
 */

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {
		ListNode temp = head;
		Stack<Integer> visited = new Stack<>();
		boolean isPalindrome = true;

		// Pushing all the linked list nodes into the stack until we reach the end of
		// the Linked list
		while (temp != null) {
			visited.push(temp.val);
			temp = temp.next;
		}
		while (head != null) {
			int i = visited.pop();
			if (i == head.val) {
				isPalindrome = true;
			} else {
				isPalindrome = false;
				break;
			}
			head = head.next;

		}

		return isPalindrome;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		PalindromeLinkedList pll = new PalindromeLinkedList();
		System.out.println("Is it a palindrome ? :" + pll.isPalindrome(head));

		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		System.out.println("Is it a palindrome ? : " + pll.isPalindrome(head1));

	}

}
