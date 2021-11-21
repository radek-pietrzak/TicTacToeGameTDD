package org.tictactoe.game.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorMatrixTest {

    ActorMatrix actorMatrix = new ActorMatrix();
    String[][] emptyMatrix = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};

    @Test
    void shouldReturnEmptyMatrix() {

        //given
        //when
        //then
        assertArrayEquals(emptyMatrix, actorMatrix.getMatrix());
    }

    @Test
    void shouldReturnXOnFirstPosition() {

        //given
        String[][] expectedMatrix = {{"X", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};

        //when
        actorMatrix.addActorToMatrix(true,11);

        //then
        assertArrayEquals(expectedMatrix, actorMatrix.getMatrix());

    }
}
