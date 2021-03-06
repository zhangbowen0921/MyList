package com.zbowen;

import com.zbowen.AbstractList;

public class LinkedList<E> extends AbstractList<E> {

	private Node<E> firstNode;
	private Node<E> lastNode;

	private static class Node<E> {
		E element;
		Node<E> pre;
		Node<E> next;

		public Node(E element, Node<E> pre, Node<E> next) {
			this.element = element;
			this.pre = pre;
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
		if (index == size) { // index = 1, size = 1
			Node<E> oldLast = lastNode;
			lastNode = new Node<E>(element, lastNode, null);
			if (oldLast == null) {
				firstNode = lastNode;
			} else {
				oldLast.next = lastNode;
			}
		} else {
			Node<E> next = getNode(index);
			Node<E> pre = next.pre;
			Node<E> node = new Node<E>(element, pre, next);
			next.pre = node;
			if (pre == null) { // index = 0
				firstNode = node;
			} else {
				pre.next = node;
			}
		}
		size++;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);

		Node<E> old = getNode(index);
		// old.pre.next = old.next;
		// old.next.pre = old.pre;

		// 考虑old.pre==null 即index==0
		if (index == 0) {
			firstNode = firstNode.next;
		} else {
			old.pre.next = old.next;
		}
		// 考虑old.next==null 即index==size-1
		if (old.next == null) { // 减少运算
			lastNode = lastNode.pre;
		} else {
			old.next.pre = old.pre;
		}
		size--;
		return old.element;
	}

	@Override
	public int indexof(E element) {
		Node<E> node = firstNode;
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (node.element == null) {
					return i;
				}
				node = node.next;
			}
		} else {
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
		lastNode = null;
		size = 0;
	}

	private Node<E> getNode(int index) {
		rangeCheck(index);
		Node<E> node = null;
		if (index > size / 2) {
			node = lastNode;
			for (int i = size - 1; i > index; i--) {
				node = node.pre;
			}
		} else {
			node = firstNode;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
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
