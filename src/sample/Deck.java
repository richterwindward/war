package sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;
    private ArrayList<Card> FirstHalf;
    private ArrayList<Card> SecondHalf;

    /**
     * Initializes an un-shuffled deck.
     */
    public Deck() {
        this.cards = new ArrayList<Card>();
        this.FirstHalf = new ArrayList<Card>();
        this.SecondHalf = new ArrayList<Card>();

        for(int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                this.cards.add(new Card(Card.suits[i]));
                String imgPath = this.cards.get(this.cards.size() - 1).getPaths()[j];
                this.cards.get(this.cards.size() - 1).setImagePath(imgPath);
            }
        }
    }

    public void Shuffle() {
        Collections.shuffle(cards);
    }

    public void Cut() {
        for(int i = 0; i < 26; i++) {
            this.FirstHalf.add(this.cards.get(i));
        }
        for(int i = 27; i < 52; i++) {
            this.SecondHalf.add(this.cards.get(i));
        }
    }

    public ArrayList<Card> getFirstHalf(){
        return FirstHalf;
    }
    public ArrayList<Card> getSecondHalf(){
        return SecondHalf;
    }
}
