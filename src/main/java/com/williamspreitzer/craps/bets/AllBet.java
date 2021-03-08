package com.williamspreitzer.craps.bets;

import java.util.HashSet;
import java.util.Set;

import com.williamspreitzer.craps.utils.CrapsUtils;

public class AllBet extends BonusCrapsBet {
	
	 AllBet(int betAmount) {
		super(betAmount);
	}
	
	@Override
	public int processBet(Bet bet, byte count) {
		double winnings = 0;
		if(this.equals(bet)) {
			if(count == 7) {
				winnings = this.betAmount * -1;
			} else {
				Set<Byte> difference = new HashSet<Byte>(allNumbers);
				difference.removeAll(CrapsUtils.getRollTracker());
				if(difference.size() == 0) {
					this.isWinningBet = true;
					winnings = OddsBet.calculator.calculate(this.betAmount, this.getOdds());
				}
			}
		}
		return (int) winnings;
	}
	
	@Override
	public double getOdds() {
		return (double) 174/1;
	}
}
