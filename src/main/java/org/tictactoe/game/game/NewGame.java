package org.tictactoe.game.game;

import org.tictactoe.game.map.GameMap;
import org.tictactoe.game.matrix.ActorMatrix;

import java.util.Objects;
import java.util.Scanner;

public class NewGame {

    GameMap gameMap = new GameMap();
    ActorMatrix actorMatrix = new ActorMatrix();

    public void startNewGame() {

        System.out.println("Hello!! Can we start new Game?");

        processUserInputOnStartNewGame();
    }

    private void processUserInputOnStartNewGame() {
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


}
