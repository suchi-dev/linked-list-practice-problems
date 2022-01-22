package com.sample.test.practice;

/*
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 */
public class MyLinkedList {

	class Node {
		int val;
		Node next;

		Node(int x) {
			this.val = x;
			this.next = null;
		}
	}

	Node head, tail;
	int size;

	public MyLinkedList() {
		this.size = 0;
		this.head = this.tail = null;
	}

	public int get(int index) {
		if (index >= size) {
			return -1;
		}
		if (index == 0) {
			return head.val;
		}

		Node temp = head;
		int i = 0;
		while (i++ < index - 1) {
			temp = temp.next;
		}

		return temp.next.val;

	}

	public void addAtHead(int val) {
		Node node = new Node(val);
		if (head == null) {
			head = tail = node;
			size++;
			return;
		}

		node.next = head;
		head = node;
		size++;

	}

	public void addAtTail(int val) {
		Node node = new Node(val);
		if (head == null) {
			addAtHead(val);
			return;

		}

		tail.next = node;
		tail = node;
		size++;
	}

	public void addAtIndex(int index, int val) {
		Node node = new Node(val);
		if (index > size) {
			return;
		}
		if (index == 0) {
			addAtHead(val);
			return;
		}

		if (index == size - 1) {
			addAtTail(val);
			return;
		}
		int i = 0;
		Node temp = head;
		while (i++ < index - 1) {
			temp = temp.next;
		}
		node.next = temp.next;
		temp.next = node;
		size ++;

	}
	
	public void deleteAtIndex(int index) {
		if(index >=size) {
			return ;
		}
		if(index ==0) {
			head = head.next;
			size --;
		}
		
		Node temp = head;
		int i =0;
		while (i++ < index -1) {
			temp = temp.next;
		}
		
		
		temp.next = temp.next.next;
		if(index == size -1) {
			tail = temp;
		}
		size --;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

			MyLinkedList myll = new MyLinkedList();
			myll.addAtHead(1);
			myll.addAtTail(3);
			myll.addAtIndex(1,2);
			Node temp = myll.head;
			
			System.out.println("After adding values to linked list");
			while(temp !=null) {
				System.out.print(temp.val +"|");
				temp = temp.next;
			}
			
			System.out.println();
			System.out.println("Getting the value at index 1");
			System.out.println(myll.get(1));
			myll.deleteAtIndex(1);
			System.out.println("After deletion at index 1");
			Node temp1 = myll.head;
			while(temp1 !=null) {
				System.out.print(temp1.val +"|");
				temp1 = temp1.next;
			}
			
	}			
			
			

}
