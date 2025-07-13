package com.java.basic.threads;

public class DemoOddEven {
	public static void main(String[] args) {
		NumberPrinter numberPrinter = new NumberPrinter();

		EvenPrintCaller evenPrintCaller = new EvenPrintCaller(numberPrinter);
		OddPrintCaller oddPrintCaller = new OddPrintCaller(numberPrinter);

		Thread t1 = new Thread(evenPrintCaller);
		Thread t2 = new Thread(oddPrintCaller);

	}
}
