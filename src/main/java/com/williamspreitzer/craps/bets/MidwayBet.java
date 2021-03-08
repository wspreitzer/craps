package com.williamspreitzer.craps.bets;

public class MidwayBet extends PropositionBet{

	public MidwayBet(int betAmount) {
		super(betAmount);
	}
	
	@Override
	public int processBet(Bet bet, byte count) {
		int winnings = 0;
		if(this.equals(bet)) {
			switch(count) {
			case 6: case 7: case 8:
				this.isWinningBet = true;
				winnings = this.betAmount;
				break;
			default: 
				winnings = this.betAmount * -1;
				break;
			}
		}
		return winnings;
	}
}