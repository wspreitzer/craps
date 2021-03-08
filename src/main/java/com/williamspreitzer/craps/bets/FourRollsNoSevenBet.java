package com.williamspreitzer.craps.bets;

public class FourRollsNoSevenBet extends PropositionBet {

	public FourRollsNoSevenBet(int betAmount) {
		super(betAmount);
	}

	@Override
	public int processBet(Bet bet, byte count) {
		return 0;
	}
}