package com.sample.test.practice;

/*
 * You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional child pointer. This child pointer may or may not point to a separate doubly linked list, also containing these special nodes. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.

Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level, doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr and before curr.next in the flattened list.

Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.
 */

class MLLListNode {
	int val;
	MLLListNode next;
	MLLListNode child;
	MLLListNode prev;

	MLLListNode() {
	}

	MLLListNode(int val) {
		this.val = val;
		this.prev = null;
		this.next = null;
		this.child = null;
	}

	MLLListNode(int val, MLLListNode next, MLLListNode child, MLLListNode prev) {
		this.val = val;
		this.next = next;
		this.child = child;
		this.prev = prev;
	}
}

public class FlattenMultilevelDLL {

	public MLLListNode flatten(MLLListNode head) {
		if (head == null)
			return null;

		MLLListNode temp = head;
		while (temp != null) {
			if (temp.child != null) {
				MLLListNode lowerTail = flattenUnder(temp.child);
				MLLListNode next = temp.next;
				temp.next = temp.child;
				temp.child.prev = temp;

				if (next != null) {
					lowerTail.next = next;
					next.prev = lowerTail;
				}

				temp.child = null;
				temp = temp.next;

			} else {
				temp = temp.next;
			}
		}

		return head;

	}

	private MLLListNode flattenUnder(MLLListNode child) {
		MLLListNode temp = child;
		while (temp.next != null) {
			temp = temp.next;
		}
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FlattenMultilevelDLL fmll = new FlattenMultilevelDLL();
		
		MLLListNode head = new MLLListNode(1);
		MLLListNode second = new MLLListNode(2);
		MLLListNode third = new MLLListNode(3);
		MLLListNode fourth = new MLLListNode(4);
		MLLListNode fifth = new MLLListNode(5);
		MLLListNode sixth = new MLLListNode(6);
		MLLListNode seventh = new MLLListNode(7);
		MLLListNode eighth = new MLLListNode(8);
		MLLListNode ninth = new MLLListNode(9);
		MLLListNode tenth = new MLLListNode(10);
		MLLListNode eleventh = new MLLListNode(11);
		MLLListNode twelveth = new MLLListNode(12);

		head.next = second;
		second.prev = head;
		second.next = third;
		third.prev = second;
		third.child = seventh;
		third.next = fourth;
		fourth.prev=third;
		fourth.next = fifth;
		fifth.prev = fourth;
		fifth.next = sixth;
		sixth.prev = fifth;
		
		seventh.next = eighth;
		eighth.prev = seventh;
		eighth.next = ninth;
		ninth.prev = eighth;
		ninth.next = tenth;
		tenth.prev = ninth;
		
		eighth.child = eleventh;
		eleventh.next = twelveth;
		twelveth.prev = eleventh;
		
		System.out.println("---------Flatten MLL data--------");
		
		MLLListNode result = fmll.flatten(head);
		while(result !=null) {
			System.out.print(result.val +"|");
			result = result.next;
		}
		
		
		
		
		
		
		

	}

}
