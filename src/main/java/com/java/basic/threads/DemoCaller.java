package com.java.basic.threads;

public class DemoCaller {
	public static void main(String[] args) {
	Callme callme = new Callme();
       Caller o1 = new Caller("Hello",callme);
       Caller o2 = new Caller("Synchronised",callme);
       Caller o3 = new Caller("World",callme);
       try {
       o1.getTh().join();
       o2.getTh().join();
       o3.getTh().join();
       }catch (InterruptedException e) {
		// TODO: handle exception
    	   e.printStackTrace();
	}
       
	}
}
