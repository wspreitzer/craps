package com.williamspreitzer.craps.bets;

import java.util.ArrayList;
import java.util.List;

import com.williamspreitzer.craps.utils.CrapsUtils;

public class FireBet extends PropositionOddsBet {

	private List<Byte> pointsMade;
	
	public FireBet(int betAmount) {
		super(CrapsUtils.ZERO, betAmount);
		pointsMade = new ArrayList<Byte>();
	}

	public List<Byte> getPointsMade() {
		return this.pointsMade;
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