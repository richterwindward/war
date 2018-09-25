package sample; // test


import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println(c1.compareTo(c2));
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
