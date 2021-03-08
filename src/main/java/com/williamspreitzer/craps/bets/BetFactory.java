package com.williamspreitzer.craps.bets;

public class BetFactory {

	private static Bet bet = null;
	
	
	/*
	 * public static Bet createBet(BetType type, byte number, short amount) { Bet
	 * bet = null; switch(type) { case ALL_BET: bet = new AllBet(number, amount);
	 * break; case ANY_SEVEN_BET: break; case COME_BET: bet = new ComeBet(amount);
	 * break; case CRAPS_TWO_OR_TWELEVE_BET: bet = new CrapsTwoOrTweleveBet(number,
	 * amount); break; case DONT_COME_BAR_TWELEVE_BET: break; case
	 * DONT_PASS_BAR_TWELEVE_BET: break; case DOUBLES_BET: break; case FIELD_BET:
	 * bet = new FieldBet(amount); break; case FIRE_BET: bet = new FireBet(number,
	 * amount); break; case FIVE_NINE_ODDS_BET: break; case FIVE_NINE_PLACE_BET: bet
	 * = new FiveNinePlaceBet(number, amount); break; case FOUR_TEN_HARDWAY_BET:
	 * break; case FOUR_TEN_ODDS_BET: break; case FOUR_TEN_PLACE_BET: bet = new
	 * FourTenPlaceBet(number, amount); break; case HORN_BET: break; case
	 * PASS_LINE_BET: bet = new PassLineBet(amount); break; case
	 * SIX_EIGHT_HARDWAY_BET: break; case SIX_EIGHT_ODDS_BET: break; case
	 * SIX_EIGHT_PLACE_BET: bet = new SixEightPlaceBet(number, amount); break; case
	 * SMALL_BET: bet = new SmallBet(number, amount); break; case TALL_BET: bet =
	 * new TallBet(number, amount); break; case THREE_OR_ELEVEN_BET: break; } return
	 * bet; }
	 */
	
	@SuppressWarnings("incomplete-switch")
	public static PropositionBet createPropsBet(BetType type, int betAmount) {
		switch(type) {
		case MIDWAY_BET:
			bet = new MidwayBet(betAmount);
			break;
		case OVER_SEVEN_BET:
			bet = new OverSevenBet(betAmount);
			break;
		case UNDER_SEVEN_BET:
			bet = new UnderSevenBet(betAmount);
			break;
		case FOUR_ROLLS_NO_SEVEN:
			break;
		}
		return (PropositionBet) bet;
	}
	
	@SuppressWarnings("incomplete-switch")
	public static PropositionOddsBet createPropsOddsBet(BetType type, byte number, int betAmount) {
		switch(type) {
		case ALL_BET:
			bet = new AllBet(betAmount);
		case ANY_CRAPS_BET:
			break;
		case ANY_SEVEN_BET:
			break;
		case CRAPS_TWO_OR_TWELEVE_BET:
			bet = new CrapsTwoOrTweleveBet(number, betAmount);
		case DOUBLES_BET:
			break;
		case FIRE_BET:
			break;
		case FOUR_TEN_HARDWAY_BET:
			bet = new FourTenHardway(number, betAmount);
		case HORN_BET:
			bet = new HornBet(betAmount, number);
			break;
		case SIX_EIGHT_HARDWAY_BET:
			break;
		case SMALL_BET:
			bet = new SmallBet(betAmount);
			break;
		case TALL_BET:
			bet = new TallBet(betAmount);
			break;
		case THREE_OR_ELEVEN_BET:
			bet = new ThreeOrElevenBet(number, betAmount);
			break;
		case WORLD_BET:
			break;
		}
		return (PropositionOddsBet) bet;
	}
	
	public static NonPropositionBet createNonPropsBet() {
		return null;
	}
	
	public static NonPropositionOddsBet createNonPropsOddsBet() {
		return null;
	}
}