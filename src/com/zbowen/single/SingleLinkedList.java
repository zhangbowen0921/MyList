package com.zbowen.single;

import com.zbowen.AbstractList;

public class SingleLinkedList<E> extends AbstractList<E> {

	private Node<E> firstNode;
	
	private static class Node<E>{
		E element;
		Node<E> next;
		
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
		
	}
	
	
	@Override
	public E get(int index) {
		Node<E> node = getNode(index);
		return node.element;
	}

	@Override
	public E set(int index, E element) {
		Node<E> node = getNode(index);
		E old = node.element;
		node.element = element;
		return old;
	}

	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		if (index==0) {
			firstNode = new Node<E>(element, firstNode);
		}else {
			Node<E> pre = getNode(index-1);
			pre.next = new Node<E>(element, pre.next);
		}
		size++;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		Node<E> node = firstNode;
		if (index==0) {
			firstNode = firstNode.next;
		}else {
			Node<E> preNode = getNode(index-1);
			node = preNode.next;
			preNode.next = node.next;
		}
		size--;
		return node.element;
	}

	@Override
	public int indexof(E element) {
		Node<E> node = firstNode;
		if (element==null) {
			for (int i = 0; i < size; i++) {
				if (node.element==null) {
					return i;
				}
				node = node.next;
			}
		}else {
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element)) {
					return i;
				}
			}
		}
		return ELEMENT_NOT_FOUND;
	}

	@Override
	public void clear() {
		firstNode = null;
		size = 0;
	}
	
	private Node<E> getNode(int index) {
		rangeCheck(index);
		Node<E> node = firstNode;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		Node<E> node = firstNode;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				builder.append(", ");
			}
			builder.append(node.element);
			node = node.next;
		}
		builder.append("]");
		return builder.toString();
	}

}
