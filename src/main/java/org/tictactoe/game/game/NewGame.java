package org.tictactoe.game.game;

import org.tictactoe.game.map.GameMap;
import org.tictactoe.game.matrix.ActorMatrix;

import java.util.Objects;
import java.util.Scanner;

public class NewGame {

    GameMap gameMap = new GameMap();
    private boolean xFlag = true;

    public boolean isxFlag() {
        return xFlag;
    }

    public void startNewGame(ActorMatrix actorMatrix) {

        System.out.println("Hello!! Can we start new Game?");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        do {

            if (Objects.equals(input, "y")) {
                System.out.println("Starting game");
                gameMap.createGameMap(actorMatrix);
                startTurn(true, actorMatrix);
                return;
            } else if (Objects.equals(input, "n")) {
                System.out.println("Bye!!");
                return;
            }

            System.out.println("Type y or n");

        } while (!Objects.equals(input, "y") && !Objects.equals(input, "n"));
    }

    public void startTurn(boolean isX, ActorMatrix actorMatrix) {

        if (isFirstRowMatch(actorMatrix)) {
            System.out.println(actorMatrix.getMatrix()[0][0] + " wins");
            return;
        }
        if (isSecondRowMatch(actorMatrix)) {
            System.out.println(actorMatrix.getMatrix()[1][0] + " wins");
            return;
        }
        if (isThirdRowMatch(actorMatrix)) {
            System.out.println(actorMatrix.getMatrix()[2][0] + " wins");
            return;
        }
        if (isFirstColumnMatch(actorMatrix)) {
            System.out.println(actorMatrix.getMatrix()[0][0] + " wins");
            return;
        }
        if (isSecondColumnMatch(actorMatrix)) {
            System.out.println(actorMatrix.getMatrix()[0][1] + " wins");
            return;
        }
        if (isThirdColumnMatch(actorMatrix)) {
            System.out.println(actorMatrix.getMatrix()[0][2] + " wins");
            return;
        }
        if (isFirstSlantMatch(actorMatrix)) {
            System.out.println(actorMatrix.getMatrix()[0][0] + " wins");
            return;
        }
        if (isSecondSlantMatch(actorMatrix)) {
            System.out.println(actorMatrix.getMatrix()[0][2] + " wins");
            return;
        }


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

    private boolean isFirstRowMatch(ActorMatrix actorMatrix) {
        return (Objects.equals(actorMatrix.getMatrix()[0][0], "X") ||
                Objects.equals(actorMatrix.getMatrix()[0][0], "O")) &&
                Objects.equals(actorMatrix.getMatrix()[0][0], actorMatrix.getMatrix()[0][1]) &&
                Objects.equals(actorMatrix.getMatrix()[0][2], actorMatrix.getMatrix()[0][1]);
    }

    private boolean isSecondRowMatch(ActorMatrix actorMatrix) {
        return (Objects.equals(actorMatrix.getMatrix()[1][0], "X") ||
                Objects.equals(actorMatrix.getMatrix()[1][0], "O")) &&
                Objects.equals(actorMatrix.getMatrix()[1][0], actorMatrix.getMatrix()[1][1]) &&
                Objects.equals(actorMatrix.getMatrix()[1][2], actorMatrix.getMatrix()[1][1]);
    }

    private boolean isThirdRowMatch(ActorMatrix actorMatrix) {
        return (Objects.equals(actorMatrix.getMatrix()[2][0], "X") ||
                Objects.equals(actorMatrix.getMatrix()[2][0], "O")) &&
                Objects.equals(actorMatrix.getMatrix()[2][0], actorMatrix.getMatrix()[2][1]) &&
                Objects.equals(actorMatrix.getMatrix()[2][2], actorMatrix.getMatrix()[2][1]);
    }

    private boolean isFirstColumnMatch(ActorMatrix actorMatrix) {
        return (Objects.equals(actorMatrix.getMatrix()[0][0], "X") ||
                Objects.equals(actorMatrix.getMatrix()[0][0], "O")) &&
                Objects.equals(actorMatrix.getMatrix()[0][0], actorMatrix.getMatrix()[1][0]) &&
                Objects.equals(actorMatrix.getMatrix()[2][0], actorMatrix.getMatrix()[1][0]);
    }

    private boolean isSecondColumnMatch(ActorMatrix actorMatrix) {
        return (Objects.equals(actorMatrix.getMatrix()[0][1], "X") ||
                Objects.equals(actorMatrix.getMatrix()[0][1], "O")) &&
                Objects.equals(actorMatrix.getMatrix()[0][1], actorMatrix.getMatrix()[1][1]) &&
                Objects.equals(actorMatrix.getMatrix()[2][1], actorMatrix.getMatrix()[1][1]);
    }

    private boolean isThirdColumnMatch(ActorMatrix actorMatrix) {
        return (Objects.equals(actorMatrix.getMatrix()[0][2], "X") ||
                Objects.equals(actorMatrix.getMatrix()[0][2], "O")) &&
                Objects.equals(actorMatrix.getMatrix()[0][2], actorMatrix.getMatrix()[1][2]) &&
                Objects.equals(actorMatrix.getMatrix()[2][2], actorMatrix.getMatrix()[1][2]);
    }

    private boolean isFirstSlantMatch(ActorMatrix actorMatrix) {
        return (Objects.equals(actorMatrix.getMatrix()[0][0], "X") ||
                Objects.equals(actorMatrix.getMatrix()[0][0], "O")) &&
                Objects.equals(actorMatrix.getMatrix()[0][0], actorMatrix.getMatrix()[1][1]) &&
                Objects.equals(actorMatrix.getMatrix()[2][2], actorMatrix.getMatrix()[1][1]);
    }

    private boolean isSecondSlantMatch(ActorMatrix actorMatrix) {
        return (Objects.equals(actorMatrix.getMatrix()[0][2], "X") ||
                Objects.equals(actorMatrix.getMatrix()[0][2], "O")) &&
                Objects.equals(actorMatrix.getMatrix()[0][2], actorMatrix.getMatrix()[1][1]) &&
                Objects.equals(actorMatrix.getMatrix()[2][0], actorMatrix.getMatrix()[1][1]);
    }


}
