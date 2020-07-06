package com.bharadwaj;

public class LinkedPositionalList<E> implements PositionalList<E> {
	
	private static class Node<E> implements Position<E>{
		
		private E element;
		private Node<E> prev;
		private Node<E> next;
		
		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}
		public Node<E> getPrev(){
			return prev;
		}
		public Node<E> getNext(){
			return next;
		}
		private void setNext(Node<E> n) {
			next = n;
		}
		private void setPrev(Node<E> p) {
			prev= p;
		}
		public E getElement() throws IllegalStateException {
			if(next == null) {
				throw new IllegalStateException("Not a valid Position");
			}
			return element;
		}
		public void setElement(E e) {
			element = e;
		}
	}
	
	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;
	
	public LinkedPositionalList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}
	
	private Node<E> validate(Position<E> p) throws IllegalStateException{
		if (!(p instanceof Node)) {
			throw new IllegalStateException("Not a valid Position");
		}
		Node<E> node = (Node<E>) p;
		if(node.next == null) {
			throw new IllegalStateException("Position Doesn't exist");
		}
		return node;
	}
	
	private Position<E> position(Node<E> node){
		if(node == header || node == trailer) {
			return null;
		}
		return node;
	}
	
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public Position<E> first() {
		return position(header.getNext());
	}

	public Position<E> last() {
		return position(trailer.getPrev());
	}

	public Position<E> after(Position<E> p) throws IllegalStateException {
		Node<E> node = validate(p);
		return position(node.getNext());
	}

	public Position<E> before(Position<E> p) throws IllegalStateException {
		Node<E> node = validate(p);
		return position(node.getPrev());
	}

	private Position<E> addBetween(E e, Node<E> pred, Node<E> succ){
		Node<E> newest = new Node<>(e, pred, succ);
		pred.setNext(newest);
		succ.setPrev(newest);
		size++;
		return newest;
	}
	
	public Position<E> addFirst(E e) {
		return addBetween(e, header, header.getNext());
	}

	public Position<E> addLast(E e) {
		return addBetween(e, trailer.getPrev(), trailer);
	}

	public Position<E> addBefore(Position<E> p, E e) throws IllegalStateException {
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}

	public Position<E> addAfter(Position<E> p, E e) throws IllegalStateException {
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}

	public E set(Position<E> p, E e) {
		Node<E> node = validate(p);
		E answer = node.getElement();
		node.setElement(e);
		return answer;
	}

	public E remove(Position<E> p) {
		Node<E> node = validate(p);
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		E answer = node.getElement();
		node.setElement(null);
		node.setNext(null);
		node.setPrev(null);
		return answer;
	}

	@Override
	public Iterable<Position<E>> positions() {
		// TODO Auto-generated method stub
		return null;
	}

}
