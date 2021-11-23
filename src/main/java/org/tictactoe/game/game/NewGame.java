package org.tictactoe.game.game;

import org.tictactoe.game.map.GameMap;
import org.tictactoe.game.matrix.ActorMatrix;

import java.util.Objects;
import java.util.Scanner;

public class NewGame {

    GameMap gameMap = new GameMap();
    ActorMatrix actorMatrix = new ActorMatrix();
    private boolean xFlag = true;

    public boolean isxFlag() {
        return xFlag;
    }

    public void startNewGame() {

        System.out.println("Hello!! Can we start new Game?");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        do {
            System.out.println("Type y or n");
            if (Objects.equals(input, "y")) {
                System.out.println("Starting game");
                gameMap.createGameMap(actorMatrix);
                return;
            } else if (Objects.equals(input, "n")) {
                System.out.println("Bye!!");
                return;
            }
        } while (!Objects.equals(input, "y") && !Objects.equals(input, "n"));
    }

    public void startTurn(boolean isX) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (isX) {
            System.out.println("X turn");

            actorMatrix.addActorToMatrix(true, input);
            gameMap.createGameMap(actorMatrix);

            this.xFlag = false;
        } else {
            System.out.println("O turn");
            this.xFlag = true;
        }
    }


}
