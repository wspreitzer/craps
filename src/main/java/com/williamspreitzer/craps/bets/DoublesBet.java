package com.williamspreitzer.craps.bets;

import com.williamspreitzer.craps.utils.CrapsUtils;

public class DoublesBet extends PropositionOddsBet {

	public DoublesBet(int betAmount) {
		super(CrapsUtils.ZERO, betAmount);
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