package com.sample.test.practice;
/*
 * You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

eg :- if l1 = [1,2,4] and l2 =[1,3,4] then the merged list = [1,1,2,3,4,4]
 */
public class MergeTwoLists {
	
	public ListNode merge(ListNode head1, ListNode head2) {
		if(head1 == null) return head2;
		if(head2 == null) return head1;
		
		if(head1.val < head2.val) {
			head1.next = merge(head1.next, head2);
			return head1;
		}else {
			head2.next = merge(head1, head2.next);
			return head2;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MergeTwoLists mergeList = new MergeTwoLists();
		ListNode head1 = new ListNode(1);
		ListNode head2 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(4);
		
		head2.next = new ListNode(3);
		head2.next.next = new ListNode(4);
		ListNode result = mergeList.merge(head1, head2);
		System.out.println("The head of the merged list is "+result.val);
		

	}

}
