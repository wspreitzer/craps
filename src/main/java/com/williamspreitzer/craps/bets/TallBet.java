package com.williamspreitzer.craps.bets;

import java.util.HashSet;
import java.util.Set;

import com.williamspreitzer.craps.utils.CrapsUtils;

public class TallBet extends BonusCrapsBet{

	TallBet(int betAmount) {
		super(betAmount);
	}

	@Override
	public int processBet(Bet bet, byte count) {
		double winnings = 0;
		if(this.equals(bet)) {
			if(count == 7) {
				winnings = this.betAmount * -1;
			} else {
				Set<Byte> difference = new HashSet<Byte>(tallNumbers);
				difference.removeAll(CrapsUtils.getRollTracker());
				if(difference.size() == 0) {
					this.isWinningBet = true;
					winnings = OddsBet.calculator.calculate(this.betAmount, this.getOdds());
				}
			}
		}
		return (int) winnings;
	}
}