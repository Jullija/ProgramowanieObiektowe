package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class Vector2dTest {

    @Test
    public void equalsTest(){
        Vector2d firstVector = new Vector2d(1, 2);
        Vector2d secondVector = new Vector2d(1, 2);
        Vector2d thirdVector = new Vector2d(5, 10);
        Vector2d fourthVector = secondVector;

        assertTrue(firstVector.equals(secondVector)); //assertEquals(firstVector.equals(secondVector), true);
        assertTrue(secondVector.equals(fourthVector));
        assertFalse(thirdVector.equals(secondVector));

    }


    @Test
    public void toStringTest(){

        //given
        Vector2d firstVector = new Vector2d(1, 2);

        //when
        String a = "(1, 2)";
        String b = "(3, 4)";

        //then
        assertTrue(firstVector.toString().equals(a));
        assertFalse(firstVector.toString().equals(b));

    }


    @Test
    public void precedesTest(){
        Vector2d firstVector = new Vector2d(1, 2);
        Vector2d secondVector = new Vector2d(1, 2);
        Vector2d thirdVector = new Vector2d(0, 1);

        assertTrue(firstVector.precedes(secondVector));
        assertTrue(thirdVector.precedes(firstVector));
        assertFalse(firstVector.precedes(thirdVector));
    }

    @Test
    public void followsTest(){
        Vector2d firstVector = new Vector2d(1, 2);
        Vector2d secondVector = new Vector2d(1, 2);
        Vector2d thirdVector = new Vector2d(0, 1);

        assertTrue(firstVector.follows(secondVector));
        assertFalse(thirdVector.follows(firstVector));
        assertTrue(firstVector.follows(thirdVector));
    }


    @Test
    public void upperRightTest(){
        Vector2d firstVector = new Vector2d(1, 2);
        Vector2d secondVector = new Vector2d(3, 0);
        Vector2d thirdVector = new Vector2d(1, 2);
        Vector2d ans = new Vector2d(3, 2);

        assertEquals(ans, firstVector.upperRight(secondVector));
        assertEquals(firstVector, firstVector.upperRight(thirdVector));

    }

    @Test
    public void lowerLeftTest(){
        Vector2d firstVector = new Vector2d(1, 2);
        Vector2d secondVector = new Vector2d(3, 0);
        Vector2d thirdVector = new Vector2d(1, 2);
        Vector2d ans = new Vector2d(1, 0);

        assertEquals(ans, firstVector.lowerLeft(secondVector));
        assertEquals(firstVector, firstVector.lowerLeft(thirdVector));

    }



    @Test
    public void addTest(){
        Vector2d firstVector = new Vector2d(1, 2);
        Vector2d secondVector = new Vector2d(3, 4);
        Vector2d thirdVector = new Vector2d(-1, -2);
        Vector2d ans1 = new Vector2d(4, 6);
        Vector2d ans2 = new Vector2d(0, 0);

        assertEquals(ans1, firstVector.add(secondVector));
        assertEquals(ans2, firstVector.add(thirdVector));
    }


    @Test
    public void substractTest(){
        Vector2d firstVector = new Vector2d(1, 2);
        Vector2d secondVector = new Vector2d(3, 4);
        Vector2d thirdVector = new Vector2d(-1, -2);
        Vector2d ans1 = new Vector2d(-2, -2);
        Vector2d ans2 = new Vector2d(-2, -4);
        Vector2d ans3 = new Vector2d(2, 4);

        assertEquals(ans1, firstVector.subtract(secondVector));
        assertEquals(ans3, firstVector.subtract(thirdVector));
        assertEquals(ans2, thirdVector.subtract(firstVector));

    }


    @Test
    public void oppositeTest(){
        Vector2d firstVector = new Vector2d(1, 2);
        Vector2d secondVector = new Vector2d(3, 4);
        Vector2d thirdVector = new Vector2d(-1, -2);
        Vector2d ans1 = new Vector2d(-3, -4);

        assertEquals(thirdVector, firstVector.opposite());
        assertEquals(ans1, secondVector.opposite());
        assertEquals(firstVector, thirdVector.opposite());
    }



}
