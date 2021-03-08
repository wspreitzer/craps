package com.williamspreitzer.craps.bets;

public class BetFactory {

	private static Bet bet = null;
	
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