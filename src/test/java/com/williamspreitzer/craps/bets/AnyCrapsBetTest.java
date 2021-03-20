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
public class AnyCrapsBetTest {
	
	@Mock
	Bet bet;
	
	Bet anyCrapsBet = null;
	
	@BeforeEach
	private void setup() {
		anyCrapsBet = BetFactory.createPropsBet(BetType.ANY_CRAPS_BET, 5);
	}
	
	@Test
	public void mockNotNullsTest() {
		assertNotNull(bet);
	}
	
	@Test
	public void winAnyCrapWith2Rolled() {
		when(bet
				.processBet(anyCrapsBet, (byte) 2))
				.thenReturn(this.processBet(anyCrapsBet, (byte) 2));
		assertEquals(35, bet.processBet(anyCrapsBet, (byte) 2));
	}
	
	@Test
	public void winAnyCrapWith3Rolled() {
		when(bet
				.processBet(anyCrapsBet, (byte) 3))
				.thenReturn(this.processBet(anyCrapsBet, (byte) 3));
		assertEquals(35, bet.processBet(anyCrapsBet, (byte) 3));
	}
	
	@Test
	public void winAnyCrapWith12Rolled() {
		when(bet
				.processBet(anyCrapsBet, (byte) 12))
				.thenReturn(this.processBet(anyCrapsBet, (byte) 12));
		assertEquals(35, bet.processBet(anyCrapsBet, (byte) 12));
	}
	
	@Test
	public void loseAnyCrapWith4Rolled() {
		when(bet
				.processBet(anyCrapsBet, (byte) 4))
				.thenReturn(this.processBet(anyCrapsBet, (byte) 4));
		assertEquals(-5, bet.processBet(anyCrapsBet, (byte) 4));
	}
	
	@Test
	public void loseAnyCrapWith5Rolled() {
		when(bet
				.processBet(anyCrapsBet, (byte) 5))
				.thenReturn(this.processBet(anyCrapsBet, (byte) 5));
		assertEquals(-5, bet.processBet(anyCrapsBet, (byte) 5));
	}
	
	@Test
	public void loseAnyCrapWith6Rolled() {
		when(bet
				.processBet(anyCrapsBet, (byte) 6))
				.thenReturn(this.processBet(anyCrapsBet, (byte) 6));
		assertEquals(-5, bet.processBet(anyCrapsBet, (byte) 6));
	}
	
	@Test
	public void loseAnyCrapWith8Rolled() {
		when(bet
				.processBet(anyCrapsBet, (byte) 8))
				.thenReturn(this.processBet(anyCrapsBet, (byte) 8));
		assertEquals(-5, bet.processBet(anyCrapsBet, (byte) 8));
	}
	
	@Test
	public void loseAnyCrapWith9Rolled() {
		when(bet
				.processBet(anyCrapsBet, (byte) 9))
				.thenReturn(this.processBet(anyCrapsBet, (byte) 9));
		assertEquals(-5, bet.processBet(anyCrapsBet, (byte) 9));
	}
	
	@Test
	public void loseAnyCrapWith10Rolled() {
		when(bet
				.processBet(anyCrapsBet, (byte) 10))
				.thenReturn(this.processBet(anyCrapsBet, (byte) 10));
		assertEquals(-5, bet.processBet(anyCrapsBet, (byte) 10));
	}
	
	@Test
	public void loseAnyCrapWith11Rolled() {
		when(bet
				.processBet(anyCrapsBet, (byte) 11))
				.thenReturn(this.processBet(anyCrapsBet, (byte) 11));
		assertEquals(-5, bet.processBet(anyCrapsBet, (byte) 11));
	}
	
	@Test
	public void loseAnyCrapWith7Rolled() {
		when(bet
				.processBet(anyCrapsBet, (byte) 7))
				.thenReturn(this.processBet(anyCrapsBet, (byte) 7));
		assertEquals(-5, bet.processBet(anyCrapsBet, (byte) 7));
	}
	
	private int processBet(Bet bet, byte count) {
		double winnings = 0;
		switch(count) {
		case 2: case 3: case 12:
			winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 7/1);
			break;
		default:
			winnings = bet.getBetAmount() * -1;
		}
		return (int) winnings;
	}
}