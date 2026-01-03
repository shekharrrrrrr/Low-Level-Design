package Game.Food;

class DefaultFood extends Food {

    public DefaultFood(int row, int col) {
        super(row, col);
    }

    @Override
    public int getFoodScore() {
        return 1;
    }
}
