package sample;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> cards;

    public Player(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Card playCard() {
        Card playedCard = this.cards.get(0);
        this.cards.remove(0);
        return playedCard;
    }

    public void addCard(Card card, int index) {
        this.cards.add(index, card);
    }

    public int cardCount() {
        return this.cards.size();
    }

    /**
     * Gets and removes an arbitrary number of cards from the player's deck.
     * @param nCards Number of cards to get from the top of the deck
     * @return ArrayList of cards
     */
    public ArrayList<Card> getTopCards(int nCards) {
        ArrayList<Card> result = new ArrayList<Card>();
        for(int i = 0; i < nCards; i++) {
            result.add(0, this.cards.get(0));
            this.cards.remove(0);
        }
        return result;
    }
}
