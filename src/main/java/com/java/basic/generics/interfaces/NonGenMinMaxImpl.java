package com.java.basic.generics.interfaces;
/**
 * @author shashwat singh
 * This is class having No Generic.
 */
public class NonGenMinMaxImpl implements GenMinMax<Integer>{
	
	Integer[] val;

	NonGenMinMaxImpl(Integer[] o) {
		val = o;
	}

	@Override
	public Integer min() {
		// TODO Auto-generated method stub
		Integer v = val[0];
		for (int i = 1; i < val.length; i++)
			if (val[i].compareTo(v) < 0)
				v = val[i];
		return v;
	}

	@Override
	public Integer max() {
		// TODO Auto-generated method stub
		Integer v = val[0];
		for (int i = 1; i < val.length; i++)
			if (val[i].compareTo(v) > 0)
				v = val[i];
		return v;
	}

}
