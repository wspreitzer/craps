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
public class SixEightPlaceBetTest {
	@Mock
	Bet bet;
	
	@Mock
	SixEightPlaceBet buyBet;
	
	Bet sixEightPlaceBet = null;
	
	boolean isOn;
	boolean isBuy;
	
	@BeforeEach
	private void setup() { 
		when(buyBet.isOn()).thenReturn(true);
		when(buyBet.isBuy()).thenReturn(false);
		this.isOn = buyBet.isOn();
		this.isBuy = buyBet.isBuy();
		sixEightPlaceBet = BetFactory.createPropsBet(BetType.SIX_EIGHT_PLACE_BET, (byte) 6, 6);
	}
	
	@Test
	public void mocksNotNullsTest() {
		assertNotNull(bet);
	}
	
	@Test
	public void winSixEightPlaceBetWith6() {
		when(bet
				.processBet(sixEightPlaceBet, (byte) 6))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 6, isOn, isBuy));
		assertEquals(7, bet.processBet(sixEightPlaceBet, (byte) 6));
	}
	
	@Test 
	public void winSixEightPlaceBetWith8() {
		sixEightPlaceBet = BetFactory.createPropsBet(BetType.SIX_EIGHT_PLACE_BET, (byte) 8, 6);
		when(bet
				.processBet(sixEightPlaceBet, (byte) 8))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 8, isOn, isBuy));
		assertEquals(7, bet.processBet(sixEightPlaceBet, (byte) 8));
	}
	
	@Test
	public void dontWinSixEightPlaceBetWith6AndOffBet() {
		when(buyBet.isOn()).thenReturn(false);
		this.isOn = buyBet.isOn();
		when(bet
				.processBet(sixEightPlaceBet, (byte) 6))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 6, isOn, isBuy));
		assertEquals(0, bet.processBet(sixEightPlaceBet, (byte) 6));
	}
	
	@Test 
	public void dontWinSixEightPlaceBetWith8AndOffBet() {
		sixEightPlaceBet = BetFactory.createPropsBet(BetType.SIX_EIGHT_PLACE_BET, (byte) 8, 6);
		when(buyBet.isOn()).thenReturn(false);
		this.isOn = buyBet.isOn();
		when(bet
				.processBet(sixEightPlaceBet, (byte) 8))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 8, isOn, isBuy));
		assertEquals(0, bet.processBet(sixEightPlaceBet, (byte) 8));
	}
	
	@Test
	public void loseSixEightPlaceBetWith7() {
		when(bet
				.processBet(sixEightPlaceBet, (byte) 7))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 7, isOn, isBuy));
		assertEquals(-6, bet.processBet(sixEightPlaceBet, (byte) 7));
	}
	
	@Test
	public void dontLoseSixEightPlaceBetWith7AndOffBet() {
		when(buyBet.isOn()).thenReturn(false);
		this.isOn = buyBet.isOn();
		when(bet
				.processBet(sixEightPlaceBet, (byte) 7))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 7, isOn, isBuy));
		assertEquals(0, bet.processBet(sixEightPlaceBet, (byte) 7));
	}
	
	@Test
	public void winSixEightBuyBetWith6() {
		sixEightPlaceBet = BetFactory.createPropsBet(BetType.SIX_EIGHT_PLACE_BET, (byte) 6, 5);
		when(buyBet.isBuy()).thenReturn(true);
		this.isBuy = buyBet.isBuy();
		when(bet
				.processBet(sixEightPlaceBet, (byte) 6))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 6, isOn, isBuy));
		assertEquals(5, bet.processBet(sixEightPlaceBet, (byte) 6));
	}
	
	@Test
	public void winSixEightBuyBetWith8() {
		sixEightPlaceBet = BetFactory.createPropsBet(BetType.SIX_EIGHT_PLACE_BET, (byte) 8, 5);
		when(buyBet.isBuy()).thenReturn(true);
		this.isBuy = buyBet.isBuy();
		when(bet
				.processBet(sixEightPlaceBet, (byte) 8))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 8, isOn, isBuy));
		assertEquals(5, bet.processBet(sixEightPlaceBet, (byte) 8));
	}
	
	@Test
	public void pushSixEightPlaceBetWith2() {
		when(bet
				.processBet(sixEightPlaceBet, (byte) 2))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 2, isOn, isBuy));
		assertEquals(0, bet.processBet(sixEightPlaceBet, (byte) 2));
	}
	
	@Test
	public void pushSixEightPlaceBetWith3() {
		when(bet
				.processBet(sixEightPlaceBet, (byte) 3))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 3, isOn, isBuy));
		assertEquals(0, bet.processBet(sixEightPlaceBet, (byte) 3));
	}
	
	@Test
	public void pushSixEightPlaceBetWith5() {
		when(bet
				.processBet(sixEightPlaceBet, (byte) 5))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 5, isOn, isBuy));
		assertEquals(0, bet.processBet(sixEightPlaceBet, (byte) 5));
	}
	
	@Test
	public void pushSixEightPlaceBetWith4() {
		when(bet
				.processBet(sixEightPlaceBet, (byte) 4))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 4, isOn, isBuy));
		assertEquals(0, bet.processBet(sixEightPlaceBet, (byte) 4));
	}
	
	@Test
	public void pushSixEightPlaceBetWith10() {
		when(bet
				.processBet(sixEightPlaceBet, (byte) 10))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 10, isOn, isBuy));
		assertEquals(0, bet.processBet(sixEightPlaceBet, (byte) 10));
	}
	
	@Test
	public void pushSixEightPlaceBetWith9() {
		when(bet
				.processBet(sixEightPlaceBet, (byte) 9))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 9, isOn, isBuy));
		assertEquals(0, bet.processBet(sixEightPlaceBet, (byte) 9));
	}
	
	@Test
	public void pushSixEightPlaceBetWith11() {
		when(bet
				.processBet(sixEightPlaceBet, (byte) 11))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 11, isOn, isBuy));
		assertEquals(0, bet.processBet(sixEightPlaceBet, (byte) 11));
	}
	
	@Test
	public void pushSixEightPlaceBetWith12() {
		when(bet
				.processBet(sixEightPlaceBet, (byte) 12))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 12, isOn, isBuy));
		assertEquals(0, bet.processBet(sixEightPlaceBet, (byte) 12));
	}
	
	private int processBet(Bet bet, byte count, boolean isOn, boolean isBuyBet) {
		double winnings = 0;
		if(isOn) {
			switch(count) {
			case 6: case 8:
				if(isBuyBet) {
					winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 6/5) - (bet.getBetAmount() * .05);
				} else {
					winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 7/6);
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