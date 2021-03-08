package com.williamspreitzer.craps.bets;

import com.williamspreitzer.craps.roll.Dice;
import com.williamspreitzer.craps.utils.CrapsUtils;

public class FourTenHardway extends PropositionOddsBet {

	public FourTenHardway(byte number, int betAmount) {
		super(number, betAmount);
	}
	
	@Override
	public int processBet(Bet bet, byte count) {
		double winnings = 0;
		if(this.equals(bet)) {
			switch(count) {
				case 4: case 10:
					Dice dice = CrapsUtils.getDiceTracker().get(CrapsUtils.getDiceTracker().size() -1);
					if(dice.getDieVal1() == dice.getDieVal2()) {
						this.isWinningBet = true;
						winnings = OddsBet.calculator.calculate(this.betAmount, getOdds());
						break;
					}
				case 7:
					winnings = this.betAmount * -1;
					break;
				default:
					break;
			}
		}
		return (int) winnings;
	}

	@Override
	public double getOdds() {
		return (double) 7/1;
	}
}