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
public class FourTenPlaceBetTest {

	@Mock
	Bet bet;
	
	@Mock
	FourTenPlaceBet buyBet;
	
	boolean isOn;
	boolean isBuy;
	
	Bet fourTenPlaceBet = null;
	
	@BeforeEach
	private void setup() { 
		when(buyBet.isOn()).thenReturn(true);
		when(buyBet.isBuy()).thenReturn(false);
		this.isOn = buyBet.isOn();
		this.isBuy = buyBet.isBuy();
		fourTenPlaceBet = BetFactory.createPropsBet(BetType.FOUR_TEN_PLACE_BET, (byte) 4, 5);
	}
	
	@Test
	public void mocksNotNullsTest() {
		assertNotNull(bet);
	}
	
	@Test
	public void winFourTenPlaceBetWith4() {
		when(bet
				.processBet(fourTenPlaceBet, (byte) 4))
				.thenReturn(this.processBet(fourTenPlaceBet, (byte) 4, isOn, isBuy));
		assertEquals(9, bet.processBet(fourTenPlaceBet, (byte) 4));
	}
	
	@Test 
	public void winFourTenPlaceBetWith10() {
		fourTenPlaceBet = BetFactory.createPropsBet(BetType.FOUR_TEN_PLACE_BET, (byte) 10, 5);
		when(bet
				.processBet(fourTenPlaceBet, (byte) 10))
				.thenReturn(this.processBet(fourTenPlaceBet, (byte) 10, isOn, isBuy));
		assertEquals(9, bet.processBet(fourTenPlaceBet, (byte) 10));
	}
	
	@Test
	public void dontWinFourTenPlaceBetWith4AndOffBet() {
		when(buyBet.isOn()).thenReturn(false);
		this.isOn = buyBet.isOn();
		when(bet
				.processBet(fourTenPlaceBet, (byte) 4))
				.thenReturn(this.processBet(fourTenPlaceBet, (byte) 4, isOn, isBuy));
		assertEquals(0, bet.processBet(fourTenPlaceBet, (byte) 4));
	}
	
	@Test 
	public void dontWinFourTenPlaceBetWith10AndOffBet() {
		fourTenPlaceBet = BetFactory.createPropsBet(BetType.FOUR_TEN_PLACE_BET, (byte) 10, 5);
		when(buyBet.isOn()).thenReturn(false);
		this.isOn = buyBet.isOn();
		when(bet
				.processBet(fourTenPlaceBet, (byte) 10))
				.thenReturn(this.processBet(fourTenPlaceBet, (byte) 10, isOn, isBuy));
		assertEquals(0, bet.processBet(fourTenPlaceBet, (byte) 10));
	}
	
	@Test
	public void loseFourTenPlaceBetWith7() {
		when(bet
				.processBet(fourTenPlaceBet, (byte) 7))
				.thenReturn(this.processBet(fourTenPlaceBet, (byte) 7, isOn, isBuy));
		assertEquals(-5, bet.processBet(fourTenPlaceBet, (byte) 7));
	}
	
	@Test
	public void dontLoseFourTenPlaceBetWith7AndOffBet() {
		when(buyBet.isOn()).thenReturn(false);
		this.isOn = buyBet.isOn();
		when(bet
				.processBet(fourTenPlaceBet, (byte) 7))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FOUR_TEN_PLACE_BET, (byte) 7, 5), (byte) 7, isOn, isBuy));
		assertEquals(0, bet.processBet(fourTenPlaceBet, (byte) 7));
	}
	
	@Test
	public void winFourTenBuyBetWith4() {
		when(buyBet.isBuy()).thenReturn(true);
		this.isBuy = buyBet.isBuy();
		when(bet
				.processBet(fourTenPlaceBet, (byte) 4))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.FOUR_TEN_PLACE_BET, (byte) 4, 5), (byte) 4, isOn, isBuy));
		assertEquals(9, bet.processBet(fourTenPlaceBet, (byte) 4));
	}
	
	@Test
	public void winFourTenBuyBetWith10() {
		fourTenPlaceBet = BetFactory.createPropsBet(BetType.FOUR_TEN_PLACE_BET, (byte) 10, 5);
		when(buyBet.isBuy()).thenReturn(true);
		this.isBuy = buyBet.isBuy();
		when(bet
				.processBet(fourTenPlaceBet, (byte) 10))
				.thenReturn(this.processBet(fourTenPlaceBet, (byte) 10, isOn, isBuy));
		assertEquals(9, bet.processBet(fourTenPlaceBet, (byte) 10));
	}
	
	@Test
	public void pushFourTenPlaceBetWith2() {
		when(bet
				.processBet(fourTenPlaceBet, (byte) 2))
				.thenReturn(this.processBet(fourTenPlaceBet, (byte) 2, isOn, isBuy));
		assertEquals(0, bet.processBet(fourTenPlaceBet, (byte) 2));
	}
	
	@Test
	public void pushFourTenPlaceBetWith3() {
		when(bet
				.processBet(fourTenPlaceBet, (byte) 3))
				.thenReturn(this.processBet(fourTenPlaceBet, (byte) 3, isOn, isBuy));
		assertEquals(0, bet.processBet(fourTenPlaceBet, (byte) 3));
	}
	
	@Test
	public void pushFourTenPlaceBetWith5() {
		when(bet
				.processBet(fourTenPlaceBet, (byte) 5))
				.thenReturn(this.processBet(fourTenPlaceBet, (byte) 5, isOn, isBuy));
		assertEquals(0, bet.processBet(fourTenPlaceBet, (byte) 5));
	}
	
	@Test
	public void pushFourTenPlaceBetWith6() {
		when(bet
				.processBet(fourTenPlaceBet, (byte) 6))
				.thenReturn(this.processBet(fourTenPlaceBet, (byte) 6, isOn, isBuy));
		assertEquals(0, bet.processBet(fourTenPlaceBet, (byte) 6));
	}
	
	@Test
	public void pushFourTenPlaceBetWith8() {
		when(bet
				.processBet(fourTenPlaceBet, (byte) 8))
				.thenReturn(this.processBet(fourTenPlaceBet, (byte) 8, isOn, isBuy));
		assertEquals(0, bet.processBet(fourTenPlaceBet, (byte) 8));
	}
	
	@Test
	public void pushFourTenPlaceBetWith9() {
		when(bet
				.processBet(fourTenPlaceBet, (byte) 9))
				.thenReturn(this.processBet(fourTenPlaceBet, (byte) 9, isOn, isBuy));
		assertEquals(0, bet.processBet(fourTenPlaceBet, (byte) 9));
	}
	
	@Test
	public void pushFourTenPlaceBetWith11() {
		when(bet
				.processBet(fourTenPlaceBet, (byte) 11))
				.thenReturn(this.processBet(fourTenPlaceBet, (byte) 11, isOn, isBuy));
		assertEquals(0, bet.processBet(fourTenPlaceBet, (byte) 11));
	}
	
	@Test
	public void pushFourTenPlaceBetWith12() {
		when(bet
				.processBet(fourTenPlaceBet, (byte) 12))
				.thenReturn(this.processBet(fourTenPlaceBet, (byte) 12, isOn, isBuy));
		assertEquals(0, bet.processBet(fourTenPlaceBet, (byte) 12));
	}
	
	private int processBet(Bet bet, byte count, boolean isOn, boolean isBuyBet) {
		double winnings = 0;
		if(isOn) {
			switch(count) {
			case 4: case 10:
				if(isBuyBet) {
					winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 2/1) - (bet.getBetAmount() * .05);
				} else {
					winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 9/5);
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