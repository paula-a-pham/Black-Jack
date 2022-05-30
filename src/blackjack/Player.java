package blackjack;

public class Player 
{
    private String Name;
    private int Score = 0;
    private Card[] player_card = new Card[11];
    private int count = 0 ;
    private boolean blackjack = false;
    private boolean win = false;

    public void add_card(Card card)
    {
        player_card[count] = card;
        setScore(getScore() + card.getValue());
        count++ ;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public Card[] getPlayer_card() {
        return player_card;
    }

    public void setPlayer_card(Card[] player_card) {
        this.player_card = player_card;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isBlackjack() {
        return blackjack;
    }

    public void setBlackjack(boolean blackjack) {
        this.blackjack = blackjack;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
    
}
