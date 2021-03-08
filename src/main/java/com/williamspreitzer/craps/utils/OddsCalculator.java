package com.williamspreitzer.craps.utils;

@FunctionalInterface
public interface OddsCalculator<A, O> {
	O calculate(A betAmount, O odds);
}
