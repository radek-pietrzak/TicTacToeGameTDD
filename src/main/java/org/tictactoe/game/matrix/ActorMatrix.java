package org.tictactoe.game.matrix;

public class ActorMatrix {

    private String[][] matrix = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};

    public String[][] getMatrix() {
        return matrix;
    }

    public void addActorToMatrix(boolean isX, String position) {
        String actor;

        if (isX) {
            actor = "X";
        } else {
            actor = "O";
        }

        int intPosition = Integer.parseInt(position);
        int y = intPosition % 10;
        int x = (intPosition - y) / 10;

        matrix[x - 1][y - 1] = actor;
    }
}
