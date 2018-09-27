package sample;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> cards;

    public Player(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Card playCard() {
        Card playedCard = this.cards.get(cards.size() - 1);
        this.cards.remove(cards.size() - 1);
        return playedCard;
    }

    public void addCard(Card card, int index) {
        this.cards.add(index, card);
    }

    public int cardCount() {
        return this.cards.size();
    }
}
