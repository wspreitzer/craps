package com.williamspreitzer.craps.bets;

import com.williamspreitzer.craps.utils.CrapsUtils;

public class AnySevenBet extends PropositionOddsBet {

	AnySevenBet(int betAmount) {
		super(CrapsUtils.ZERO, betAmount);
	}

	@Override
	public double getOdds() {
		return (double) 4/1;
	}

	@Override
	public int processBet(Bet bet, byte count) {
		double winnings = 0;
		if(this.equals(bet)) {
			if(count == 7) {
				this.isWinningBet = true;
				winnings = OddsBet.calculator.calculate(this.betAmount, getOdds());
			} else {
				winnings = this.betAmount * -1;
			}
		}
		return (int) winnings;
	}
}