package com.java.basic.threads;

public class Callme {

//	public synchronized void call(String msg) {
//		System.out.print("[" + msg);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("]");
//	}
	
	public void call(String msg) {
		System.out.print("[" + msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("]");
	}

}
