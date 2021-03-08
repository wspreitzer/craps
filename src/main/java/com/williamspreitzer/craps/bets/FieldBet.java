package com.williamspreitzer.craps.bets;

public class FieldBet extends NonPropositionBet {

	public FieldBet(int betAmount) {
		super(betAmount);
	}

	@Override
	public int processBet(Bet bet, byte count) {
		return 0;
	}
}