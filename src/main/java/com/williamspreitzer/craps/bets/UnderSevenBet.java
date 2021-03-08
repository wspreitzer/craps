package com.williamspreitzer.craps.bets;

public class UnderSevenBet extends PropositionBet {

	public UnderSevenBet(int betAmount) {
		super(betAmount);
	}
	
	@Override
	public int processBet(Bet bet, byte count) {
		int winnings = 0;
		if(this.equals(bet)) {
			if(count < 7) {
				this.isWinningBet = true;
				winnings = this.betAmount;
			} else {
				winnings = this.betAmount * -1;
			}
		}
		return winnings;
	}
}