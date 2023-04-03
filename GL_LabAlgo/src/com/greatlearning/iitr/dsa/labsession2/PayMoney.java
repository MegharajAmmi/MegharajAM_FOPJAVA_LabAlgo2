package com.greatlearning.iitr.dsa.labsession2;

import java.util.*;

/* the size of the transaction array and the values of the array. 
 * It then creates a doubly linked list and adds the transaction values to it.*/

class DoublyLinkedList {
	class Node {
		int data;
		Node prev, next;

		public Node(int data) {
			this.data = data;
			prev = null;
			next = null;
		}
	}

	Node head, tail;

	/*
	 * the total number of targets that need to be achieved, and for each target, it
	 * prompts the user to enter the value of the target. It then calls the
	 * findTarget method of the doubly linked list to find the number of
	 * transactions needed to achieve the target.
	 */

	public DoublyLinkedList() {
		head = null;
		tail = null;
	}

	public void add(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}

	public void display() {
		Node current = head;
		System.out.print("List: ");
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	/*
	 * The findTarget method takes a target value as input and returns the number of
	 * transactions needed to achieve that target. It iterates over the nodes of the
	 * doubly linked list and keeps track of the sum of transaction values seen so
	 * far. If the sum becomes greater than or equal to the target value, it returns
	 * the number of transactions seen so far. If the end of the list is reached
	 * without achieving the target, it returns -1 to indicate that the target is
	 * not achievable.
	 */

	public int findTarget(int target) {
		Node current = head;
		int sum = 0, count = 0;
		while (current != null) {
			sum += current.data;
			count++;
			if (sum >= target) {
				return count;
			}
			current = current.next;
		}
		return -1;
	}
}

/*
 * The program outputs the result of each target query, indicating whether the
 * target was achieved and how many transactions were needed to achieve it, or
 * that the target was not achievable.
 */

public class PayMoney {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of transaction array: ");
		int n = sc.nextInt();
		DoublyLinkedList list = new DoublyLinkedList();
		System.out.print("Enter the values of array: ");
		for (int i = 0; i < n; i++) {
			int data = sc.nextInt();
			list.add(data);
		}
		System.out.print("Enter the total number of targets that needs to be achieved: ");
		int k = sc.nextInt();
		while (k-- > 0) {
			System.out.print("Enter the value of target: ");
			int target = sc.nextInt();
			int result = list.findTarget(target);
			if (result == -1) {
				System.out.println("Given target is not achieved");
			} else {
				System.out.println("Target achieved after " + result + " transactions");

			}
		}
		sc.close();
	}
}
