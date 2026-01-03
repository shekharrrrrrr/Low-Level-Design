package Game.Food;

import java.awt.*;

public abstract class Food {
    private final Point foodPos;

    public Food(int row, int col) {
        this.foodPos = new Point(row, col);
    }

    public abstract int getFoodScore();

    public Point getPos() {
        return foodPos;
    }
}
