package com.williamspreitzer.craps.bets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
public class AllBetTest {

	@Mock
	AllBet bet;

	Bet allBet = null;
	
	static MockedStatic<CrapsUtils> utils = null;

	static boolean isSmallBetWon;

	static boolean isTallBetWon;

	static {
		utils = mockStatic(CrapsUtils.class);
		utils.when(CrapsUtils::isSmallBetWon).thenReturn(true);
		utils.when(CrapsUtils::isTallBetWon).thenReturn(true);
		isSmallBetWon = CrapsUtils.isSmallBetWon();
		isTallBetWon = CrapsUtils.isTallBetWon();
	}

	@BeforeEach
	private void setup() {
		allBet = BetFactory.createPropsBet(BetType.ALL_BET, 100);
	}

	@Test
	public void mockNotNullsTest() {
		assertNotNull(bet);
	}

	@Test
	public void allBetWinTest() {
		when(bet.processBet(allBet, (byte) 8))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.TALL_BET, 100), (byte) 8));
		assertEquals(17400, bet.processBet(allBet, (byte) 8));
	}

	@Test
	public void allBetLoseTest() {
		when(bet.processBet(allBet, (byte) 7))
				.thenReturn(this.processBet(BetFactory.createPropsBet(BetType.TALL_BET, 100), (byte) 7));
		assertEquals(-100, bet.processBet(allBet, (byte) 7));
	}

	private int processBet(Bet bet, byte count) {
		double winnings = 0;
		if (count == 7) {
			winnings = bet.getBetAmount() * -1;
		} else {
			if (isSmallBetWon && isTallBetWon)
			winnings = OddsBet.calculator.calculate(bet.getBetAmount(), (double) 174 / 1);
		}
		return (int) winnings;
	}
	
	@AfterAll
	private static void close() {
		utils.close();
	}
}
