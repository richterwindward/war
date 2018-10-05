package sample;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Card implements Comparable<Card> {
    final static char[] suits = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    final static String clubsSuffix = "_of_clubs.png";
    final static String diamondsSuffix = "_of_diamonds.png";
    final static String heartsSuffix = "_of_hearts.png";
    final static String spadesSuffix = "_of_spades.png";

    public Image cardImage;
    public Rectangle cardRect;

    public char suit;
    private String[] paths;
    private String imagePath;

    public Card(char suit) {
        this.suit = suit;
        this.paths = this.toURL();
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
        this.cardImage = new Image(this.imagePath);
        System.out.println(this.imagePath);
        this.cardRect = new Rectangle(100, 100, 240, 360);
        this.cardRect.setFill(new ImagePattern(this.cardImage));
    }

    public String getImagePath() {
        return imagePath;
    }

    public String[] getPaths() {
        return paths;
    }

    private String[] toURL() {
        Path currentRelativePath = Paths.get("");
        String relPath = currentRelativePath.toAbsolutePath().toString() + "/PNG-cards-1.3/";
        if(suit >= 2 && suit <= 10) {
            String prefix = "file://" + relPath +  String.valueOf((int)suit);
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
                    prefix = "file://" + relPath + "jack";
                case 12:
                    // queen
                    prefix = "file://" + relPath + "queen";
                case 13:
                    // king
                    prefix =  "file://" + relPath + "king";
                case 14:
                    // ace
                    prefix =  "file://" + relPath + "ace";
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
