package com.williamspreitzer.craps.bets;

public interface Bet {

	int getBetAmount();
	//byte getBetNumber(); 
	int processBet(Bet bet, byte count);
	boolean isWinningBet();
	boolean getRackProperty();
}
