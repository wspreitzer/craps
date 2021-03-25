package com.williamspreitzer.craps.bets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.williamspreitzer.craps.roll.Roll;

@ExtendWith(MockitoExtension.class)
public class DoublesBetTest {

	@Mock
	DoublesBet bet;
	
	@Mock
	Roll roll;
	
	Bet doublesBet = null;
	
	Set<Byte> doublesTracker = new HashSet<Byte>();
	
	boolean isHardway;
	
	@BeforeEach
	private void setup() {
		doublesBet = (DoublesBet) BetFactory.createPropsBet(BetType.DOUBLES_BET, 5);
	}
	
	@Test
	public void loseDoublesBetWithNoDoublesAndSevenRolled() {
		when(bet.getDoublesTracker()).thenReturn(new HashSet<Byte>());
		doublesTracker = bet.getDoublesTracker();
		when(bet.processBet(doublesBet, (byte) 7)).thenReturn(this.processBet(doublesBet, (byte) 7));
		assertEquals(-5, bet.processBet(doublesBet, (byte) 7));
	}
	
	@Test
	public void loseDoublesBetWithOneDoubleAndSevenRolled() {
		when(bet.getDoublesTracker()).thenReturn(new HashSet<Byte>() {
			private static final long serialVersionUID = 8700468310562434810L;
			{
				add((byte) 2);
			}
		});
		doublesTracker = bet.getDoublesTracker();
		when(bet.processBet(doublesBet, (byte) 7)).thenReturn(this.processBet(doublesBet, (byte) 7));
		assertEquals(-5, bet.processBet(doublesBet, (byte) 7));
		assertEquals(1, doublesTracker.size());
	}
	
	@Test
	public void loseDoublesBetWithTwoDoubleAndSevenRolled() {
		when(bet.getDoublesTracker()).thenReturn(new HashSet<Byte>() {
			private static final long serialVersionUID = 8700468310562434810L;
			{
				add((byte) 2);
				add((byte) 4);
			}
		});
		doublesTracker = bet.getDoublesTracker();
		when(bet.processBet(doublesBet, (byte) 7)).thenReturn(this.processBet(doublesBet, (byte) 7));
		assertEquals(-5, bet.processBet(doublesBet, (byte) 7));
		assertEquals(2, doublesTracker.size());
	}
	
	@Test
	public void winDoublesBetWithThreeDoublesAndSevenRolled() {
		when(bet.getDoublesTracker()).thenReturn(new HashSet<Byte>() {
			private static final long serialVersionUID = 8874206143638892177L;
			{
				add((byte) 2);
				add((byte) 4);
				add((byte) 6);
			}
		});
		doublesTracker = bet.getDoublesTracker();
		when(bet.processBet(doublesBet, (byte) 7)).thenReturn(this.processBet(doublesBet, (byte) 7));
		assertEquals(20, bet.processBet(doublesBet, (byte) 7));
		assertEquals(3, doublesTracker.size());
	}
	
	@Test
	public void winDoublesBetWithfourDoublesAndSevenRolled() {
		when(bet.getDoublesTracker()).thenReturn(new HashSet<Byte>() {
			private static final long serialVersionUID = 6880860328447827222L;
			{
				add((byte) 2);
				add((byte) 4);
				add((byte) 6);
				add((byte) 8);
			}
		});
		doublesTracker = bet.getDoublesTracker();
		when(bet.processBet(doublesBet, (byte) 7)).thenReturn(this.processBet(doublesBet, (byte) 7));
		assertEquals(40, bet.processBet(doublesBet, (byte) 7));
		assertEquals(4, doublesTracker.size());
	}
	
	
	
