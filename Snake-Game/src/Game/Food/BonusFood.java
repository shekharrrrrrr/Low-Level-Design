package Game.Food;

class BonusFood extends Food {

    public BonusFood(int row, int col) {
        super(row, col);
    }

    @Override
    public int getFoodScore() {
        return 2;
    }
}
