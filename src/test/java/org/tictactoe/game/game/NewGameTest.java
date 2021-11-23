package org.tictactoe.game.game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.tictactoe.game.matrix.ActorMatrix;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

public class NewGameTest {

    private final PrintStream printStream = System.out;
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private final NewGame newGame = new NewGame();
    private final ActorMatrix actorMatrix = new ActorMatrix();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(printStream);
    }

    @Disabled
    @Test
    void validAnswerYesShouldResultInExpectedOutput() {

        //given
        String input = "y";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
        String expectedOutput = """
                Hello!! Can we start new Game?\r
                Starting game\r
                 | |\s
                -+-+-
                 | |\s
                -+-+-
                 | |\s""";

        //when
        newGame.startNewGame(actorMatrix);

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
                Bye!!\r
                """;

        //when
        newGame.startNewGame(actorMatrix);

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
        newGame.startTurn(true, actorMatrix);
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
        newGame.startTurn(false, actorMatrix);
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
        newGame.startTurn(true, actorMatrix);
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
        newGame.startTurn(false, actorMatrix);
        //then
        assertTrue(newGame.isxFlag());
    }

    @Test
    void ifFirstRowMatchShouldEndGame(){

        //given
        actorMatrix.addActorToMatrix(true, "11");
        actorMatrix.addActorToMatrix(true, "21");
        actorMatrix.addActorToMatrix(true, "31");

        String expectedOutput = "X wins\r\n";

        //when
        newGame.startTurn(true, actorMatrix);

        //then
        assertEquals(expectedOutput, byteArrayOutputStream.toString());
    }

    @Test
    void ifSecondRowMatchShouldEndGame(){

        //given
        actorMatrix.addActorToMatrix(false, "12");
        actorMatrix.addActorToMatrix(false, "22");
        actorMatrix.addActorToMatrix(false, "32");

        String expectedOutput = "O wins\r\n";

        //when
        newGame.startTurn(false, actorMatrix);

        //then
        assertEquals(expectedOutput, byteArrayOutputStream.toString());
    }

    @Test
    void ifThirdRowMatchShouldEndGame(){

        //given
        actorMatrix.addActorToMatrix(true, "13");
        actorMatrix.addActorToMatrix(true, "23");
        actorMatrix.addActorToMatrix(true, "33");

        String expectedOutput = "X wins\r\n";

        //when
        newGame.startTurn(true, actorMatrix);

        //then
        assertEquals(expectedOutput, byteArrayOutputStream.toString());
    }

    @Test
    void ifFirstColumnMatchShouldEndGame(){

        //given
        actorMatrix.addActorToMatrix(true, "11");
        actorMatrix.addActorToMatrix(true, "12");
        actorMatrix.addActorToMatrix(true, "13");

        String expectedOutput = "X wins\r\n";

        //when
        newGame.startTurn(true, actorMatrix);

        //then
        assertEquals(expectedOutput, byteArrayOutputStream.toString());
    }

    @Test
    void ifSecondColumnMatchShouldEndGame(){

        //given
        actorMatrix.addActorToMatrix(true, "21");
        actorMatrix.addActorToMatrix(true, "22");
        actorMatrix.addActorToMatrix(true, "23");

        String expectedOutput = "X wins\r\n";

        //when
        newGame.startTurn(true, actorMatrix);

        //then
        assertEquals(expectedOutput, byteArrayOutputStream.toString());
    }

    @Test
    void ifThirdColumnMatchShouldEndGame(){

        //given
        actorMatrix.addActorToMatrix(false, "31");
        actorMatrix.addActorToMatrix(false, "32");
        actorMatrix.addActorToMatrix(false, "33");

        String expectedOutput = "O wins\r\n";

        //when
        newGame.startTurn(false, actorMatrix);

        //then
        assertEquals(expectedOutput, byteArrayOutputStream.toString());
    }

    @Test
    void ifFirstSlantMatchShouldEndGame(){

        //given
        actorMatrix.addActorToMatrix(false, "11");
        actorMatrix.addActorToMatrix(false, "22");
        actorMatrix.addActorToMatrix(false, "33");

        String expectedOutput = "O wins\r\n";

        //when
        newGame.startTurn(false, actorMatrix);

        //then
        assertEquals(expectedOutput, byteArrayOutputStream.toString());
    }

    @Test
    void ifSecondSlantMatchShouldEndGame(){

        //given
        actorMatrix.addActorToMatrix(true, "31");
        actorMatrix.addActorToMatrix(true, "22");
        actorMatrix.addActorToMatrix(true, "13");

        String expectedOutput = "X wins\r\n";

        //when
        newGame.startTurn(true, actorMatrix);

        //then
        assertEquals(expectedOutput, byteArrayOutputStream.toString());
    }


}
