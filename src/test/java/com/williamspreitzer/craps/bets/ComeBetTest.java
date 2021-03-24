package com.williamspreitzer.craps.bets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ComeBetTest {
	
	@Mock
	ComeBet bet;
	
	Bet comeBet;
	
	byte number;
	
	@BeforeEach
	private void setup() {
		comeBet = BetFactory.createPropsBet(BetType.COME_BET, 5);
	}
	
	@Test
	public void winComeBetWith4() {
		when(bet.getNumber()).thenReturn((byte) 4);
		number = bet.getNumber();
		when(bet.processBet(comeBet, (byte) 4)).thenReturn(this.processBet(comeBet, (byte) 4));
		assertEquals(5, bet.processBet(comeBet, (byte) 4));
	}
	
	@Test
	public void winComeBetWith5() {
		when(bet.getNumber()).thenReturn((byte) 5);
		number = bet.getNumber();
		when(bet.processBet(comeBet, (byte) 5)).thenReturn(this.processBet(comeBet, (byte) 5));
		assertEquals(5, bet.processBet(comeBet, (byte) 5));
	}
	
	@Test
	public void winComeBetWith6() {
		when(bet.getNumber()).thenReturn((byte) 6);
		number = bet.getNumber();
		when(bet.processBet(comeBet, (byte) 6)).thenReturn(this.processBet(comeBet, (byte) 6));
		assertEquals(5, bet.processBet(comeBet, (byte) 6));
	}
	
	@Test
	public void winComeBetWith7() {
		when(bet.processBet(comeBet, (byte) 7)).thenReturn(this.processBet(comeBet, (byte) 7));
		assertEquals(5, bet.processBet(comeBet, (byte) 7));
	}
	
	@Test
	public void winComeBetWith8() {
		when(bet.getNumber()).thenReturn((byte) 8);
		number = bet.getNumber();
		when(bet.processBet(comeBet, (byte) 8)).thenReturn(this.processBet(comeBet, (byte) 8));
		assertEquals(5, bet.processBet(comeBet, (byte) 8));
	}
	
	@Test
	public void winComeBetWith9() {
		when(bet.getNumber()).thenReturn((byte) 9);
		number = bet.getNumber();
		when(bet.processBet(comeBet, (byte) 9)).thenReturn(this.processBet(comeBet, (byte) 9));
		assertEquals(5, bet.processBet(comeBet, (byte) 9));
	}
	
	@Test
	public void winComeBetWith10() {
		when(bet.getNumber()).thenReturn((byte) 10);
		number = bet.getNumber();
		when(bet.processBet(comeBet, (byte) 10)).thenReturn(this.processBet(comeBet, (byte) 10));
		assertEquals(5, bet.processBet(comeBet, (byte) 10));
	}
	
	@Test
	public void winComeBetWith11() {
		when(bet.processBet(comeBet, (byte) 11)).thenReturn(this.processBet(comeBet, (byte) 11));
		assertEquals(5, bet.processBet(comeBet, (byte) 11));
	}
	
	@Test
	public void loseComeBetWith2() {
		when(bet.processBet(comeBet, (byte) 2)).thenReturn(this.processBet(comeBet, (byte) 2));
		assertEquals(-5, bet.processBet(comeBet, (byte) 2));
	}
	
	@Test
	public void loseComeBetWith3() {
		when(bet.processBet(comeBet, (byte) 3)).thenReturn(this.processBet(comeBet, (byte) 3));
		assertEquals(-5, bet.processBet(comeBet, (byte) 3));
	}
	
	@Test
	public void loseComeBetWith7() {
		when(bet.getNumber()).thenReturn((byte) 5);
		number = bet.getNumber();
		when(bet.processBet(comeBet, (byte) 7)).thenReturn(this.processBet(comeBet, (byte) 7));
		assertEquals(-5, bet.processBet(comeBet, (byte) 7));		
	}

	@Test
	public void loseComeBetWith12() {
		when(bet.processBet(comeBet, (byte) 12)).thenReturn(this.processBet(comeBet, (byte) 12));
		assertEquals(-5, bet.processBet(comeBet, (byte) 12));
	}
	
	private int processBet(Bet bet, byte count) {
		double winnings = 0;
		if(number == 0) {
			switch(count) {
			case 2: case 3: case 12:
				winnings = bet.getBetAmount() * -1;
				break;
			case 7: case 11:
				winnings = bet.getBetAmount();
				break;
			default:
				number = count;
				break;
			}
		} else {
			switch(count) {
			case 4: case 5: case 6: case 8: case 9: case 10:
				if(count == number) {
					winnings = bet.getBetAmount();
				}
				break;
			case 7:
				winnings = bet.getBetAmount() * -1;
				break;
			default:
				break;
			}
		}
		return (int) winnings;
	}
}