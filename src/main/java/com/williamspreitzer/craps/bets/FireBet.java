package com.williamspreitzer.craps.bets;

import java.util.HashSet;
import java.util.Set;

import com.williamspreitzer.craps.utils.CrapsUtils;

public class FireBet extends PropositionOddsBet {

	private Set<Byte> pointsMade;
	
	public FireBet(int betAmount) {
		super(CrapsUtils.ZERO, betAmount);
		pointsMade = new HashSet<Byte>();
	}

	public Set<Byte> getPointsMade() {
		return this.pointsMade;
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