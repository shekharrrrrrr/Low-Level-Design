package Game.Snake;
import Game.Movement.Move;
import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Deque;

public class Snake {

    private Deque<Point> body;
    private Move direction;

    public Snake(int startRow, int startCol) {
        body = new ArrayDeque<>();
        body.addFirst(new Point(startRow, startCol));
        direction = Move.RIGHT;
    }

    public Point nextHead() {
        Point head = body.peekFirst();
        return new Point(
                head.x + direction.dx,
                head.y + direction.dy
        );
    }

    public void applyMove(Point newHead, boolean grow) {
        body.addFirst(newHead);
        if (!grow) {
            body.removeLast();
        }
    }

    public void changeDirection(Move newDirection) {
        this.direction = newDirection;
    }

    public boolean occupies(Point p) {
        return body.contains(p);
    }

    public Point getTail() {
        return body.peekLast();
    }

    public Deque<Point> getBody() {
        return body;
    }

    public Point getHead() {
        return body.peekFirst();
    }
}
