package com.williamspreitzer.craps.bets;

import com.williamspreitzer.craps.utils.CrapsUtils;

public class WhirlBet extends PropositionOddsBet{

	BetType type = null;
	public WhirlBet(int betAmount) {
		super(CrapsUtils.ZERO, betAmount);
	}

	@SuppressWarnings("incomplete-switch")
	@Override
	public double getOdds() {
		double odds = 0;
		switch(type) {
		case ANY_SEVEN_BET:
			odds = (double) 4/1;
			break;
		case CRAPS_TWO_OR_TWELEVE_BET:
			odds = (double) 30/1;
			break;
		case THREE_OR_ELEVEN_BET:
			odds = (double) 15/1;
			break;
		}
		return odds;
	}
	
	@Override
	public int processBet(Bet bet, byte count) {
		double winnings = 0;
		this.isWinningBet = true;
		if(this.equals(bet)) {
			switch(count) {
			case 2: case 12:
				type = BetType.CRAPS_TWO_OR_TWELEVE_BET;
				winnings = OddsBet.calculator.calculate(getSingleUnit(this.betAmount, (byte) 5), getOdds());
			case 3: case 11:
				type = BetType.THREE_OR_ELEVEN_BET;
				winnings = OddsBet.calculator.calculate(getSingleUnit(this.betAmount, (byte) 5), getOdds());
			case 7: 
				type = BetType.ANY_SEVEN_BET;
				winnings = OddsBet.calculator.calculate(getSingleUnit(this.betAmount, (byte) 5), getOdds());
			default:
				this.isWinningBet = false;
				winnings = this.betAmount * -1;
			}
		}
		winnings = winnings - (getSingleUnit(this.betAmount, (byte) 5) * 4);
		return (int) winnings;
	}
}
