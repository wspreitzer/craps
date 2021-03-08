package com.williamspreitzer.craps.bets;

import com.williamspreitzer.craps.utils.CrapsUtils;

public abstract class NonPropositionBet implements Bet{

	int betAmount;
	boolean isWinningBet;
	boolean rackProperty;
	int minBet;
	int maxBet;
	
	public NonPropositionBet() {
		this.minBet = Integer.parseInt(CrapsUtils.props.getProperty("bet.min"));
		this.maxBet = Integer.parseInt(CrapsUtils.props.getProperty("bet.max"));
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
	public int getBetAmount() {
		return this.betAmount;
	}
}