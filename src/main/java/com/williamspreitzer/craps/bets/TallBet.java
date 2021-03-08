package com.williamspreitzer.craps.bets;

public class TallBet extends BonusCrapsBet{

	TallBet(int betAmount) {
		super(betAmount);
	}

	@Override
	public int processBet(Bet bet, byte count) {
		return 0;
	}
}