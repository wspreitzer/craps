package com.williamspreitzer.craps.bets;

public class SmallBet extends BonusCrapsBet {

	SmallBet(int betAmount) {
		super(betAmount);
	}

	@Override
	public int processBet(Bet bet, byte count) {
		return 0;
	}
}