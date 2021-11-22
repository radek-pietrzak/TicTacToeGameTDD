package org.tictactoe.game.map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.tictactoe.game.matrix.ActorMatrix;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameMapTest {

    private final PrintStream printStream = System.out;
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(printStream);
    }

    @Test
    void shouldPrintEmptyMap() {

        //given
        GameMap gameMap = new GameMap();
        ActorMatrix actorMatrix = new ActorMatrix();

        String emptyMap = """
                 | |\s
                -+-+-
                 | |\s
                -+-+-
                 | |\s""";

        //when
        gameMap.createGameMap(actorMatrix);

        //then
        assertEquals(emptyMap, byteArrayOutputStream.toString());
    }

    @Test
    void shouldPrintMapWithOInMiddle() {

        //given
        GameMap gameMap = new GameMap();
        ActorMatrix actorMatrix = new ActorMatrix();
        actorMatrix.addActorToMatrix(false, 22);

        String emptyMap = """
                 | |\s
                -+-+-
                 |O|\s
                -+-+-
                 | |\s""";


        //when
        gameMap.createGameMap(actorMatrix);

        //then
        assertEquals(emptyMap, byteArrayOutputStream.toString());
    }
    @Test
    void shouldPrintMapWithXXXOnSlant() {

        //given
        GameMap gameMap = new GameMap();
        ActorMatrix actorMatrix = new ActorMatrix();
        actorMatrix.addActorToMatrix(true, 11);
        actorMatrix.addActorToMatrix(true, 22);
        actorMatrix.addActorToMatrix(true, 33);

        String emptyMap = """
                X| |\s
                -+-+-
                 |X|\s
                -+-+-
                 | |X""";


        //when
        gameMap.createGameMap(actorMatrix);

        //then
        assertEquals(emptyMap, byteArrayOutputStream.toString());
    }

}
