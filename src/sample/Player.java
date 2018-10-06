package sample;

import java.util.ArrayList;

/**
 * Class that represents the players
 */
public class Player {
    private ArrayList<Card> cards; // the cards the player has

    public Player(ArrayList<Card> cards) { // initializes a player object with an arraylist of cards that represents the cards the player has
        this.cards = cards;
    }

    public Card playCard() { // method to play a card
        Card playedCard = this.cards.get(0); // tracks the played card
        this.cards.remove(0); // removes the player's card from their cards
        return playedCard; // returns the played card
    }

    public void addCard(Card card, int index) { // adds a card to the arraylist of the player's cards at a certain index
        this.cards.add(index, card);
    }

    public int cardCount() { // returns the number of cards the player has
        return this.cards.size();
    }

    /**
     * Gets and removes an arbitrary number of cards from the player's deck.
     * @param nCards Number of cards to get from the top of the deck
     * @return ArrayList of cards
     */
    public ArrayList<Card> getTopCards(int nCards) { // only for ties, will always be the top 3
        ArrayList<Card> result = new ArrayList<Card>(); // tracks the cards that are being wagered
        for(int i = 0; i < nCards; i++) {
            result.add(0, this.cards.get(0));
            this.cards.remove(0);
        }
        return result; // returns the wagered cards as an arraylist
    }
}
