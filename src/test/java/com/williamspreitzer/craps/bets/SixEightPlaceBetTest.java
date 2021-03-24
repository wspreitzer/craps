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
	SixEightPlaceBet bet;
	
	Bet sixEightPlaceBet = null;
	
	boolean isOn;
	boolean isBuy;
	
	@BeforeEach
	private void setup() { 
		when(bet.isOn()).thenReturn(true);
		when(bet.isBuy()).thenReturn(false);
		this.isOn = bet.isOn();
		this.isBuy = bet.isBuy();
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
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 6));
		assertEquals(7, bet.processBet(sixEightPlaceBet, (byte) 6));
	}
	
	@Test 
	public void winSixEightPlaceBetWith8() {
		sixEightPlaceBet = BetFactory.createPropsBet(BetType.SIX_EIGHT_PLACE_BET, (byte) 8, 6);
		when(bet
				.processBet(sixEightPlaceBet, (byte) 8))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 8));
		assertEquals(7, bet.processBet(sixEightPlaceBet, (byte) 8));
	}
	
	@Test
	public void dontWinSixEightPlaceBetWith6AndOffBet() {
		when(bet.isOn()).thenReturn(false);
		this.isOn = bet.isOn();
		when(bet
				.processBet(sixEightPlaceBet, (byte) 6))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 6));
		assertEquals(0, bet.processBet(sixEightPlaceBet, (byte) 6));
	}
	
	@Test 
	public void dontWinSixEightPlaceBetWith8AndOffBet() {
		sixEightPlaceBet = BetFactory.createPropsBet(BetType.SIX_EIGHT_PLACE_BET, (byte) 8, 6);
		when(bet.isOn()).thenReturn(false);
		this.isOn = bet.isOn();
		when(bet
				.processBet(sixEightPlaceBet, (byte) 8))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 8));
		assertEquals(0, bet.processBet(sixEightPlaceBet, (byte) 8));
	}
	
	@Test
	public void loseSixEightPlaceBetWith7() {
		when(bet
				.processBet(sixEightPlaceBet, (byte) 7))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 7));
		assertEquals(-6, bet.processBet(sixEightPlaceBet, (byte) 7));
	}
	
	@Test
	public void dontLoseSixEightPlaceBetWith7AndOffBet() {
		when(bet.isOn()).thenReturn(false);
		this.isOn = bet.isOn();
		when(bet
				.processBet(sixEightPlaceBet, (byte) 7))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 7));
		assertEquals(0, bet.processBet(sixEightPlaceBet, (byte) 7));
	}
	
	@Test
	public void winSixEightBuyBetWith6() {
		sixEightPlaceBet = BetFactory.createPropsBet(BetType.SIX_EIGHT_PLACE_BET, (byte) 6, 5);
		when(bet.isBuy()).thenReturn(true);
		this.isBuy = bet.isBuy();
		when(bet
				.processBet(sixEightPlaceBet, (byte) 6))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 6));
		assertEquals(5, bet.processBet(sixEightPlaceBet, (byte) 6));
	}
	
	@Test
	public void winSixEightBuyBetWith8() {
		sixEightPlaceBet = BetFactory.createPropsBet(BetType.SIX_EIGHT_PLACE_BET, (byte) 8, 5);
		when(bet.isBuy()).thenReturn(true);
		this.isBuy = bet.isBuy();
		when(bet
				.processBet(sixEightPlaceBet, (byte) 8))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 8));
		assertEquals(5, bet.processBet(sixEightPlaceBet, (byte) 8));
	}
	
	@Test
	public void pushSixEightPlaceBetWith2() {
		when(bet
				.processBet(sixEightPlaceBet, (byte) 2))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 2));
		assertEquals(0, bet.processBet(sixEightPlaceBet, (byte) 2));
	}
	
	@Test
	public void pushSixEightPlaceBetWith3() {
		when(bet
				.processBet(sixEightPlaceBet, (byte) 3))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 3));
		assertEquals(0, bet.processBet(sixEightPlaceBet, (byte) 3));
	}
	
	@Test
	public void pushSixEightPlaceBetWith5() {
		when(bet
				.processBet(sixEightPlaceBet, (byte) 5))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 5));
		assertEquals(0, bet.processBet(sixEightPlaceBet, (byte) 5));
	}
	
	@Test
	public void pushSixEightPlaceBetWith4() {
		when(bet
				.processBet(sixEightPlaceBet, (byte) 4))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 4));
		assertEquals(0, bet.processBet(sixEightPlaceBet, (byte) 4));
	}
	
	@Test
	public void pushSixEightPlaceBetWith10() {
		when(bet
				.processBet(sixEightPlaceBet, (byte) 10))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 10));
		assertEquals(0, bet.processBet(sixEightPlaceBet, (byte) 10));
	}
	
	@Test
	public void pushSixEightPlaceBetWith9() {
		when(bet
				.processBet(sixEightPlaceBet, (byte) 9))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 9));
		assertEquals(0, bet.processBet(sixEightPlaceBet, (byte) 9));
	}
	
	@Test
	public void pushSixEightPlaceBetWith11() {
		when(bet
				.processBet(sixEightPlaceBet, (byte) 11))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 11));
		assertEquals(0, bet.processBet(sixEightPlaceBet, (byte) 11));
	}
	
	@Test
	public void pushSixEightPlaceBetWith12() {
		when(bet
				.processBet(sixEightPlaceBet, (byte) 12))
				.thenReturn(this.processBet(sixEightPlaceBet, (byte) 12));
		assertEquals(0, bet.processBet(sixEightPlaceBet, (byte) 12));
	}
	
	private int processBet(Bet bet, byte count) {
		double winnings = 0;
		if(isOn) {
			switch(count) {
			case 6: case 8:
				if(isBuy) {
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