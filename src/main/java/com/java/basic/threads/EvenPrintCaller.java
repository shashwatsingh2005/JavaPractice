package com.java.basic.threads;

public class EvenPrintCaller implements Runnable {
	private NumberPrinter numberPrinter;

	public EvenPrintCaller(NumberPrinter numberPrinter) {
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
		int i = 0;
		while ( i < 30) {
			numberPrinter.printEven(i);
			i=i+2;
		}
	}
}
