package com.williamspreitzer.craps.bets;

public class AllBet extends BonusCrapsBet {
	
	 AllBet(int betAmount) {
		super(betAmount);
	}
	
	@Override
	public int processBet(Bet bet, byte count) {
		return 0;
	}
	
	@Override
	public double getOdds() {
		return 0;
	}
}
