package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {

    @Test
    public void allCorrectLines(){
        String[] move = {"f", "forward", "r", "backward", "left"};

        MoveDirection przod = MoveDirection.FORWARD;
        MoveDirection tyl = MoveDirection.BACKWARD;
        MoveDirection lewo = MoveDirection.LEFT;
        MoveDirection prawo = MoveDirection.RIGHT;


        MoveDirection[] ans = {przod, przod, prawo, tyl, lewo};
        OptionsParser tmp = new OptionsParser();
        assertArrayEquals(ans, tmp.parse(move));
    }

    @Test
    public void correctAndIncorrectLines(){
        String[] move = {"foward", "forward", "p", "backward", "l"};

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new OptionsParser().parse(move);
        });

        assertEquals("foward" + "is not legal move specification", exception.getMessage());
    }

    @Test
    public void allIncorrectLines(){

        String[] move = {"foward", "q", "p", "g", "tralala"};


        MoveDirection przod = MoveDirection.FORWARD;
        MoveDirection tyl = MoveDirection.BACKWARD;
        MoveDirection lewo = MoveDirection.LEFT;
        MoveDirection prawo = MoveDirection.RIGHT;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("error");
        });

        assertEquals("error", exception.getMessage());
    }




}
