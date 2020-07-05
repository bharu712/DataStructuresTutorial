package com.bharadwaj;

import java.util.Arrays;

public class ArrayReversal {

	public static <E> void reverseArrayRecursive (E[] data, int low, int high) {
		if(low<high) {
			E temp = data[low];
			data[low] = data[high];
			data[high] = temp;
			reverseArrayRecursive(data, low+1, high-1);
		}
	}
	
	public static <E> void reverseArrayusingStack(E[] data) {
		Stack<E> buffer = new ArrayStack<>(data.length);
		for(int i=0; i<data.length;i++) {
			buffer.push(data[i]);
		}
		for(int i=0; i<data.length;i++) {
			data[i] = buffer.pop();
		}
	}
	
	public static void main(String args[]) {
		Integer[] a = {4, 8, 15, 16, 23, 42};
		String[] s = {"Jack", "Kate", "Hurley", "Jin", "Michael"};
		System.out.println("a = " + Arrays.toString(a));
		System.out.println("s = " + Arrays.toString(s));
		System.out.println("Reversing...");
		reverseArrayRecursive(s, 0, s.length-1);
		reverseArrayusingStack(a);
		System.out.println("a = " + Arrays.toString(a));
		System.out.println("s = " + Arrays.toString(s));
	}
}
