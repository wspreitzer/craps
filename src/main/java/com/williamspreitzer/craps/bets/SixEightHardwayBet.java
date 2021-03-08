package com.williamspreitzer.craps.bets;

public class SixEightHardwayBet extends PropositionOddsBet {
	public SixEightHardwayBet(byte number, int betAmount) {
		super(number, betAmount);
	}
	
	@Override
	public int processBet(Bet bet, byte count) {
		return 0;
	}

	@Override
	public double getOdds() {
		return 0;
	}
}