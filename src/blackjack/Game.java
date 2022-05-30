package blackjack;
import java.util.Random;
import java.util.Scanner;

public class Game 
{
    Scanner input = new Scanner(System.in);
    private Player[] player = new Player[4];
    private Card[] card_deck = new Card[52];
    private  int high_score;
    
    public void generate_card_deck()
    {
        int i = 0;
        int count = 0;
        while(i<4)
        {
            for(int j = 1 ; j < 14 ; j++)
            {
                if(j < 10)
                {
                    card_deck[count] = new Card(i,j-1,j);
                    count++;
                }
                else
                {
                    card_deck[count] = new Card(i,j-1,10);
                    count++;
                }
            }
            i++;
        }

             
    }
    
    public Card draw()
    {
        Random rand = new Random();
        while(true)
        {
            int random_choice = rand.nextInt(52);
            if(card_deck[random_choice] != null)
            {
                Card draw = new Card(card_deck[random_choice]);
                card_deck[random_choice] = null ;
                return draw;
            }
            else
            {
                continue ;
            }
        }  
    }
    public void set_player()
    {
        for(int i = 0 ; i < 3 ; i++)
        {
            player[i] = new Player();
            System.out.print("enter the name of player " + (i+1) + " : ");
            player[i].setName(input.next());
            player[i].add_card(this.draw());
            player[i].add_card(this.draw());
        }
        player[3] = new Player();
        player[3].setName("Dilar");
        player[3].add_card(this.draw());
        player[3].add_card(this.draw());
    }
    public void update_score()
    {
        int a = player[0].getScore();
        int b = player[1].getScore();
        int c = player[2].getScore();

        if(a <= 21)
        {
            high_score = a;
            if(b > high_score && b <=21)
            {
                high_score = b;
                if(c > high_score && c <= 21)
                {
                    high_score = c;
                }
            }
            else if(c > high_score && c <= 21)
            {
                high_score = c;
            }
        }
        else if(b <= 21)
        {
            high_score = b;
            if(a > high_score && a <=21)
            {
                high_score = a;
                if(c > high_score && c <= 21)
                {
                    high_score = c;
                }
            }
            else if(c > high_score && c <= 21)
            {
                high_score = c;
            }
        }
        else if(c <= 21)
        {
            high_score = c;
            if(a > high_score && a <=21)
            {
                high_score = a;
                if(b > high_score && b <= 21)
                {
                    high_score = b;
                }
            }
            else if(b > high_score && b <= 21)
            {
                high_score = b;
            }
        }
    }
    
    public Scanner getInput() {
        return input;
    }

    public Player[] getPlayer() {
        return player;
    }

    public Card[] getCard_deck() {
        return card_deck;
    }

    public int getHigh_score() {
        return high_score;
    }
    
    
}
