package com.williamspreitzer.craps.bets;

public abstract class PropositionBet implements Bet {

	int minBet;
	int maxBet;
	int betAmount;
	boolean isWinningBet;
	boolean rackProperty;
	boolean isOn;

	public PropositionBet(int betAmount) {
		this.minBet = 1;
		this.maxBet = 100;
		this.betAmount = betAmount;
	}

	@Override
	public boolean isOn() {
		return this.isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	public void setRackProperty(boolean rackProperty) {
		this.rackProperty = rackProperty;
	}

	@Override
	public boolean getRackProperty() {
		return this.rackProperty;
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