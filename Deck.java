/** A class that simulated a deck of cards
*/
import java.util.Random;

public class Deck {
	
	private Card[] cards;
	private int top;
	private int cardNumber = 0; // the index of the top of the deck
	private Card forSort; 
	private Random r; 
	private int Random1; 
	private int Random2; 
	private Card deltCard; 


	// add more instance variables if needed
	
	public Deck(){
		r = new Random();
		// make a 52 card deck here
		cards = new Card[52];
		for(int suit=1; suit<5;suit++){
			for(int rank = 1; rank<14;rank++){
				cards[cardNumber] = new Card(suit,rank);
				cardNumber++;
			}
		}
		cardNumber = 0;
	}

	/* cards with be in order: Card 0 = Ace of Clubs, Card 1 = 2 of Clubs .... 
	Card 13 = Ace of Diamonds, Card 14 2 of Diamonds....
	Card 26 = Ace of Hearts... Card 39 = 3 of Spades...etc
	*/
	
	/** A method for shuffling the deck
	*/
	public void shuffle(){
		for(int shuffleNumber = 1; shuffleNumber<1000; shuffleNumber ++){
			Random1 = r.nextInt(52);
			Random2 = r.nextInt(52);

			forSort = cards[Random1];
			cards[Random1] = cards[Random2];
			cards[Random2] = forSort;
		}
		cardNumber = 0;
		// shuffle the deck here
	}
	
	/** A method for dealing the top card
	@return The top card
	*/
	public Card deal(){
		deltCard = cards[cardNumber];
		cardNumber++;
		return deltCard;
		// deal the top card in the deck
	}

	/** A method to return the order of the cards in the deck.
	@return The deck of cards.
	*/
	public String getDeck(){
		String deckk = "";
		for(int z = 0; z<cards.length; z++){
			deckk +=cards[z];
		}
		return deckk;
	}

//	public void addDeck(int x, Card addedCard){
//		cards[x] = addedCard;
//	}
	
	// add more methods here if needed

}
