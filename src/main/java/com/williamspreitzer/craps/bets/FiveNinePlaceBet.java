package com.williamspreitzer.craps.bets;

public class FiveNinePlaceBet extends NonPropositionOddsBet {

	private boolean isBuyBet;
	
	public FiveNinePlaceBet(byte number, int betAmount) {
		super(number, betAmount);
	}

	public boolean isBuyBet() {
		return isBuyBet;
	}

	public void setBuyBet(boolean isBuyBet) {
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