package com.bharadwaj;

public class LinkedQueue<E> implements Queue<E> {

	private SinglyLinkedList<E> sl = new SinglyLinkedList<>();
	
	@Override
	public int size() {
		return sl.size();
	}

	@Override
	public boolean isEmpty() {
		return sl.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		sl.addLast(e);
	}

	@Override
	public E dequeue() {
		return sl.removeFirst();
	}

	@Override
	public E first() {
		return sl.first();
	}

}
