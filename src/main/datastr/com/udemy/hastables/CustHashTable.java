package com.udemy.hastables;

/**
 * Custom HashTable Implementation for fast lookup
 * 
 * @author Shashwat
 */

public class CustHashTable<V> {
	private V[] entries;
	private int capacity;
	private int size = 0;
	private float loadFactor = 0.8f;

	public CustHashTable() {
		capacity = 10;
		entries = (V[]) new Object[capacity];
	}

	/**
	 * Prints the details of the Hash Table..
	 */
	public void printTableDetails() {
		System.out.println("Capacity : " + capacity);
		System.out.println("size : " + size);
		System.out.println("Load Factor : " + loadFactor);
	}

	private int hash(V entry) {
		return 0;

	}

	public int add(V entry) {
		return 0;
	}
}
