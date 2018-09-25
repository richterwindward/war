package sample;

public class Card {
    final static char[] suits = {2, 3 , 4, 5, 6 , 7 , 8, 9, 10, 11, 12, 13, 14};

    private char suit;

    public Card(char suit) {
        this.suit = suit;
    }

    public String toString() {
        switch (this.suit) {
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            case 14:
                return "Ace";
        }
    }

}
