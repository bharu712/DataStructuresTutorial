package com.bharadwaj;

public class SinglyLinkedList<E> implements Cloneable{

	public static class Node<E>{
		private E element;
		private Node<E> next;
		
		public Node(E e, Node<E> n){
			element = e;
			next = n;
		}
		public E getElement() {
			return element;
		}
		public Node<E> getNext(){
			return next;
		}
		public void setNext(Node<E> n) {
			next = n;
		}
	}
	
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	public SinglyLinkedList() {
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public E first() {
		if(isEmpty()) {
		return null;
		}
		else {
		return head.getElement();
		}
	}
	
	public E last() {
		if(isEmpty()) {
			return null;
			}
			else {
			return tail.getElement();
			}
	}
	
	public void addFirst(E e) {
		head = new Node<E>(e,head);
		if(size==0) {
			tail = head;
		}
		size++;
	}
	
	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		if(isEmpty()) {
			head = newest;
		}
		else {
			tail.setNext(newest);
		}
		tail = newest;
		size++;
	}
	
	public E removeFirst() {
		if(isEmpty()) {
			return null;
		}
		E answer = head.getElement();
		head = head.getNext();
		size--;
		
		if(size==0) {
			tail = null;
		}
		return answer;
	}
	
	public static void main(String args[]) {
		SinglyLinkedList<Integer> llist = new SinglyLinkedList<>();
		SinglyLinkedList<Integer> llist2 = new SinglyLinkedList<>();
		System.out.println(llist.size);
		
		llist.addFirst(10);
		llist.addFirst(20);
		llist.addFirst(30);
		llist.addFirst(40);
		
		llist2.addFirst(10);
		llist2.addFirst(20);
		llist2.addFirst(30);
		llist2.addFirst(40);
		
		
		System.out.println(llist.first());
		System.out.println(llist.last());
		llist.removeFirst();
		llist2.removeFirst();
		System.out.println(llist.first());
		System.out.println(llist.head);
		System.out.println(llist.tail);
		
		System.out.println(llist.size);
		System.out.println(llist2.size);
		System.out.println(llist.equals(llist2));
		
	}
	
	//Implementing equals method
	
	public boolean equals(Object o) {
		if(o==null) {
			return false;
		}
		if(getClass()!= o.getClass()) {
			return false;
		}
		SinglyLinkedList other = (SinglyLinkedList) o;
		if(size!=other.size) {
			return false;
		}
		Node walkA = head;
		Node walkB = other.head;
		
		while(walkA != null) {
			if(!(walkA.getElement().equals(walkB.getElement()))){
				return false;
			}
			System.out.println(walkA.getElement());
			System.out.println(walkB.getElement());
			walkA = walkA.getNext();
			walkB = walkB.getNext();
		}
		return true;
	}
	
	public SinglyLinkedList<E> clone() throws CloneNotSupportedException{
		SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone();
		if(size>0) {
			other.head = new Node<>(head.getElement(),null);
			Node<E> walk = head.getNext();
			Node<E> otherTail = other.head;
			while(walk!=null) {
				Node<E> newest = new Node<>(walk.getElement(),null);
				otherTail.setNext(newest);
				otherTail=newest;
				walk = walk.getNext();
			}
		}
		return other;
	}
	
}
