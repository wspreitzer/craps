package com.williamspreitzer.craps.roll;

public class Dice {

	private byte dieVal1;
	private byte dieVal2;
	
	public Dice(byte dieVal1, byte dieVal2) {
		this.dieVal1 = dieVal1;
		this.dieVal2 = dieVal2;
	}

	public byte getDieVal1() {
		return dieVal1;
	}

	public void setDieVal1(byte dieVal1) {
		this.dieVal1 = dieVal1;
	}

	public byte getDieVal2() {
		return dieVal2;
	}

	public void setDieVal2(byte dieVal2) {
		this.dieVal2 = dieVal2;
	}
	
	
}
