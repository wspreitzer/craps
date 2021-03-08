package com.williamspreitzer.craps.bets;

public class ThreeOrElevenBet extends PropositionOddsBet{

	public ThreeOrElevenBet(byte number, int betAmount) {
		super(number, betAmount);
	}

	@Override
	public double getOdds() {
		return 0;
	}

	@Override
	public int processBet(Bet bet, byte count) {
		return 0;
	}
}