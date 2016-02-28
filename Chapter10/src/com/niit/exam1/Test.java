package com.niit.exam1;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Poker poker = new Poker(Poker.DIAMOND, 8);
		//poker.details();
		
		Poker poker = new Poker(PokerEnum.heart, 10);
		Poker poker1 = new Poker(PokerEnum.diamond, 3);
		Poker poker2 = new Poker(PokerEnum.club, 8);
		poker2.details();
	}

}
