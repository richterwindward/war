package sample;

public class GameManager {
    private Player p1;
    private Player p2;

    public GameManager(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public int nextRound() {
        Card playerOneCard = this.p1.playCard();
        Card playerTwoCard = this.p2.playCard();

        if (playerOneCard.compareTo(playerTwoCard) > 0) {
            /* Player one wins */
            this.p1.addCard(playerOneCard, 0);
            this.p1.addCard(playerTwoCard, 0);
            return 1;
        } else if(playerOneCard.compareTo(playerTwoCard) < 0) {
            /* Player two wins */
            this.p2.addCard(playerOneCard, 0);
            this.p2.addCard(playerTwoCard, 0);
            return 1;
        } else {
            /* Tie */
        }
    }

    private Player checkWin() {
        if (this.p1.cardCount() == 0)
            return this.p2;
        else if (this.p2.cardCount() == 0)
            return this.p1;
        else
            return null;
    }
}
