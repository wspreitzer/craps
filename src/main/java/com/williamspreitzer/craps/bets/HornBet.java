package com.williamspreitzer.craps.bets;

import com.williamspreitzer.craps.utils.CrapsUtils;

public class HornBet extends PropositionOddsBet {
	
	byte highBetNumber;
	BetType type = null;
	
	public HornBet(int betAmount, byte highBetNumber) {
		super(CrapsUtils.ZERO, betAmount);
		this.highBetNumber = highBetNumber;
		
	}
	
	@Override
	public double getOdds() {
		double odds = 0;
		if(type.equals(BetType.CRAPS_TWO_OR_TWELEVE_BET)) {
			odds = (double) 30/1;
		} else {
			odds = (double) 15/1;
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
				if(this.highBetNumber == count) {
					winnings = OddsBet.calculator.calculate(getHighBet(this.betAmount), getOdds());
				} else {
					winnings = OddsBet.calculator.calculate(getSingleUnit(this.betAmount, (byte) 4), getOdds());
				}
				break;
			case 3: case 11:
				type = BetType.THREE_OR_ELEVEN_BET;
				if(this.highBetNumber == count) {
					winnings = OddsBet.calculator.calculate(getHighBet(this.betAmount), getOdds());
				}else {
					winnings = OddsBet.calculator.calculate(getSingleUnit(this.betAmount, (byte) 4), getOdds());
				}
				break;
			default:
				this.isWinningBet = false;
				winnings = this.betAmount * -1;
				break;
			}
		}
		winnings = winnings - (getSingleUnit(this.betAmount, (byte) 4) * 3);
		return (int) winnings;
	}
	
	private int getHighBet(int betAmount) {
		return (betAmount % 4) + getSingleUnit(betAmount, (byte) 4);
	}
}