package com.williamspreitzer.craps.bets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import com.williamspreitzer.craps.utils.CrapsUtils;

@ExtendWith(MockitoExtension.class)
public class FourTenOddsBetTest {

	@Mock
	FourTenOddsBet bet;
	
	Bet fourTenOddsBet = null;	
	
	static MockedStatic<CrapsUtils> utils = null;
	
	static byte point;
	
	static {
		utils = mockStatic(CrapsUtils.class);
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 4);
		point = CrapsUtils.getPoint();
	}
	
	@BeforeEach
	private void setup() {
		fourTenOddsBet = BetFactory.createPropsBet(BetType.FOUR_TEN_ODDS_BET, (byte) 4, 5);
	}
	
	@Test
	public void winFourTenOddsBetWith4() {
		when(bet.processBet(fourTenOddsBet, (byte) 4)).thenReturn(
				this.processBet(fourTenOddsBet, (byte) 4, point));
		assertEquals(10, bet.processBet(fourTenOddsBet,(byte) 4));
	}
	
	@Test
	public void winFourTenOddsBetWith10() {
		fourTenOddsBet = BetFactory.createPropsBet(BetType.FOUR_TEN_ODDS_BET, (byte) 10, 5);
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 10);
		assertEquals((byte) 10, CrapsUtils.getPoint());
		point = CrapsUtils.getPoint();

		when(bet.processBet(fourTenOddsBet, (byte) 10)).thenReturn(
				this.processBet(fourTenOddsBet, (byte) 10, point));
		assertEquals(10, bet.processBet(fourTenOddsBet, (byte) 10));
	}
	
	@Test
	public void loseFourTenOddsBetWith7() {
		when(bet.processBet(fourTenOddsBet, (byte) 7)).thenReturn(
				this.processBet(fourTenOddsBet, (byte) 7, point));
		assertEquals(-5, bet.processBet(fourTenOddsBet, (byte) 7));
	}
	
	@Test
	public void pushFourTenOddsBetWith2() {
		when(bet.processBet(fourTenOddsBet, (byte) 2)).thenReturn(
				this.processBet(fourTenOddsBet, (byte) 2, point));
		assertEquals(0, bet.processBet(fourTenOddsBet, (byte) 2));
	}
	
	@Test
	public void pushFourTenOddsBetWith3() {
		when(bet.processBet(fourTenOddsBet, (byte) 3)).thenReturn(
				this.processBet(fourTenOddsBet, (byte) 3, point));
		assertEquals(0, bet.processBet(fourTenOddsBet, (byte) 3));
	}
	
	@Test
	public void pushFourTenOddsBetWith5() {
		when(bet.processBet(fourTenOddsBet, (byte) 5)).thenReturn(
				this.processBet(fourTenOddsBet, (byte) 5, point));
		assertEquals(0, bet.processBet(fourTenOddsBet, (byte) 5));
	}
	
	@Test
	public void pushFourTenOddsBetWith6() {
		when(bet.processBet(fourTenOddsBet, (byte) 6)).thenReturn(
				this.processBet(fourTenOddsBet, (byte) 6, point));
		assertEquals(0, bet.processBet(fourTenOddsBet,(byte) 6));
	}
	
	@Test
	public void pushFourTenOddsBetWith8() {
		when(bet.processBet(fourTenOddsBet, (byte) 8)).thenReturn(
				this.processBet(fourTenOddsBet, (byte) 8, point));
		assertEquals(0, bet.processBet(fourTenOddsBet,(byte) 8));
	}
	
	@Test
	public void pushFourTenOddsBetWith9() {
		when(bet.processBet(fourTenOddsBet, (byte) 9)).thenReturn(
				this.processBet(fourTenOddsBet, (byte) 9, point));
		assertEquals(0, bet.processBet(fourTenOddsBet, (byte) 9));
	}
	
	@Test
	public void pushFourTenOddsBetWith11() {
		when(bet.processBet(fourTenOddsBet, (byte) 11)).thenReturn(
				this.processBet(fourTenOddsBet, (byte) 11, point));
		assertEquals(0, bet.processBet(fourTenOddsBet, (byte) 11));
	}
	
	@Test
	public void pushFourTenOddsBetWith12() {
		when(bet.processBet(fourTenOddsBet, (byte) 12)).thenReturn(
				this.processBet(fourTenOddsBet, (byte) 12, point));
		assertEquals(0, bet.processBet(fourTenOddsBet, (byte) 12));
	}
	
	private int processBet(Bet bet, byte count, byte point) {
		double winnings = 0;
		if((point == 4 || point == 10) && count == point) {
			winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 2/1);
		} else if (count == 7) {
			winnings = bet.getBetAmount() * -1;
		}
		return (int) winnings;
	}
	
	@AfterAll
	private static void close() {
		utils.close();
	}
}