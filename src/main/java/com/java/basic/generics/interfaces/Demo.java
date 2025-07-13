package com.java.basic.generics.interfaces;

/**
 * @author shashwat singh This class demonstrate the min max using generic.
 */
public class Demo {
	public static void main(String[] args) {
		Integer inums[] = { 3, 6, 2, 8, 6 };
		Character chs[] = { 'b', 'r', 'p', 'w' };
		GenMinMaxImpl<Integer> iob = new GenMinMaxImpl<Integer>(inums);
		GenMinMaxImpl<Character> cob = new GenMinMaxImpl<Character>(chs);
		System.out.println("Max value in inums: " + iob.max());
		System.out.println("Min value in inums: " + iob.min());
		System.out.println("Max value in chs: " + cob.max());
		System.out.println("Min value in chs: " + cob.min());
		
		//Demonstrating ::: class MyClass implements MinMax<Integer>
		NonGenMinMaxImpl nonGenMinMaxImpl = new NonGenMinMaxImpl(inums);
		System.out.println("Max value in inums: Using non generic class Implementation ::  " + nonGenMinMaxImpl.max());
		System.out.println("Min value in inums: Using non generic class Implementation ::  " + nonGenMinMaxImpl.min());
	}
}
