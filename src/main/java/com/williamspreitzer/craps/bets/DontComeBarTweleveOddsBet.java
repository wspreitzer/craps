package com.williamspreitzer.craps.bets;

public class DontComeBarTweleveOddsBet extends NonPropositionOddsBet {

	protected byte number;
	
	private NonPropositionOddsBet oddsBet;
	
	DontComeBarTweleveOddsBet(byte number, int betAmount) {
		super(number, betAmount);
		this.number = number;
	}
	
	public byte getNumber() {
		return this.number;
	}
	
	public NonPropositionOddsBet getOddsBet() {
		return this.oddsBet;
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