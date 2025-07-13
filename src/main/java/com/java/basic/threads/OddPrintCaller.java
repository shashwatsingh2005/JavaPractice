package com.java.basic.threads;

public class OddPrintCaller implements Runnable {

	private NumberPrinter numberPrinter;

	public OddPrintCaller(NumberPrinter numberPrinter) {
		super();
		this.numberPrinter = numberPrinter;
		new Thread(this).start();
	}

	public NumberPrinter getNumberPrinter() {
		return numberPrinter;
	}

	public void setNumberPrinter(NumberPrinter numberPrinter) {
		this.numberPrinter = numberPrinter;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 1;
		while (i < 30) {
			numberPrinter.printOdd(i);
			i = i + 2;
		}
	}
}
