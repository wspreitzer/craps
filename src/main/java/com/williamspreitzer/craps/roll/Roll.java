package com.williamspreitzer.craps.roll;

import java.util.Random;

import com.williamspreitzer.craps.utils.CrapsUtils;
import com.williamspreitzer.craps.utils.Die;

public abstract class Roll {
	boolean isPointEstablished;
	Die roll;
	int die;
	int die2;
	byte count;
	static int rollCount;
	
	Roll() {
		Random rand = new Random();
		roll = () -> {
			return rand.nextInt(6) + 1;
		};
		
		die =  roll.getRoll();
		die2 = roll.getRoll();
		count = (byte) ( die + die2);
		CrapsUtils.getDiceTracker().put(getRollCount(), new Dice((byte)this.die, (byte)this.die2));
	}

	public byte getCount() {
		return count;
	}
	
	public void setCount(byte count) {
		this.count = count;
	}
	
	private static int getRollCount() {
		return rollCount++;
	}
	
	public abstract boolean isPointEstablished();
}