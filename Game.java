/** A class that simulates a poker game.
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
import java.util.Collections;

public class Game {
	
	private Player p;
	private Deck cards;
	private int counter = 0;
	private ArrayList<Card> comparingHand;
	private int counter2 = 0;
	private int bet;
	private int counter3 = 0;
	private int counter11 = 0;
	private int counter22 = 0;
	private int counter33 = 0;
	private String [] testHand;
	private int bankroll;
	private int [] testHand2;
	private int bet3;
	
	// you'll probably need some more here
	
	
	public Game(String[] testHand){

		Scanner input = new Scanner(System.in);
		this.testHand = testHand;
		bankroll = 100;	
		p = new Player(bankroll);

		System.out.println("You have $100 in your bankroll."
		+ " How much do you want to bet?");
		bet3 = input.nextInt();
		while(bet3 < 1 || bet3 > 5){
			System.out.println("How much do you want to bet?");
			int bet4 = input.nextInt();
			bet3 = bet4;
		}

		p.bets(bet3);

		String testHandSub1 =testHand[0].substring(1,3);
		String testHandSub2 =testHand[1].substring(1,3);
		String testHandSub3 =testHand[2].substring(1,3);
		String testHandSub4 =testHand[3].substring(1,3);
		String testHandSub5 =testHand[4].substring(1,3);

		int testHandInt1 = Integer.parseInt(testHandSub1);
		int testHandInt2 = Integer.parseInt(testHandSub2);
		int testHandInt3 = Integer.parseInt(testHandSub3);
		int testHandInt4 = Integer.parseInt(testHandSub4);
		int testHandInt5 = Integer.parseInt(testHandSub5);

		testHand2 = new int[5];
		testHand2[0] = testHandInt1;
		testHand2[1] = testHandInt2;
		testHand2[2] = testHandInt3;
		testHand2[3] = testHandInt4;
		testHand2[4] = testHandInt5;

			System.out.println(checkHandTester(testHand2, testHand));

		}

		/** A method that checks to see if the player won any tokens.
		@param intArray The ranks of the cards in the hand of the player
		@param stringArray The array of cards in the hand of the player.
		*/
	public String checkHandTester(int [] intArray, String [] stringArray){

		for(int i = 0; i<(testHand2.length-1); i++){
			for (int j =i+1; j<testHand2.length;j++ ){
				if(testHand2[i] == testHand2[j]){
				counter11 ++;
				}
			}
		}

		for(int i = 0; i<(testHand2.length-1); i++){
			for (int j =i+1; j<testHand2.length;j++ ){
				if(testHand2[i] - testHand2[j] == 1 
				|| testHand2[j] - testHand2[i] == 1
				|| testHand2[i] - testHand2[j] == 12 
				|| testHand2[j] - testHand2[i] == 12 ){
				counter22 ++;
				}
			}
		}


		for(int i = 0; i<(testHand.length-1); i++){
			for(int j =i+1; j<testHand.length;j++ ){
				if(testHand[i].charAt(0) == testHand[j].charAt(0)){
				counter33 ++;
				}
			}
		}
			
		if(counter22 ==4 && counter33 == 10){
				for(int i = 0; i<testHand2.length; i++){
					for(int j = i+1; j<testHand2.length; j++){
						if(testHand2[i]>testHand2[j]){
						int holder = testHand2[i];
						testHand2[i]= testHand2[j];
						testHand2[j] = holder;
						}
					}
				}
			if(testHand2[0] == 1 && testHand2[1] == 10){
				p.winnings(250 * bet3);
				return "You have a Royal Flush!";
				//MAKE SURE THIS WORKS AS ACE AS 1
			} else {
			p.winnings(50 * bet3);
			return "You have a Straight Flush!";
			}
		} else if (counter11 == 6){
			p.winnings(25* bet3);
			return "You have Four of a Kind!";
		} else if(counter11 == 4){
			p.winnings(4* bet3);
			return "You have a Full House";
		} else if(counter33 == 10){
			p.winnings(5 * bet3);
			return "You have a flush!";
		} else if (counter22 == 4){
			p.winnings(4* bet3);
			return "You have a Straight!";
			// make sure that ace to 2 works when debugging
		} else if( counter11 ==3){
			p.winnings(3* bet3);
			return "You have Three of a kind!";
		}  else if (counter11 ==2){
			p.winnings(2* bet3);
			return "You have Two Pairs!";
		} else if(counter11 == 1){
			p.winnings(1* bet3);
			return"You have a pair!";
		}  else {
			return "You have nothing. You lost!";
		}
		// This constructor is to help test your code.
		// use the contents of testHand to
		// make a hand for the player
		// use the following encoding for cards
		// c = clubs
		// d = diamonds
		// h = hearts
		// s = spades
		// 1-13 correspond to ace-king
		// example: s1 = ace of spades
		// example: testhand = {s1, s13, s12, s11, s10} = royal flush
		
	}
	
	public Game(){

		Scanner input = new Scanner(System.in);
		System.out.print("How much money is in your bankroll? ");
		int bankroll = input.nextInt();

		p = new Player(bankroll);
		cards = new Deck();

		cards.shuffle();

		for(int i = 0; i<5; i++){
			p.addCard(cards.deal());
		}
		
		System.out.println("How much do you want to bet? (between 1-5)");
		bet = input.nextInt();
		if(bet < 1 || bet > 5){
			System.out.println("INVALID BET AMOUNT!");
			System.out.println("How much do you want to bet? (between 1-5)");
			int bet2 = input.nextInt();
			bet = bet2;
		}
		
		p.bets(bet);

		System.out.println(p.getHand());

        System.out.println("How many cards would you like to change? ");
        int cardChange = input.nextInt();

        Card[] rejectedCards; 
//		rejectedCards = new Card[cardChange];

        if (cardChange>0 && cardChange <6){
            System.out.println("Which card number(order in which delt)"
			 + " would you like to change?");
            for(int i = 0; i< cardChange; i++){
				int cardGiveAway = input.nextInt();
//             	Card giveAway = p.getCard(cardGiveAway);
 //             rejectedCards[i] = giveAway;
				p.changeCard((cardGiveAway-1), cards.deal());
            } 
		} else if(cardChange == 0){
            	System.out.println("Your deck is the same.");
        } else {
                System.out.println("INVALID AMOUNT OF CARDS");
        }

//			for(int i = 0; i<rejectedCards.length ; i++){
//				int j = 52;
//				cards.addDeck(j,rejectedCards[i]);
//				j--;
//			}

		//USE CHECK HAND METHOD

		System.out.println(checkHand(p.getHand()));
		System.out.println("Hand: " + p.getHand());
		// This no-argument constructor is to actually play a normal game
	}
	
	//check highest ranked hand first 
	
	/** A method that plays the poker game.
	*/
	
	public void play(){

		System.out.println("New Bankroll: " + p.getBankroll());

		// this method should play the game	
    }

	/** A method that checks if the player won any tokens 
	@param hand The hand of the player.
	@return The reason the player won.
	*/
	public String checkHand(ArrayList<Card> hand){

		for(int i = 0; i<4; i++){
			for (int j =i+1; j<5;j++ ){
				if(p.getCard(i).compareTo(p.getCard(j)) == 0){
				counter ++;
				}
			}
		}

		for(int i = 0; i<4; i++){
			for (int j =i+1; j<5;j++) {
				if(p.getCard(i).compareTo(p.getCard(j)) == 1 
				|| p.getCard(i).compareTo(p.getCard(j))== 12 
				|| p.getCard(i).compareTo(p.getCard(j)) == -1 
				||p.getCard(i).compareTo(p.getCard(j))== -12){
				counter2 ++;
				}
			}
		}

		for(int i = 0; i<4; i++){
			for(int j =i+1; j<5;j++ ){
				if(p.getCard(i).compareTo(p.getCard(j))< 0){
				counter3 ++;
				}
			}
		}

		if(counter2 ==4 && counter3 == 10){
			Collections.sort(p.getHand());
			if(p.getCard(0).getRank() == 1 && p.getCard(1).getRank() ==10){
				p.winnings(250 * bet);
				return "You have a Royal Flush!";
				//MAKE SURE THIS WORKS WITH ACE AS 1
			} else {
			p.winnings(50 * bet);
			return "You have a Straight Flush!";
			}
		} else if (counter == 6){
			p.winnings(25* bet);
			return "You have Four of a Kind!";
		} else if(counter == 4){
			p.winnings(4* bet);
			return "You have a Full House";
		} else if (counter2 == 4){
			p.winnings(4* bet);
			return "You have a Straight!";
			// make sure that ace to 2 works when debugging
		} else if(counter3 == 10){
			p.winnings(5 * bet);
			return "You have a flush!";
		} else if( counter ==3){
			p.winnings(3* bet);
			return "You have Three of a kind!";
		} else if (counter ==2){
			p.winnings(2* bet);
			return "You have Two Pairs!";
		} else if(counter == 1){
			p.winnings(1* bet);
			return"You have a pair!";
		} else {
			return "You have nothing. You lost!";
		}

		// this method should take an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String
		
	}
	
	
	// you will likely want many more methods here
	// per discussion in class
}
