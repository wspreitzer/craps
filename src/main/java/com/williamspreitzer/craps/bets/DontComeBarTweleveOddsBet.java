package com.williamspreitzer.craps.bets;

public class DontComeBarTweleveOddsBet extends NonPropositionOddsBet {

	protected byte number;
	
	DontComeBarTweleveOddsBet(byte number, int betAmount) {
		super(number, betAmount);
		this.number = number;
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