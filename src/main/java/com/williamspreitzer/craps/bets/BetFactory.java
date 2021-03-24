package com.williamspreitzer.craps.bets;

public class BetFactory {

	private static Bet bet = null;
	
	public static Bet createPropsBet(BetType type, int betAmount) {
		switch(type) {
		case ALL_BET:
			bet = new AllBet(betAmount);
			break;
		case ANY_CRAPS_BET:
			bet = new AnyCrapsBet(betAmount);
			break;
		case ANY_SEVEN_BET:
			bet = new AnySevenBet(betAmount);
			break;
		case COME_BET:
			bet = new ComeBet(betAmount);
			break;
		case DONT_COME_BAR_TWELEVE_BET:
			bet = new DontComeBarTweleveBet(betAmount);
			break;
		case DONT_PASS_BAR_TWELEVE_BET:
			bet = new DontPassBet(betAmount);
			break;
		case DOUBLES_BET:
			bet = new DoublesBet(betAmount);
			break;
		case FIELD_BET:
			bet = new FieldBet(betAmount);
			break;
		case FIRE_BET:
			bet = new FireBet(betAmount);
			break;
		case FOUR_ROLLS_NO_SEVEN_BET:
			bet = new FourRollsNoSevenBet(betAmount);
			break;
		case MIDWAY_BET:
			bet = new MidwayBet(betAmount);
			break;
		case OVER_SEVEN_BET:
			bet = new OverSevenBet(betAmount);
			break;
		case PASS_LINE_BET:
			bet = new PassLineBet(betAmount);
			break;
		case PASS_LINE_ODDS_BET:
			bet = new PassLineOddsBet(betAmount);
			break;
		case SMALL_BET:
			bet = new SmallBet(betAmount);
			break;
		case TALL_BET:
			bet = new TallBet(betAmount);
			break;
		case UNDER_SEVEN_BET:
			bet = new UnderSevenBet(betAmount);
			break;		
		case WHIRL_BET:
			bet = new WhirlBet(betAmount);
			break;
		default:
			break;
		}
		return bet;
	}
	
	public static Bet createPropsBet(BetType type, byte number, int betAmount) {
		switch(type) {
		case COME_ODDS_BET:
			bet = new ComeOddsBet(number, betAmount);
			break;
		case DONT_COME_BAR_TWELEVE_ODDS_BET:
			bet = new DontComeBarTweleveOddsBet(number, betAmount);
			break;
		case CRAPS_TWO_OR_TWELEVE_BET:
			bet = new CrapsTwoOrTweleveBet(number, betAmount);
			break;
		case FIVE_NINE_ODDS_BET:
			bet = new FiveNineOddsBet(number, betAmount);
			break;
		case FIVE_NINE_PLACE_BET:
			bet = new FiveNinePlaceBet(number, betAmount);
			break;
		case FOUR_TEN_HARDWAY_BET:
			bet = new FourTenHardway(number, betAmount);
			break;
		case FOUR_TEN_ODDS_BET:
			bet =  new FourTenOddsBet(number, betAmount);
			break;
		case FOUR_TEN_PLACE_BET:
			bet = new FourTenPlaceBet(number, betAmount);
			break;
		case HORN_BET:
			bet = new HornBet(betAmount, number);
			break;
		case SIX_EIGHT_HARDWAY_BET:
			bet = new SixEightHardwayBet(number, betAmount);
			break;
		case SIX_EIGHT_ODDS_BET:
			bet = new SixEightOddsBet(number, betAmount);
			break;
		case SIX_EIGHT_PLACE_BET:
			bet = new SixEightPlaceBet(number, betAmount);
			break;
		case THREE_OR_ELEVEN_BET:
			bet = new ThreeOrElevenBet(number, betAmount);
			break;
		default:
			break;
		}
		return bet;
	}
}