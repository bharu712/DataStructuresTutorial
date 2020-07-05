package com.bharadwaj;

public class DoublyLinkedList<E> {
	private static class Node<E>{
		private E element;
		private Node<E> next;
		private Node<E> prev;
		
		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			next = n;
			prev = p;
		}
		private E getElement() {
			return element;
		}
		private Node<E> getNext(){
			return next;
		}
		private Node<E> getPrev(){
			return prev;
		}
		private void setNext(Node<E> n) {
			next = n;
		}
		private void setPrev(Node<E> p) {
			prev= p;
		}
	}
	
	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;
	
	public DoublyLinkedList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0 ;
	}
	
	public E first() {
		if(isEmpty()) {
			return null;
		}
		return header.getNext().getElement();
	}
	
	public E last() {
		if(isEmpty()) {
			return null;
		}
		return trailer.getPrev().getElement();
	}
	
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}
	
	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}
	public void addLast(E e) {
		addBetween(e,trailer.getPrev(),trailer);
	}
	
	private E remove(Node<E> node) {
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement();
	}
	
	public E removeFirst() {
		return remove(header.getNext());
	}
	public E removeLast() {
		return remove(trailer.getPrev());
	}
}
