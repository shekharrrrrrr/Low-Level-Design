package Game.Player;

import Game.Movement.Move;
import java.util.Scanner;

public class Player {

    private final String name;
    private Move latestMove;

    public Player(String name) {
        this.name = name;
        printControls();
        startInputThread();
    }

    private void printControls() {
        System.out.println("Controls:");
        System.out.println("  W → Up");
        System.out.println("  S → Down");
        System.out.println("  A → Left");
        System.out.println("  D → Right");
        System.out.println("---------------------------");
    }

    private void startInputThread() {
        Thread inputThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String input = scanner.nextLine().trim().toUpperCase();
                Move move = Move.getMovementKey(input);
                if (move != null) {
                    setLatestMove(move);
                }
            }
        });
        inputThread.setDaemon(true);
        inputThread.start();
    }

    public String getName() {
        return name;
    }

    private synchronized void setLatestMove(Move move) {
        this.latestMove = move;
    }

    public synchronized Move consumeMove() {
        Move move = this.latestMove;
        this.latestMove = null;
        return move;
    }
}
