package com.williamspreitzer.craps.bets;

public class FourTenPlaceBet extends NonPropositionOddsBet {

	private boolean isBuy;

	public FourTenPlaceBet(byte number, int betAmount) {
		super(number, betAmount);
	}

	public boolean isBuy() {
		return isBuy;
	}

	public void setBuy(boolean isBuy) {
		this.isBuy = isBuy;
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