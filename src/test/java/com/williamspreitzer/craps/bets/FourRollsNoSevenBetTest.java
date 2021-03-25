package com.williamspreitzer.craps.bets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FourRollsNoSevenBetTest {

	@Mock
	FourRollsNoSevenBet bet;
	
	FourRollsNoSevenBet fourRollsNoSevenBet = null;
	
	byte rollCount;
	
	@BeforeEach
	private void setUp() {
		when(bet
				.getRollCount())
				.thenReturn((byte) 4);
		rollCount = bet.getRollCount();
		fourRollsNoSevenBet = (FourRollsNoSevenBet) BetFactory.createPropsBet(BetType.FOUR_ROLLS_NO_SEVEN_BET, 5);
	}
	
	@Test
	public void winFourRollsNoSevenBet() {
		when(bet
				.processBet(fourRollsNoSevenBet, (byte) 5))
				.thenReturn(this.processBet(fourRollsNoSevenBet, (byte) 5));
		assertEquals(5, bet.processBet(fourRollsNoSevenBet, (byte) 5));
	}
	
	@Test
	public void loseFourRollsNoSevenBetOnSecondRoll() {
		when(bet.getRollCount()).thenReturn((byte) 2);
		rollCount = bet.getRollCount();
		when(bet
				.processBet(fourRollsNoSevenBet, (byte) 7))
				.thenReturn(this.processBet(fourRollsNoSevenBet, (byte) 7));
		assertEquals(-5, bet.processBet(fourRollsNoSevenBet, (byte) 7));
	}
	
	@Test
	public void loseFourRollsNoSevenBetOnFourthRoll() {
		when(bet
				.processBet(fourRollsNoSevenBet, (byte) 7))
				.thenReturn(this.processBet(fourRollsNoSevenBet, (byte) 7));
		assertEquals(-5, bet.processBet(fourRollsNoSevenBet, (byte) 7));
	}
	
	@Test
	public void pushFourRollsNoSevenBetOnThirdRoll() {
		when(bet
				.getRollCount()).thenReturn((byte) 3);
		rollCount = bet.getRollCount();
		when(bet
				.processBet(fourRollsNoSevenBet, (byte) 5))
				.thenReturn(this.processBet(fourRollsNoSevenBet, (byte) 5));
		assertEquals(0, bet.processBet(fourRollsNoSevenBet, (byte) 	5));
	}
	
	private int processBet(Bet bet, byte count) {
		double winnings = 0;
		if(count == 7) {
			winnings = bet.getBetAmount() * -1;
		} else if( rollCount == 4) {
			winnings = bet.getBetAmount();
		} 
		return (int) winnings;
	}
}