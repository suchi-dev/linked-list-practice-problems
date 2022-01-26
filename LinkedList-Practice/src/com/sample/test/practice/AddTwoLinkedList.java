package com.sample.test.practice;

/*
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

L1 = [2,4,3]
L2 = [5,6,4]
result = [7,0,8]
 */
public class AddTwoLinkedList {

	public ListNode add(ListNode first, ListNode second) {
		ListNode temp = null;
		ListNode result = null;
		ListNode prev = null;
		int carry = 0;
		while (first != null || second != null) {
			int sum = carry + (first != null ? first.val : 0) + (second != null ? second.val : 0);
			carry = (sum >= 10) ? 1 : 0;
			sum = sum % 10;
			temp = new ListNode(sum);
			if (result == null) {
				result = temp;
			} else {
				prev.next = temp;
			}
			prev = temp;
			if (first != null)
				first = first.next;
			if (second != null)
				second = second.next;

		}

		if (carry == 1) {
			temp.next = new ListNode(carry);
		}
		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoLinkedList all = new AddTwoLinkedList();
		ListNode head1 = new ListNode(2);
		head1.next = new ListNode(4);
		head1.next.next = new ListNode(3);
		
		ListNode head2 = new ListNode(5);
		head2.next = new ListNode(6);
		head2.next.next = new ListNode(4);
		int count =0;
		ListNode result = all.add(head1, head2);
		while(count < 3) {
			System.out.print(result.val + "|");
			result = result.next;
			count ++;
			
		}
		
		
		

	}

}
