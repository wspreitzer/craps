package com.williamspreitzer.craps.bets;

public class ComeOddsBet extends NonPropositionOddsBet{

	NonPropositionOddsBet oddsBet;
	
	public ComeOddsBet(byte number, int betAmount) {
		super(number, betAmount);
		switch(number) {
		case 4: case 10:
			break;
		case 5: case 9:
			break;
		case 6: case 8:
		}
	}

	@Override
	public double getOdds() {
		return 0;
	}

	public NonPropositionOddsBet getOddsBet() {
		return this.oddsBet;
	}
	
	@Override
	public int processBet(Bet bet, byte count) {
		return 0;
	}
}