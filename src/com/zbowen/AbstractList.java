package com.zbowen;

public abstract class AbstractList<E> implements List<E> {

	protected int size;

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public boolean contains(E element) {
		return indexof(element)!= ELEMENT_NOT_FOUND;
	}

	@Override
	public void add(E element) {
		add(size, element);
	}

	@Override
	public abstract E get(int index);

	@Override
	public abstract E set(int index, E element);

	@Override
	public abstract void add(int index, E element);

	@Override
	public abstract E remove(int index);

	@Override
	public abstract int indexof(E element);

	@Override
	public abstract void clear();
	
	
	protected void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			outOutOfBoundsException(index);
		}
	}

	protected void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			outOutOfBoundsException(index);
		}
	}

	protected void outOutOfBoundsException(int index) {
		throw new IndexOutOfBoundsException("Index:" + index + " Size:" + size);
	}
	
}
