package com.bharadwaj;

import java.util.Comparator;

public class UnsortedPrioirtyQueue<K,V> extends AbstractPriorityQueue<K,V> {

	private PositionalList<Entry<K,V>> list = new LinkedPositionalList<>();
	
	public UnsortedPrioirtyQueue() {
		super();
	}
	public UnsortedPrioirtyQueue(Comparator<K> comp) {
		super(comp);
	}
	
	private Position<Entry<K,V>> findMin() throws IllegalArgumentException{
		 Position<Entry<K,V>> small = list.first();
		 for(Position<Entry<K,V>> walk : list.positions()) {
			 if(compare(walk.getElement(),small.getElement()) < 0) {
				 small = walk;
			 }
		 }
		 return small;
	}
	
	public int size() {
		return list.size();
	}
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key);
		Entry<K,V> newest = new PQEntry<>(key, value);
		list.addLast(newest);
		return newest;
	}
	public Entry<K, V> min() {
		if(list.isEmpty()) {
			return null;
		}
		return findMin().getElement();
	}
	public Entry<K, V> removeMin() {
		if(list.isEmpty()) {
			return null;
		}
		return list.remove(findMin());
	}
	
}
