package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Class for game logic/game tracker
 */
public class GameManager {
    private Player p1;
    private Player p2;
    private ArrayList<Card> field; // all the cards that are temporarily on the field and not owned by either player yet

    public GameManager(Player p1, Player p2) { // initializes a new game with two players and an empty field
        this.p1 = p1;
        this.p2 = p2;
        this.field = new ArrayList<Card>();
    }

    public int nextRound(Group root) { // plays the next round and takes the group as a parameter to be able to call it to add children

        // both players play cards
        Card playerOneCard = this.p1.playCard();
        Card playerTwoCard = this.p2.playCard();

        // rectangles with specific positions that represent the cards the players played
        Rectangle p1PlayedCard = renderCard(playerOneCard, 315, 500);
        Rectangle p2PlayedCard = renderCard(playerTwoCard, 315, 50);

        // renders the played cards
        animateBoard(root, p1PlayedCard);
        animateBoard(root, p2PlayedCard);

        // TODO: some pause to show board
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//        }


        if (playerOneCard.compareTo(playerTwoCard) > 0) {
            /* Player one wins */
            System.out.println("Player One Wins! Their card: " + (int)playerOneCard.suit);
            System.out.println("Player Two Lose! Their card: " + (int)playerTwoCard.suit);

            // adds the two played cards to the end of player one's deck
            this.p1.addCard(playerOneCard, p1.cardCount()-1);
            this.p1.addCard(playerTwoCard, p1.cardCount()-1);

            // checks and adds any other wagered cards (i.e. if the last round ended in a tie)
            for (Card c : field){ this.p1.addCard(c, p1.cardCount()-1); }
            return 1;

        } else if(playerOneCard.compareTo(playerTwoCard) < 0) {
            /* Player two wins */
            System.out.println("Player One Loses! Their card: " + (int)playerOneCard.suit);
            System.out.println("Player Two Wins! Their card: " + (int)playerTwoCard.suit);

            // adds the two played cards to the end player two's deck
            this.p2.addCard(playerOneCard, p2.cardCount()-1);
            this.p2.addCard(playerTwoCard, p2.cardCount()-1);

            // checks and adds any other wagered cards
            for (Card c : field){ this.p2.addCard(c, p2.cardCount()-1); }
            return 2;

        } else {
            System.out.println("War!");
            /* Tie */

            // adds the played cards and the three wagered cards from on the top of their decks temporarily to field
            field.add(playerOneCard);
            field.add(playerTwoCard);
            for (Card c : p1.getTopCards(3)){ field.add(c); }
            for (Card c : p2.getTopCards(3)){ field.add(c); }

            // stacks rectangles with the cardback image that represents the wagered cards
            for (int i = 0; i < field.size(); i++){
                Rectangle r = new Rectangle(385, 372, 30, 56);
                Image img = new Image("file://" + Paths.get("").toAbsolutePath().toString() + "/PNG-cards-1.3/gen_cardback.png");
                r.setFill(new ImagePattern(img));

                // adds the rectangles to the board
                animateBoard(root, r);
            }

            // immediately starts a new round; recursion
            this.nextRound(root);
        }
        return -1; // Something went wrong. This should never happen.
    }

    /**
     *  Looks at the field and renders the back of each players' deck
     */
    public void animateBoard(Group root, Rectangle r) {
        root.getChildren().add(r);
    }

    // take a card and where it should be positioned to change its position on the board
    public Rectangle renderCard(Card C, int x, int y){
        Rectangle r = C.cardRect;
        r.setX(x);
        r.setY(y);
        return r;
    }

    // checks to see if a player has won
    private Player checkWin() {
        if (this.p1.cardCount() == 0)
            return this.p2;
        else if (this.p2.cardCount() == 0)
            return this.p1;
        else
            return null;
    }

    // returns number of wagered cards
    int getFieldCount() {
        return this.field.size();
    }

}
