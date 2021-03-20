package com.williamspreitzer.craps.bets;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FireBetTest {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Mock
	FireBet bet;
	
	Bet fireBet = null;
	
	Set<Byte> pointsMade = null;
	
	@BeforeEach
	private void setup() {
		fireBet = (FireBet) BetFactory.createPropsBet(BetType.FIRE_BET, 5);
	}

	@Test
	public void winFireBetWithFourthPointMade() {
		when(bet.getPointsMade()).thenReturn(new ArrayList<Byte>() {
		{
			add((byte) 4);
			add((byte) 5);
			add((byte) 6);
			add((byte) 8);
		}});
		pointsMade = new HashSet<Byte>(bet.getPointsMade());
		this.processBet(bet, (byte) 0);
	}
	
	@Test
	public void winFireBetWithFifthPointMade() {
		when(bet.getPointsMade()).thenReturn(new ArrayList<Byte>() {{
			add((byte) 4);
			add((byte) 5);
			add((byte) 6);
			add((byte) 8);
			add((byte) 9);
		}});
		pointsMade = new HashSet<Byte>(bet.getPointsMade());
	}
	
	private int processBet(Bet bet, byte count) {
		double winnings = 0;
		if(count == 7) {
			switch(pointsMade.size()) {
			case 1: case 2: case 3:
				winnings = bet.getBetAmount() * -1;
				break;
			case 4:
				winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 24/1);
				break;
			case 5:
				winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 249/1);
				break;
			case 6:
				winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 999/1);
				break;
			} 
		} else {
			if(count == point) {
					pointsMade.add(count);
			}
		}
		return (int) winnings;
	}
}