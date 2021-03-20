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
public class FieldBetTest {

	@Mock 
	Bet bet;
	
	Bet fieldBet = null;
	
	@BeforeEach
	private void setup() {
		fieldBet = BetFactory.createPropsBet(BetType.FIELD_BET, 5);
	}
	
	@Test
	public void mockNotNullsTest() {
		assertNotNull(bet);
	}
	
	@Test
	public void winDoubleWith2RolledTest() {
		when(bet
				.processBet(fieldBet, (byte) 2))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIELD_BET, 5), (byte) 2));
		assertEquals(10, bet.processBet(fieldBet, (byte) 2));
	}
	
	@Test
	public void winWith3RolledTest() {
		when(bet
				.processBet(fieldBet, (byte) 3))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIELD_BET, 5), (byte) 3));
		assertEquals(5, bet.processBet(fieldBet, (byte) 3));
	}
	
	@Test
	public void winWith4RolledTest() {
		when(bet
				.processBet(fieldBet, (byte) 4))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIELD_BET, 5), (byte) 4));
		assertEquals(5, bet.processBet(fieldBet, (byte) 4));
	}
	
	@Test
	public void loseWith5RolledTest() {
		when(bet
				.processBet(fieldBet, (byte) 5))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIELD_BET, 5), (byte) 5));
		assertEquals(-5, bet.processBet(fieldBet, (byte) 5));
	}
	
	@Test
	public void loseWith6RolledTest() {
		when(bet
				.processBet(fieldBet, (byte) 6))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIELD_BET, 5), (byte) 6));
		assertEquals(-5, bet.processBet(fieldBet, (byte) 6));
	}
	
	@Test
	public void loseWith7RolledTest() {
		when(bet
				.processBet(fieldBet, (byte) 7))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIELD_BET, 5), (byte) 7));
		assertEquals(-5, bet.processBet(fieldBet, (byte) 7));
	}
	
	@Test
	public void loseWith8RolledTest() {
		when(bet
				.processBet(fieldBet, (byte) 8))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIELD_BET, 5), (byte) 8));
		assertEquals(-5, bet.processBet(fieldBet, (byte) 8));
	}
	
	@Test
	public void winWith9RolledTest() {
		when(bet
				.processBet(fieldBet, (byte) 9))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIELD_BET, 5), (byte) 9));
		assertEquals(5, bet.processBet(fieldBet, (byte) 9));
	}
	
	@Test
	public void winWith10RolledTest() {
		when(bet
				.processBet(fieldBet, (byte) 10))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIELD_BET, 5), (byte) 10));
		assertEquals(5, bet.processBet(fieldBet, (byte) 10));
	}
	
	@Test
	public void winWith11RolledTest() {
		when(bet
				.processBet(fieldBet, (byte) 11))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIELD_BET, 5), (byte) 11));
		assertEquals(5, bet.processBet(fieldBet, (byte) 11));
	}
	
	@Test
	public void winTripleWith12RolledTest() { 
		when(bet
				.processBet(fieldBet, (byte) 12))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIELD_BET, 5), (byte) 12));
		assertEquals(15, bet.processBet(fieldBet, (byte) 12));
	}
	
	private int processBet(Bet bet, byte count) {
		double winnings = 0;
		switch(count) {
		case 2:
			winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 2/1);
			break;
		case 5: case 6: case 7: case 8:
			winnings = bet.getBetAmount() * -1;
			break;
		case 12:
			winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 3/1);
			break;
		default:
			winnings = bet.getBetAmount();
			break;
		}
		return (int) winnings;
	}
}