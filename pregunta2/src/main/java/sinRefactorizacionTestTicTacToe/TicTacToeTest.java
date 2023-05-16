package sinRefactorizacionTestTicTacToe;
import org.junit.jupiter.api.Test;
import sinRefactorizacionTicTacToe.TicTacToe;

import static org.junit.jupiter.api.Assertions.*;
public class TicTacToeTest {
    @Test
    public void WhenOffBoardXaxisThenThrowException() {
        TicTacToe tictactoe = new TicTacToe();
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            tictactoe.jugar(5, 0);
        });
        assertEquals("Saliste del tablero fuera del eje x", exception.getMessage());
    }
    @Test
    public void WhenOffBoardYaxisThenThrowException() {
        TicTacToe tictactoe = new TicTacToe();
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            tictactoe.jugar(0, 5);
        });
        assertEquals("Saliste del tablero fuera del eje y", exception.getMessage());
    }
    @Test
    public void WhenOccupiedPositionBoardThenThrowException() {
        TicTacToe tictactoe = new TicTacToe();
        tictactoe.jugar(0, 2);
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            tictactoe.jugar(0, 2);
        });
        assertEquals("Esta posicion esta ocupada", exception.getMessage());
    }

}
