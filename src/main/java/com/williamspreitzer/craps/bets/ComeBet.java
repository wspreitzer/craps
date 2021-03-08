package com.williamspreitzer.craps.bets;

public class ComeBet extends NonPropositionBet{

	protected byte number;
	
	public ComeBet(int betAmount) {
		super(betAmount);
	}

	public byte getNumber() {
		return number;
	}

	public void setNumber(byte number) {
		this.number = number;
	}

	@Override
	public int processBet(Bet bet, byte count) {
		return 0;
	}
}