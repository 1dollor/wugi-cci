package com.wugi;

import com.wugi.LinkedList.Node;

public class WeavingLinkedList {
	private static int NUM_OF_ONE_KIND_ELEMENT = 8;
	public static void main(String[] args) {
		// Make data
		LinkedList<String> list = new LinkedList<>();
		String[] prefixs = {"A", "B"};
		for (String prefix : prefixs) {
			for (int i=1; i<=NUM_OF_ONE_KIND_ELEMENT; i++) {
				list.append(prefix+i);
			}
		}
		
		list.printAll();
		
		// 주 : 항상 짝수 가정.
		// Find middle point
		Node<String> n1 = list.head.next;
		Node<String> n2 = list.head;
		while (n1.next != null) {
			n1 = n1.next.next;
			n2 = n2.next;
		}
		
		// Weaving
		n1 = list.head;
		Node<String> tmp = n2.next;
		n2.next = null;
		n2 = tmp;
		while (n2 != null) {
			tmp = n1.next;
			n1.next = n2;
			Node<String> newN2 = n2.next;
			n2.next = tmp;
			n1 = tmp;
			n2 = newN2;
		}
		
		System.out.println("------------");
		list.printAll();

	}
}
