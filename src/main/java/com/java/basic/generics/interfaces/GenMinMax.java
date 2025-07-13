package com.java.basic.generics.interfaces;

/**
 * @author shashwat singh Interface to get Min and Max from the Collection.
 */
public interface GenMinMax<T extends Comparable<T>> {
	/**
	 * Method to determine minimum
	 * @return
	 */
	T min();
    /**
     * Method to determine maximum
     * @return
     */
	T max();
}
