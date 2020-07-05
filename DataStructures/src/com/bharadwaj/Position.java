package com.bharadwaj;

public interface Position<E> {

	E getElement() throws IllegalStateException;
}
