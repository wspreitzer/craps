package com.williamspreitzer.craps.bets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DontComeBarTweleveOddsBetTest {
	
	@Mock
	DontComeBarTweleveOddsBet bet;
	
	NonPropositionOddsBet oddsBet;
	
	byte number;
	
	@BeforeEach
	private void setup() {
		when(bet.getOddsBet()).thenReturn((FourTenOddsBet) BetFactory.createPropsBet(BetType.FOUR_TEN_ODDS_BET, (byte) 4, 20));
		oddsBet = bet.getOddsBet();
	}
	
	@Test
	public void winDontComeOddsBetWith7AndPointOf4() {
		number = oddsBet.number;
		when(bet.processBet(oddsBet, (byte) 7)).thenReturn(this.processBet(oddsBet, (byte) 7));
		assertEquals(10, bet.processBet(oddsBet, (byte) 7));
	}
	
	@Test
	public void winDontComeOddsBetWith7AndPoint10() {
		when(bet.getOddsBet()).thenReturn((FourTenOddsBet) BetFactory.createPropsBet(BetType.FOUR_TEN_ODDS_BET, (byte) 10, 20));
		oddsBet = bet.getOddsBet();
		number = oddsBet.number;
		when(bet.processBet(oddsBet, (byte) 7)).thenReturn(this.processBet(oddsBet, (byte) 7));
		assertEquals(10, bet.processBet(oddsBet, (byte) 7));
	}
	
	@Test
	public void winDontComeOddsBetWith7AndPoint5() {
		when(bet.getOddsBet()).thenReturn((FiveNineOddsBet) BetFactory.createPropsBet(BetType.FIVE_NINE_ODDS_BET, (byte) 5, 30));
		oddsBet = bet.getOddsBet();
		number = oddsBet.number;
		when(bet.processBet(oddsBet, (byte) 7)).thenReturn(this.processBet(oddsBet, (byte) 7));
		assertEquals(20, bet.processBet(oddsBet, (byte) 7));
	}
	
	@Test
	public void winDontComeOddsBetWith7AndPoint9() {
		when(bet.getOddsBet()).thenReturn((FiveNineOddsBet) BetFactory.createPropsBet(BetType.FIVE_NINE_ODDS_BET, (byte) 9, 30));
		oddsBet = bet.getOddsBet();
		number = oddsBet.number;
		when(bet.processBet(oddsBet, (byte) 7)).thenReturn(this.processBet(oddsBet, (byte) 7));
		assertEquals(20, bet.processBet(oddsBet, (byte) 7));	
	}
	
	@Test
	public void winDontComeOddsBetWith7AndPoint6() {
		when(bet.getOddsBet()).thenReturn((SixEightOddsBet) BetFactory.createPropsBet(BetType.SIX_EIGHT_ODDS_BET, (byte) 6, 24));
		oddsBet = bet.getOddsBet();
		number = oddsBet.number;
		when(bet.processBet(oddsBet, (byte) 7)).thenReturn(this.processBet(oddsBet, (byte) 7));
		assertEquals(20, bet.processBet(oddsBet, (byte) 7));
	}
	
	@Test
	public void winDontComeOddsBetWith7AndPoint8() {
		when(bet.getOddsBet()).thenReturn((SixEightOddsBet) BetFactory.createPropsBet(BetType.SIX_EIGHT_ODDS_BET, (byte) 8, 24));
		oddsBet = bet.getOddsBet();
		number = oddsBet.number;
		when(bet.processBet(oddsBet, (byte) 7)).thenReturn(this.processBet(oddsBet, (byte) 7));
		assertEquals(20, bet.processBet(oddsBet, (byte) 7));
	}
	
	@Test
	public void loseDontComeOddsBetWith4() {
		number = oddsBet.number;
		when(bet.processBet(oddsBet, (byte) 4)).thenReturn(this.processBet(oddsBet, (byte) 4));
		assertEquals(-20, bet.processBet(oddsBet, (byte) 4));
	}
	@Test
	public void loseDontComeOddsBetWith10() {
		when(bet.getOddsBet()).thenReturn((FourTenOddsBet) BetFactory.createPropsBet(BetType.FOUR_TEN_ODDS_BET, (byte) 10, 20));
		oddsBet = bet.getOddsBet();
		number = oddsBet.number;
		when(bet.processBet(oddsBet, (byte) 10)).thenReturn(this.processBet(oddsBet, (byte) 10));
		assertEquals(-20, bet.processBet(oddsBet, (byte) 10));
	}
	
	@Test
	public void loseDontComeOddsBetWith5() {
		when(bet.getOddsBet()).thenReturn((FiveNineOddsBet) BetFactory.createPropsBet(BetType.FIVE_NINE_ODDS_BET, (byte) 5, 30));
		oddsBet = bet.getOddsBet();
		number = oddsBet.number;
		when(bet.processBet(oddsBet, (byte) 5)).thenReturn(this.processBet(oddsBet, (byte) 5));
		assertEquals(-30, bet.processBet(oddsBet, (byte) 5));
	}

	@Test
	public void loseDontComeOddsBetWith9() {
		when(bet.getOddsBet()).thenReturn((FiveNineOddsBet) BetFactory.createPropsBet(BetType.FIVE_NINE_ODDS_BET, (byte) 9, 30));
		oddsBet = bet.getOddsBet();
		number = oddsBet.number;
		when(bet.processBet(oddsBet, (byte) 9)).thenReturn(this.processBet(oddsBet, (byte) 9));
		assertEquals(-30, bet.processBet(oddsBet, (byte) 9));
	}
	
	@Test
	public void loseDontComeOddsBetWith6() {
		when(bet.getOddsBet()).thenReturn((SixEightOddsBet) BetFactory.createPropsBet(BetType.SIX_EIGHT_ODDS_BET, (byte) 6, 24));
		oddsBet = bet.getOddsBet();
		number = oddsBet.number;
		when(bet.processBet(oddsBet, (byte) 6)).thenReturn(this.processBet(oddsBet, (byte) 6));
		assertEquals(-24, bet.processBet(oddsBet, (byte) 6));
	}
	@Test
	public void loseDontComeOddsBetWith8() {
		when(bet.getOddsBet()).thenReturn((SixEightOddsBet) BetFactory.createPropsBet(BetType.SIX_EIGHT_ODDS_BET, (byte) 8, 24));
		oddsBet = bet.getOddsBet();
		number = oddsBet.number;
		when(bet.processBet(oddsBet, (byte) 8)).thenReturn(this.processBet(oddsBet, (byte) 8));
		assertEquals(-24, bet.processBet(oddsBet, (byte) 8));
	}
	
	@Test 
	public void pushDontComeOddsBetWith2() {
		when(bet.processBet(oddsBet, (byte) 2)).thenReturn(this.processBet(oddsBet, (byte) 2));
		assertEquals(0, bet.processBet(oddsBet, (byte) 2));
	}
	
	@Test
	public void pushDontComeOddsBetWith3() {
		when(bet.processBet(oddsBet, (byte) 3)).thenReturn(this.processBet(oddsBet, (byte) 3));
		assertEquals(0, bet.processBet(oddsBet, (byte) 3));
	}
	
	@Test
	public void pushDontComeOddsBetWith11() {
		when(bet.processBet(oddsBet, (byte) 11)).thenReturn(this.processBet(oddsBet, (byte) 11));
		assertEquals(0, bet.processBet(oddsBet, (byte) 11));
	}
	
	@Test
	public void pushDontComeOddsBetWith12() {
		when(bet.processBet(oddsBet, (byte) 12)).thenReturn(this.processBet(oddsBet, (byte) 12));
		assertEquals(0, bet.processBet(oddsBet, (byte) 12));
	}
	
	private int processBet(Bet bet, byte count) {
		double winnings=  0;
		switch(count) {
		case 2: case 3: case 11: case 12:
			break;
		case 7:
			switch(number) {
			case 4: case 10:
				winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 1/2);
				break;
			case 5: case 9:
				winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 2/3);
				break;
			case 6: case 8:
				winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 5/6);
				break;
			default:
				break;
			}
			break;
		default:
			if(count == number) {
				winnings = bet.getBetAmount() * -1;
			}
		}
		return (int) winnings;
	}

}
