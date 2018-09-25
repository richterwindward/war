package sample;

public class Card implements Comparable<Card> {
    final static char[] suits = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

    private char suit;

    public Card(char suit) {
        this.suit = suit;
    }

    @Override
    public int compareTo(Card card) {
        return this.suit - card.suit;
    }
}
