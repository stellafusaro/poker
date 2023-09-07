/** A class that simulates the player of a poker game
*/
// add your own banner here
import java.util.ArrayList;
public class Player {
	
		
	private ArrayList<Card> hand; // the player's cards
	private double bankroll;
    private double bet;

	// you may choose to use more instance variables
		
	public Player(double bankroll){	
        this.bankroll = bankroll;
        hand = new ArrayList<>();	
	    // create a player here
	}

	/** A method for adding a card to the players hand
    @param c The card being added to the hand.
	*/
    public void addCard(Card c){
        hand.add(c);
	    // add the card c to the player's hand
	}

    /** A method for remocing a card from the players hand
    @param c The card being removed from the hand.
	*/
	public void removeCard(Card c){
        hand.remove(c);
	    // remove the card c from the player's hand
        }

    /** A method for replacing a card in the players hand
    @param spot The spot in which a new card will be added.
    @param c The card being added.
	*/
    public void changeCard(int spot, Card c){
        hand.set(spot,c);
    }
		
    /** A method for the player to bet a an amount of tokens
    @param amt The amount that the player bets.
	*/
    public void bets(int amt){
        bankroll = bankroll - amt;
            // player makes a bet
    }

    /** A method that adds the tokens won to the bankroll.
    @param odds The amount that the player wins back.
	*/
    public void winnings(int odds){
            bankroll = bankroll + odds;
            //	adjust bankroll if player wins
        }
    /** A method that returns the amount of money in the bankroll.
    @return The amount of money in the bankroll of the player.
	*/  
    public double getBankroll(){
    return bankroll;
            // return current balance of bankroll
        }

    /** A method for dealing that returns the hand of the player.
    @return The hand of the player.
	*/
    public ArrayList<Card> getHand(){
            return hand;
        }

    /** A method for returning a card in the hand of the player.
    @param x The position card being returned
    @return The card at position x. 
	*/
    public Card getCard (int x) {
            return hand.get(x);
        }

        // you may wish to use more methods here
}


