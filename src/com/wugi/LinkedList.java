package com.wugi;

public class LinkedList<E> {
	Node<E> head;
	Node<E> tail;
	
	static class Node<E> {
		E value;
		Node<E> next;
		
		public Node(E value) {
			this.value = value;
		}
	}
	
	public void append(E value) {
		Node<E> node = new Node<>(value);
		if (head == null) {
			head = node;
			tail = node;
			return;
		}
		
		tail.next = node;
		tail = node;
	}
	
	public void printAll() {
		Node<E> node = head;
		while (node != null) {
			System.out.println(node.value);
			node = node.next;
		}
	}
}
