package com.williamspreitzer.craps.bets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import com.williamspreitzer.craps.utils.CrapsUtils;

@ExtendWith(MockitoExtension.class)
public class FireBetTest {

	@Mock
	FireBet bet;

	Bet fireBet = null;

	Set<Byte> pointsMade = null;

	static MockedStatic<CrapsUtils> utils = null;

	static byte point;

	static {
		utils = mockStatic(CrapsUtils.class);
		utils.when(CrapsUtils::getPoint).thenReturn((byte) 6);
		point = CrapsUtils.getPoint();
	}

	@BeforeEach
	private void setup() {
		fireBet = (FireBet) BetFactory.createPropsBet(BetType.FIRE_BET, 5);
	}

	@Test
	public void addPointMadeTest() {
		pointsMade = new HashSet<Byte>();
		when(bet.processBet(fireBet, (byte) 6)).thenReturn(this.processBet(fireBet, (byte) 6));
		assertEquals(0, bet.processBet(fireBet, (byte) 6));
		assertEquals(1, pointsMade.size());
	}

	@Test
	public void addDuplicatePointMadeTest() {
		when(bet.getPointsMade()).thenReturn(new HashSet<Byte>() {
			private static final long serialVersionUID = -6040690862442215945L;
			{
				add((byte) 6);
			}
		});
		pointsMade = bet.getPointsMade();
		when(bet.processBet(fireBet, (byte) 6)).thenReturn(this.processBet(fireBet, (byte) 6));
		assertEquals(0, bet.processBet(fireBet, (byte) 6));
		assertEquals(1, pointsMade.size());
	}

	@Test
	public void loseFireBetWithNoPointsMade() {
		pointsMade = new HashSet<Byte>();
		when(bet.processBet(fireBet, (byte) 7)).thenReturn(this.processBet(fireBet, (byte) 7));
		assertEquals(-5, bet.processBet(fireBet, (byte) 7));
	}

	@Test
	public void loseFireBetWithOnePointsMade() {
		when(bet.getPointsMade()).thenReturn(new HashSet<Byte>() {
			private static final long serialVersionUID = -6040690862442215945L;
			{
				add((byte) 4);
			}
		});
		pointsMade = bet.getPointsMade();
		when(bet.processBet(fireBet, (byte) 7)).thenReturn(this.processBet(fireBet, (byte) 7));
		assertEquals(-5, bet.processBet(fireBet, (byte) 7));
	}

	@Test
	public void loseFireBetWithTwoPointsMade() {
		when(bet.getPointsMade()).thenReturn(new HashSet<Byte>() {
			private static final long serialVersionUID = 754219039476879421L;
			{
				add((byte) 4);
				add((byte) 5);
			}
		});
		pointsMade = bet.getPointsMade();
		when(bet.processBet(fireBet, (byte) 7)).thenReturn(this.processBet(fireBet, (byte) 7));
		assertEquals(-5, bet.processBet(fireBet, (byte) 7));
	}

	@Test
	public void loseFireBetWithThreePointsMade() {
		when(bet.getPointsMade()).thenReturn(new HashSet<Byte>() {
			private static final long serialVersionUID = 754219039476879421L;
			{
				add((byte) 4);
				add((byte) 5);
				add((byte) 6);
			}
		});
		pointsMade = bet.getPointsMade();
		when(bet.processBet(fireBet, (byte) 7)).thenReturn(this.processBet(fireBet, (byte) 7));
		assertEquals(-5, bet.processBet(fireBet, (byte) 7));
	}

	@Test
	public void winFireBetWithFourPointsMade() {
		when(bet.getPointsMade()).thenReturn(new HashSet<Byte>() {
			private static final long serialVersionUID = -6040690862442215945L;
			{
				add((byte) 4);
				add((byte) 5);
				add((byte) 6);
				add((byte) 8);
			}
		});
		pointsMade = bet.getPointsMade();
		when(bet.processBet(fireBet, (byte) 7)).thenReturn(this.processBet(fireBet, (byte) 7));
		assertEquals(120, bet.processBet(fireBet, (byte) 7));
	}

	@Test
	public void winFireBetWithFivePointsMade() {
		when(bet.getPointsMade()).thenReturn(new HashSet<Byte>() {
			private static final long serialVersionUID = 754219039476879421L;
			{
				add((byte) 4);
				add((byte) 5);
				add((byte) 6);
				add((byte) 8);
				add((byte) 9);
			}
		});
		pointsMade = bet.getPointsMade();
		when(bet.processBet(fireBet, (byte) 7)).thenReturn(this.processBet(fireBet, (byte) 7));
		assertEquals(1245, bet.processBet(fireBet, (byte) 7));
	}

	@Test
	public void winFireBetWithSixPointsMade() {
		when(bet.getPointsMade()).thenReturn(new HashSet<Byte>() {
			private static final long serialVersionUID = 3368224143039402269L;
			{
				add((byte) 4);
				add((byte) 5);
				add((byte) 6);
				add((byte) 8);
				add((byte) 9);
				add((byte) 10);
			}
		});
		pointsMade = bet.getPointsMade();
		when(bet.processBet(fireBet, (byte) 7)).thenReturn(this.processBet(fireBet, (byte) 7));
		assertEquals(4995, bet.processBet(fireBet, (byte) 7));
	}

	private int processBet(Bet bet, byte count) {
		double winnings = 0;
		if (count == 7) {
			switch (pointsMade.size()) {
			case 0:
			case 1:
			case 2:
			case 3:
				winnings = bet.getBetAmount() * -1;
				break;
			case 4:
				winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 24 / 1);
				break;
			case 5:
				winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 249 / 1);
				break;
			case 6:
				winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 999 / 1);
				break;
			}
		} else {
			if (count == point) {
				pointsMade.add(count);
			}
		}
		return (int) winnings;
	}

	@AfterAll
	public static void close() {
		utils.close();
	}

}