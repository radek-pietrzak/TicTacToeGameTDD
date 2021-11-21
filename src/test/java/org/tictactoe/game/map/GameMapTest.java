package org.tictactoe.game.map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameMapTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void shouldPrintEmptyMap() {

        //given
        GameMap gameMap = new GameMap();
        String emptyMap = """
                 | | 
                -+-+-
                 | | 
                -+-+-
                 | | 
                """;

        //when
        gameMap.createGameMap();

        //then
        assertEquals(emptyMap, outputStreamCaptor.toString());
    }

}
