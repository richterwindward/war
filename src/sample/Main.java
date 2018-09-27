package sample; // test


import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    /* if this is the class we're using for the game I think we should have a method here we can run for ties, a while loop that runs until
    one of the players' decks are 0, and then I'm not sure if we need methods for the actual player since we'll just be using touch events
    with buttons or smth else. we also prob need array lists that represent what cards the players have played on the field.
     */

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("War");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();

        boolean done = false;

        while(!done) {
            
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
