package sample;

import java.util.ArrayList;

public class AI_Player {
    private ArrayList<Card> deck;

    public AI_Player(ArrayList<Card> deck){
        this.deck = deck;
    }

    // assuming we use an arraylist to represent the field, I think we'll have to have one for each player but in the main class

    public void PlayCard(){
        //TODO: play(copy?) first card onto something (will be first card in deck, and will prob add it to some arraylist that represents the field)
        //TODO: remove the first card from deck
    }

    public void tiePlayCard(){
        //TODO: add first 3 cards face down (skip their indexes in the new arraylist) to the field arraylist
        //TODO: add new card face up (use this index, will be 3, 7, 11 etc depending on how many consecutive ties there are)
    }
}
