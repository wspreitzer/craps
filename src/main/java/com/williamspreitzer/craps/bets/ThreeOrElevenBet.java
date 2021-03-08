package com.williamspreitzer.craps.bets;

public class ThreeOrElevenBet extends PropositionOddsBet{

	public ThreeOrElevenBet(byte number, int betAmount) {
		super(number, betAmount);
	}

	@Override
	public double getOdds() {
		// TODO Auto-generated method stub
		return (double) 15/1;
	}

	@Override
	public int processBet(Bet bet, byte count) {
		// TODO Auto-generated method stub
		return 0;
	}
}
