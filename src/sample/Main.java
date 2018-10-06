package sample; // test


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;

/**
 * SOURCES:
 *
 * card images:
 * https://opengameart.org/content/playing-cards-vector-png
 * https://i.pinimg.com/originals/10/80/a4/1080a4bd1a33cec92019fab5efb3995d.png
 *
 * ideas:
 * https://stackoverflow.com/questions/22848829/how-do-i-add-an-image-inside-a-rectangle-or-a-circle-in-javafx
 * https://stackoverflow.com/questions/27066484/remove-all-children-from-a-group-without-knowing-the-containing-nodes
 */

public class Main extends Application {

    /* if this is the class we're using for the game I think we should have a method here we can run for ties, a while loop that runs until
    one of the players' decks are 0, and then I'm not sure if we need methods for the actual player since we'll just be using touch events
    with buttons or smth else. we also prob need array lists that represent what cards the players have played on the field.
     */

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        primaryStage.setTitle("War");
        primaryStage.setScene(new Scene(root, 800, 800, Color.BLACK));
        primaryStage.show();


        boolean done = false;

        Deck deck = new Deck();
        deck.Shuffle();
        deck.Cut();
        for (Card c: deck.getFirstHalf()) {
            System.out.println((int)c.suit + "\n");
        }
        System.out.println(deck.getFirstHalf().size());

        Player user = new Player(deck.getFirstHalf());
        Player computer = new Player(deck.getSecondHalf());

        //root.getChildren().add(deck.getFirstHalf().get(0).cardRect);

        GameManager manager = new GameManager(user, computer);
        Button btn = new Button();
        btn.setText("War!");
        root.getChildren().add(btn);

        btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                (manager).nextRound(root);
                if (manager.checkWin() == user) {

                } else if (manager.checkWin() == computer) {

                } else {
                    // Nobody has won
                }
            }
        });

    }


    public static void main(String[] args) {
        launch(args);
    }
}
