package com.williamspreitzer.craps.bets;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
public class SmallBetTest {

	@Mock
	SmallBet bet;

	private List<Byte> rolls;

	private Set<Byte> smallNumbers;

	Bet smallBet = null;

	@BeforeEach
	private void setup() {
		smallBet = BetFactory.createPropsBet(BetType.SMALL_BET, 100);
		smallNumbers = new HashSet<Byte>();
		smallNumbers.add((byte) 2);
		smallNumbers.add((byte) 3);
		smallNumbers.add((byte) 4);
		smallNumbers.add((byte) 5);
		smallNumbers.add((byte) 6);
	}

	@Test
	public void smallBetTestWin() {
		when(bet.getRollTracker()).thenReturn(new ArrayList<Byte>() {
			private static final long serialVersionUID = -5394842091702529791L;
			{
				add((byte) 2);
				add((byte) 3);
				add((byte) 4);
				add((byte) 5);
			}
		});
		rolls = bet.getRollTracker();
		when(bet.processBet(smallBet, (byte) 6))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.SMALL_BET, 100), (byte) 6));
		assertEquals(3400, bet.processBet(smallBet, (byte) 6));
	}

	@Test
	public void smallBetLose() {
		when(bet.getRollTracker()).thenReturn(new ArrayList<Byte>() {
		
			private static final long serialVersionUID = -618124376793148335L;
		{
			add((byte) 2);
			add((byte) 3);
			add((byte) 4);
			add((byte) 5);
			
		}});
		
		rolls = bet.getRollTracker();
		when(bet.processBet(smallBet, (byte) 7))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.SMALL_BET, 100), (byte) 7));
		assertEquals(-100, bet.processBet(smallBet, (byte) 7));
	}

	@Test
	public void smallBetFirstRollAdded() {
		when(bet.getRollTracker()).thenReturn(new ArrayList<Byte> ());
		rolls = bet.getRollTracker();
		when(bet.processBet(smallBet, (byte) 2)).thenReturn(this.processBet(smallBet, (byte) 2));
		assertEquals(0, bet.processBet(smallBet, (byte) 2));
		assertEquals(1, rolls.size());
	}
	
	@Test
	public void smallBetSecondRollAdded() {
		when(bet.getRollTracker()).thenReturn(new ArrayList<Byte>() {
			private static final long serialVersionUID = 5606409774616682020L;
			{
				add((byte) 2);
			}
		});
		rolls = bet.getRollTracker();
		when(bet.processBet(smallBet, (byte) 3))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.SMALL_BET, 100), (byte) 3));
		assertEquals(0, bet.processBet(smallBet, (byte) 3));
		assertEquals(2, rolls.size());
	}

	@Test
	public void smallBetThirdRollAdded() {
		when(bet.getRollTracker()).thenReturn(new ArrayList<Byte>() {
			private static final long serialVersionUID = 5606409774616682020L;
			{
				add((byte) 2);
				add((byte) 3);
			}
		});
		rolls = bet.getRollTracker();
		when(bet.processBet(smallBet, (byte) 4))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.SMALL_BET, 100), (byte) 4));
		assertEquals(0, bet.processBet(smallBet, (byte) 4));
		assertEquals(3, rolls.size());
	}
	
	@Test
	public void smallBetFourthRollAdded() {
		when(bet.getRollTracker()).thenReturn(new ArrayList<Byte>() {
			private static final long serialVersionUID = 5606409774616682020L;
			{
				add((byte) 2);
				add((byte) 3);
				add((byte) 4);
			}
		});
		rolls = bet.getRollTracker();
		when(bet.processBet(smallBet, (byte) 5))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.SMALL_BET, 100), (byte) 5));
		assertEquals(0, bet.processBet(smallBet, (byte) 5));
		assertEquals(4, rolls.size());
	}
	
	private int processBet(Bet bet, byte count) {
		double winnings = 0;
		if (count == 7) {
			winnings = bet.getBetAmount() * -1;
		} else if(smallNumbers.contains(count)) { 
			rolls.add((byte) count);
			Set<Byte> difference = new HashSet<Byte>(smallNumbers);
			difference.removeAll(rolls);
			if (difference.size() == 0) {
				winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 34 / 1);
			}
		}
		return (int) winnings;
	}
}