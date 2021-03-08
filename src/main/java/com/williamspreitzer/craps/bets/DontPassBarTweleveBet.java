package com.williamspreitzer.craps.bets;

public class DontPassBarTweleveBet extends NonPropositionBet {

	public DontPassBarTweleveBet(int betAmount) {
		super(betAmount);
	}

	@Override
	public int processBet(Bet bet, byte count) {
		return 0;
	}
}