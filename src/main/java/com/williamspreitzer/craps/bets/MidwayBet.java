package com.williamspreitzer.craps.bets;

public class MidwayBet extends PropositionBet{

	public MidwayBet(int betAmount) {
		super(betAmount);
	}
	
	@Override
	public int processBet(Bet bet, byte count) {
		return 0;
	}
}