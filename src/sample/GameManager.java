package sample;

import javafx.scene.Group;

import java.util.ArrayList;

public class GameManager {
    private Player p1;
    private Player p2;
    private ArrayList<Card> field;

    public GameManager(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.field = new ArrayList<Card>();
    }

    public int nextRound() {
        Card playerOneCard = this.p1.playCard();
        Card playerTwoCard = this.p2.playCard();

        if (playerOneCard.compareTo(playerTwoCard) > 0) {
            /* Player one wins */
            this.p1.addCard(playerOneCard, 0);
            this.p1.addCard(playerTwoCard, 0);
            for (Card c : field){ this.p1.addCard(c, 0); }
            return 1;
        } else if(playerOneCard.compareTo(playerTwoCard) < 0) {
            /* Player two wins */
            this.p2.addCard(playerOneCard, 0);
            this.p2.addCard(playerTwoCard, 0);
            for (Card c : field){ this.p2.addCard(c, 0); }
            return 2;
        } else {
            /* Tie */
            field.add(playerOneCard);
            field.add(playerTwoCard);
            for (Card c : p1.getTopCards(3)){ field.add(c); }
            for (Card c : p2.getTopCards(3)){ field.add(c); }
            this.nextRound();
        }
        return -1; // Something went wrong. This should never happen.
    }

    /**
     *  Looks at the field and renders the back of each players' deck
     */
    public void animateBoard(Group root) {

    }

    private Player checkWin() {
        if (this.p1.cardCount() == 0)
            return this.p2;
        else if (this.p2.cardCount() == 0)
            return this.p1;
        else
            return null;
    }

    int getFieldCount() {
        return this.field.size();
    }

}
