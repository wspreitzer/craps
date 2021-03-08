package com.williamspreitzer.craps.bets;

public class UnderSevenBet extends PropositionBet {

	public UnderSevenBet(int betAmount) {
		super(betAmount);
	}
	
	@Override
	public int processBet(Bet bet, byte count) {
		return 0;
	}
}