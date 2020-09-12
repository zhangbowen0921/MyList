package com.zbowen;

/**
 * 自己实现 动态数组
 * 
 * @author zbowen
 *
 */
@SuppressWarnings("unchecked")
public class ArrayList<E> extends AbstractList<E> {

	private E[] elements;

	private static final int DEFAULT_CAPATICY = 10;

	public ArrayList(int capaticy) {
		capaticy = capaticy < DEFAULT_CAPATICY ? DEFAULT_CAPATICY : capaticy;
		elements = (E[]) new Object[capaticy];
	}

	public ArrayList() {
		this(DEFAULT_CAPATICY);
	}

	@Override
	public E get(int index) {
		rangeCheck(index);
		return elements[index];
	}

	@Override
	public E set(int index, E element) {
		rangeCheck(index);
		E old = elements[index];
		elements[index] = element;
		return old;
	}

	@Override
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		ensureCapaticy();
		for (int i = size; i > index; i--) {
			elements[i] = elements[i-1];
		}
		elements[index] = element;
		size++;
	}

	private void ensureCapaticy() {
		if (size >= elements.length) {
			// 扩容
			int newCapaticy = size + (size >> 2);
			E[] arr = (E[]) new Object[newCapaticy];
			for (int i = 0; i < elements.length; i++) {
				arr[i] = elements[i];
			}
			elements = arr;
		}
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		E remove = elements[index];
		for (int i = index + 1; i < size; i++) {
			elements[i-1] = elements[i];
		}
		elements[size--] = null;
		return remove;
	}

	@Override
	public int indexof(E element) {
		if (element == null) {
			for (int i = 0; i < elements.length; i++) {
				if (elements[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < elements.length; i++) {
				if (element.equals(elements[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	public void clear() {
		for (int i = 0; i < elements.length; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				builder.append(", ");
			}
			builder.append(elements[i]);
		}
		builder.append("]");
		return builder.toString();
	}
}
