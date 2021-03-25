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
public class FourTenHardWayBetTest {
	
	@Mock
	FourTenHardway bet;
	
	@Mock
	Roll rollMock;
	
	Bet fourTenHardwayBet;
	
	boolean isHardway;
	
	@Test
	public void mockNotNullsTest() {
		assertNotNull(bet);
		assertNotNull(rollMock);
	}
	
	@BeforeEach
	private void setup() {
		fourTenHardwayBet = BetFactory.createPropsBet(BetType.FOUR_TEN_HARDWAY_BET, (byte) 4, 5);
	}
	
	@Test
	public void winFourTenHardwayBetWithHard4Test() {
		when(rollMock.
				isHardway()).thenReturn(true);
		isHardway = rollMock.isHardway();
		when(bet
				.processBet(fourTenHardwayBet, (byte) 4))
				.thenReturn(this.processBet(fourTenHardwayBet, (byte) 4));
		assertEquals(35,bet.processBet(fourTenHardwayBet, (byte) 4));
	}
	
	@Test
	public void winFourTenHardwayBetWithHard10Test() {
		fourTenHardwayBet = BetFactory.createPropsBet(BetType.FOUR_TEN_HARDWAY_BET, (byte) 10, 5);
		when(rollMock
				.isHardway()).thenReturn(true);
		isHardway = rollMock.isHardway();
		
		when(bet
				.processBet(fourTenHardwayBet, (byte) 10))
				.thenReturn(this.processBet(fourTenHardwayBet, (byte) 10));
		assertEquals(35, bet.processBet(fourTenHardwayBet, (byte) 10));
	}
	
	@Test
	public void loseFourTenHardwayBetWithSoft4Test() {
		when(rollMock
				.isHardway()).thenReturn(false);
		isHardway = rollMock.isHardway();
		when(bet
				.processBet(fourTenHardwayBet, (byte) 4))
				.thenReturn(this.processBet(fourTenHardwayBet, (byte) 4));
		assertEquals(-5, bet.processBet(fourTenHardwayBet, (byte) 4));
	}
	
	@Test
	public void loseFourTenHardwayBetWithSoft10Test() {
		fourTenHardwayBet = BetFactory.createPropsBet(BetType.FOUR_TEN_HARDWAY_BET, (byte) 10, 5);
		when(rollMock
				.isHardway()).thenReturn(false);
		isHardway = rollMock.isHardway();
		when(bet
				.processBet(fourTenHardwayBet, (byte) 10))
				.thenReturn(this.processBet(fourTenHardwayBet, (byte) 10));
		assertEquals(-5, bet.processBet(fourTenHardwayBet, (byte) 10));
	}
	
	@Test
	public void loseFourTenHArdwayBetWith7Test() {
		when(bet
				.processBet(fourTenHardwayBet, (byte) 7))
				.thenReturn(this.processBet(fourTenHardwayBet, (byte) 7));
		assertEquals(-5, bet.processBet(fourTenHardwayBet, (byte) 7));
	}

	@Test
	public void pushFourTenHardwayBetWith2Test() {
		when(bet
				.processBet(fourTenHardwayBet, (byte) 2))
				.thenReturn(this.processBet(fourTenHardwayBet, (byte) 2));
		assertEquals(0, bet.processBet(fourTenHardwayBet, (byte) 2));
	}
	
	@Test
	public void pushFourTenHardwayBetWith3Test() {
		when(bet
				.processBet(fourTenHardwayBet, (byte) 3))
				.thenReturn(this.processBet(fourTenHardwayBet, (byte) 3));
		assertEquals(0, bet.processBet(fourTenHardwayBet, (byte) 3));
	}
	
	@Test
	public void pushFourTenHardwayBetWith5Test() {
		when(bet
				.processBet(fourTenHardwayBet, (byte) 5))
				.thenReturn(this.processBet(fourTenHardwayBet, (byte) 5));
		assertEquals(0, bet.processBet(fourTenHardwayBet, (byte) 5));
	}
	
	@Test
	public void pushFourTenHardwayBetWith6Test() {
		when(bet
				.processBet(fourTenHardwayBet, (byte) 6))
				.thenReturn(this.processBet(fourTenHardwayBet, (byte) 6));
		assertEquals(0, bet.processBet(fourTenHardwayBet, (byte) 6));
	}
	
	@Test
	public void pushFourTenHardwayBetWith8Test() {
		when(bet
				.processBet(fourTenHardwayBet, (byte) 8))
				.thenReturn(this.processBet(fourTenHardwayBet, (byte) 8));
		assertEquals(0, bet.processBet(fourTenHardwayBet, (byte) 8));
	}
	
	@Test
	public void pushFourTenHardwayBetWith9Test() {
		when(bet
				.processBet(fourTenHardwayBet, (byte) 9))
				.thenReturn(this.processBet(fourTenHardwayBet, (byte) 9));
		assertEquals(0, bet.processBet(fourTenHardwayBet, (byte) 9));
	}
	
	
	@Test
	public void pushFourTenHardwayBetWith11Test() {
		when(bet
				.processBet(fourTenHardwayBet, (byte) 11))
				.thenReturn(this.processBet(fourTenHardwayBet, (byte) 11));
		assertEquals(0, bet.processBet(fourTenHardwayBet, (byte) 11));
	}
	
	@Test
	public void pushFourTenHardwayBetWith12Test() {
		when(bet
				.processBet(fourTenHardwayBet, (byte) 12))
				.thenReturn(this.processBet(fourTenHardwayBet, (byte) 12));
		assertEquals(0, bet.processBet(fourTenHardwayBet, (byte) 12));
	}
	
	private int processBet(Bet bet, byte count) {
		double winnings = 0;
		switch(count) {
		case 4: case 10:
			if(isHardway) {
				winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 7/1);
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