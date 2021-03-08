package com.williamspreitzer.craps.bets;

import com.williamspreitzer.craps.utils.CrapsUtils;

public class HornBet extends PropositionOddsBet {
	
	byte highBetNumber;
	BetType type = null;
	
	public HornBet(int betAmount, byte highBetNumber) {
		super(CrapsUtils.ZERO, betAmount);
		this.highBetNumber = highBetNumber;
		
	}
	
	@Override
	public double getOdds() {
		return 0;
	}

	@Override
	public int processBet(Bet bet, byte count) {
		return 0;
	}
	
	private int getHighBet(int betAmount) {
		return (betAmount % 4) + getSingleUnit(betAmount, (byte) 4);
	}
}