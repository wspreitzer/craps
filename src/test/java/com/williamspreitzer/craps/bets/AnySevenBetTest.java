package com.williamspreitzer.craps.bets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AnySevenBetTest {

	@Mock
	AnySevenBet bet;
	
	Bet anySevenBet = null;
	
	@BeforeEach
	private void setup() {
		anySevenBet = BetFactory.createPropsBet(BetType.ANY_SEVEN_BET, 5);
	}
	
	@Test
	public void mockNotNullsTest() {
		assertNotNull(bet);
		assertNotNull(anySevenBet);
	}
	
	
	@Test
	public void loseAnySevenBetWith2RolledTest() {
		when(bet
				.processBet(anySevenBet, (byte) 2))
				.thenReturn(this.processBet(anySevenBet, (byte) 2));
		assertEquals(-5, bet.processBet(anySevenBet, (byte) 2));
	}
	
	@Test
	public void loseAnySevenBetWith3RolledTest() {
		when(bet
				.processBet(anySevenBet, (byte) 3))
				.thenReturn(this.processBet(anySevenBet, (byte) 3));
		assertEquals(-5, bet.processBet(anySevenBet, (byte) 3));
	}
	
	@Test
	public void loseAnySevenBetWith4RolledTest() {
		when(bet
				.processBet(anySevenBet, (byte) 4))
				.thenReturn(this.processBet(anySevenBet, (byte) 4));
		assertEquals(-5, bet.processBet(anySevenBet, (byte) 4));
	}
	
	@Test
	public void loseAnySevenBetWith5RolledTest() {
		when(bet
				.processBet(anySevenBet, (byte) 5))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.ANY_SEVEN_BET, 5), (byte) 5));
		assertEquals(-5, bet.processBet(anySevenBet, (byte) 5));
	}
	
	@Test
	public void loseAnySevenBetWith6RolledTest() {
		when(bet
				.processBet(anySevenBet, (byte) 6))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.ANY_SEVEN_BET, 5), (byte) 6));
		assertEquals(-5, bet.processBet(anySevenBet, (byte) 6));
	}
	
	@Test
	public void winAnySevenBetTest() {
		when(bet
				.processBet(anySevenBet, (byte) 7))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.ANY_SEVEN_BET, 5), (byte) 7));
		assertEquals(20, bet.processBet(anySevenBet, (byte) 7));
	}
	
	@Test
	public void loseAnySevenBetWith8RolledTest() {
		when(bet
				.processBet(anySevenBet, (byte) 8))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.ANY_SEVEN_BET, 5), (byte) 8));
		assertEquals(-5, bet.processBet(anySevenBet, (byte) 8));
	}
	
	@Test
	public void loseAnySevenBetWith9RolledTest() {
		when(bet
				.processBet(anySevenBet, (byte) 9))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.ANY_SEVEN_BET, 5), (byte) 9));
		assertEquals(-5, bet.processBet(anySevenBet, (byte) 9));
	}
	
	@Test
	public void loseAnySevenBetWith10RolledTest() {
		when(bet
				.processBet(anySevenBet, (byte) 10))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.ANY_SEVEN_BET, 5), (byte) 10));
		assertEquals(-5, bet.processBet(anySevenBet, (byte) 10));
	}
	
	@Test
	public void loseAnySevenBetWith11RolledTest() {
		when(bet
				.processBet(anySevenBet, (byte) 11))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.ANY_SEVEN_BET, 5), (byte) 11));
		assertEquals(-5, bet.processBet(anySevenBet, (byte) 11));
	}
	
	@Test
	public void loseAnySevenBetWith12RolledTest() {
		when(bet
				.processBet(anySevenBet, (byte) 12))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.ANY_SEVEN_BET, 5), (byte) 12));
		assertEquals(-5, bet.processBet(anySevenBet, (byte) 12));
	}	
	
	private int processBet(Bet bet, byte count) {
		double winnings = 0;
		if(count == 7) {
			winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 4/1);
		} else {
			winnings = bet.getBetAmount() * -1;
		}
		return (int) winnings;
	}
}
