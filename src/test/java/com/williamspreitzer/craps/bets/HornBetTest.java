package com.williamspreitzer.craps.bets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HornBetTest {

	@Mock
	HornBet propBet;
	
	@Mock
	Bet bet;
	
	HornBet hornBet = null; 

	int betUnit;
	
	byte highBetNumber;
	
	int highBet;
	
	@BeforeEach
	private void setUp() {
		when(propBet.getSingleUnit(5, (byte) 4)).thenReturn(1);
		when(propBet.getHighBetNumber()).thenReturn((byte) 2);
		when(propBet.getHighBet(5)).thenReturn(2);
		highBetNumber = propBet.getHighBetNumber();
		betUnit = propBet.getSingleUnit(5, (byte) 4);
		hornBet = (HornBet) BetFactory.createPropsBet(BetType.HORN_BET, (byte) 2, 5);
		highBet = propBet.getHighBet(5);
	}
	
	@Test
	public void winHornBetWith2And2IsHigh() {
		when(bet
				.processBet(hornBet, (byte) 2))
				.thenReturn(this.processBet(hornBet, (byte) 2, betUnit, highBetNumber));
		assertEquals(57, bet.processBet(hornBet, (byte) 2));
	}
	
	@Test
	public void winHornBetWith12And12IsHigh() {
		when(propBet.getHighBetNumber()).thenReturn((byte) 12);
		highBetNumber = propBet.getHighBetNumber();
		hornBet = (HornBet) BetFactory.createPropsBet(BetType.HORN_BET, (byte) 12, 5);
		when(bet
				.processBet(hornBet, (byte) 12))
				.thenReturn(this.processBet(hornBet, (byte) 12, betUnit, highBetNumber));
		assertEquals(57, bet.processBet(hornBet, (byte) 12));
	}
	
	@Test
	public void winHornBetWith3And3IsHigh() {
		hornBet = (HornBet) BetFactory.createPropsBet(BetType.HORN_BET, (byte) 3, 5);
		when(propBet.getHighBetNumber()).thenReturn((byte) 3);
		highBetNumber = propBet.getHighBetNumber();
		when(bet
				.processBet(hornBet, (byte) 3))
				.thenReturn(this.processBet(hornBet, (byte) 3, betUnit, highBetNumber));
		assertEquals(27, bet.processBet(hornBet, (byte) 3));
	}
	
	@Test
	public void winHornBetWith11And11IsHigh() {
		hornBet = (HornBet) BetFactory.createPropsBet(BetType.HORN_BET, (byte) 11, 5);
		when(propBet.getHighBetNumber()).thenReturn((byte) 11);
		highBetNumber = propBet.getHighBetNumber();
		when(bet
				.processBet(hornBet, (byte) 11))
				.thenReturn(this.processBet(hornBet, (byte) 11, betUnit, highBetNumber));
		assertEquals(27, bet.processBet(hornBet, (byte) 11));
	}
	
	@Test
	public void winHornBetWith2And2NotHigh() {
		hornBet = (HornBet) BetFactory.createPropsBet(BetType.HORN_BET, (byte) 12, 5);
		when(propBet.getHighBetNumber()).thenReturn((byte) 12);
		highBetNumber = propBet.getHighBetNumber();
		when(bet
				.processBet(hornBet, (byte) 2))
				.thenReturn(this.processBet(hornBet, (byte) 2, betUnit, highBetNumber));
		assertEquals(26, bet.processBet(hornBet, (byte) 2));
	}
	
	@Test
	public void winHornBetWith12And12NotHigh() {
		when(bet
				.processBet(hornBet, (byte) 12))
				.thenReturn(this.processBet(hornBet, (byte) 12, betUnit, highBetNumber));
		assertEquals(26, bet.processBet(hornBet, (byte) 12));
	}
	
	@Test
	public void winHornBetWith3And3NotHigh() {
		when(bet
				.processBet(hornBet, (byte) 3))
				.thenReturn(this.processBet(hornBet, (byte) 3, betUnit, highBetNumber));
		assertEquals(11, bet.processBet(hornBet, (byte) 3));
	}
	
	@Test
	public void winHornBetWith11And11NotHigh() {
		when(bet
				.processBet(hornBet, (byte) 11))
				.thenReturn(this.processBet(hornBet, (byte) 11, betUnit, highBetNumber));
		assertEquals(11, bet.processBet(hornBet, (byte) 11));
	}
	
	@Test
	public void loseHornBetWith4() {
		when(bet
				.processBet(hornBet, (byte) 4))
				.thenReturn(this.processBet(hornBet, (byte) 4, betUnit, highBetNumber));
		assertEquals(-5, bet.processBet(hornBet, (byte) 4));
	}
	
	@Test
	public void loseHornBetWith5() {
		when(bet
				.processBet(hornBet, (byte) 5))
				.thenReturn(this.processBet(hornBet, (byte) 5, betUnit, highBetNumber));
		assertEquals(-5, bet.processBet(hornBet, (byte) 5));
	}
	
	@Test
	public void loseHornBetWith6() {
		when(bet
				.processBet(hornBet, (byte) 6))
				.thenReturn(this.processBet(hornBet, (byte) 6, betUnit, highBetNumber));
		assertEquals(-5, bet.processBet(hornBet, (byte) 6));
	}
	
	@Test
	public void loseHornBetWith7() {
		when(bet
				.processBet(hornBet, (byte) 7))
				.thenReturn(this.processBet(hornBet, (byte) 7, betUnit, highBetNumber));
		assertEquals(-5, bet.processBet(hornBet, (byte) 7));
	}
	
	@Test
	public void loseHornBetWith8() {
		when(bet
				.processBet(hornBet, (byte) 8))
				.thenReturn(this.processBet(hornBet, (byte) 8, betUnit, highBetNumber));
		assertEquals(-5, bet.processBet(hornBet, (byte) 8));
	}
	
	@Test
	public void loseHornBetWith9() {
		when(bet
				.processBet(hornBet, (byte) 9))
				.thenReturn(this.processBet(hornBet, (byte) 9, betUnit, highBetNumber));
		assertEquals(-5, bet.processBet(hornBet, (byte) 9));
	}
	
	@Test
	public void loseHornBetWith10() {
		when(bet
				.processBet(hornBet, (byte) 10))
				.thenReturn(this.processBet(hornBet, (byte) 10, betUnit, highBetNumber));
		assertEquals(-5, bet.processBet(hornBet, (byte) 10));
	}
	
	private int processBet(HornBet bet, byte count, int betUnit, byte highNumber) {
		double winnings = 0;
		switch(count) {
		case 2: case 12:
			if(highNumber == count) {
				winnings = OddsBet.calculator.calculate(highBet, (double) 30/1) - (3 * betUnit);
			} else {
				winnings = OddsBet.calculator.calculate(betUnit, (double) 30/1) - (3 * betUnit + betUnit);
			}
			break;
		case 3: case 11:
			if(highNumber == count) {
				winnings = OddsBet.calculator.calculate(highBet, (double) 15/1) - (3 * betUnit);
			} else {
				winnings = OddsBet.calculator.calculate(betUnit, (double) 15/1) - (3 * betUnit + betUnit);
			}
			break;
		default:
			winnings = bet.getBetAmount() * -1;
			break;
		}
		return (int) winnings;
	}
}