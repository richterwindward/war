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

public class GameManager {
    private Player p1;
    private Player p2;
    private ArrayList<Card> field;

    public GameManager(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.field = new ArrayList<Card>();
    }

    public int nextRound(Group root) {
        Card playerOneCard = this.p1.playCard();
        Card playerTwoCard = this.p2.playCard();

        // give cards positions
        Rectangle p1PlayedCard = renderCard(playerOneCard, 650, 363); // test card positions
        Rectangle p2PlayedCard = renderCard(playerTwoCard, 650, 437);

        // renders shown cards
        animateBoard(root, p1PlayedCard);
        animateBoard(root, p2PlayedCard);

        // pause so players can see board src: http://tomasmikula.github.io/blog/2014/06/04/timers-in-javafx-and-reactfx.html
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(2500),
                ae -> doNothing())); // honestly no clue if this is gunna work
        timeline.play();


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

            for (int i = 0; i < field.size(); i++){
                Rectangle r = new Rectangle(); // img src: https://i.pinimg.com/originals/10/80/a4/1080a4bd1a33cec92019fab5efb3995d.png
                Image img = new Image("file://" + Paths.get("").toAbsolutePath().toString() + "/PNG-cards-1.3/gen_cardback.png");
                r.setFill(new ImagePattern(img));

                // r.setX(); // maybe give r borders + have position shift by some number * i if want
                // r.setY();

                animateBoard(root, r);
            }

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

    private void doNothing(){

    }

    public Rectangle renderCard(Card C, int x, int y){
        Rectangle r = C.cardRect;
        r.setX(x);
        r.setY(y);
        return r;
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
