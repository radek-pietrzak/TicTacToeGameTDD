package org.tictactoe.game.matrix;

public class ActorMatrix {

    private String[][] matrix = {
            {" ", " ", " "},
            {" ", " ", " "},
            {" ", " ", " "}
    };

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

        int x = Integer.parseInt(position.substring(0, 1));
        int y = Integer.parseInt(position.substring(1, 2));

        matrix[y - 1][x - 1] = actor;
    }
}
