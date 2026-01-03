package Game.Controller;

import Game.Board.Board;
import Game.Food.*;
import Game.Movement.Move;
import Game.Player.Player;
import Game.Snake.Snake;

import java.awt.Point;
import java.util.Random;

public class GameController {

    private static final long TICK_MS = 5000;
    private final Board board;
    private final Snake snake;
    private final Player player;

    private Food food;
    private int score;
    private boolean running;

    public GameController(Board board, Snake snake, Player player) {
        this.board = board;
        this.snake = snake;
        this.player = player;
        this.score = 0;
        this.running = true;
        this.food = spawnFood();
    }

    public int getScore(){
        return this.score;
    }

    public void start() {
        System.out.println("Welcome " + player.getName());
        board.printBoard(snake, food);

        long lastTick = System.currentTimeMillis();

        while (running) {
            long now = System.currentTimeMillis();
            Move move = player.consumeMove();
            if (move != null) {
                snake.changeDirection(move);
                step();
                continue;
            }

            if (now - lastTick >= TICK_MS) {
                step();
                lastTick = now;
            }
        }

        System.out.println("GAME OVER");
        System.out.println("Final Score: " + this.getScore());
    }

    private void step() {
        Point next = snake.nextHead();
        boolean grow = false;

        if (food != null && next.equals(food.getPos())) {
            grow = true;
            this.score += food.getFoodScore();
            food = spawnFood();
        }

        if (!board.canMove(next, grow, snake)) {
            running = false;
            return;
        }

        snake.applyMove(next, grow);

        board.printBoard(snake, food);
        System.out.println("Score: " + this.getScore());
    }

    private Food spawnFood() {
        Random random = new Random();

        while (true) {
            int r = random.nextInt(board.getRows());
            int c = random.nextInt(board.getCols());
            Point p = new Point(r, c);

            if (!snake.occupies(p)) {
                FoodTypes type = random.nextInt(2) == 0
                        ? FoodTypes.BONUS
                        : FoodTypes.DEFAULT;

                return FoodFactory.createFood(type, r, c);
            }
        }
    }
}
