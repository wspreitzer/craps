package com.williamspreitzer.craps.bets;

public class PassLineBet extends NonPropositionBet {

	public PassLineBet(int betAmount) {
		super(betAmount);
	}

	@Override
	public int processBet(Bet bet, byte count) {
		return 0;
	}
}