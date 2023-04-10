This project creates a bot that can play tic tac toe using Minimax algorithm. The implementation is made in multiple languages, and eventually a physical version using arduino will be made.

---

## Minimax Algorithm

Minimax Algorithm provides the player with the best move, assuming that the opponent player will make the most optimal move in their turn. This algorithm is often used for two-player turn based games, such as tic tac toe. In this project, the bot opponent will determine its moves based on the minimax algorithm.

Here is a simple explanation of how this algorithm works. There will be two players: the `maximizing player` and the `minimizing player`. Once the algorithm is told to determine certain player's move, it goes through the following process. First, the algorithm examines all possible moves that the player can make. Then, it assigns values to those moves through evaluating gameboard that is produced as a result of the moves. Typically, positive number is assigned if the `maximizing player` is winning in given gameboard, and negative number is assigned if the `minimizing player` is winning. Finally, the algorithm returns "most optimal" move for the given player. This would be the move with the highest value for the `maximizing player` and the move with the lowest value for the `minimizing player`

---

### Determining Value of a Gameboard(Tic Tac Toe)

There will be two different ways to determine the value depending on the gameboard's state.

First type of board is a board that reached the end state. In tic tac toe, this will be when no more moves are possible or when a winner is determined. In this case, if the `maximizing player` won, the board is given a value of 10 and if `minimizing player` won, the board is given a value of -10. If there is no winner, the board will get a value of 0.

Second type of board is a board that did not reach the end state yet. In this case, the value of a board is determined based on next moves that will be made. The algorithm examines all board that can result out of current board. If the current player is the `mazimizing player`, current board's value will be same as the value of a future board with the largest value. For the `minimizing player`, the value will be same as the value of a future board with the smalles value.

It is noticible that this algorithm will result in recurssion, because most boards will need to examine its future board until it reaches the end state recurssivly.
