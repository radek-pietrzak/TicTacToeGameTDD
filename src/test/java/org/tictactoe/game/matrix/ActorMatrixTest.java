package org.tictactoe.game.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorMatrixTest {

    ActorMatrix actorMatrix = new ActorMatrix();
    String[][] emptyMatrix = {
            {" ", " ", " "},
            {" ", " ", " "},
            {" ", " ", " "}
    };

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
        String[][] expectedMatrix = {
                {"X", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}
        };

        //when
        actorMatrix.addActorToMatrix(true, "11");

        //then
        assertArrayEquals(expectedMatrix, actorMatrix.getMatrix());

    }

    @Test
    void shouldReturnXXXOnSlant() {

        //given
        String[][] expectedMatrix = {
                {"X", " ", " "},
                {" ", "X", " "},
                {" ", " ", "X"}
        };

        //when
        actorMatrix.addActorToMatrix(true, "11");
        actorMatrix.addActorToMatrix(true, "22");
        actorMatrix.addActorToMatrix(true, "33");

        //then
        assertArrayEquals(expectedMatrix, actorMatrix.getMatrix());

    }

    @Test
    void shouldReturnOXOOnLastRow() {

        //given
        String[][] expectedMatrix = {
                {" ", " ", " "},
                {" ", " ", " "},
                {"O", "X", "O"}
        };

        //when
        actorMatrix.addActorToMatrix(false, "13");
        actorMatrix.addActorToMatrix(true, "23");
        actorMatrix.addActorToMatrix(false, "33");

        //then
        assertArrayEquals(expectedMatrix, actorMatrix.getMatrix());

    }

    @Test
    void shouldReturnXOXOnFirstColumn() {

        //given
        String[][] expectedMatrix = {
                {"X", " ", " "},
                {"O", " ", " "},
                {"X", " ", " "}
        };

        //when
        actorMatrix.addActorToMatrix(true, "11");
        actorMatrix.addActorToMatrix(false, "12");
        actorMatrix.addActorToMatrix(true, "13");

        //then
        assertArrayEquals(expectedMatrix, actorMatrix.getMatrix());

    }

    @Test
    void shouldReturnX_OOnMiddleColumn() {

        //given
        String[][] expectedMatrix = {
                {" ", " ", " "},
                {"X", " ", "O"},
                {" ", " ", " "}
        };

        //when
        actorMatrix.addActorToMatrix(true, "12");
        actorMatrix.addActorToMatrix(false, "32");

        //then
        assertArrayEquals(expectedMatrix, actorMatrix.getMatrix());

    }
}
