import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Engine engine = new Engine();
        engine.print_board();
        boolean playerTurn = true  ;
        Scanner sc = new Scanner(System.in);
        while(engine.get_winner() == 0 && !engine.board_full())
        {
            if(playerTurn){
                String input = sc.nextLine();
                switch (input){
                    case "q":
                        engine.set_board_comp(0,0,2);
                        break;
                    case "w":
                        engine.set_board_comp(0,1,2);
                        break;
                    case "e":
                        engine.set_board_comp(0,2,2);
                        break;
                    case "a":
                        engine.set_board_comp(1,0,2);
                        break;
                    case "s":
                        engine.set_board_comp(1,1,2);
                        break;
                    case "d":
                        engine.set_board_comp(1,2,2);
                        break;
                    case "z":
                        engine.set_board_comp(2,0,2);
                        break;
                    case "x":
                        engine.set_board_comp(2,1,2);
                        break;
                    case "c":
                        engine.set_board_comp(2,2,2);
                        break;
                }
            }
            else{
                engine.bot_move();
            }
            engine.print_board();
            playerTurn = !playerTurn;
        }

        int winner = engine.get_winner();
        if      (winner == 1) { System.out.println("Computer Wins");}
        else if (winner == 2) { System.out.println("You Win");}
        else                  { System.out.println("Tie");}
    }
}
