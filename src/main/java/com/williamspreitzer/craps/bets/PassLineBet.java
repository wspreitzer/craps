package com.williamspreitzer.craps.bets;

public class PassLineBet extends NonPropositionBet {

	boolean isPointEstablished;
	
	public PassLineBet(int betAmount) {
		super(betAmount);
	}

	public boolean isPointEstablished() {
		return this.isPointEstablished;
	}
	
	@Override
	public int processBet(Bet bet, byte count) {
		return 0;
	}
}