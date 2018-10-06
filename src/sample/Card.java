package sample;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class that represents any of the 52 cards
 */
public class Card implements Comparable<Card> {
    final static char[] suits = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}; // values for cards with 11, 12, 13, and 14 being the face cards

    // the four suits for the file paths
    final static String clubsSuffix = "_of_clubs.png";
    final static String diamondsSuffix = "_of_diamonds.png";
    final static String heartsSuffix = "_of_hearts.png";
    final static String spadesSuffix = "_of_spades.png";

    public Image cardImage; // image that matches a card's number and suit
    public Rectangle cardRect; // a rectangle who is filled with the card's image

    public char suit; // card's value (i.e. 1 or 7 or ace)
    private String[] paths; // card's image path options (one for each suit)
    private String imagePath; // card's image path with decided suit

    // initializes a card given its value
    public Card(char suit) {
        this.suit = suit;
        this.paths = this.toURL(); // sets field paths equal to the potential image paths for the card with its specific value
    }

    // sets field imagePath equal to the image path for the card's image
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
        this.cardImage = new Image(this.imagePath);

        System.out.println(this.imagePath);

        // makes the rectangle object that represents the card with its image
        this.cardRect = new Rectangle(315, 50, 170, 250);
        this.cardRect.setFill(new ImagePattern(this.cardImage));
    }


    // getters
    public String getImagePath() {
        return imagePath;
    }
    public String[] getPaths() {
        return paths;
    }


    // returns an array with the four potential image paths (one for each suit) for the card
    private String[] toURL() {
        Path currentRelativePath = Paths.get(""); // gets local path
        String relPath = currentRelativePath.toAbsolutePath().toString() + "/PNG-cards-1.3/"; // adds the part of the file path at the end that will always be the same
        if(suit >= 2 && suit <= 10) { // the file paths for the non face cards
            String prefix = "file://" + relPath +  String.valueOf((int)suit); // adds the part of the file path at the beginning that is always the same
            String[] res = { // includes the options for the four suits
                    prefix + clubsSuffix,
                    prefix + diamondsSuffix,
                    prefix + heartsSuffix,
                    prefix + spadesSuffix
            };
            return res; // array with the four complete file paths
        } else { // same as above but instead of just using the number in the file path, has to use the names of the face cards
            String prefix = "*";

            switch (suit) { // cases where each card value (number) corresponds to the name of a face
                case 11:
                    // jack
                    prefix = "file://" + relPath + "jack";
                    break;
                case 12:
                    // queen
                    prefix = "file://" + relPath + "queen";
                    break;
                case 13:
                    // king
                    prefix =  "file://" + relPath + "king";
                    break;
                case 14:
                    // ace
                    prefix =  "file://" + relPath + "ace";
                    break;
            }
            String[] res = { // four suits
                    prefix + clubsSuffix,
                    prefix + diamondsSuffix,
                    prefix + heartsSuffix,
                    prefix + spadesSuffix
            };

            return res; // array with four potential file paths
        }
    }

    @Override
    public int compareTo(Card card) { // compareTo that compares card value and ignores suit
        return this.suit - card.suit;
    }
}
