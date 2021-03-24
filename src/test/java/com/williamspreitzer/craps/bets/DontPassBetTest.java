package com.williamspreitzer.craps.bets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import com.williamspreitzer.craps.roll.Roll;
import com.williamspreitzer.craps.utils.CrapsUtils;

@ExtendWith(MockitoExtension.class)
public class DontPassBetTest {

	@Mock
	DontPassBet bet;
	
	@Mock
	Roll roll;
	
	Bet dontPassLineBet = null;
	
	static MockedStatic<CrapsUtils> utils = null;
	
	static byte point;
	
	Boolean isPointEstablished;
	
	static {
		utils = mockStatic(CrapsUtils.class);
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 0);
		point = CrapsUtils.getPoint();
	}
	
	@BeforeEach
	private void setup() {
		dontPassLineBet = BetFactory.createPropsBet(BetType.DONT_PASS_BAR_TWELEVE_BET, 5);
	}
	
	@Test
	public void loseDontPassLineBetWith7OnComeOut() {
		when(roll.isPointEstablished()).thenReturn(false);
		 this.isPointEstablished = roll.isPointEstablished();
		when(bet
				.processBet(dontPassLineBet, (byte) 7))
				.thenReturn(this.processBet(dontPassLineBet, (byte) 7));
		assertEquals(-5,bet.processBet(dontPassLineBet, (byte) 7));
	}
	
	@Test
	public void loseDontPassLineBetWith11OnComeOut() {
		when(roll.isPointEstablished()).thenReturn(false);
		this.isPointEstablished = roll.isPointEstablished();
		when(bet
				.processBet(dontPassLineBet, (byte) 11))
				.thenReturn(this.processBet(dontPassLineBet, (byte) 11));
		assertEquals(-5,bet.processBet(dontPassLineBet, (byte) 11));
	}
	
	@Test
	public void winDontPassLineBetWith2OnComeOut() {
		when(roll.isPointEstablished()).thenReturn(false);
		this.isPointEstablished = roll.isPointEstablished();
		when(bet
				.processBet(dontPassLineBet, (byte) 2))
				.thenReturn(this.processBet(dontPassLineBet, (byte) 2));
		assertEquals(5, bet.processBet(dontPassLineBet, (byte) 2));
	}
	
	@Test
	public void winDontPassLineBetWith3OnComeOut() {
		when(roll.isPointEstablished()).thenReturn(false);
		this.isPointEstablished = roll.isPointEstablished();
		when(bet
				.processBet(dontPassLineBet, (byte) 3))
				.thenReturn(this.processBet(dontPassLineBet, (byte) 3));
		assertEquals(5, bet.processBet(dontPassLineBet, (byte) 3));
	}
	
	@Test
	public void winDontPassLineBetWith12OnComeOut() {
		when(roll.isPointEstablished()).thenReturn(false);
		this.isPointEstablished = roll.isPointEstablished();
		when(bet
				.processBet(dontPassLineBet, (byte) 12))
				.thenReturn(this.processBet(dontPassLineBet, (byte) 12));
		assertEquals(5, bet.processBet(dontPassLineBet, (byte) 12));
	}
	
	@Test
	public void setPointWith4OnComeOut() {
		when(roll.isPointEstablished()).thenReturn(false);
		this.isPointEstablished = roll.isPointEstablished();
		when(bet
				.processBet(dontPassLineBet, (byte) 4))
				.thenReturn(this.processBet(dontPassLineBet, (byte) 4));
		assertEquals(0, bet.processBet(dontPassLineBet, (byte) 4));
		assertTrue(this.isPointEstablished);
		assertEquals(4, point);
	}
	
	@Test
	public void setPointWith5OnComeOut() {
		when(roll.isPointEstablished()).thenReturn(false);
		this.isPointEstablished = roll.isPointEstablished();
		when(bet
				.processBet(dontPassLineBet, (byte) 5))
				.thenReturn(this.processBet(dontPassLineBet, (byte) 5));
		assertEquals(0, bet.processBet(dontPassLineBet, (byte) 5));
		assertTrue(this.isPointEstablished);
		assertEquals(5, point);
	}
	
	@Test
	public void setPointWith6OnComeOut() {
		when(roll.isPointEstablished()).thenReturn(false);
		this.isPointEstablished = roll.isPointEstablished();
		when(bet
				.processBet(dontPassLineBet, (byte) 6))
				.thenReturn(this.processBet(dontPassLineBet, (byte) 6));
		assertEquals(0, bet.processBet(dontPassLineBet, (byte) 6));
		assertTrue(this.isPointEstablished);
		assertEquals(6, point);
	}
	
	@Test
	public void setPointWith8OnComeOut() {
		when(roll.isPointEstablished()).thenReturn(false);
		this.isPointEstablished = roll.isPointEstablished();
		when(bet
				.processBet(dontPassLineBet, (byte) 8))
				.thenReturn(this.processBet(dontPassLineBet, (byte) 8));
		assertEquals(0, bet.processBet(dontPassLineBet, (byte) 8));
		assertTrue(this.isPointEstablished);
		assertEquals(8, point);
	}
	
	@Test
	public void setPointWith9OnComeout() {
		when(roll.isPointEstablished()).thenReturn(false);
		this.isPointEstablished = roll.isPointEstablished();
		when(bet
				.processBet(dontPassLineBet, (byte) 9))
				.thenReturn(this.processBet(dontPassLineBet, (byte) 9));
		assertEquals(0, bet.processBet(dontPassLineBet, (byte) 9));
		assertTrue(this.isPointEstablished);
		assertEquals(9, point);
	}
	
	@Test
	public void setPointWith10OnComeOut() {
		when(roll.isPointEstablished()).thenReturn(false);
		this.isPointEstablished = roll.isPointEstablished();
		when(bet
				.processBet(dontPassLineBet, (byte) 10))
				.thenReturn(this.processBet(dontPassLineBet, (byte) 10));
		assertEquals(0, bet.processBet(dontPassLineBet, (byte) 10));
		assertTrue(isPointEstablished);
		assertEquals(10, point);
	}
	
	@Test
	public void winDontPassLineBetWith7AndPointOf4() {
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 4);
		assertEquals((byte) 4, CrapsUtils.getPoint());
		point = CrapsUtils.getPoint();
		
		when(roll.isPointEstablished()).thenReturn(true);
		this.isPointEstablished = roll.isPointEstablished();
		assertTrue(this.isPointEstablished);
		when(bet
				.processBet(dontPassLineBet, (byte) 7))
				.thenReturn(this.processBet(dontPassLineBet, (byte) 7));
		assertEquals(5, bet.processBet(dontPassLineBet, (byte) 7));
		assertFalse(this.isPointEstablished);
	}
	
	@Test
	public void winDontPassLineBetWith7AndPointOf5() {
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 5);
		assertEquals((byte) 5, CrapsUtils.getPoint());
		point = CrapsUtils.getPoint();
		
		when(roll.isPointEstablished()).thenReturn(true);
		this.isPointEstablished = roll.isPointEstablished();
		assertTrue(this.isPointEstablished);
		when(bet
				.processBet(dontPassLineBet, (byte) 7))
				.thenReturn(this.processBet(dontPassLineBet, (byte) 7));
		assertEquals(5, bet.processBet(dontPassLineBet, (byte) 7));
		assertFalse(this.isPointEstablished);
	}
	
	@Test
	public void winDontPassLineBetWith7AndPointOf6() {
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 6);
		assertEquals((byte) 6, CrapsUtils.getPoint());
		point = CrapsUtils.getPoint();
		
		when(roll.isPointEstablished()).thenReturn(true);
		this.isPointEstablished = roll.isPointEstablished();
		assertTrue(this.isPointEstablished);
		when(bet
				.processBet(dontPassLineBet, (byte) 7))
				.thenReturn(this.processBet(dontPassLineBet, (byte) 7));
		assertEquals(5, bet.processBet(dontPassLineBet, (byte) 7));
		assertFalse(this.isPointEstablished);
	}
	
	@Test
	public void winDontPassLineBetWith7AndPointOf8() {
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 8);
		assertEquals((byte) 8, CrapsUtils.getPoint());
		point = CrapsUtils.getPoint();
		
		when(roll.isPointEstablished()).thenReturn(true);
		this.isPointEstablished = roll.isPointEstablished();
		assertTrue(this.isPointEstablished);
		when(bet
				.processBet(dontPassLineBet, (byte) 7))
				.thenReturn(this.processBet(dontPassLineBet, (byte) 7));
		assertEquals(5, bet.processBet(dontPassLineBet, (byte) 7));
		assertFalse(this.isPointEstablished);
	}
	
	@Test
	public void winDontPassLineBetWith7AndPointOf9() {
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 9);
		assertEquals((byte) 9, CrapsUtils.getPoint());
		point = CrapsUtils.getPoint();
		
		when(roll.isPointEstablished()).thenReturn(true);
		this.isPointEstablished = roll.isPointEstablished();
		assertTrue(this.isPointEstablished);
		when(bet
				.processBet(dontPassLineBet, (byte) 7))
				.thenReturn(this.processBet(dontPassLineBet, (byte) 7));
		assertEquals(5, bet.processBet(dontPassLineBet, (byte) 7));
		assertFalse(this.isPointEstablished);
	}
	
	@Test
	public void winDontPassLineBetWith7AndPointOf10() {
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 10);
		assertEquals((byte) 10, CrapsUtils.getPoint());
		point = CrapsUtils.getPoint();
		
		when(roll.isPointEstablished()).thenReturn(true);
		this.isPointEstablished = roll.isPointEstablished();
		assertTrue(this.isPointEstablished);
		when(bet
				.processBet(dontPassLineBet, (byte) 7))
				.thenReturn(this.processBet(dontPassLineBet, (byte) 7));
		assertEquals(5, bet.processBet(dontPassLineBet, (byte) 7));
		assertFalse(this.isPointEstablished);
	}
	
	@Test
	public void loseDontPassLineBetWith4AndPointOf4() {
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 4);
		assertEquals((byte) 4, CrapsUtils.getPoint());
		point = CrapsUtils.getPoint();
		
		when(roll.isPointEstablished()).thenReturn(true);
		this.isPointEstablished = roll.isPointEstablished();
		assertTrue(this.isPointEstablished);
		when(bet
				.processBet(dontPassLineBet, (byte) 4))
				.thenReturn(this.processBet(dontPassLineBet, (byte) 4));
		assertEquals(-5, bet.processBet(dontPassLineBet, (byte) 4));
		assertFalse(this.isPointEstablished);
	}
	
	@Test
	public void loseDontPassLineBetWith5AndPointOf5() {
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 5);
		assertEquals((byte) 5, CrapsUtils.getPoint());
		point = CrapsUtils.getPoint();
		
		when(roll.isPointEstablished()).thenReturn(true);
		this.isPointEstablished = roll.isPointEstablished();
		assertTrue(this.isPointEstablished);
		when(bet
				.processBet(dontPassLineBet, (byte) 5))
				.thenReturn(this.processBet(dontPassLineBet, (byte) 5));
		assertEquals(-5, bet.processBet(dontPassLineBet, (byte) 5));
		assertFalse(this.isPointEstablished);
	}
	
	@Test
	public void loseDontPassLineBetWith6AndPointOf6() {
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 6);
		assertEquals((byte) 6, CrapsUtils.getPoint());
		point = CrapsUtils.getPoint();
		
		when(roll.isPointEstablished()).thenReturn(true);
		this.isPointEstablished = roll.isPointEstablished();
		assertTrue(this.isPointEstablished);
		when(bet
				.processBet(dontPassLineBet, (byte) 6))
				.thenReturn(this.processBet(dontPassLineBet, (byte) 6));
		assertEquals(-5, bet.processBet(dontPassLineBet, (byte) 6));
		assertFalse(this.isPointEstablished);
	}
	
	@Test
	public void loseDontPassLineBetWith8AndPointOf8() {
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 8);
		assertEquals((byte) 8, CrapsUtils.getPoint());
		point = CrapsUtils.getPoint();
		
		when(roll.isPointEstablished()).thenReturn(true);
		this.isPointEstablished = roll.isPointEstablished();
		assertTrue(this.isPointEstablished);
		when(bet
				.processBet(dontPassLineBet, (byte) 8))
				.thenReturn(this.processBet(dontPassLineBet, (byte) 8));
		assertEquals(-5, bet.processBet(dontPassLineBet, (byte) 8));
		assertFalse(this.isPointEstablished);
	}
	
	@Test
	public void loseDontPassLineBetWith9AndPointOf9() {
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 9);
		assertEquals((byte) 9, CrapsUtils.getPoint());
		point = CrapsUtils.getPoint();
		
		when(roll.isPointEstablished()).thenReturn(true);
		this.isPointEstablished = roll.isPointEstablished();
		assertTrue(this.isPointEstablished);
		when(bet
				.processBet(dontPassLineBet, (byte) 9))
				.thenReturn(this.processBet(dontPassLineBet, (byte) 9));
		assertEquals(-5, bet.processBet(dontPassLineBet, (byte) 9));
		assertFalse(this.isPointEstablished);
	}
	
	@Test
	public void loseDontPassLineBetWith10AndPointOf10() {
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 10);
		assertEquals((byte) 10, CrapsUtils.getPoint());
		point = CrapsUtils.getPoint();
		
		when(roll.isPointEstablished()).thenReturn(true);
		this.isPointEstablished = roll.isPointEstablished();
		assertTrue(this.isPointEstablished);
		when(bet
				.processBet(dontPassLineBet, (byte) 10))
				.thenReturn(this.processBet(dontPassLineBet, (byte) 10));
		assertEquals(-5, bet.processBet(dontPassLineBet, (byte) 10));
		assertFalse(this.isPointEstablished);
	}

	private int processBet(Bet bet, byte count) {
		double winnings = 0;
		if(isPointEstablished) {
			switch(count) {
			case 2: case 3: case 11: case 12:
				break;
			case 7:
				winnings = bet.getBetAmount();
				isPointEstablished = false;
				break;
			default:
				if(count == point) {
					winnings = bet.getBetAmount() * -1;
					isPointEstablished = false;
				}
				break;
			} 
		} else {
			switch(count) {
			case 2: case 3: case 12:
				winnings = bet.getBetAmount();
				break;
			case 7: case 11:
				winnings = bet.getBetAmount() * -1;
				break;
			default:
				this.isPointEstablished = true;
				point = count;
				break;
			}
		}
		return (int) winnings;
	}
	
	@AfterAll
	private static void close() {
		utils.close();
	}
}
