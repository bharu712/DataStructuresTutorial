package com.bharadwaj;

public class CircularLinkedQueue<E> implements CircularQueue<E> {

private CircularlyLinkedList<E> cl = new CircularlyLinkedList<>();
	
	@Override
	public int size() {
		return cl.size();
	}

	@Override
	public boolean isEmpty() {
		return cl.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		cl.addLast(e);
	}

	@Override
	public E dequeue() {
		return cl.removeFirst();
	}

	@Override
	public E first() {
		return cl.first();
	}

	@Override
	public void rotate() {
		cl.rotate();		
	}
	
	
}
