package com.williamspreitzer.craps.bets;

public abstract class PropositionOddsBet extends PropositionBet implements OddsBet {

	public PropositionOddsBet(byte number, int betAmount) {
		super(betAmount);
		
	}
	
	protected int getSingleUnit(int betAmount, byte numberOfBets) {
		return betAmount / numberOfBets;
	}
}
