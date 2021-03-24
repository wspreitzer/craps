package com.williamspreitzer.craps.bets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UnderSevenBetTest {

	@Mock
	UnderSevenBet bet;
	
	Bet underSevenBet = null;
	
	@BeforeEach
	private void setup() {
		underSevenBet = BetFactory.createPropsBet(BetType.UNDER_SEVEN_BET, 5);
	}
	
	@Test
	public void winUnderSevenBetWith2() {
		when(bet
				.processBet(underSevenBet, (byte) 2))
				.thenReturn(this.processBet(underSevenBet, (byte) 2));
		assertEquals(5, bet.processBet(underSevenBet, (byte) 2));
	}
	
	@Test
	public void winUnderSevenBetWith3() {
		when(bet
				.processBet(underSevenBet, (byte) 3))
				.thenReturn(this.processBet(underSevenBet, (byte) 3));
		assertEquals(5, bet.processBet(underSevenBet, (byte) 3));
	}
	
	@Test
	public void winUnderSevenBetWith4() {
		when(bet
				.processBet(underSevenBet, (byte) 4))
				.thenReturn(this.processBet(underSevenBet, (byte) 4));
		assertEquals(5, bet.processBet(underSevenBet, (byte) 4));
	}
	
	@Test
	public void winUnderSevenBetWith5() {
		when(bet
				.processBet(underSevenBet, (byte) 5))
				.thenReturn(this.processBet(underSevenBet, (byte) 5));
		assertEquals(5, bet.processBet(underSevenBet, (byte) 5));
	}
	
	@Test
	public void winUnderSevenBetWith6() {
		when(bet
				.processBet(underSevenBet, (byte) 6))
				.thenReturn(this.processBet(underSevenBet, (byte) 6));
		assertEquals(5, bet.processBet(underSevenBet, (byte) 6));
	}
	
	@Test
	public void loseUnderSevenBetWith7() {
		when(bet
				.processBet(underSevenBet, (byte) 7))
				.thenReturn(this.processBet(underSevenBet, (byte) 7));
		assertEquals(-5, bet.processBet(underSevenBet, (byte) 7));
	}
	
	@Test
	public void loseUnderSevenBetWith8() {
		when(bet
				.processBet(underSevenBet, (byte) 8))
				.thenReturn(this.processBet(underSevenBet, (byte) 8));
		assertEquals(-5, bet.processBet(underSevenBet, (byte) 8));
	}
	
	@Test
	public void loseUnderSevenBetWith9() {
		when(bet
				.processBet(underSevenBet, (byte) 9))
				.thenReturn(this.processBet(underSevenBet, (byte)  9));
		assertEquals(-5, bet.processBet(underSevenBet, (byte) 9));
	}
	
	@Test
	public void loseUnderSevenBetWith10() {
		when(bet
				.processBet(underSevenBet, (byte) 10))
				.thenReturn(this.processBet(underSevenBet, (byte) 10));
		assertEquals(-5, bet.processBet(underSevenBet, (byte) 10));
	}
	
	@Test
	public void loseUnderSevenBetWith11() {
		when(bet
				.processBet(underSevenBet, (byte) 11))
				.thenReturn(this.processBet(underSevenBet, (byte) 11));
		assertEquals(-5, bet.processBet(underSevenBet, (byte) 11));
	}
	
	@Test
	public void loseUnderSevenBetWith12() {
		when(bet
				.processBet(underSevenBet, (byte) 12))
				.thenReturn(this.processBet(underSevenBet, (byte) 12));
		assertEquals(-5, bet.processBet(underSevenBet, (byte) 12));
	}
	
	private int processBet(Bet bet, byte count) {
		double winnings = 0;
		if(count < 7) {
			winnings = bet.getBetAmount();
		} else {
			winnings = bet.getBetAmount() * -1;
		}
		return (int) winnings;
	}
}