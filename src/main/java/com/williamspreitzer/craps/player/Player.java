package com.williamspreitzer.craps.player;

import java.util.ArrayList;
import java.util.List;

import com.williamspreitzer.craps.bets.Bet;

public class Player {

	int bankRoll;
	short totalBets;
	private List<Bet> bets;
	boolean lineBetRequired;
	
	public Player( int bankRoll, boolean lineBetRequired) {
		this.bankRoll = bankRoll;
		this.lineBetRequired = lineBetRequired;
		this.setBets(new ArrayList<Bet>());
	}
	
	public void placeBet(Bet bet) {

	}
	
	public int traverseBets(byte rollCount) {
		return 0;
	}
	
	public int getTotalBets() {
		return this.totalBets;
	}
	
	public int getBankRoll() {
		return this.bankRoll;
	}
	
	public void setBankRoll(int bankRoll) {
		this.bankRoll = bankRoll;
	}

	public List<Bet> getBets() {
		return bets;
	}

	public void setBets(List<Bet> bets) {
		this.bets = bets;
	}
}