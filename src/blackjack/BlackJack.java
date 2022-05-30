package blackjack;

import java.util.Scanner;

public class BlackJack {

    static Game play = new Game();
    
    public static void main(String[] args) 
    {
        GUI gui = new GUI();

        play.generate_card_deck();       
        play.set_player();
        
        gui.runGUI( play.getCard_deck(), play.getPlayer()[0].getPlayer_card(), play.getPlayer()[1].getPlayer_card(), play.getPlayer()[2].getPlayer_card(), play.getPlayer()[3].getPlayer_card() );
               
        player_turn(gui);
        dilar_turn(gui);
    }
    
    public static void player_turn(GUI gui)
    {
        Scanner input = new Scanner(System.in);
        for(int i = 0 ; i < 3 ; i++)
        {
            int x = 0;
            System.out.println("Turn of Player " + (i+1) + " with score : " + play.getPlayer()[i].getScore());
            while(true)
            {
                System.out.println("1 - hit\n2 - stand");
                x = input.nextInt();
                if(x == 1)
                {
                    Card card = play.draw();
                    play.getPlayer()[i].add_card(card);
                    System.out.println("your score :" + play.getPlayer()[i].getScore());
                    gui.updatePlayerHand(card , i);
                    continue;
                }
                else if(x == 2)
                {
                    break;
                }
                else
                {
                    System.out.println("invalid choice");
                }
            }
        }
    }
    public static void dilar_turn(GUI gui)
    {
        play.update_score();
        System.out.println("Turn of Dilar with score : " + play.getPlayer()[3].getScore());

        if(play.getPlayer()[3].getScore() > play.getHigh_score() && play.getPlayer()[3].getScore() <= 21)
        {
            
            gui.updateDealerHand(play.getPlayer()[3].getPlayer_card()[(play.getPlayer()[3].getCount() - 1)],play.getCard_deck());
            System.out.println("Dilar win");
        }

        else if(play.getPlayer()[3].getScore() <= play.getHigh_score())
        {
            while(true)
            {
                Card card = play.draw();
                play.getPlayer()[3].add_card(card);
                
                if(play.getPlayer()[3].getScore() == play.getHigh_score())
                {
                    
                    gui.updateDealerHand(card,play.getCard_deck());
                    System.out.println("Dilar with score : " + play.getPlayer()[3].getScore());
                    continue;                    
                }
                else if(play.getPlayer()[3].getScore() < play.getHigh_score())
                {
                    
                    gui.updateDealerHand(card,play.getCard_deck());
                    System.out.println("Dilar with score : " + play.getPlayer()[3].getScore());
                    continue;
                }

                else if(play.getPlayer()[3].getScore() > play.getHigh_score() && play.getPlayer()[3].getScore() <= 21)
                {

                    gui.updateDealerHand(card,play.getCard_deck());
                    System.out.println("Dilar with score : " + play.getPlayer()[3].getScore());
                    System.out.println("Dilar win");
                    break;
                }
                else if(play.getPlayer()[3].getScore() > 21)
                {

                    gui.updateDealerHand(card,play.getCard_deck());
                    System.out.println("Dilar with score : " + play.getPlayer()[3].getScore());
                    System.out.println("Dilar busts");
                    
                    winner();

                    
                    break;
                }
            }
        }
    }
    public static void winner()
    {
        play.update_score();
        
        if(play.getHigh_score() == play.getPlayer()[0].getScore())
        {
            if(play.getPlayer()[0].getScore() == play.getPlayer()[1].getScore())
            {
                
                if(play.getPlayer()[0].getScore() == play.getPlayer()[2].getScore())
                {
                    System.out.println("PUSH");
                }
                System.out.println("PUSH");
            }
            else if(play.getPlayer()[0].getScore() == play.getPlayer()[2].getScore())
                {
                    System.out.println("PUSH");
                }
            else
            System.out.println("player 1 win");
        }
        else if (play.getHigh_score() == play.getPlayer()[1].getScore())
        {
            if(play.getPlayer()[1].getScore() == play.getPlayer()[0].getScore())
            {
                
                if(play.getPlayer()[1].getScore() == play.getPlayer()[2].getScore())
                {
                    System.out.println("PUSH");
                }
                System.out.println("PUSH");
            }
            else if(play.getPlayer()[1].getScore() == play.getPlayer()[2].getScore())
                {
                    System.out.println("PUSH");
                }
            else
            System.out.println("player 2 win");
        }
        else if (play.getHigh_score() == play.getPlayer()[2].getScore())
        {
            if(play.getPlayer()[2].getScore() == play.getPlayer()[0].getScore())
            {
                
                if(play.getPlayer()[2].getScore() == play.getPlayer()[1].getScore())
                {
                    System.out.println("PUSH");
                }
                System.out.println("PUSH");
            }
            else if(play.getPlayer()[2].getScore() == play.getPlayer()[1].getScore())
                {
                    System.out.println("PUSH");
                }
            else
            System.out.println("player 3 win");
        }
    }
}
