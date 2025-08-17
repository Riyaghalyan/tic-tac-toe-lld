package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class demo {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("TIC TAC TOE \uD83C\uDFB2");
        System.out.println("pls enter no of players playing");
        int no_of_players = scn.nextInt();
        scn.nextLine();
        List<Player> players = new ArrayList<>();
        int k = 1;
        while(k < no_of_players + 1){
            System.out.println("Player " + k + " : please enter your name");
            String name = scn.nextLine();

            System.out.println("Choose a symbol");
            String symbol = scn.nextLine();
            Player p = new Player(name, symbol);
            players.add(p);
            k++;
        }
        System.out.println("Enter Board size");
        int n = scn.nextInt();
        Game game = new Game(n , players);
        game.playGame();
    }
}
