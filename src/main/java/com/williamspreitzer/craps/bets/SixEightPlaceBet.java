package com.williamspreitzer.craps.bets;

public class SixEightPlaceBet extends NonPropositionOddsBet {

	private boolean isBuyBet;
	
	public SixEightPlaceBet(byte number, int betAmount) {
		super(number, betAmount);
	}
	
	public boolean isBuy() {
		return isBuyBet;
	}
	
	public void setBuy(boolean isBuyBet) {
		this.isBuyBet = isBuyBet;
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