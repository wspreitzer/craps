package com.williamspreitzer.craps.bets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ThreeOrElevenBetTest {

	@Mock
	Bet bet;
	
	Bet threeOrElevenBet = null;
	
	@BeforeEach
	private void setup() {
		threeOrElevenBet = BetFactory.createPropsBet(BetType.THREE_OR_ELEVEN_BET, (byte) 3, 5);
	}
	
	@Test
	public void winThreeOrElevenBetWith3() {
		when(bet
				.processBet(threeOrElevenBet, (byte) 3))
				.thenReturn(this.processBet(threeOrElevenBet, (byte) 3));
		assertEquals(75, bet.processBet(threeOrElevenBet, (byte) 3));
	}
	
	@Test
	public void winThreeOrElevenBetWith11() {
		threeOrElevenBet = BetFactory.createPropsBet(BetType.THREE_OR_ELEVEN_BET, (byte) 11, 5);
		when(bet
				.processBet(threeOrElevenBet, (byte) 11))
				.thenReturn(this.processBet(threeOrElevenBet, (byte) 11));
		assertEquals(75, bet.processBet(threeOrElevenBet, (byte) 11));
	}
	
	@Test
	public void loseThreeOrElevenBetWith2() {
		when(bet
				.processBet(threeOrElevenBet, (byte) 2))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.THREE_OR_ELEVEN_BET, (byte) 2, 5), (byte) 2));
		assertEquals(-5, bet.processBet(threeOrElevenBet, (byte) 2));
	}
	
	@Test
	public void loseThreeOrElevenBetWith4() {
		when(bet
				.processBet(threeOrElevenBet, (byte) 4))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.THREE_OR_ELEVEN_BET, (byte) 4, 5), (byte) 4));
		assertEquals(-5, bet.processBet(threeOrElevenBet, (byte) 4));
	}
	
	@Test
	public void loseThreeOrElevenBetWith5() {
		when(bet
				.processBet(threeOrElevenBet, (byte) 5))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.THREE_OR_ELEVEN_BET, (byte) 5,  5), (byte) 5));
		assertEquals(-5, bet.processBet(threeOrElevenBet, (byte) 5));
	}
	
	@Test
	public void loseThreeOrElevenBetWith6() {
		when(bet
				.processBet(threeOrElevenBet, (byte) 6))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.THREE_OR_ELEVEN_BET, (byte) 6, 5), (byte) 6));
		assertEquals(-5, bet.processBet(threeOrElevenBet, (byte) 6));
	}
	
	@Test
	public void loseThreeOrElevenBetWith7() {
		when(bet
				.processBet(threeOrElevenBet, (byte) 7))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.THREE_OR_ELEVEN_BET, (byte) 6, 5), (byte) 7));
		assertEquals(-5, bet.processBet(threeOrElevenBet, (byte) 7));
	}
	
	@Test
	public void loseThreeOrElevenBetWith8() {
		when(bet
				.processBet(threeOrElevenBet, (byte) 8))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.THREE_OR_ELEVEN_BET, (byte) 7, 5), (byte) 7));
		assertEquals(-5, bet.processBet(threeOrElevenBet, (byte) 8));
	}
	
	@Test
	public void loseThreeOrElevenBetWith9() {
		when(bet
				.processBet(threeOrElevenBet, (byte) 9))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.THREE_OR_ELEVEN_BET, (byte) 9, 5), (byte) 9));
		assertEquals(-5, bet.processBet(threeOrElevenBet, (byte) 9));
	}
	
	@Test
	public void loseThreeOrElevenBetWith10() {
		when(bet
				.processBet(threeOrElevenBet, (byte) 10))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.THREE_OR_ELEVEN_BET, (byte) 10, 5), (byte) 10));
		assertEquals(-5, bet.processBet(threeOrElevenBet, (byte) 10));
	}
	
	@Test
	public void loseThreeOrElevenBetWith12() {
		when(bet
				.processBet(threeOrElevenBet, (byte) 12))
				.thenReturn(this.processBet(threeOrElevenBet, (byte) 12));
		assertEquals(-5, bet.processBet(threeOrElevenBet, (byte) 12));
	}

	private int processBet(Bet bet, byte count) {
		double winnings = 0;
		if(count == 3 || count == 11) {
			winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 15/1);
		} else {
			winnings = bet.getBetAmount() * -1;
		}
		return (int) winnings;
	}
}
