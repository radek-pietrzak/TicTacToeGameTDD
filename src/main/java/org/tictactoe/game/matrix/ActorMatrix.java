package org.tictactoe.game.matrix;

public class ActorMatrix {

    private String[][] matrix = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};

    public String[][] getMatrix() {
        return matrix;
    }

    public void addActorToMatrix(boolean isX, int position) {
        String actor;

        if (isX) {
            actor = "X";
        } else {
            actor = "O";
        }

        int y = position % 10;
        int x = (position - y) / 10;

        matrix[x - 1][y - 1] = actor;
    }
}
