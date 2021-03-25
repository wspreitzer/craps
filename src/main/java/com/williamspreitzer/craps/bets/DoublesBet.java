package com.williamspreitzer.craps.bets;

import java.util.HashSet;
import java.util.Set;

import com.williamspreitzer.craps.utils.CrapsUtils;

public class DoublesBet extends PropositionOddsBet {

	private Set<Byte> doublesTracker;
	
	public DoublesBet(int betAmount) {
		super(CrapsUtils.ZERO, betAmount);
		doublesTracker = new HashSet<Byte>();
	}

	public Set<Byte> getDoublesTracker() {
		return this.doublesTracker;
	}
	
	@Override
	public double getOdds() {
		return 0;
	}

	@Override
	public int processBet(Bet bet, byte count) {
		return 0;
	}
}