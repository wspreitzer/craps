package com.williamspreitzer.craps.bets;

public abstract class NonPropositionOddsBet extends NonPropositionBet implements OddsBet {

	protected byte number;
	
	public NonPropositionOddsBet(byte number, int betAmount) {
		super(betAmount);
		this.number = number;
	}
	
	public byte getNumber() {
		return this.number;
	}
}