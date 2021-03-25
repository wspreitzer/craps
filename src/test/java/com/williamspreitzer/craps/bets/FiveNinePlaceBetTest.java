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
public class FiveNinePlaceBetTest {
	
	@Mock
	FiveNinePlaceBet bet;
	
	boolean isOn;
	boolean isBuy;
	
	Bet fiveBet = null;
	Bet nineBet = null;
	
	@BeforeEach
	private void setup() { 
		when(bet.isOn()).thenReturn(true);
		when(bet.isBuyBet()).thenReturn(false);
		this.isOn = bet.isOn();
		this.isBuy = bet.isBuyBet();
		fiveBet = BetFactory.createPropsBet(BetType.FIVE_NINE_PLACE_BET, (byte) 5, 5);
		nineBet = BetFactory.createPropsBet(BetType.FIVE_NINE_PLACE_BET, (byte) 9, 5);
	}
	
	@Test
	public void mocksNotNullsTest() {
		assertNotNull(bet);
	}
	
	@Test
	public void winFiveNinePlaceBetWith5() {
		when(bet
				.processBet(fiveBet, (byte) 5))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIVE_NINE_PLACE_BET, (byte) 5, 5), (byte) 5, isOn, isBuy));
		assertEquals(7, bet.processBet(fiveBet, (byte) 5));
	}
	
	@Test void winFiveNinePlaceBetWith9() {
		when(bet
				.processBet(nineBet, (byte) 9))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIVE_NINE_PLACE_BET, (byte) 9, 5), (byte) 9, isOn, isBuy));
		assertEquals(7, bet.processBet(nineBet, (byte) 9));
	}
	
	@Test
	public void dontWinFiveNinePlaceBetWith5AndOffBet() {
		when(bet.isOn()).thenReturn(false);
		this.isOn = bet.isOn();
		when(bet
				.processBet(fiveBet, (byte) 5))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIVE_NINE_PLACE_BET, (byte) 5, 5), (byte) 5, isOn, isBuy));
		assertEquals(0, bet.processBet(fiveBet, (byte) 5));
	}
	
	@Test void dontWinFiveNinePlaceBetWith9AndOffBet() {
		when(bet.isOn()).thenReturn(false);
		this.isOn = bet.isOn();
		when(bet
				.processBet(nineBet, (byte) 9))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIVE_NINE_PLACE_BET, (byte) 9, 5), (byte) 9, isOn, isBuy));
		assertEquals(0, bet.processBet(nineBet, (byte) 9));
	}
	
	@Test
	public void loseFiveNinePlaceBetWith7() {
		when(bet
				.processBet(fiveBet, (byte) 7))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIVE_NINE_PLACE_BET, (byte) 7, 5), (byte) 7, isOn, isBuy));
		assertEquals(-5, bet.processBet(fiveBet, (byte) 7));
	}
	
	@Test
	public void dontLoseFiveNinePlaceBetWith7AndOffBet() {
		when(bet.isOn()).thenReturn(false);
		this.isOn = bet.isOn();
		when(bet
				.processBet(fiveBet, (byte) 7))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIVE_NINE_PLACE_BET, (byte) 7, 5), (byte) 7, isOn, isBuy));
		assertEquals(0, bet.processBet(fiveBet, (byte) 7));
	}
	
	@Test
	public void winFiveNineBuyBetWith5() {
		when(bet.isBuyBet()).thenReturn(true);
		this.isBuy = bet.isBuyBet();
		when(bet
				.processBet(fiveBet, (byte) 5))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIVE_NINE_PLACE_BET, (byte) 5, 10), (byte) 5, isOn, isBuy));
		assertEquals(14, bet.processBet(fiveBet, (byte) 5));
	}
	
	@Test
	public void winFiveNineBuyBetWith9() {
		when(bet.isBuyBet()).thenReturn(true);
		this.isBuy = bet.isBuyBet();
		when(bet
				.processBet(nineBet, (byte) 9))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIVE_NINE_PLACE_BET, (byte) 9, 10), (byte) 9, isOn, isBuy));
		assertEquals(14, bet.processBet(nineBet, (byte) 9));
	}
	
	@Test
	public void pushFiveNinePlaceBetWith2() {
		when(bet
				.processBet(fiveBet, (byte) 2))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIVE_NINE_PLACE_BET, (byte) 2, 5), (byte) 2, isOn, isBuy));
		assertEquals(0, bet.processBet(fiveBet, (byte) 2));
	}
	
	@Test
	public void pushFiveNinePlaceBetWith3() {
		when(bet
				.processBet(fiveBet, (byte) 3))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIVE_NINE_PLACE_BET, (byte) 3, 5), (byte) 3, isOn, isBuy));
		assertEquals(0, bet.processBet(fiveBet, (byte) 3));
	}
	
	@Test
	public void pushFiveNinePlaceBetWith4() {
		when(bet
				.processBet(fiveBet, (byte) 4))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIVE_NINE_PLACE_BET, (byte) 4, 5), (byte) 4, isOn, isBuy));
		assertEquals(0, bet.processBet(fiveBet, (byte) 4));
	}
	
	@Test
	public void pushFiveNinePlaceBetWith6() {
		when(bet
				.processBet(fiveBet, (byte) 6))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIVE_NINE_PLACE_BET, (byte) 6, 5), (byte) 6, isOn, isBuy));
		assertEquals(0, bet.processBet(fiveBet, (byte) 6));
	}
	
	@Test
	public void pushFiveNinePlaceBetWith8() {
		when(bet
				.processBet(fiveBet, (byte) 8))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIVE_NINE_PLACE_BET, (byte) 8, 5), (byte) 8, isOn, isBuy));
		assertEquals(0, bet.processBet(fiveBet, (byte) 8));
	}
	
	@Test
	public void pushFiveNinePlaceBetWith10() {
		when(bet
				.processBet(fiveBet, (byte) 10))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIVE_NINE_PLACE_BET, (byte) 10, 5), (byte) 10, isOn, isBuy));
		assertEquals(0, bet.processBet(fiveBet, (byte) 10));
	}
	
	@Test
	public void pushFiveNinePlaceBetWith11() {
		when(bet
				.processBet(fiveBet, (byte) 11))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIVE_NINE_PLACE_BET, (byte) 11, 5), (byte) 11, isOn, isBuy));
		assertEquals(0, bet.processBet(fiveBet, (byte) 11));
	}
	
	@Test
	public void pushFiveNinePlaceBetWith12() {
		when(bet
				.processBet(fiveBet, (byte) 12))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FIVE_NINE_PLACE_BET, (byte) 12, 5), (byte) 12, isOn, isBuy));
		assertEquals(0, bet.processBet(fiveBet, (byte) 12));
	}
	
	private int processBet(Bet bet, byte count, boolean isOn, boolean isBuyBet) {
		double winnings = 0;
		if(isOn) {
			switch(count) {
			case 5: case 9:
				if(isBuyBet) {
					winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 3/2) - (bet.getBetAmount() * .05);
				} else {
					winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 7/5);
				}
				break;
			case 7: 
				winnings = bet.getBetAmount() * -1;
				break;
			default:
				break;
			}
		}
		return (int) winnings;
	}
}
