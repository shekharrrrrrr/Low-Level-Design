import Game.Board.Board;
import Game.Controller.GameController;
import Game.Player.Player;
import Game.Snake.Snake;

public static void main(String[] args) {
    Snake snake = new Snake(5, 5);
    Board board = new Board(10, 10);
    Player player = new Player("Shekhar");
    GameController game = new GameController(board, snake, player);
    game.start();
}
