package com.williamspreitzer.craps.bets;

import com.williamspreitzer.craps.utils.CrapsUtils;

public class PassLineOddsBet extends NonPropositionOddsBet {

	private NonPropositionOddsBet oddsBet;
	public PassLineOddsBet(int betAmount) {
		super(CrapsUtils.getPoint(), betAmount);
	}

	public NonPropositionOddsBet getOddsBet() {
		return this.oddsBet;
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