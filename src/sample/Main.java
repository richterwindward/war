package sample; // test


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;

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

        // root.getChildren().add(deck.getFirstHalf().get(0).cardRect);

        GameManager manager = new GameManager(user, computer);

        manager.nextRound(root);


        /*
        while(!done) {
            
        }
        */
    }


    public static void main(String[] args) {
        launch(args);
    }
}
