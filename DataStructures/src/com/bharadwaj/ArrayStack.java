package com.bharadwaj;

public class ArrayStack<E> implements Stack<E> {

	private static final int CAPACITY = 1000;
	private E[] data;
	private int t = -1;
	
	public ArrayStack() {
		this(CAPACITY);
	}
	
	public ArrayStack(int capacity) {
		data = (E[]) new Object[capacity];
	}

	@Override
	public int size() {
		return t+1;
	}

	@Override
	public boolean isEmpty() {
		return (t==-1);
	}

	@Override
	public void push(E e) {
		if(size() == data.length) {
			throw new IllegalStateException("Stack is full");
		}
		else {
			data[++t] = e;
		}
	}

	@Override
	public E top() {
		if(isEmpty()) {
			return null;
		}
		else {
			return data[t];
		}
	}

	@Override
	public E pop() {
		if(isEmpty()) {
			return null;
		}
		else {
			E answer = data[t];
			data[t] = null;
			t--;
			return answer;
		}
	}

	public static void main(String args[]) {
		ArrayStack<Integer> a = new ArrayStack<>();
		
		System.out.println(a.isEmpty());
		System.out.println(a.top());
		a.push(10);
		a.push(20);
		a.push(30);
		System.out.println(a.top());
		System.out.println(a.pop());
		System.out.println(a.top());
	}
}
