package com.williamspreitzer.craps.bets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.williamspreitzer.craps.utils.CrapsUtils;

@ExtendWith(MockitoExtension.class)
public class ComeOddsBetTest {
	
	@Mock
	ComeOddsBet bet;
	
	NonPropositionOddsBet oddsBet;
	
	byte number;

	@BeforeEach
	private void setup() {
		when(bet.getOddsBet()).thenReturn((FourTenOddsBet) BetFactory.createPropsBet(BetType.FOUR_TEN_ODDS_BET, (byte) 4, 5));
		oddsBet = bet.getOddsBet();
		number = oddsBet.number;
	}
	
	@Test
	public void winComeOddsBetWith4() {
		assertEquals(10, CrapsUtils.TABLE_MINIMUM);
		when(bet.processBet(oddsBet, (byte) 4)).thenReturn(this.processBet(oddsBet, (byte) 4));
		assertEquals(10, bet.processBet(oddsBet, (byte) 4));
	}
	
	@Test
	public void winComeOddsBetWith10() {
		when(bet.getOddsBet()).thenReturn((FourTenOddsBet) BetFactory.createPropsBet(BetType.FOUR_TEN_ODDS_BET, (byte) 10, 5));
		oddsBet = bet.getOddsBet();
		number = oddsBet.number;
		when(bet.processBet(oddsBet, (byte) 10)).thenReturn(this.processBet(oddsBet, (byte) 10));
		assertEquals(10, bet.processBet(oddsBet, (byte) 10));
	}
	
	@Test
	public void winComeOddsBetWith5() {
		when(bet.getOddsBet()).thenReturn((FiveNineOddsBet) BetFactory.createPropsBet(BetType.FIVE_NINE_ODDS_BET, (byte) 5, 6));
		oddsBet = bet.getOddsBet();
		number = oddsBet.number;
		when(bet.processBet(oddsBet, (byte) 5)).thenReturn(this.processBet(oddsBet, (byte) 5));
		assertEquals(9, bet.processBet(oddsBet, (byte) 5));
	}
	
	@Test
	public void winComeOddsBetWith9() {
		when(bet.getOddsBet()).thenReturn((FiveNineOddsBet) BetFactory.createPropsBet(BetType.FIVE_NINE_ODDS_BET, (byte) 9, 6));
		oddsBet = bet.getOddsBet();
		number = oddsBet.number;
		when(bet.processBet(oddsBet, (byte) 9)).thenReturn(this.processBet(oddsBet, (byte) 9));
		assertEquals(9, bet.processBet(oddsBet, (byte) 9));	
	}
	
	@Test
	public void winComeOddsBetWith6() {
		when(bet.getOddsBet()).thenReturn((SixEightOddsBet) BetFactory.createPropsBet(BetType.SIX_EIGHT_ODDS_BET, (byte) 6, 5));
		oddsBet = bet.getOddsBet();
		number = oddsBet.number;
		when(bet.processBet(oddsBet, (byte) 6)).thenReturn(this.processBet(oddsBet, (byte) 6));
		assertEquals(6, bet.processBet(oddsBet, (byte) 6));
	}
	
	@Test
	public void winComeOddsBetWith8() {
		when(bet.getOddsBet()).thenReturn((SixEightOddsBet) BetFactory.createPropsBet(BetType.SIX_EIGHT_ODDS_BET, (byte) 8, 5));
		oddsBet = bet.getOddsBet();
		number = oddsBet.number;
		when(bet.processBet(oddsBet, (byte) 8)).thenReturn(this.processBet(oddsBet, (byte) 8));
		assertEquals(6, bet.processBet(oddsBet, (byte) 8));
	}
	
	@Test
	public void loseComeOddsBetWith7() {
		when(bet.processBet(oddsBet, (byte) 7)).thenReturn(this.processBet(oddsBet, (byte) 7));
		assertEquals(-5, bet.processBet(oddsBet, (byte) 7));
	}
	
	@Test 
	public void pushComeOddsBetWith2() {
		when(bet.processBet(oddsBet, (byte) 2)).thenReturn(this.processBet(oddsBet, (byte) 2));
		assertEquals(0, bet.processBet(oddsBet, (byte) 2));
	}
	
	@Test
	public void pushComeOddsBetWith3() {
		when(bet.processBet(oddsBet, (byte) 3)).thenReturn(this.processBet(oddsBet, (byte) 3));
		assertEquals(0, bet.processBet(oddsBet, (byte) 3));
	}
	
	@Test
	public void pushComeOddsBetWith11() {
		when(bet.processBet(oddsBet, (byte) 11)).thenReturn(this.processBet(oddsBet, (byte) 11));
		assertEquals(0, bet.processBet(oddsBet, (byte) 11));
	}
	
	@Test
	public void pushComeOddsBetWith12() {
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
}