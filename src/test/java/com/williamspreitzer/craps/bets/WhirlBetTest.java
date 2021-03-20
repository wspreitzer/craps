package com.williamspreitzer.craps.bets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyByte;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WhirlBetTest {

	@Mock
	Bet bet;

	@Mock
	PropositionOddsBet betMock;
	
	Bet whirlBet = null;

	@BeforeEach
	private void setup() {
		when(betMock.getSingleUnit(anyInt(), anyByte())).thenReturn(1);
		whirlBet = BetFactory.createPropsBet(BetType.WHIRL_BET, 5);
	}

	@Test
	public void winWhirlBetWith2() {
		int unit = betMock.getSingleUnit(5, (byte) 5);
		when(bet.processBet(whirlBet, (byte) 2))
				.thenReturn(this.processBet(whirlBet, (byte) 2, unit));
		assertEquals(26, bet.processBet(whirlBet, (byte) 2));
	}

	@Test
	public void winWhirlBetWith3() {
		int unit = betMock.getSingleUnit(5, (byte) 5);
		when(bet.processBet(whirlBet, (byte) 3))
				.thenReturn(this.processBet(whirlBet, (byte) 3, unit));
		assertEquals(11, bet.processBet(whirlBet, (byte) 3));
	}

	@Test
	public void winWhirlBetWith7() {
		int unit = betMock.getSingleUnit(5, (byte) 5);
		when(bet.processBet(whirlBet, (byte) 7))
				.thenReturn(this.processBet(whirlBet, (byte) 7, unit));
		assertEquals(0, bet.processBet(whirlBet, (byte) 7));
	}

	@Test
	public void winWhirlBetWith11() {
		int unit = betMock.getSingleUnit(5, (byte) 5);
		when(bet.processBet(whirlBet, (byte) 11))
				.thenReturn(this.processBet(whirlBet, (byte) 11, unit));
		assertEquals(11, bet.processBet(whirlBet, (byte) 11));
	}

	@Test
	public void winWhirlBetWith12() {
		int unit = betMock.getSingleUnit(5, (byte) 5);
		when(bet.processBet(whirlBet, (byte) 12))
				.thenReturn(this.processBet(whirlBet, (byte) 12, unit));
		assertEquals(26, bet.processBet(whirlBet, (byte) 12));
	}

	@Test
	public void loseWhirlBetWith4() {
		int unit = betMock.getSingleUnit(5, (byte) 5);
		when(bet.processBet(whirlBet, (byte) 4))
				.thenReturn(this.processBet(whirlBet, (byte) 4, unit));
		assertEquals(-5, bet.processBet(whirlBet, (byte) 4));
	}

	@Test
	public void loseWhirlBetWith5() {
		int unit = betMock.getSingleUnit(5, (byte) 5);
		when(bet.processBet(whirlBet, (byte) 5))
				.thenReturn(this.processBet(whirlBet, (byte) 5, unit));
		assertEquals(-5, bet.processBet(whirlBet, (byte) 5));
	}

	@Test
	public void loseWhirlBetWith6() {
		int unit = betMock.getSingleUnit(5, (byte) 5);
		when(bet.processBet(whirlBet, (byte) 6))
				.thenReturn(this.processBet(whirlBet, (byte) 6, unit));
		assertEquals(-5, bet.processBet(whirlBet, (byte) 6));
	}

	@Test
	public void loseWhirlBetWith8() {
		int unit = betMock.getSingleUnit(5, (byte) 5);
		when(bet.processBet(whirlBet, (byte) 8))
				.thenReturn(this.processBet(whirlBet, (byte) 8, unit));
		assertEquals(-5, bet.processBet(whirlBet, (byte) 8));
	}

	@Test
	public void loseWhirlBetWith9() {
		int unit = betMock.getSingleUnit(5, (byte) 5);
		when(bet.processBet(whirlBet, (byte) 9))
				.thenReturn(this.processBet(whirlBet, (byte) 9, unit));
		assertEquals(-5, bet.processBet(whirlBet, (byte) 9));
	}

	@Test
	public void loseWhirlBetWith10() {
		int unit = betMock.getSingleUnit(5, (byte) 5);
		when(bet.processBet(whirlBet, (byte) 10))
				.thenReturn(this.processBet(whirlBet, (byte) 10, unit));
		assertEquals(-5, bet.processBet(whirlBet, (byte) 10));
	}

	private int processBet(Bet bet, byte count, int unit) {
		double winnings = 0;

		switch (count) {
		case 2:
		case 12:
			winnings = OddsBet.calculator.calculate(unit, (double) 30 / 1) - (unit * 4);
			break;
		case 3:
		case 11:
			winnings = OddsBet.calculator.calculate(unit, (double) 15 / 1) - (unit * 4);
			break;
		case 7:
			winnings = OddsBet.calculator.calculate(unit, (double) 4 / 1) - (unit * 4);
			break;
		default:
			winnings = bet.getBetAmount() * -1;
			break;
		}
		return (int) winnings;
	}
}