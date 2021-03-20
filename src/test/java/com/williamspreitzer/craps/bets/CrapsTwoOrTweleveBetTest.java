package com.williamspreitzer.craps.bets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CrapsTwoOrTweleveBetTest {

	@Mock
	Bet bet;
	
	Bet twoOrTweleveBet = null;
	
	@BeforeEach
	private void setUp() {
		twoOrTweleveBet = BetFactory.createPropsBet(BetType.CRAPS_TWO_OR_TWELEVE_BET, (byte) 2, 5);
	}
	
	@Test
	public void winTwoOrTweleveBetWith2() {
		when(bet
				.processBet(twoOrTweleveBet, (byte) 2))
				.thenReturn(this.processBet(twoOrTweleveBet, (byte) 2));
		assertEquals(150, bet.processBet(twoOrTweleveBet, (byte) 2));
	}
	
	@Test
	public void winTwoOrTweleveBetWith12() {
		twoOrTweleveBet = BetFactory.createPropsBet(BetType.CRAPS_TWO_OR_TWELEVE_BET, (byte) 12, 5);
		when(bet
				.processBet(twoOrTweleveBet, (byte) 12))
				.thenReturn(this.processBet(twoOrTweleveBet, (byte) 12));
		assertEquals(150, bet.processBet(twoOrTweleveBet, (byte) 12));
	}
	
	@Test
	public void loseTwoOrTwelveBetWith3() {
		when(bet
				.processBet(twoOrTweleveBet, (byte) 3))
				.thenReturn(this.processBet(twoOrTweleveBet, (byte) 3));
		assertEquals(-5, bet.processBet(twoOrTweleveBet, (byte) 3));
	}
	
	@Test
	public void loseTwoOrTwelveBetWith4() {
		when(bet
				.processBet(twoOrTweleveBet, (byte) 4))
				.thenReturn(this.processBet(twoOrTweleveBet, (byte) 4));
		assertEquals(-5, bet.processBet(twoOrTweleveBet, (byte) 4));
	}
	
	@Test
	public void loseTwoOrTwelveBetWith5() {
		when(bet
				.processBet(twoOrTweleveBet, (byte) 5))
				.thenReturn(this.processBet(twoOrTweleveBet, (byte) 5));
		assertEquals(-5, bet.processBet(twoOrTweleveBet, (byte) 5));
	}
	
	@Test
	public void loseTwoOrTwelveBetWith6() {
		when(bet
				.processBet(twoOrTweleveBet, (byte) 6))
				.thenReturn(this.processBet(twoOrTweleveBet, (byte) 6));
		assertEquals(-5, bet.processBet(twoOrTweleveBet, (byte) 6));
	}
	
	@Test
	public void loseTwoOrTwelveBetWith7() {
		when(bet
				.processBet(twoOrTweleveBet, (byte) 7))
				.thenReturn(this.processBet(twoOrTweleveBet, (byte) 7));
		assertEquals(-5, bet.processBet(twoOrTweleveBet, (byte) 7));
	}
	
	@Test
	public void loseTwoOrTwelveBetWith8() {
		when(bet
				.processBet(twoOrTweleveBet, (byte) 8))
				.thenReturn(this.processBet(twoOrTweleveBet, (byte) 8));
		assertEquals(-5, bet.processBet(twoOrTweleveBet, (byte) 8));
	}
	
	@Test
	public void loseTwoOrTwelveBetWith9() {
		when(bet
				.processBet(twoOrTweleveBet, (byte) 9))
				.thenReturn(this.processBet(twoOrTweleveBet, (byte) 9));
		assertEquals(-5, bet.processBet(twoOrTweleveBet, (byte) 9));
	}
	
	@Test
	public void loseTwoOrTwelveBetWith10() {
		when(bet
				.processBet(twoOrTweleveBet, (byte) 10))
				.thenReturn(this.processBet(twoOrTweleveBet, (byte) 10));
		assertEquals(-5, bet.processBet(twoOrTweleveBet, (byte) 10));
	}
	
	@Test
	public void loseTwoOrTwelveBetWith11() {
		when(bet
				.processBet(twoOrTweleveBet, (byte) 11))
				.thenReturn(this.processBet(twoOrTweleveBet, (byte) 11));
		assertEquals(-5, bet.processBet(twoOrTweleveBet, (byte) 11));
	}
	
	private int processBet(Bet bet, byte count) {
		double winnings = 0;
		if(count == 2 || count == 12) {
			winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 30/1);
		} else {
			winnings = bet.getBetAmount() * -1;
		}
		return (int) winnings;
	}
}
