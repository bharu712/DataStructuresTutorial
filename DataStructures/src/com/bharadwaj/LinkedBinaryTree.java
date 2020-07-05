package com.bharadwaj;

import java.util.Iterator;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
	
	protected static class Node<E> implements Position<E>{
		
		private E element;
		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;
		
		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild){
			element = e;
			parent = above;
			left = leftChild;
			right = rightChild;
		}
		
		public E getElement() {
			return element;
		}
		public Node<E> getParent(){
			return parent;
		}
		public Node<E> getLeft(){
			return left;
		}
		public Node<E> getRight(){
			return right;
		}
		
		public void setElement(E e) {
			element = e;
		}
		public void setParent(Node<E> p) {
			parent = p;
		}
		public void setLeft(Node<E> l) {
			left = l;
		}
		public void setRight(Node<E> r) {
			right = r;
		}
	}
	
	protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right){
		return new Node<E>(e, parent, left, right);
	}
	
	protected Node<E> root = null;
	private int size = 0;
	
	public LinkedBinaryTree() {}
	
	protected Node<E> validate(Position<E> p) throws IllegalArgumentException{
		if(!(p instanceof Node)) {
			throw new IllegalArgumentException("Not a valid Position Type");
		}
		Node<E> node = (Node<E>) p;
		if(node.parent == node) {
			throw new IllegalArgumentException("p is no longer in the tree");
		}
		return node;
	}
	
	public int size() {
		return size;
	}
	public boolean isEmtpy() {
		return size == 0;
	}
	public Position<E> root() {
		return root;
	}
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		Node<E> n = validate(p);
		return n.getParent();
	}
	public Position<E> left(Position<E> p) throws IllegalArgumentException {
		Node<E> n = validate(p);
		return n.getLeft();
	}
	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		Node<E> n = validate(p);
		return n.getRight();
	}
	
	public Position<E> addRoot(E e) throws IllegalArgumentException{
		if(!isEmpty()) {
			throw new IllegalArgumentException("Tree is not Empty");
		}
		root = createNode(e, null, null, null);
		size = 1;
		return root;
	}
	
	public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> parent = validate(p);
		if(parent.getLeft() != null) {
			throw new IllegalArgumentException("p already has a left child");
		}
		Node<E> leftChild = createNode(e, parent, null, null );
		parent.setLeft(leftChild);
		size++;
		return leftChild;
	}
	
	public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> parent = validate(p);
		if(parent.getRight() != null) {
			throw new IllegalArgumentException("p already has a Right child");
		}
		Node<E> rightChild = createNode(e, parent, null, null );
		parent.setRight(rightChild);
		size++;
		return rightChild;
	}
	
	public E set(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> n = validate(p);
		E temp = n.getElement();
		n.setElement(e);
		return temp;
	}
	
	public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException{
		Node<E> node = validate(p);
		if(isInternal(p)) {
			throw new IllegalArgumentException("p must be a leaf");
		}
		size += t1.size() + t2.size();
		if(!t1.isEmtpy()) {
			t1.root.setParent(node);
			node.setLeft(t1.root);
			t1.root = null;
			t1.size = 0;
		}
		if(!t2.isEmtpy()) {
			t2.root.setParent(node);
			node.setRight(t1.root);
			t2.root = null;
			t2.size = 0;
		}
	}
	
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		if(numChildren(p) == 2) {
			throw new IllegalArgumentException("p has two children");
		}
		Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
		if(child != null) {
			child.setParent(node.getParent());
		}
		if(node == root) {
			root = child;
		}
		else {
			Node<E> parent = node.getParent();
			if(node == parent.getLeft()) {
				parent.setLeft(child);
			}
			else {
				parent.setRight(child);
			}
		}
		size--;
		
		E temp = node.getElement();
		node.setElement(null);
		node.setLeft(null);
		node.setRight(null);
		node.setParent(node);
		return temp;
	}
	
}
