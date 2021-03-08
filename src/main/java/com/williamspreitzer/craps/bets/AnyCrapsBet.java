package com.williamspreitzer.craps.bets;

import com.williamspreitzer.craps.utils.CrapsUtils;

public class AllCrapsBet extends PropositionOddsBet {

	public AllCrapsBet(int betAmount) {
		super(CrapsUtils.ZERO, betAmount);
	}

	@Override
	public double getOdds() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int processBet(Bet bet, byte count) {
		// TODO Auto-generated method stub
		return 0;
	}

}
