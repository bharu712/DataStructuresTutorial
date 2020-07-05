package com.bharadwaj;

public interface Queue<E> {
	int size();
	boolean isEmpty();
	void enqueue(E e);
	E dequeue();
	E first();
}
