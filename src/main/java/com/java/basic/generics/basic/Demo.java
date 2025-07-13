package com.java.basic.generics.basic;

/**
 * @author shashwat singh Class to demonstrate basics of generic.
 */
public class Demo {
	public static void main(String[] args) {
		Gen<String> gen1 = new Gen<String>();
		gen1.obj = "Hello Shashwat";

		Gen<Integer> gen2 = new Gen<Integer>();
		gen2.obj = 99;

		gen1.showType();
		gen2.showType();
		
		// generic constructor test
		Gen<Double> gen3 = new Gen<Double>(99.9);
		gen3.showType();
	}
}
