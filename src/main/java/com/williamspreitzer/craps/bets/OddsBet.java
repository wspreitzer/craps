package com.williamspreitzer.craps.bets;

import com.williamspreitzer.craps.utils.OddsCalculator;

public interface OddsBet {

	public static final OddsCalculator<Integer, Double> calculator = (a, o) -> {
		return a * o;
	};
	
	abstract double getOdds();
}
