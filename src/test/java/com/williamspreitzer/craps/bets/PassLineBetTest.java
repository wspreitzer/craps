package com.williamspreitzer.craps.bets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import com.williamspreitzer.craps.roll.Roll;
import com.williamspreitzer.craps.utils.CrapsUtils;

@ExtendWith(MockitoExtension.class)
public class PassLineBetTest {
	
	@Mock
	Bet bet;
	
	@Mock
	Roll roll;
	
	Bet passLineBet = null;
	
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
		isPointEstablished = null;
		passLineBet = BetFactory.createPropsBet(BetType.PASS_LINE_BET, 5);
	}
	
	@Test
	public void winPassLineBetWith7OnComeOut() {
		when(roll.isPointEstablished()).thenReturn(false);
		 this.isPointEstablished = roll.isPointEstablished();
		when(bet
				.processBet(passLineBet, (byte) 7))
				.thenReturn(this.processBet(passLineBet, (byte) 7, isPointEstablished, point));
		assertEquals(5,bet.processBet(passLineBet, (byte) 7));
	}
	
	@Test
	public void winPassLineBetWith11OnComeOut() {
		when(roll.isPointEstablished()).thenReturn(false);
		this.isPointEstablished = roll.isPointEstablished();
		when(bet
				.processBet(passLineBet, (byte) 11))
				.thenReturn(this.processBet(passLineBet, (byte) 11, isPointEstablished, point));
		assertEquals(5,bet.processBet(passLineBet, (byte) 11));
	}
	
	@Test
	public void losePassLineBetWith2OnComeOut() {
		when(roll.isPointEstablished()).thenReturn(false);
		this.isPointEstablished = roll.isPointEstablished();
		when(bet
				.processBet(passLineBet, (byte) 2))
				.thenReturn(this.processBet(passLineBet, (byte) 2, isPointEstablished, point));
		assertEquals(-5, bet.processBet(passLineBet, (byte) 2));
	}
	
	@Test
	public void losePassLineBetWith3OnComeOut() {
		when(roll.isPointEstablished()).thenReturn(false);
		this.isPointEstablished = roll.isPointEstablished();
		when(bet
				.processBet(passLineBet, (byte) 3))
				.thenReturn(this.processBet(passLineBet, (byte) 3, isPointEstablished, point));
		assertEquals(-5, bet.processBet(passLineBet, (byte) 3));
	}
	
	@Test
	public void losePassLineBetWith12OnComeOut() {
		when(roll.isPointEstablished()).thenReturn(false);
		this.isPointEstablished = roll.isPointEstablished();
		when(bet
				.processBet(passLineBet, (byte) 12))
				.thenReturn(this.processBet(passLineBet, (byte) 12, isPointEstablished, point));
		assertEquals(-5, bet.processBet(passLineBet, (byte) 12));
	}
	
	@Test
	public void setPointWith4OnComeOut() {
		when(roll.isPointEstablished()).thenReturn(false);
		this.isPointEstablished = roll.isPointEstablished();
		when(bet
				.processBet(passLineBet, (byte) 4))
				.thenReturn(this.processBet(passLineBet, (byte) 4, isPointEstablished, point));
		assertEquals(0, bet.processBet(passLineBet, (byte) 4));
		assertTrue(this.isPointEstablished);
	}
	
	@Test
	public void setPointWith5OnComeOut() {
		when(roll.isPointEstablished()).thenReturn(false);
		this.isPointEstablished = roll.isPointEstablished();
		when(bet
				.processBet(passLineBet, (byte) 5))
				.thenReturn(this.processBet(passLineBet, (byte) 5, isPointEstablished, point));
		assertEquals(0, bet.processBet(passLineBet, (byte) 5));
		assertTrue(this.isPointEstablished);
	}
	
	@Test
	public void setPointWith6OnComeOut() {
		when(roll.isPointEstablished()).thenReturn(false);
		this.isPointEstablished = roll.isPointEstablished();
		when(bet
				.processBet(passLineBet, (byte) 6))
				.thenReturn(this.processBet(passLineBet, (byte) 6, isPointEstablished, point));
		assertEquals(0, bet.processBet(passLineBet, (byte) 6));
		assertTrue(this.isPointEstablished);
	}
	
	@Test
	public void setPointWith8OnComeOut() {
		when(roll.isPointEstablished()).thenReturn(false);
		this.isPointEstablished = roll.isPointEstablished();
		when(bet
				.processBet(passLineBet, (byte) 8))
				.thenReturn(this.processBet(passLineBet, (byte) 8, isPointEstablished, point));
		assertEquals(0, bet.processBet(passLineBet, (byte) 8));
		assertTrue(this.isPointEstablished);
	}
	
	@Test
	public void setPointWith9OnComeout() {
		when(roll.isPointEstablished()).thenReturn(false);
		this.isPointEstablished = roll.isPointEstablished();
		when(bet
				.processBet(passLineBet, (byte) 9))
				.thenReturn(this.processBet(passLineBet, (byte) 9, isPointEstablished, point));
		assertEquals(0, bet.processBet(passLineBet, (byte) 9));
		assertTrue(this.isPointEstablished);
	}
	
	@Test
	public void setPointWith10OnComeOut() {
		when(roll.isPointEstablished()).thenReturn(false);
		this.isPointEstablished = roll.isPointEstablished();
		when(bet
				.processBet(passLineBet, (byte) 10))
				.thenReturn(this.processBet(passLineBet, (byte) 10, isPointEstablished, point));
		assertEquals(0, bet.processBet(passLineBet, (byte) 10));
		assertTrue(isPointEstablished);
	}
	
	@Test
	public void losePassLineBetWith7AndPointOf5() {
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 5);
		assertEquals((byte) 5, CrapsUtils.getPoint());
		point = CrapsUtils.getPoint();
		
		when(roll.isPointEstablished()).thenReturn(true);
		this.isPointEstablished = roll.isPointEstablished();
		assertTrue(this.isPointEstablished);
		when(bet
				.processBet(passLineBet, (byte) 7))
				.thenReturn(this.processBet(passLineBet, (byte) 7, isPointEstablished, point));
		assertEquals(-5, bet.processBet(passLineBet, (byte) 7));
		assertFalse(this.isPointEstablished);
	}
	
	@Test
	public void winPassLineBetWith4AndPointOf4() {
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 4);
		assertEquals((byte) 4, CrapsUtils.getPoint());
		point = CrapsUtils.getPoint();
		
		when(roll.isPointEstablished()).thenReturn(true);
		this.isPointEstablished = roll.isPointEstablished();
		assertTrue(this.isPointEstablished);
		when(bet
				.processBet(passLineBet, (byte) 4))
				.thenReturn(this.processBet(passLineBet, (byte) 4, isPointEstablished, point));
		assertEquals(5, bet.processBet(passLineBet, (byte) 4));
		assertFalse(this.isPointEstablished);
	}
	
	@Test
	public void winPassLineBetWith5AndPointOf5() {
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 5);
		assertEquals((byte) 5, CrapsUtils.getPoint());
		point = CrapsUtils.getPoint();
		
		when(roll.isPointEstablished()).thenReturn(true);
		this.isPointEstablished = roll.isPointEstablished();
		assertTrue(this.isPointEstablished);
		when(bet
				.processBet(passLineBet, (byte) 5))
				.thenReturn(this.processBet(passLineBet, (byte) 5, isPointEstablished, point));
		assertEquals(5, bet.processBet(passLineBet, (byte) 5));
		assertFalse(this.isPointEstablished);
	}
	
	@Test
	public void winPassLineBetWith6AndPointOf6() {
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 6);
		assertEquals((byte) 6, CrapsUtils.getPoint());
		point = CrapsUtils.getPoint();
		
		when(roll.isPointEstablished()).thenReturn(true);
		this.isPointEstablished = roll.isPointEstablished();
		assertTrue(this.isPointEstablished);
		when(bet
				.processBet(passLineBet, (byte) 6))
				.thenReturn(this.processBet(passLineBet, (byte) 6, isPointEstablished, point));
		assertEquals(5, bet.processBet(passLineBet, (byte) 6));
		assertFalse(this.isPointEstablished);
	}
	
	@Test
	public void winPassLineBetWith8AndPointOf8() {
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 8);
		assertEquals((byte) 8, CrapsUtils.getPoint());
		point = CrapsUtils.getPoint();
		
		when(roll.isPointEstablished()).thenReturn(true);
		this.isPointEstablished = roll.isPointEstablished();
		assertTrue(this.isPointEstablished);
		when(bet
				.processBet(passLineBet, (byte) 8))
				.thenReturn(this.processBet(passLineBet, (byte) 8, isPointEstablished, point));
		assertEquals(5, bet.processBet(passLineBet, (byte) 8));
		assertFalse(this.isPointEstablished);
	}
	
	@Test
	public void winPassLineBetWith9AndPointOf9() {
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 9);
		assertEquals((byte) 9, CrapsUtils.getPoint());
		point = CrapsUtils.getPoint();
		
		when(roll.isPointEstablished()).thenReturn(true);
		this.isPointEstablished = roll.isPointEstablished();
		assertTrue(this.isPointEstablished);
		when(bet
				.processBet(passLineBet, (byte) 9))
				.thenReturn(this.processBet(passLineBet, (byte) 9, isPointEstablished, point));
		assertEquals(5, bet.processBet(passLineBet, (byte) 9));
		assertFalse(this.isPointEstablished);
	}
	
	@Test
	public void winPassLineBetWith10AndPointOf10() {
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 10);
		assertEquals((byte) 10, CrapsUtils.getPoint());
		point = CrapsUtils.getPoint();
		
		when(roll.isPointEstablished()).thenReturn(true);
		this.isPointEstablished = roll.isPointEstablished();
		assertTrue(this.isPointEstablished);
		when(bet
				.processBet(passLineBet, (byte) 10))
				.thenReturn(this.processBet(passLineBet, (byte) 10, isPointEstablished, point));
		assertEquals(5, bet.processBet(passLineBet, (byte) 10));
		assertFalse(this.isPointEstablished);
	}
	
	private int processBet(Bet bet, byte count, boolean isPointEstablished, byte point) {
		double winnings = 0;
		if (isPointEstablished) {
			switch(count) {
			case 2: case 3: case 11: case 12:
				break;	
			case 7:
				winnings = bet.getBetAmount() * -1;
				this.isPointEstablished = false;
				break;
			default:
				if(count == point) {
					this.isPointEstablished = false;
					winnings = bet.getBetAmount();
				}
			}
		} else {
			switch(count) {
			case 7: case 11:
				winnings = bet.getBetAmount();
				break;
			case 2: case 3: case 12:
				winnings = bet.getBetAmount() * -1;
				break;
			default:
				this.isPointEstablished = true;
				break;
			}
		}
		return (int) winnings;
	}
}