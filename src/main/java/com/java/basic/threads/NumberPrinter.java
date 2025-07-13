package com.java.basic.threads;

public class NumberPrinter {
	private boolean isOddPrintTurn = false;

	public synchronized void printEven(int i) {
		while (isOddPrintTurn) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			System.out.println("Even Printer " + i);
			isOddPrintTurn = true;
			notify();
		
	}

	public synchronized void printOdd(int i) {
		while (!isOddPrintTurn) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
			System.out.println("Odd Printer " + i);
			isOddPrintTurn = false;
			notify();
		
	}

	public boolean isOddPrintTurn() {
		return isOddPrintTurn;
	}

	public void setOddPrintTurn(boolean isOddPrintTurn) {
		this.isOddPrintTurn = isOddPrintTurn;
	}
}
