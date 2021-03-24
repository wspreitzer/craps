package com.williamspreitzer.craps.bets;

import com.williamspreitzer.craps.utils.CrapsUtils;

public class DontPassOddsBet extends NonPropositionOddsBet{

	NonPropositionOddsBet oddsBet;
	DontPassOddsBet(int betAmount) {
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