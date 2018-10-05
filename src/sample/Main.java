package sample; // test


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
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
        primaryStage.setScene(new Scene(root, 1300, 800, Color.BLACK));
        primaryStage.show();


        boolean done = false;

        Deck deck = new Deck();
        deck.Cut();
        deck.Shuffle();
        System.out.println(deck.getFirstHalf().size());


/**
 *  If we have the button class in the while loop we can just clear the board (literally delete everything) at the end
 *  of each iteration if memory/lag becomes a problem and it should be fine.
 */
        /*
        while(!done) {

            Button btn = new Button();
            btn.setText("War!");

            btn.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
                    (GameManager object).nextRound(root);
                }
            });

        }
        */
    }


    public static void main(String[] args) {
        launch(args);
    }
}
