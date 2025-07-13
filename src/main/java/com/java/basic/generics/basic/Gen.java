package com.java.basic.generics.basic;

/**
 * @author shashwat singh This is basic POJO class to demonstrate Generic.
 */
public class Gen<T> {
	T obj;

	public void showType() {
		System.out.println("---- The type of generic Object : " + obj.getClass().getName() + "----");
	}
	
	//generic constructor.
	public <N extends T> Gen(N o) {
		// TODO Auto-generated constructor stub
		this.obj = o;
	}
	
	//Normal constructor.
	public Gen() {
		// TODO Auto-generated constructor stub
	}
}
