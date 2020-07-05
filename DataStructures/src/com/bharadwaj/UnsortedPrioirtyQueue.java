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
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Entry<K, V> min() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Entry<K, V> removeMin() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
