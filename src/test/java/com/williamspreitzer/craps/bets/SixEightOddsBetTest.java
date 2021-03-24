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
public class SixEightOddsBetTest {

	@Mock
	SixEightOddsBet bet;

	Bet sixEightOddsBet = null;
	
	static MockedStatic<CrapsUtils> utils = null;

	static byte point;

	static {
		utils = mockStatic(CrapsUtils.class);
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 6);
		point = CrapsUtils.getPoint();
	}

	@BeforeEach
	private void setup() {
		sixEightOddsBet = BetFactory.createPropsBet(BetType.SIX_EIGHT_ODDS_BET, (byte) 6, 5);
	}

	@Test
	public void winSixEightOddsBetWith6() {
		when(bet.processBet(sixEightOddsBet, (byte) 6)).thenReturn(
				this.processBet(sixEightOddsBet, (byte) 6, point));
		assertEquals(6, bet.processBet(sixEightOddsBet,(byte) 6));
	}

	@Test
	public void winSixEightOddsBetWith8() {
		sixEightOddsBet = BetFactory.createPropsBet(BetType.SIX_EIGHT_ODDS_BET, (byte) 8, 5);
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 8);
		assertEquals((byte) 8, CrapsUtils.getPoint());
		point = CrapsUtils.getPoint();

		when(bet.processBet(sixEightOddsBet, (byte) 8)).thenReturn(
				this.processBet(sixEightOddsBet, (byte) 8, point));
		assertEquals(6, bet.processBet(sixEightOddsBet, (byte) 8));
	}

	@Test
	public void loseSixEightOddsBetWith7() {
		when(bet.processBet(sixEightOddsBet, (byte) 7)).thenReturn(
				this.processBet(sixEightOddsBet, (byte) 7, point));
		assertEquals(-5, bet.processBet(sixEightOddsBet, (byte) 7));
	}

	@Test
	public void pushSixEightOddsBetWith2() {
		when(bet.processBet(sixEightOddsBet, (byte) 2)).thenReturn(
				this.processBet(sixEightOddsBet, (byte) 2, point));
		assertEquals(0, bet.processBet(sixEightOddsBet, (byte) 2));
	}

	@Test
	public void pushSixEightOddsBetWith3() {
		when(bet.processBet(sixEightOddsBet, (byte) 3)).thenReturn(
				this.processBet(sixEightOddsBet, (byte) 3, point));
		assertEquals(0, bet.processBet(sixEightOddsBet, (byte) 3));
	}

	@Test
	public void pushSixEightOddsBetWith4() {
		when(bet.processBet(sixEightOddsBet, (byte) 4)).thenReturn(
				this.processBet(sixEightOddsBet, (byte) 4, point));
		assertEquals(0, bet.processBet(sixEightOddsBet, (byte) 4));
	}

	@Test
	public void pushSixEightOddsBetWith5() {
		when(bet.processBet(sixEightOddsBet, (byte) 5)).thenReturn(
				this.processBet(sixEightOddsBet, (byte) 5, point));
		assertEquals(0, bet.processBet(sixEightOddsBet, (byte) 5));
	}

	@Test
	public void pushSixEightOddsBetWith9() {
		when(bet.processBet(sixEightOddsBet, (byte) 9)).thenReturn(
				this.processBet(sixEightOddsBet, (byte) 9, point));
		assertEquals(0, bet.processBet(sixEightOddsBet, (byte) 9));
	}

	@Test
	public void pushSixEightOddsBetWith10() {
		when(bet.processBet(sixEightOddsBet, (byte) 10)).thenReturn(
				this.processBet(sixEightOddsBet, (byte) 10, point));
		assertEquals(0, bet.processBet(sixEightOddsBet, (byte) 10));
	}

	@Test
	public void pushSixEightOddsBetWith11() {
		when(bet.processBet(sixEightOddsBet, (byte) 11)).thenReturn(
				this.processBet(sixEightOddsBet, (byte) 11, point));
		assertEquals(0, bet.processBet(sixEightOddsBet, (byte) 11));
	}

	@Test
	public void pushSixEightOddsBetWith12() {
		when(bet.processBet(sixEightOddsBet, (byte) 12)).thenReturn(
				this.processBet(sixEightOddsBet, (byte) 12, point));
		assertEquals(0, bet.processBet(sixEightOddsBet, (byte) 12));
	}

	private int processBet(Bet bet, byte count, byte point) {
		double winnings = 0;
		if ((point == 6 || point == 8) && count == point) {
			winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 6 / 5);
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