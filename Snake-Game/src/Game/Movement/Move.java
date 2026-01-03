package Game.Movement;

public enum Move {
    UP(-1, 0, "W"),
    DOWN(1, 0, "S"),
    LEFT(0, -1, "A"),
    RIGHT(0, 1, "D");

    public final int dx;
    public final int dy;
    private final String key;

    Move(int dx, int dy, String key) {
        this.dx = dx;
        this.dy = dy;
        this.key = key;
    }
    public static Move getMovementKey(String input) {
        for (Move m : values()) {
            if (m.key.equals(input)) {
                return m;
            }
        }
        return null;
    }
}
