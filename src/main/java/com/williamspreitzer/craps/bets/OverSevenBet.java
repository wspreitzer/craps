package com.williamspreitzer.craps.bets;

public class OverSevenBet extends PropositionBet{

	public OverSevenBet(int betAmount) {
		super(betAmount);
	}
	
	@Override
	public int processBet(Bet bet, byte count) {
		return 0;
	}
}