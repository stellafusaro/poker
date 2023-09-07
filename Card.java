/** A class that simulates a deck of cards
*/

public class Card implements Comparable<Card>{
	
	private int suit; // use integers 1-4 to encode the suit
	private int rank; // use integers 1-13 to encode the rank
	private String cardRank;
	private String cardSuit;
	
	public Card(int s, int r){
		suit = s;
		rank = r;
	}
	
	/** A method to return the suit of the card.
	@return The suit of the card.
	*/
	public int getSuit(){
		return suit;
	}

	/** A method to return the rank of the card.
	@return The rank of the card.
	*/
	public int getRank(){
		return rank;
	}

	/** A method to compare two cards
	*/
	/*public int compareTo(Card c){
		if(rank> c.getRank()){
			return 1;
		} else if(rank<c.getRank()) {
			return -1;
		} else if(rank == c.getRank() && suit> c.getSuit()){
			return 1;
		} else if(rank == c.getRank() && suit< c.getSuit()) {
			return -1;
		} else {
			return 0;
		}
	}
	*/

	/** A method to compare two cards
	@param c The second cared being compared to.
	*/
	public int compareTo(Card c) {

		//return rank*4 - c.getRank()*4

		int compare = 0;
		int compare2 = 1;

		if(rank == c.getRank()){
			compare = 0;
		}

		if(rank > c.getRank()){
			compare = (rank - c.getRank());
		}

		if(rank< c.getRank()){
			compare = (c.getRank() - rank);
		}

		if(suit == c.getSuit()){
			compare2 = -1;
		}

	return compare*compare2;

	}


	
	@Override
	public String toString(){
		if(rank != 1 && rank<11){
			cardRank = Integer.toString(rank);
		} else if (rank == 11) {
			cardRank = "Jack";
		} else if(rank ==12){
			cardRank = "Queen";
		} else if( rank == 13){
			cardRank = "King";
		} else {
			cardRank = "Ace";
		}

		if(suit == 1){
			cardSuit = "Clubs";
		} else if( suit == 2){
			cardSuit = "Diamonds";
		} else if(suit == 3){
			cardSuit = "Hearts";
		} else {
			cardSuit = "Spades";
		}

		return cardRank + " of " + cardSuit + " ";
	}
	// add some more methods here if needed

}
