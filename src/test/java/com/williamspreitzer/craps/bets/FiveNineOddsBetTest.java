package com.williamspreitzer.craps.bets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import com.williamspreitzer.craps.utils.CrapsUtils;

@ExtendWith(MockitoExtension.class)
public class FiveNineOddsBetTest {

	@Mock
	Bet bet;
	
	Bet fiveNineOddsBet = null;	
	
	static MockedStatic<CrapsUtils> utils = null;
	
	static byte point;
	
	static {
		utils = mockStatic(CrapsUtils.class);
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 5);
		point = CrapsUtils.getPoint();
	}
	
	@BeforeEach
	private void setup() {
		fiveNineOddsBet = BetFactory.createPropsBet(BetType.FIVE_NINE_ODDS_BET, (byte) 5, 10);
	}
	
	@Test
	public void winFiveNineOddsBetWith5() {
		when(bet.processBet(fiveNineOddsBet, (byte) 5)).thenReturn(
				this.processBet(fiveNineOddsBet, (byte) 5, point));
		assertEquals(15, bet.processBet(fiveNineOddsBet, (byte) 5));
	}
	
	@Test
	public void winFiveNineOddsBetWith9() {
		fiveNineOddsBet = BetFactory.createPropsBet(BetType.FOUR_TEN_ODDS_BET, (byte) 9, 10);
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 9);
		assertEquals((byte) 9, CrapsUtils.getPoint());
		point = CrapsUtils.getPoint();

		when(bet.processBet(fiveNineOddsBet, (byte) 9)).thenReturn(
				this.processBet(fiveNineOddsBet, (byte) 9, point));
		assertEquals(15, bet.processBet(fiveNineOddsBet, (byte) 9));
	}
	
	@Test
	public void loseFiveNineOddsBetWith7() {
		when(bet.processBet(fiveNineOddsBet, (byte) 7)).thenReturn(
				this.processBet(fiveNineOddsBet, (byte) 7, point));
		assertEquals(-10, bet.processBet(fiveNineOddsBet, (byte) 7));
	}
	
	@Test
	public void pushFiveNineOddsBetWith2() {
		when(bet.processBet(fiveNineOddsBet, (byte) 2)).thenReturn(
				this.processBet(fiveNineOddsBet, (byte) 2, point));
		assertEquals(0, bet.processBet(fiveNineOddsBet, (byte) 2));
	}
	
	@Test
	public void pushFiveNineOddsBetWith3() {
		when(bet.processBet(fiveNineOddsBet, (byte) 3)).thenReturn(
				this.processBet(fiveNineOddsBet, (byte) 3, point));
		assertEquals(0, bet.processBet(fiveNineOddsBet, (byte) 3));
	}
	
	@Test
	public void pushFiveNineOddsBetWith4() {
		when(bet.processBet(fiveNineOddsBet, (byte) 4)).thenReturn(
				this.processBet(fiveNineOddsBet, (byte) 4, point));
		assertEquals(0, bet.processBet(fiveNineOddsBet,(byte) 4));
	}
	
	@Test
	public void pushFiveNineOddsBetWith6() {
		when(bet.processBet(fiveNineOddsBet, (byte) 6)).thenReturn(
				this.processBet(fiveNineOddsBet, (byte) 6, point));
		assertEquals(0, bet.processBet(fiveNineOddsBet,(byte) 6));
	}
	
	@Test
	public void pushFiveNineOddsBetWith8() {
		when(bet.processBet(fiveNineOddsBet, (byte) 8)).thenReturn(
				this.processBet(fiveNineOddsBet, (byte) 8, point));
		assertEquals(0, bet.processBet(fiveNineOddsBet,(byte) 8));
	}
	
	@Test
	public void pushFiveNineOddsBetWith10() {
		when(bet.processBet(fiveNineOddsBet, (byte) 10)).thenReturn(
				this.processBet(fiveNineOddsBet, (byte) 10, point));
		assertEquals(0, bet.processBet(fiveNineOddsBet, (byte) 10));
	}
	
	@Test
	public void pushFiveNineOddsBetWith11() {
		when(bet.processBet(fiveNineOddsBet, (byte) 11)).thenReturn(
				this.processBet(fiveNineOddsBet, (byte) 11, point));
		assertEquals(0, bet.processBet(fiveNineOddsBet, (byte) 11));
	}
	
	@Test
	public void pushFiveNineOddsBetWith12() {
		when(bet.processBet(fiveNineOddsBet, (byte) 12)).thenReturn(
				this.processBet(fiveNineOddsBet, (byte) 12, point));
		assertEquals(0, bet.processBet(fiveNineOddsBet, (byte) 12));
	}
	
	private int processBet(Bet bet, byte count, byte point) {
		double winnings = 0;
		if((point == 5 || point == 9) && count == point) {
			winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 3/2);
		} else if (count == 7) {
			winnings = bet.getBetAmount() * -1;
		}
		return (int) winnings;
	}
}