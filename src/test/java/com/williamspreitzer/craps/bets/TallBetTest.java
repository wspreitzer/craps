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
public class TallBetTest {
	
	@Mock
	TallBet bet;
	
	private List<Byte> rolls;
	
	private Set<Byte> tallNumbers;
	
	Bet tallBet = null;
	
	@BeforeEach
	private void setup() {
		tallBet = BetFactory.createPropsBet(BetType.TALL_BET, 100);
		tallNumbers = new HashSet<Byte>();
		tallNumbers.add((byte) 8);
		tallNumbers.add((byte) 9);
		tallNumbers.add((byte) 10);
		tallNumbers.add((byte) 11);
		tallNumbers.add((byte) 12);
	}
	
	@Test
	public void tallBetWinTest() {
		when(bet.getRollTracker()).thenReturn(new ArrayList<Byte>() {
			private static final long serialVersionUID = 2836599310661169931L;
			{
				add((byte) 9);
				add((byte) 10);
				add((byte) 11);
				add((byte) 12);
			}
		});
		rolls = bet.getRollTracker();
		when(bet
				.processBet(tallBet, (byte) 8))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.TALL_BET, 100), (byte) 8));
		assertEquals(3400, bet.processBet(tallBet, (byte) 8));
	}

	@Test
	public void tallBetLoseTest() {
		when(bet.getRollTracker()).thenReturn(new ArrayList<Byte>() {
			private static final long serialVersionUID = 2836599310661169931L;
			{
				add((byte) 9);
				add((byte) 10);
				add((byte) 11);
				add((byte) 12);
			}
		});
		rolls = bet.getRollTracker();
		when(bet.processBet(tallBet, (byte) 7))
			.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.TALL_BET, 100), (byte) 7));
		assertEquals(-100, bet.processBet(tallBet, (byte) 7));
	}
	
	private int processBet(Bet bet, byte count) {
		double winnings = 0;
		if (count == 7) {
			winnings = bet.getBetAmount() * -1;
		} else if(tallNumbers.contains(count)) {
			rolls.add((byte) count);
			Set<Byte> difference = new HashSet<Byte>(tallNumbers);
			difference.removeAll(rolls);
			if (difference.size() == 0) {
				winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 34 / 1);
			}
		}
		return (int) winnings;
	}
}