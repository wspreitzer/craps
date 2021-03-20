package com.williamspreitzer.craps.bets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AllTallSmallBetTest {

	@Mock
	private Bet bet;

	Bet smallBet = null;
	Bet tallBet = null;
	Bet allBet = null;
	
	private List<Byte> rolls;
	private Set<Byte> allNumbers;
	private Set<Byte> tallNumbers;
	private Set<Byte> smallNumbers;

	@BeforeEach
	private void setup() {

		smallBet = BetFactory.createPropsBet(BetType.SMALL_BET, 100);
		tallBet = BetFactory.createPropsBet(BetType.TALL_BET, 100);
		allBet = BetFactory.createPropsBet(BetType.ALL_BET, 100);
		this.rolls = new ArrayList<Byte>();
		rolls.add((byte) 2);
		rolls.add((byte) 3);
		rolls.add((byte) 4);
		rolls.add((byte) 5);
		rolls.add((byte) 9);
		rolls.add((byte) 10);
		rolls.add((byte) 11);
		rolls.add((byte) 12);

		smallNumbers = new HashSet<Byte>();
		tallNumbers = new HashSet<Byte>();
		smallNumbers.add((byte) 2);
		smallNumbers.add((byte) 3);
		smallNumbers.add((byte) 4);
		smallNumbers.add((byte) 5);
		smallNumbers.add((byte) 6);
		tallNumbers.add((byte) 8);
		tallNumbers.add((byte) 9);
		tallNumbers.add((byte) 10);
		tallNumbers.add((byte) 11);
		tallNumbers.add((byte) 12);
		allNumbers = new HashSet<Byte>(smallNumbers);
		allNumbers.addAll(tallNumbers);
		allNumbers.add((byte) 6);
		allNumbers.add((byte) 8);
	}

	@Test
	public void mockNotNullsTest() {
		assertNotNull(bet);
	}

	@Test
	public void smallBetTestWin() {
		rolls.add((byte) 6);
		when(bet.processBet(smallBet, (byte) 6))
				.thenReturn(this.processSmallBet(BetFactory.createPropsBet(BetType.SMALL_BET, 100), (byte) 6));
		assertEquals(3400, bet.processBet(smallBet, (byte) 6));
	}

	@Test
	public void smallBetLose() {
		when(bet.processBet(smallBet, (byte) 7))
				.thenReturn(this.processSmallBet(BetFactory.createPropsBet(BetType.SMALL_BET, 100), (byte) 7));
		assertEquals(-100, bet.processBet(smallBet, (byte) 7));
	}

	@Test
	public void smallBetNoWinNoLose() {
		when(bet.processBet(smallBet, (byte) 3))
				.thenReturn(this.processSmallBet(BetFactory.createPropsBet(BetType.SMALL_BET, 100), (byte) 3));
		assertEquals(0, bet.processBet(smallBet, (byte) 3));
	}

	@Test
	public void tallBetWinTest() {
		rolls.add((byte) 8);
		when(bet
				.processBet(tallBet, (byte) 8))
				.thenReturn(this.processTallBet(BetFactory.createPropsBet(BetType.TALL_BET, 100), (byte) 8));
		assertEquals(3400, bet.processBet(tallBet, (byte) 8));
	}

	@Test
	public void tallBetLoseTest() {
		when(bet.processBet(tallBet, (byte) 7))
			.thenReturn(this.processTallBet(BetFactory.createPropsBet(BetType.TALL_BET, 100), (byte) 7));
		assertEquals(-100, bet.processBet(tallBet, (byte) 7));
	}
	
	@Test
	public void tallBetNoWinNoLose() {
		when(bet
				.processBet(tallBet, (byte) 3))
				.thenReturn(this.processAllBet(BetFactory.createPropsBet(BetType.TALL_BET, 100), (byte) 3));
		assertEquals(0, bet.processBet(tallBet, (byte) 3));
	}

	@Test
	public void allBetWinTest() {
		rolls.add((byte) 8);
		rolls.add((byte) 6);
		when(bet
				.processBet(allBet, (byte) 8))
				.thenReturn(this.processAllBet(BetFactory.createPropsBet(BetType.TALL_BET, 100), (byte) 8));
		assertEquals(17400, bet.processBet(allBet, (byte) 8));
	}

	@Test
	public void allBetLoseTest() {
		when(bet.processBet(allBet, (byte) 7))
			.thenReturn(this.processTallBet(BetFactory.createPropsBet(BetType.TALL_BET, 100), (byte) 7));
		assertEquals(-100, bet.processBet(allBet, (byte) 7));
	}
	
	@Test
	public void allBetNoWinNoLose() {
		when(bet
				.processBet(allBet, (byte) 3))
				.thenReturn(this.processAllBet(BetFactory.createPropsBet(BetType.TALL_BET, 100), (byte) 3));
		assertEquals(0, bet.processBet(allBet, (byte) 3));
	}
	
	private int processSmallBet(Bet bet, byte count) {
		double winnings = 0;
		if (count == 7) {
			winnings = bet.getBetAmount() * -1;
		} else {
			Set<Byte> difference = new HashSet<Byte>(smallNumbers);
			difference.removeAll(rolls);
			if (difference.size() == 0) {
				winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 34 / 1);
			}
		}
		return (int) winnings;
	}

	private int processTallBet(Bet bet, byte count) {
		double winnings = 0;
		if (count == 7) {
			winnings = bet.getBetAmount() * -1;
		} else {
			Set<Byte> difference = new HashSet<Byte>(tallNumbers);
			difference.removeAll(rolls);
			if (difference.size() == 0) {
				winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 34 / 1);
			}
		}
		return (int) winnings;
	}
	
	private int processAllBet(Bet bet, byte count) {
		double winnings = 0;
		if (count == 7) {
			winnings = bet.getBetAmount() * -1;
		} else {
			Set<Byte> difference = new HashSet<Byte>(allNumbers);
			difference.removeAll(rolls);
			if (difference.size() == 0) {
				winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 174 / 1);
			}
		}
		return (int) winnings;
	}
}