	@Test
	public void winDoublesBetWithFiveDoublesAndSevenRolled() {
		when(bet.getDoublesTracker()).thenReturn(new HashSet<Byte>() {
			private static final long serialVersionUID = -7086090534834406556L;
			{
				add((byte) 2);
				add((byte) 4);
				add((byte) 6);
				add((byte) 8);
				add((byte) 10);
			}
		});
		doublesTracker = bet.getDoublesTracker();
		when(bet.processBet(doublesBet, (byte) 7)).thenReturn(this.processBet(doublesBet, (byte) 7));
		assertEquals(75, bet.processBet(doublesBet, (byte) 7));
		assertEquals(5, doublesTracker.size());
	}
	
	@Test
	public void winDoublesBetWithSixDoublesAndSevenRolled() {
		when(bet.getDoublesTracker()).thenReturn(new HashSet<Byte>() {
			private static final long serialVersionUID = 8005248825423420854L;
			{
				add((byte) 2);
				add((byte) 4);
				add((byte) 6);
				add((byte) 8);
				add((byte) 10);
				add((byte) 12);
			}
		});
		doublesTracker = bet.getDoublesTracker();
		when(bet.processBet(doublesBet, (byte) 7)).thenReturn(this.processBet(doublesBet, (byte) 7));
		assertEquals(500, bet.processBet(doublesBet, (byte) 7));
	}
	
	@Test
	public void addAces() {
		when(roll.isHardway()).thenReturn(true);
		isHardway = roll.isHardway();
		when(bet.processBet(doublesBet, (byte) 2)).thenReturn(this.processBet(doublesBet, (byte) 2));
		assertEquals(0, bet.processBet(doublesBet, (byte) 2));
		assertEquals(1, doublesTracker.size());
	}
	
	@Test
	public void addFourHardway() {
		when(roll.isHardway()).thenReturn(true);
		isHardway = roll.isHardway();
		when(bet.processBet(doublesBet, (byte) 4)).thenReturn(this.processBet(doublesBet, (byte) 4));
		assertEquals(0, bet.processBet(doublesBet, (byte) 4));
		assertEquals(1, doublesTracker.size());
	}
	
	@Test
	public void addSixHardway() {
		when(roll.isHardway()).thenReturn(true);
		isHardway = roll.isHardway();
		when(bet.processBet(doublesBet, (byte) 6)).thenReturn(this.processBet(doublesBet, (byte) 6));
		assertEquals(0, bet.processBet(doublesBet, (byte) 6));
		assertEquals(1, doublesTracker.size());
	}
	
	@Test
	public void addEightHardway() {
		when(roll.isHardway()).thenReturn(true);
		isHardway = roll.isHardway();
		when(bet.processBet(doublesBet, (byte) 8)).thenReturn(this.processBet(doublesBet, (byte) 8));
		assertEquals(0, bet.processBet(doublesBet, (byte) 8));
		assertEquals(1, doublesTracker.size());
	}
	
	@Test
	public void addTenHardway() {
		when(roll.isHardway()).thenReturn(true);
		isHardway = roll.isHardway();
		when(bet.processBet(doublesBet, (byte) 10)).thenReturn(this.processBet(doublesBet, (byte) 10));
		assertEquals(0, bet.processBet(doublesBet, (byte) 10));
		assertEquals(1, doublesTracker.size());
	}
	
	@Test
	public void addBoxCars() {
		when(roll.isHardway()).thenReturn(true);
		isHardway = roll.isHardway();
		when(bet.processBet(doublesBet, (byte) 12)).thenReturn(this.processBet(doublesBet, (byte) 12));
		assertEquals(0, bet.processBet(doublesBet, (byte) 12));
		assertEquals(1, doublesTracker.size());
	}
	
	private int processBet(Bet bet, byte count) {
		double winnings = 0;
		if(count == 7) {
			switch(doublesTracker.size()) {
			case 0: case 1: case 2:
				winnings = bet.getBetAmount() * -1;
				break;
			case 3:
				winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 4/1);
				break;
			case 4:
				winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 8/1);
				break;
			case 5:
				winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 15/1);
				break;
			case 6:
				winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 100/1);
				break;
			default:
				break;
			}
		} else if(isHardway) {
			doublesTracker.add(count);
		}
		return (int) winnings;
	}	
}