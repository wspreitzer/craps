package com.williamspreitzer.craps.bets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MidwayBetTest {

	@Mock
	Bet bet;
	
	Bet midwayBet = null;
	
	@BeforeEach
	private void setup() {
		midwayBet = BetFactory.createPropsBet(BetType.MIDWAY_BET, 5);
	}
	
	@Test
	public void winMidwayBetWith6() {
		when(bet.processBet(midwayBet, (byte) 6)).thenReturn(this.processBet(midwayBet, (byte) 6));
		assertEquals(5, bet.processBet(midwayBet, (byte) 6));
	}
	
	@Test
	public void winMidwayBetWith7() {
		when(bet.processBet(midwayBet, (byte) 7)).thenReturn(this.processBet(midwayBet, (byte) 7));
		assertEquals(5, bet.processBet(midwayBet, (byte) 7));
	}
	
	@Test
	public void winMidwayBetWith8() {
		when(bet.processBet(midwayBet, (byte) 8)).thenReturn(this.processBet(midwayBet, (byte) 8));
		assertEquals(5, bet.processBet(midwayBet, (byte) 8));
	}
	
	@Test
	public void loseMidwayBetWith2() {
		when(bet.processBet(midwayBet, (byte) 2)).thenReturn(this.processBet(midwayBet, (byte) 2));
		assertEquals(-5, bet.processBet(midwayBet, (byte) 2));
	}
	
	@Test
	public void loseMidwayBetWith3() {
		when(bet.processBet(midwayBet, (byte) 3)).thenReturn(this.processBet(midwayBet, (byte) 3));
		assertEquals(-5, bet.processBet(midwayBet, (byte) 3));
	}
	
	@Test
	public void loseMidwayBetWith4() {
		when(bet.processBet(midwayBet, (byte) 4)).thenReturn(this.processBet(midwayBet, (byte) 4));
		assertEquals(-5, bet.processBet(midwayBet, (byte) 4));
	}
	
	@Test
	public void loseMidwayBetWith5() {
		when(bet.processBet(midwayBet, (byte) 5)).thenReturn(this.processBet(midwayBet, (byte) 5));
		assertEquals(-5, bet.processBet(midwayBet, (byte) 5));
	}
	
	@Test
	public void loseMidwayBetWith9() {
		when(bet.processBet(midwayBet, (byte) 9)).thenReturn(this.processBet(midwayBet, (byte) 9));
		assertEquals(-5, bet.processBet(midwayBet, (byte) 9));
	}
	
	@Test
	public void loseMidwayBetWith10() {
		when(bet.processBet(midwayBet, (byte) 10)).thenReturn(this.processBet(midwayBet, (byte) 10));
		assertEquals(-5, bet.processBet(midwayBet, (byte) 10));
	}
	
	@Test
	public void loseMidwayBetWith11() {
		when(bet.processBet(midwayBet, (byte) 11)).thenReturn(this.processBet(midwayBet, (byte) 11));
		assertEquals(-5, bet.processBet(midwayBet, (byte) 11));
	}
	
	@Test
	public void loseMidwayBetWith12() {
		when(bet.processBet(midwayBet, (byte) 12)).thenReturn(this.processBet(midwayBet, (byte) 12));
		assertEquals(-5, bet.processBet(midwayBet, (byte) 12));
	}
	
	private int processBet(Bet bet, byte count) {
		double winnings = 0;
		switch(count) {
		case 6: case 7: case 8:
			winnings = bet.getBetAmount();
			break;
		default:
			winnings = bet.getBetAmount() * -1;
			break;
		}
		return (int) winnings;
	}
}