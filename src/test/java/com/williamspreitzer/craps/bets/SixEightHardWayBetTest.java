package com.williamspreitzer.craps.bets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.williamspreitzer.craps.roll.Roll;

@ExtendWith(MockitoExtension.class)
public class SixEightHardWayBetTest {
	
	@Mock
	SixEightHardwayBet bet;
	
	@Mock
	Roll rollMock;
	
	Bet sixEightHardwayBet = null;
	
	@BeforeEach
	private void setup() {
		sixEightHardwayBet = BetFactory.createPropsBet(BetType.SIX_EIGHT_HARDWAY_BET, (byte) 6, 5);
	}
	@Test
	public void mockNotNullsTest() {
		assertNotNull(bet);
		assertNotNull(rollMock);
	}
	
	@Test
	public void winSixEightHardwayBetWithHard6Test() {
		when(rollMock.
				isHardway()).thenReturn(true);
		boolean value = rollMock.isHardway();
		when(bet
				.processBet(sixEightHardwayBet, (byte) 6))
				.thenReturn(this.processBet(sixEightHardwayBet, (byte) 6, value));
		assertEquals(45,bet.processBet(sixEightHardwayBet, (byte) 6));
	}
	
	@Test
	public void winSixEightHardwayBetWithHard8Test() {
		sixEightHardwayBet = BetFactory.createPropsBet(BetType.SIX_EIGHT_HARDWAY_BET, (byte) 8, 5);
		when(rollMock
				.isHardway()).thenReturn(true);
		boolean isHardway = rollMock.isHardway();
		
		when(bet
				.processBet(sixEightHardwayBet, (byte) 8))
				.thenReturn(this.processBet(sixEightHardwayBet, (byte) 8, isHardway));
		assertEquals(45, bet.processBet(sixEightHardwayBet, (byte) 8));
	}
	
	@Test
	public void loseSixEightHardwayBetWithSoft6Test() {
		when(rollMock
				.isHardway()).thenReturn(false);
		boolean isHardway = rollMock.isHardway();
		when(bet
				.processBet(sixEightHardwayBet, (byte) 6))
				.thenReturn(this.processBet(sixEightHardwayBet, (byte) 6, isHardway));
		assertEquals(-5, bet.processBet(sixEightHardwayBet, (byte) 6));
	}
	
	@Test
	public void loseSixEightHardwayBetWithSoft8Test() {
		sixEightHardwayBet = BetFactory.createPropsBet(BetType.SIX_EIGHT_HARDWAY_BET, (byte) 8, 5);
		when(rollMock
				.isHardway()).thenReturn(false);
		boolean isHardway = rollMock.isHardway();
		when(bet
				.processBet(sixEightHardwayBet, (byte) 8))
				.thenReturn(this.processBet(sixEightHardwayBet, (byte) 8, isHardway));
		assertEquals(-5, bet.processBet(sixEightHardwayBet, (byte) 8));
	}
	
	@Test
	public void loseSixEightHArdwayBetWith7Test() {
		when(bet
				.processBet(sixEightHardwayBet, (byte) 7))
				.thenReturn(this.processBet(sixEightHardwayBet, (byte) 7, false));
		assertEquals(-5, bet.processBet(sixEightHardwayBet, (byte) 7));
	}

	@Test
	public void pushSixEightHardwayBetWith2Test() {
		when(bet
				.processBet(sixEightHardwayBet, (byte) 2))
				.thenReturn(this.processBet(sixEightHardwayBet, (byte) 2, false));
		assertEquals(0, bet.processBet(sixEightHardwayBet, (byte) 2));
	}
	
	@Test
	public void pushSixEightHardwayBetWith3Test() {
		when(bet
				.processBet(sixEightHardwayBet, (byte) 3))
				.thenReturn(this.processBet(sixEightHardwayBet, (byte) 3, false));
		assertEquals(0, bet.processBet(sixEightHardwayBet, (byte) 3));
	}
	
	@Test
	public void pushSixEightHardwayBetWith5Test() {
		when(bet
				.processBet(sixEightHardwayBet, (byte) 5))
				.thenReturn(this.processBet(sixEightHardwayBet, (byte) 5, false));
		assertEquals(0, bet.processBet(sixEightHardwayBet, (byte) 5));
	}
	
	@Test
	public void pushSixEightHardwayBetWith4Test() {
		when(bet
				.processBet(sixEightHardwayBet, (byte) 4))
				.thenReturn(this.processBet(sixEightHardwayBet, (byte) 4, false));
		assertEquals(0, bet.processBet(sixEightHardwayBet, (byte) 4));
	}
	
	@Test
	public void pushSixEightHardwayBetWith10Test() {
		when(bet
				.processBet(sixEightHardwayBet, (byte) 10))
				.thenReturn(this.processBet(sixEightHardwayBet, (byte) 10, false));
		assertEquals(0, bet.processBet(sixEightHardwayBet, (byte) 10));
	}
	
	@Test
	public void pushSixEightHardwayBetWith9Test() {
		when(bet
				.processBet(sixEightHardwayBet, (byte) 9))
				.thenReturn(this.processBet(sixEightHardwayBet, (byte) 9, false));
		assertEquals(0, bet.processBet(sixEightHardwayBet, (byte) 9));
	}
	
	
	@Test
	public void pushSixEightHardwayBetWith11Test() {
		when(bet
				.processBet(sixEightHardwayBet, (byte) 11))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.SIX_EIGHT_HARDWAY_BET, (byte) 11, 5), (byte) 11, false));
		assertEquals(0, bet.processBet(sixEightHardwayBet, (byte) 11));
	}
	
	@Test
	public void pushSixEightHardwayBetWith12Test() {
		when(bet
				.processBet(sixEightHardwayBet, (byte) 12))
				.thenReturn(this.processBet(sixEightHardwayBet, (byte) 12, false));
		assertEquals(0, bet.processBet(sixEightHardwayBet, (byte) 12));
	}
	
	private int processBet(Bet bet, byte count, boolean hardway) {
		double winnings = 0;
		switch(count) {
		case 6: case 8:
			if(hardway) {
				winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 9/1);
			} else {
				winnings = bet.getBetAmount() * -1;
			}
			break;
		case 7:
			winnings = bet.getBetAmount() * -1;
			break;
		default:
			break;
		}
		return (int) winnings;
	}
}