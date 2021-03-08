package com.williamspreitzer.craps.bets;

import com.williamspreitzer.craps.utils.CrapsUtils;

public abstract class PropositionBet implements Bet {
	
	int minBet;
	int maxBet;
	int betAmount;
	boolean isWinningBet;
	boolean rackProperty;
	
	
	public PropositionBet(int betAmount) {
		this.minBet = 1;
		this.maxBet = 100;
		this.betAmount = betAmount;
	}
	
	@Override
	public boolean getRackProperty() {
		return Boolean.parseBoolean(CrapsUtils.props.getProperty("bet.rack"));
	}
	
	@Override
	public boolean isWinningBet() {
		return this.isWinningBet;
	}
	
	@Override 
	public  int getBetAmount() {
		return this.betAmount;
	}
}