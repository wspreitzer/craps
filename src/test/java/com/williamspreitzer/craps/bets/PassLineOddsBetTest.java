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
public class PassLineOddsBetTest {

	@Mock
	PassLineOddsBet bet;

	NonPropositionOddsBet oddsBet = null;

	static MockedStatic<CrapsUtils> utils = null;

	static byte point;

	byte number;

	static {
		utils = mockStatic(CrapsUtils.class);
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 0);
		point = CrapsUtils.getPoint();
	}

	@BeforeEach
	private void setup() {
		when(bet.getOddsBet())
				.thenReturn((FourTenOddsBet) BetFactory.createPropsBet(BetType.FOUR_TEN_ODDS_BET, (byte) 4, 20));
		oddsBet = bet.getOddsBet();
	}

	@Test
	public void winPassLineOddsBetWithPointOf4() {
		number = oddsBet.number;
		when(bet.processBet(oddsBet, (byte) 4)).thenReturn(this.processBet(oddsBet, (byte) 4));
		assertEquals(40, bet.processBet(oddsBet, (byte) 4));
	}

	@Test
	public void winPassLineOddsBetWithPointOf10() {
		when(bet.getOddsBet())
				.thenReturn((FourTenOddsBet) BetFactory.createPropsBet(BetType.FOUR_TEN_ODDS_BET, (byte) 10, 20));
		oddsBet = bet.getOddsBet();
		number = oddsBet.number;
		when(bet.processBet(oddsBet, (byte) 10)).thenReturn(this.processBet(oddsBet, (byte) 10));
		assertEquals(40, bet.processBet(oddsBet, (byte) 10));
	}

	@Test
	public void winPassLineOddsBetWithPointOf5() {
		when(bet.getOddsBet())
				.thenReturn((FiveNineOddsBet) BetFactory.createPropsBet(BetType.FIVE_NINE_ODDS_BET, (byte) 5, 10));
		oddsBet = bet.getOddsBet();
		number = oddsBet.number;
		when(bet.processBet(oddsBet, (byte) 5)).thenReturn(this.processBet(oddsBet, (byte) 5));
		assertEquals(15, bet.processBet(oddsBet, (byte) 5));
	}

	@Test
	public void winPassLineOddsBetWithPointOf9() {
		when(bet.getOddsBet())
				.thenReturn((FiveNineOddsBet) BetFactory.createPropsBet(BetType.FIVE_NINE_ODDS_BET, (byte) 9, 10));
		oddsBet = bet.getOddsBet();
		number = oddsBet.number;
		when(bet.processBet(oddsBet, (byte) 9)).thenReturn(this.processBet(oddsBet, (byte) 9));
		assertEquals(15, bet.processBet(oddsBet, (byte) 9));
	}

	@Test
	public void winPassLineOddsBetWithPointOf6() {
		when(bet.getOddsBet())
				.thenReturn((SixEightOddsBet) BetFactory.createPropsBet(BetType.SIX_EIGHT_ODDS_BET, (byte) 6, 30));
		oddsBet = bet.getOddsBet();
		number = oddsBet.number;
		when(bet.processBet(oddsBet, (byte) 6)).thenReturn(this.processBet(oddsBet, (byte) 6));
		assertEquals(36, bet.processBet(oddsBet, (byte) 6));
	}

	@Test
	public void losePassLineOddsBetWith7AndPointOf4() {
		when(bet.processBet(oddsBet, (byte) 7)).thenReturn(this.processBet(oddsBet, (byte) 7));
		assertEquals(-20, bet.processBet(oddsBet, (byte) 7));
	}

	@Test
	public void pushPassLineOddsBetWith2() {
		when(bet.processBet(oddsBet, (byte) 2)).thenReturn(this.processBet(oddsBet, (byte) 2));
		assertEquals(0, bet.processBet(oddsBet, (byte) 2));
	}
	
	@Test
	public void pushPassLineOddsBetWith3() {
		when(bet.processBet(oddsBet, (byte) 3)).thenReturn(this.processBet(oddsBet, (byte) 3));
		assertEquals(0, bet.processBet(oddsBet, (byte) 3));
	}

	@Test
	public void pushPassLineOddsBetWith11() {
		when(bet.processBet(oddsBet, (byte) 11)).thenReturn(this.processBet(oddsBet, (byte) 11));
		assertEquals(0, bet.processBet(oddsBet, (byte) 11));
	}

	@Test
	public void pushPassLineOddsBetWith12() {
		when(bet.processBet(oddsBet, (byte) 12)).thenReturn(this.processBet(oddsBet, (byte) 12));
		assertEquals(0, bet.processBet(oddsBet, (byte) 12));
	}

	private int processBet(Bet bet, byte count) {
		double winnings = 0;
		switch(count) {
		case 4: case 10:
			if(count == number) {
				winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 2/1);
			}
			break;
		case 5: case 9:
			if(count == number) {
				winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 3/2);
			}
			break;
		case 6: case 8:
			if(count == number) {
				winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 6/5);
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
	
	@AfterAll
	private static void close() {
		utils.close();
	}
}