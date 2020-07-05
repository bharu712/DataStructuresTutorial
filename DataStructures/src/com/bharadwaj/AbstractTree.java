package com.bharadwaj;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

public abstract class AbstractTree<E> implements Tree<E> {
	public boolean isInternal(Position<E> p) {
		return numChildren(p) > 0;
	}
	
	public boolean isExternal(Position<E> p) {
		return numChildren(p) == 0;
	}
	
	public boolean isRoot(Position<E> p) {
		return p == root();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		snapshot.add(p);
		for(Position<E> c : children(p)) {
			preorderSubtree(c, snapshot);
		}
	}
	
	public Iterable<Position<E>> preorder(){
		List<Position<E>> snapshot = new ArrayList<>();
		if(!isEmpty()) {
			preorderSubtree(root(), snapshot);
		}
		return snapshot;
	}
	
	private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
		for(Position<E> c : children(p)) {
			postorderSubtree(c, snapshot);
		}
		snapshot.add(p);
	}
	
	public Iterable<Position<E>> postorder(){
		List<Position<E>> snapshot = new ArrayList<>();
		if(!isEmpty()) {
			postorderSubtree(root(), snapshot);
		}
		return snapshot;
	}
	
	public Iterable<Position<E>> breadthfirst(){
		List<Position<E>> snapshot = new ArrayList<>();
		if(!isEmpty()) {
			LinkedQueue<Position<E>> fringe = new LinkedQueue<>();
			fringe.enqueue(root());
			while(!fringe.isEmpty()) {
				Position<E> p = fringe.dequeue();
				snapshot.add(p);
				for(Position<E> c : children(p)) {
					fringe.enqueue(c);
				}
			}
		}
		return snapshot;
	}
	
	public Iterable<Position<E>> positions(){
		return preorder();
	}

	private class ElementIterator implements Iterator<E> {
		
		Iterator<Position<E>> posIterartor = positions().iterator();
		public boolean hasNext() {
			return posIterartor.hasNext();
		}
		public E next() {
			return posIterartor.next().getElement();
		}
		public void remove() {
			posIterartor.remove();
		}
	}
	
	public Iterator<E> iterator(){
		return new ElementIterator();
	}
}
