package Game.Food;

public class FoodFactory {
    public static Food createFood(FoodTypes type, int row, int col) {
        switch(type) {
            case BONUS:
                return new BonusFood(row, col);
            case DEFAULT:
            default:
                return new DefaultFood(row, col);
        }
    }
}
