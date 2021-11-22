package org.tictactoe.game.map;

import org.tictactoe.game.matrix.ActorMatrix;

public class GameMap {

    public void createGameMap(ActorMatrix actorMatrix) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(actorMatrix.getMatrix()[i][j]);
                if (j < 2)
                    sb.append("|");
                else if (i < 2)
                    sb.append("\n");
            }
            if (i < 2)
                sb.append("-+-+-\n");
        }

        System.out.print(sb);

    }


}
