package org.tictactoe.game.game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

public class NewGameTest {

    private final PrintStream printStream = System.out;
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private final NewGame newGame = new NewGame();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(printStream);
    }

    @Test
    void validAnswerYesShouldResultInExpectedOutput() {

        //given
        String input = "y";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
        String expectedOutput = """
                Hello!! Can we start new Game?\r
                Type y or n\r
                Starting game\r
                 | |\s
                -+-+-
                 | |\s
                -+-+-
                 | |\s""";

        //when
        newGame.startNewGame();

        //then
        assertEquals(expectedOutput, byteArrayOutputStream.toString());
    }

    @Test
    void validAnswerNoShouldResultInExpectedOutput() {

        //given
        String input = "n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
        String expectedOutput = """
                Hello!! Can we start new Game?\r
                Type y or n\r
                Bye!!\r
                """;

        //when
        newGame.startNewGame();

        //then
        assertEquals(expectedOutput, byteArrayOutputStream.toString());
    }

    @Test
    void shouldInsertXToMapANdPrintInfoAndMap() {

        //given
        String input = "11";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
        String expectedOutput = """
                X turn\r
                X| |\s
                -+-+-
                 | |\s
                -+-+-
                 | |\s""";
        //when
        newGame.startTurn(true);
        //then
        assertEquals(expectedOutput, byteArrayOutputStream.toString());
    }

    @Test
    void shouldPrintOTurnInfo() {

        //given
        String input = "11";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
        String expectedOutput = "O turn\r\n";
        //when
        newGame.startTurn(false);
        //then
        assertEquals(expectedOutput, byteArrayOutputStream.toString());
    }

    @Test
    void shouldChangePlayerToO() {

        //given
        String input = "11";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
        //when
        newGame.startTurn(true);
        //then
        assertFalse(newGame.isxFlag());
    }

    @Test
    void shouldChangePlayerToX() {

        //given
        String input = "11";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
        //when
        newGame.startTurn(false);
        //then
        assertTrue(newGame.isxFlag());
    }


}
