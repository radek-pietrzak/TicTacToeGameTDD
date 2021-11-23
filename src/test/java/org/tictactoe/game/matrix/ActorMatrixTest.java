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
        actorMatrix.addActorToMatrix(true,"11");

        //then
        assertArrayEquals(expectedMatrix, actorMatrix.getMatrix());

    }

    @Test
    void shouldReturnXXXOnSlant() {

        //given
        String[][] expectedMatrix = {{"X", " ", " "}, {" ", "X", " "}, {" ", " ", "X"}};

        //when
        actorMatrix.addActorToMatrix(true,"11");
        actorMatrix.addActorToMatrix(true,"22");
        actorMatrix.addActorToMatrix(true,"33");

        //then
        assertArrayEquals(expectedMatrix, actorMatrix.getMatrix());

    }

    @Test
    void shouldReturnOXOOnLastRow() {

        //given
        String[][] expectedMatrix = {{" ", " ", " "}, {" ", " ", " "}, {"O", "X", "O"}};

        //when
        actorMatrix.addActorToMatrix(false,"31");
        actorMatrix.addActorToMatrix(true,"32");
        actorMatrix.addActorToMatrix(false,"33");

        //then
        assertArrayEquals(expectedMatrix, actorMatrix.getMatrix());

    }

    @Test
    void shouldReturnXOXOnFirstColumn() {

        //given
        String[][] expectedMatrix = {{"X", " ", " "}, {"O", " ", " "}, {"X", " ", " "}};

        //when
        actorMatrix.addActorToMatrix(true,"11");
        actorMatrix.addActorToMatrix(false,"21");
        actorMatrix.addActorToMatrix(true,"31");

        //then
        assertArrayEquals(expectedMatrix, actorMatrix.getMatrix());

    }
}
