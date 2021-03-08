package com.williamspreitzer.craps.bets;

public abstract class PropositionOddsBet extends PropositionBet implements OddsBet {

	protected byte number;
	
	public PropositionOddsBet(byte number, int betAmount) {
		super(betAmount);
		this.number = number;
	}
	
	protected int getSingleUnit(int betAmount, byte numberOfBets) {
		return betAmount / numberOfBets;
	}
}