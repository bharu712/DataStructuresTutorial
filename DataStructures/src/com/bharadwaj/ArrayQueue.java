package com.bharadwaj;

import java.util.Arrays;

public class ArrayQueue<E> implements Queue<E> {

	private E data[];
	private int f = 0;
	private int sz = 0;
	private static final int CAPACITY=1000;
	
	public ArrayQueue() {
		this(CAPACITY);
	}
	
	public ArrayQueue(int capacity) {
		data = (E[]) new Object[capacity];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return sz;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size() == 0);
	}

	@Override
	public void enqueue(E e) {
		if(sz==data.length) {
			throw new IllegalStateException("Stack is Full");
		}
		else {
			int avail = (f + sz)%data.length;
			data[avail] = e;
			sz++;
		}
		
	}

	@Override
	public E dequeue() {
		if(isEmpty()) {
			return null;
		}
		else {
			E answer = data[f];
			data[f] = null;
			f= (f+1)%data.length;
			sz--;
			return answer;
		}
	}

	@Override
	public E first() {
		if(isEmpty()) {
			return null;
		}
		return data[f];
	}

	public static void main(String args[]) {
		ArrayQueue<Integer> aq = new ArrayQueue<>(5);
		System.out.println(aq.size());
		aq.enqueue(10);
		aq.enqueue(20);
		aq.enqueue(30);
		aq.enqueue(40);
		System.out.println(aq.f);
		System.out.println(aq.dequeue());
		System.out.println(aq.f);
		System.out.println(aq.size());
		System.out.println(Arrays.toString(aq.data));
		
		aq.enqueue(50);
		aq.enqueue(60);
		
		System.out.println(Arrays.toString(aq.data));
		System.out.println(aq.first());
		System.out.println(aq.dequeue());
		System.out.println(Arrays.toString(aq.data));
		
	}
}
