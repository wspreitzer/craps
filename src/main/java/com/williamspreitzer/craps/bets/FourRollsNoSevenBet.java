package com.williamspreitzer.craps.bets;

public class FourRollsNoSevenBet extends PropositionBet {

	private byte rollCount;
	
	public FourRollsNoSevenBet(int betAmount) {
		super(betAmount);
	}

	public byte getRollCount() {
		return this.rollCount;
	}
	
	@Override
	public int processBet(Bet bet, byte count) {
		return 0;
	}
}