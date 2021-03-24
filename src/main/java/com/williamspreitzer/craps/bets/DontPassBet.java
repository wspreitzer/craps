package com.williamspreitzer.craps.bets;

public class DontPassBet extends NonPropositionBet {

	boolean isPointEstablished;
	
	public DontPassBet(int betAmount) {
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