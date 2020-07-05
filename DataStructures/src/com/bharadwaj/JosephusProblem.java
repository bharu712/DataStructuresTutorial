package com.bharadwaj;

import java.util.Arrays;

public class JosephusProblem {
	
	public static <E> E josephus(CircularLinkedQueue<E> queue, int k) {
		if(queue.isEmpty()) {
			return null;
		}
		while(queue.size()>1) {
			System.out.println(queue.first());
			for(int i=0; i<k-1; i++) {
				queue.rotate();
			}
			System.out.println(queue.first());
			E e = queue.dequeue();
			System.out.println(queue.size());
			System.out.println("     " + e + " is out");
			System.out.println(queue.first());
		}
		return queue.dequeue();
	}
	
	public static<E> CircularLinkedQueue<E> buildQueue(E a[]){
		CircularLinkedQueue<E> queue = new CircularLinkedQueue<>();
		for(int i=0; i<a.length; i++) {
			queue.enqueue(a[i]);
		}
		return queue;
	}
	
	public static void main(String args[]) {
		String a1[] = {"Alice", "Bob", "Cindy", "Doug", "Ed", "Fred"};
		String a2[] = {"Gene", "Hope", "Irene","Jack","Kim","Lance"};
		String a3[] = {"Mike", "Roberto"};
		
		System.out.println("First Winner is : "+ josephus(buildQueue(a1), 3));
		//System.out.println("Second Winner is : "+ josephus(buildQueue(a2), 10));
		//System.out.println("Third Winner is : "+ josephus(buildQueue(a3), 7));
	}
}
