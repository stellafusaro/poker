Card.java 
This class implements the comparable method so that two cards can be compared. 
Each card is labeled two ints, its suit and its rank. The suits are labeled from 1
to 4, where 1 marks a club, 2 marks a diamond, 3 marks a heart and 4 marks a spade card.
The ranks go from 1 to 13, where 1 is an ace, 2-10 are the cards 2-10, 11 is jack, 12 is 
queen and 13 is king. 
Although both the rank and the suit are both encoded by numbers the toString method allows the
return for each card to be the rank and the suit in the form of a string. The getSuit and getRank 
methods return the suit and rank respectively. This will be useful later on when comparing cards. 
The comparable method compares the ranks by subtracting the smaller rank from the larger rank. If the
cards have the same rank, the compatible value will be zero. The comparable value will be negative if
the suit of the cards is the same. 

Deck.java
This class creates a deck using the card class. I did this by making a nested for loop,
as the cards the inner loop creates each card of a different rank, the outer loop changes 
the suit once all the ranks in one suit are made. The order of the cards in the deck will be 
each card of clubs, then each card of diamonds, then each card of spades, then each card of hearts. 
Then I created a shuffling method that uses the Random class. This shuffle method uses a for loop.The 
loop switches the spot of two random cards 999 times. The deal method returns the top card. Note that 
this method does not always return the card at index zero, just the next index down from the last card dealt. 
The get deck method returns all the cards in the deck - in order. It was useful to check to see the 
effectiveness of the shuffle method.  

Player.java
This class mainly deals with the bankroll and the hand of the player. The hand is an array list. 
The add card and remove card methods add and remove cards from the hand. The change card method 
removes a specific card and adds a new one in that spot. The bets method removes the bet of the player 
from their bankroll. The winnings method adds the winnings to the bankroll. The getBankroll method returns 
the bankroll of the player. The getHand method returns the hand. Lastly the getCard method returns a 
specific card of the player. 


Game.java
This class has two constructors of two different versions of poker. 

Constructor 1: This constructor must take in an array of cards of the form 
char(first letter of the suit)number(corresponding to the rank). For example s01 corresponds 
to 1 of spades. NOTE: SINGLE DIGIT NUMBERS MUST HAVE A ZERO IN FRONT OF THEM. In this version of 
the game the bankroll of the player is automatically 100 .They are asked how much they want to bet. 
Then each value in the array is divided into a new array that only contains the rank of the card. This 
new array is called testHand2. Then the checkHandTester method is run.

The checkHandTester method mainly utilizes three counters. Counter11 is increased when two ranks in 
the hand are the same. Counter22 is increased when the difference between the ranks of the hand is 
either 1 or 12, this means that the cards are one after the other (regarding ranks). Counter33 checks 
to see if the suits are the same - this counter increases when the suits are the same.  The cards are 
checked using a nested for loop. This for loop compares the first card to every other card, the second 
to every card besides the first, and so on until the last two cards are compared. Once these loops are 
done, there is a series of if statements that checks the hand. The first one checks to see if counter 22 
and counter33 are 4 and 10. This means that the cards have consecutive values and all have the same suit. 
Then it orders the cards by their rank. If the first card is an ace and the second is a 10 the cards must 
be a royal flush, since they are in order. If they are not a royal flush they must be straight flush. If 
counter11 = 6 there are four of a kind in the deck. If  counter 11 is 4 it is a full house. If counter 33 
is 10 and counter 22 is not 4 the hand is a flush. Then counter22 is 4 and counter33 is not 10 the hand is 
a straight. Lastly if counter11 is 3, the hand is three of a kind, if it is 2 two pairs and if it is 1 one 
pair. If none of these if statements are satisfied then the player loses. The checkHandTester is printed 
out and the new bankroll is presented based on the results. 

Constructor 2: this constructor takes no parameters and implements the play method. This method asks 
the user how much money is in their bankroll and creates a new player with that number. Then a new deck 
is instantiated and shuffled. Five cards are then dealt from the top of the deck and added to the player's 
hand. The player is given the choice to change any of their cards. They must say the number of cards they 
want to change and the number card they are in their hand. These cards are changed using the cardChangemethod
 with the information given by the player. If they do not want to change their cards this action is confirmed. 
 If they try to change more cards than they have an error message is printed and they are reprompted. Then 
 the player makes a bet between 1 and 5. If they don't bet within these parameters then they are prompted. 
 Once their bet is made the checkHand method is run. 

The checkHand method works similarly to the checkHandTester method. Instead of counter11 there is counter, 
instead of counter22 there is counter2 and instead of counter33 there is counter 3. The loops work in the 
same way using the cards compareTo method. If the ranks are the same (compareTo = 0) counter is increased. 
If the difference is 1 or 12 counter2 is increased and if compareTo is negative (same suit) then counter 3 
is increased. The if statements works the same way as in checkHandTester except to sort the cards in the 
first if statements collections.sort is used. Then if the first card's rank is 1 and the second card's rank 
is 10 the player has a royal flush. Once the check hand method is run the hand of the player is revealed 
(it will be different than originally revealed if they switched out cards) and the updated bankroll is revealed. 
This concludes the game.


