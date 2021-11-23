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
    private final ActorMatrix actorMatrix = new ActorMatrix();

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
        actorMatrix.addActorToMatrix(false, "22");

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
        actorMatrix.addActorToMatrix(true, "11");
        actorMatrix.addActorToMatrix(true, "22");
        actorMatrix.addActorToMatrix(true, "33");

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

    @Test
    void shouldPrintMapWithTwoXInMiddle() {

        //given
        GameMap gameMap = new GameMap();
        actorMatrix.addActorToMatrix(true, "12");
        actorMatrix.addActorToMatrix(true, "32");

        String emptyMap = """
                 | |\s
                -+-+-
                X| |X
                -+-+-
                 | |\s""";


        //when
        gameMap.createGameMap(actorMatrix);

        //then
        assertEquals(emptyMap, byteArrayOutputStream.toString());
    }

}
