package com.bharadwaj;

public class ArrayList<E> implements List<E> {
	
	private static final int CAPACITY = 16;
	private E data[];
	private int size = 0;

	public ArrayList() {
		this(CAPACITY);
	}
	
	public ArrayList(int capacity) {
		data = (E[]) new Object[capacity];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size==0);
	}

	public void checkIndex(int i, int n) {
		if(i<0 || i>= n) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		checkIndex(i,size);
		return data[i];
	}

	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i,size);
		E answer = data[i];
		data[i] = e;
		return answer;
	}

	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size+1);
		if(size == data.length) {
			throw new ArrayIndexOutOfBoundsException("Array is full");
		}
		else {
			for(int k=size-1; k>i; k--) {
				data[k+1] = data[k];
			}
			data[i] = e;
			size++;
		}
	}

	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		checkIndex(i,size);
		E answer = data[i];
		data[i] = null;
		for(int k=i; k<size-1; k++) {
			data[k] = data[k+1];
		}
		data[size-1] = null;
		size--;
		return answer;
	}

}
