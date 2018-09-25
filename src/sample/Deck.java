package sample;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;

    /**
     * Initializes an un-shuffled deck.
     */
    public Deck() {
        for(int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                this.cards.add(new Card(Card.suits[i]));
            }
        }
    }

}
