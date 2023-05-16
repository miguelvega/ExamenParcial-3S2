package conRectorizacionTestTicTacToe;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import conRefactorizacionTicTacToe.TicTacToe_Refact;

import static org.junit.jupiter.api.Assertions.*;
public class TicTacToeTest_Refact {
    private static TicTacToe_Refact tictactoe;

    @BeforeAll
    public static void init(){
        tictactoe = new TicTacToe_Refact();
    }

    @Test
    public void WhenOffBoardXaxisThenThrowException() {

        Throwable exception = assertThrows(RuntimeException.class, () -> {
            tictactoe.jugar(5, 0);
        });
        assertEquals("Saliste del tablero fuera del eje x", exception.getMessage());
    }
    @Test
    public void WhenOffBoardYaxisThenThrowException() {
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            tictactoe.jugar(0, 5);
        });
        assertEquals("Saliste del tablero fuera del eje y", exception.getMessage());
    }
    @Test
    public void WhenOccupiedPositionBoardThenThrowException() {
        tictactoe.jugar(0, 2);
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            tictactoe.jugar(0, 2);
        });
        assertEquals("Esta posicion esta ocupada", exception.getMessage());
    }
    // Requisito 2
    @Test
    public void X_playsFirst(){
        //Por defecto X empieza el juego
        assertEquals('X', tictactoe.proximoJugador());
    }
    @Test
    public void O_playsAfter_X(){
        tictactoe.jugar(0, 2);//X se coloca en la psocion (0,2)
        //El siguiente movimiento le corresponde a O
        assertEquals('O', tictactoe.proximoJugador());
    }

    @Test
    public void X_playsRightAfter_O(){
        tictactoe.jugar(0, 2);//Primero juega X
        tictactoe.jugar(1, 1);// Luego juega  O
        //Entonces el siguiente movimiento le toca a X
        assertEquals('X', tictactoe.proximoJugador());
    }
}

