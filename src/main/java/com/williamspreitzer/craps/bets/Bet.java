package com.williamspreitzer.craps.bets;

public interface Bet {

	int getBetAmount();
	int processBet(Bet bet, byte count);
	boolean isWinningBet();
	boolean getRackProperty();
	boolean isOn();
}
