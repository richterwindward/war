package sample;

import javafx.scene.image.Image;

public class Card implements Comparable<Card> {
    final static char[] suits = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    final static String clubsSuffix = "_of_clubs.png";
    final static String diamondsSuffix = "_of_diamonds.png";
    final static String heartsSuffix = "_of_hearts.png";
    final static String spadesSuffix = "_of_spades.png";

    public Image cardImage;

    private char suit;

    public Card(char suit) {
        this.suit = suit;
        switch (this.suit) {

        }
    }

    private String[] toURL() {
        if(suit >= 2 && suit <= 10) {
            String prefix = String.valueOf(suit);
            String[] res = {
                    prefix + clubsSuffix,
                    prefix + diamondsSuffix,
                    prefix + heartsSuffix,
                    prefix + spadesSuffix
            };
            return res;
        } else {
            String prefix = "*";
            switch (suit) {
                case 11:
                    // jack
                    prefix = "jack";
                case 12:
                    // queen
                    prefix = "queen";
                case 13:
                    // king
                    prefix = "king";
                case 14:
                    // ace
                    prefix = "ace";
            }

            String[] res = {
                    prefix + clubsSuffix,
                    prefix + diamondsSuffix,
                    prefix + heartsSuffix,
                    prefix + spadesSuffix
            };
            
            return res;
        }
    }

    @Override
    public int compareTo(Card card) {
        return this.suit - card.suit;
    }
}
