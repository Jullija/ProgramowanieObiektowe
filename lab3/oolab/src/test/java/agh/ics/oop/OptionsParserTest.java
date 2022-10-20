package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {

    @Test
    public void allCorrectLines(){
        //given
        String[] move = {"f", "forward", "r", "backward", "left"};

        //when
        MoveDirection przod = MoveDirection.FORWARD;
        MoveDirection tyl = MoveDirection.BACKWARD;
        MoveDirection lewo = MoveDirection.LEFT;
        MoveDirection prawo = MoveDirection.RIGHT;

        //tests
        MoveDirection[] ans = {przod, przod, prawo, tyl, lewo};
        OptionsParser tmp = new OptionsParser();
        assertArrayEquals(ans, tmp.parse(move));
    }

    @Test
    public void correctAndIncorrectLines(){
        //given
        String[] move = {"foward", "forward", "p", "backward", "l"};

        //when
        MoveDirection przod = MoveDirection.FORWARD;
        MoveDirection tyl = MoveDirection.BACKWARD;
        MoveDirection lewo = MoveDirection.LEFT;
        MoveDirection prawo = MoveDirection.RIGHT;

        //tests
        MoveDirection[] ans = {przod, tyl, lewo};
        OptionsParser tmp = new OptionsParser();
        assertArrayEquals(ans, tmp.parse(move));
    }

    @Test
    public void allIncorrectLines(){
        //given
        String[] move = {"foward", "q", "p", "g", "tralala"};

        //when
        MoveDirection przod = MoveDirection.FORWARD;
        MoveDirection tyl = MoveDirection.BACKWARD;
        MoveDirection lewo = MoveDirection.LEFT;
        MoveDirection prawo = MoveDirection.RIGHT;

        //tests
        MoveDirection[] ans = {};
        OptionsParser tmp = new OptionsParser();
        assertArrayEquals(ans, tmp.parse(move));
    }




}
