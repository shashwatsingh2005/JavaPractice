package com.java.basic.generics.interfaces;

/**
 * @author shashwat singh Class to demonstrate the Min/Max
 */
public class GenMinMaxImpl<T extends Comparable<T>> implements GenMinMax<T> {

	T[] val;

	GenMinMaxImpl(T[] o) {
		val = o;
	}

	@Override
	public T min() {
		// TODO Auto-generated method stub
		T v = val[0];
		for (int i = 1; i < val.length; i++)
			if (val[i].compareTo(v) < 0)
				v = val[i];
		return v;
	}

	@Override
	public T max() {
		// TODO Auto-generated method stub
		T v = val[0];
		for (int i = 1; i < val.length; i++)
			if (val[i].compareTo(v) > 0)
				v = val[i];
		return v;
	}

}
