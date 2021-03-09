package com.williamspreitzer.craps.roll;

public class ComeOutRoll extends Roll {

	public ComeOutRoll() {
		super();
	}

	public byte getCount() {
		return this.count;
	}
	
	@Override
	public boolean isPointEstablished() {
		return false;
	}
}