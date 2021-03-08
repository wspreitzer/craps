package com.williamspreitzer.craps.bets;

public class DontComeBarTweleveBet extends NonPropositionBet {

	protected byte number;
	
	public DontComeBarTweleveBet(int betAmount) {
		super(betAmount);
	}

	public byte getNumber() {
		return this.number;
	}
	
	public void setNumber(byte number) {
		this.number = number;
	}

	@Override
	public int processBet(Bet bet, byte count) {
		return 0;
	}
}