public class Engine {
    private final int[][] board;
    private final int DEFAULT_DEPTH = 3;
    int maxDepth;
    public Engine()
    {
        maxDepth = DEFAULT_DEPTH;
        //Initialize the game board
        board = new int[3][3];
        for(int i = 3; i < 3; i++)
            for (int j = 3; j < 3; j++)
                board[i][j] = 0;
    }



    public void print_board()
    {
        //prints the board to System.out
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print("[" );
                if      (board[i][j] == 1)  {System.out.print("O" );}
                else if (board[i][j] == 2)  {System.out.print("X" );}
                else                        {System.out.print(" " );}
                System.out.print("]" );
            }
            System.out.println();
        }

        System.out.println("--------------------------------------------");
    }

    public void set_board_comp(int row, int col, int player)
    {
        board[row][col] = player;
    }




    public void bot_move()
    {
        int move = -1;
        int moveValue = Integer.MIN_VALUE;

        for(int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if(board[row][col] == 0){
                    int[][] newBoard = get_new_board();
                    newBoard[row][col] = 1;
                    int value = minimax(newBoard, false, 0);
                    if(value > moveValue){
                        moveValue = value;
                        move = (row * 10) + col;
                    }
                }
            }
        }
        set_board_comp(move / 10, move % 10, 1);
    }


    public int minimax(int[][] curBoard, boolean playerOne, int depth)
    {
        if(board_full(curBoard) || get_winner(curBoard) != 0 || depth >= maxDepth){
            if      (get_winner(curBoard) == 1) {return 10 - depth;}
            else if (get_winner(curBoard) == 2) {return depth - 10;}
            else                                {return 0;}
        }

        if(playerOne){
            int value = Integer.MIN_VALUE;
            for(int row = 0; row < 3; row++){
                for(int col = 0; col < 3; col++){
                    if(curBoard[row][col] == 0){
                        int[][] newBoard = get_new_board();
                        newBoard[row][col] = 1;
                        value = Math.max(value, minimax(newBoard, false, depth + 1));
                    }
                }
            }
            return value;
        }
        else{   //Player 2
            int value = Integer.MAX_VALUE;
            for(int row = 0; row < 3; row++){
                for(int col = 0; col < 3; col++){
                    if(curBoard[row][col] == 0){
                        int[][] newBoard = get_new_board();
                        newBoard[row][col] = 2;
                        value = Math.min(value, minimax(newBoard, true, depth + 1));
                    }
                }
            }
            return value;
        }
    }



    public boolean board_full()
    {
        return  board_full(board);
    }


    public boolean board_full(int[][] curBoard)
    {
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if (curBoard[i][j] == 0)
                    return false;
        return true;
    }

    public int get_winner()
    {
        return get_winner(board);
    }

    public int get_winner(int[][] curBoard)
    {
        for (int row = 0; row < curBoard.length; row++)
            if (curBoard[row][0] != 0 && curBoard[row][0] == curBoard[row][1] && curBoard[row][0] == curBoard[row][2]) {
                return curBoard[row][0];
            }

        // Check columns for a winner
        for (int col = 0; col < curBoard[0].length; col++) {
            if (curBoard[0][col] != 0 && curBoard[0][col] == curBoard[1][col] && curBoard[0][col] == curBoard[2][col])
                return curBoard[0][col];
        }

        // Check diagonals for a winner
        if (curBoard[0][0] != 0 && curBoard[0][0] == curBoard[1][1] && curBoard[0][0] == curBoard[2][2]) {
            return curBoard[0][0];
        }
        if (curBoard[0][2] != 0 && curBoard[0][2] == curBoard[1][1] && curBoard[0][2] == curBoard[2][0]) {
            return curBoard[0][2];
        }

        // No winner found
        return 0;
    }

    public int[][] get_new_board()
    {
        int[][] newBoard = new int[3][3];
        for(int i = 0; i < 3; i++)
        {
            newBoard[i] = board[i].clone();
        }
        return newBoard;
    }
}
