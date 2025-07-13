package com.java.basic.threads;

public class Caller implements Runnable {

	private String msg;
	private Callme target;
	private Thread th;

	public Caller(String msg, Callme targ) {
		this.msg = msg;
		this.target = targ;
		th = new Thread(this);
		th.start();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Callme getTarget() {
		return target;
	}

	public void setTarget(Callme target) {
		this.target = target;
	}

	public Thread getTh() {
		return th;
	}

	public void setTh(Thread th) {
		this.th = th;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (target) {
			target.call(msg);
		}
	}

}
