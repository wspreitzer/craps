package com.williamspreitzer.craps.bets;

import java.util.HashSet;
import java.util.Set;

import com.williamspreitzer.craps.utils.CrapsUtils;

public abstract class BonusCrapsBet extends PropositionOddsBet{

	Set<Byte> smallNumbers;
	Set<Byte> tallNumbers;
	Set<Byte> allNumbers;
	
	BonusCrapsBet(int betAmount) {
		super(CrapsUtils.ZERO, betAmount);
		
		this.smallNumbers = new HashSet<Byte>();
		this.smallNumbers.add((byte) 2);
		this.smallNumbers.add((byte) 3);
		this.smallNumbers.add((byte) 4);
		this.smallNumbers.add((byte) 5);
		this.smallNumbers.add((byte) 6);
		
		this.tallNumbers = new HashSet<Byte>();
		this.tallNumbers.add((byte) 8);
		this.tallNumbers.add((byte) 9);
		this.tallNumbers.add((byte) 10);
		this.tallNumbers.add((byte) 11);
		this.tallNumbers.add((byte) 12);
		this.allNumbers = new HashSet<Byte>(smallNumbers);
		allNumbers.addAll(tallNumbers);
	}
	
	@Override
	public double getOdds() {
		return 0;
	}
}