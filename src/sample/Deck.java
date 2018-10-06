package sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


/**
 * Class that represents the deck of cards being used
 */
public class Deck {

    private ArrayList<Card> cards; // full deck
    private ArrayList<Card> FirstHalf; // first half of deck
    private ArrayList<Card> SecondHalf; // second half of deck

    /**
     * Initializes an un-shuffled deck.
     */
    public Deck() {
        this.cards = new ArrayList<Card>();
        this.FirstHalf = new ArrayList<Card>();
        this.SecondHalf = new ArrayList<Card>();

        // makes 4 suits for each card value
        for(int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                this.cards.add(new Card(Card.suits[i])); // adds a new card to deck with value i
                String imgPath = this.cards.get(this.cards.size() - 1).getPaths()[j]; // gives the new card one of the 4 suits
                this.cards.get(this.cards.size() - 1).setImagePath(imgPath); // sets up card's image
            }
        }
    }

    // shuffles deck
    public void Shuffle() {
        Collections.shuffle(cards);
    }

    // sets the FirstHalf and SecondHalf to be the two halves of the deck in it's current state
    public void Cut() {
        for(int i = 0; i < 26; i++) {
            this.FirstHalf.add(this.cards.get(i));
        }
        for(int i = 27; i < 52; i++) {
            this.SecondHalf.add(this.cards.get(i));
        }
    }

    // getters
    public ArrayList<Card> getFirstHalf(){
        return FirstHalf;
    }
    public ArrayList<Card> getSecondHalf(){
        return SecondHalf;
    }
}
