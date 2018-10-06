package sample; // test


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
 *
 * shuffle:
 * https://docs.oracle.com/javase/6/docs/api/java/util/Collections.html
 */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // gui setup stuff
        Group root = new Group();
        primaryStage.setTitle("War");
        primaryStage.setScene(new Scene(root, 800, 800, Color.BLACK));
        primaryStage.show();

        Label gameStatus = new Label("Press War to start a new round.");

        gameStatus.setLayoutX(400);
        gameStatus.setLayoutY(400);

        root.getChildren().add(gameStatus);

        Deck deck = new Deck();
        deck.Shuffle();
        deck.Cut();

        Player user = new Player(deck.getFirstHalf());
        Player computer = new Player(deck.getSecondHalf());

        GameManager manager = new GameManager(user, computer);
        Button btn = new Button();
        btn.setText("War!");
        root.getChildren().add(btn);

        btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                int result = (manager).nextRound(root); // returns 1 on user win and 2 on cpu win

                if(result == 1) {
                    gameStatus.setText("User wins round!");
                } else {
                    gameStatus.setText("Computer wins round!");
                }
                if (manager.checkWin() == user) {
                    gameStatus.setText("User wins it all!");
                } else if (manager.checkWin() == computer) {
                    gameStatus.setText("Computer wins it all!");

                } else {
                    // Nobody has won
                    root.getChildren().add(btn);
                }
                root.getChildren().add(gameStatus);
            }
        });

    }


    public static void main(String[] args) {
        launch(args);
    }
}
