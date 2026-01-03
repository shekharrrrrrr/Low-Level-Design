package Game.Board;

import Game.Food.Food;
import Game.Snake.Snake;
import java.awt.Point;

public class Board {

    private final int rows;
    private final int cols;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    private boolean isWallCollision(Point pos) {
        return pos.x < 0 || pos.y < 0 || pos.x >= this.rows || pos.y >= this.cols;
    }
    private boolean isSelfCollision(Point pos, boolean grow, Snake snake) {
        if (!snake.occupies(pos)) {
            return false;
        }
        return !(pos.equals(snake.getTail()) && !grow);
    }

    public boolean canMove(Point next, boolean grow, Snake snake) {
        return !isSelfCollision(next, grow,snake) && !isWallCollision(next);
    }

    public void printBoard(Snake snake, Food food) {
        char[][] grid = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = '.';
            }
        }

        if (food != null) {
            Point f = food.getPos();
            grid[f.x][f.y] = 'F';
        }

        for (Point p : snake.getBody()) {
            grid[p.x][p.y] = 'S';
        }

        Point head = snake.getHead();
        grid[head.x][head.y] = 'H';

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
