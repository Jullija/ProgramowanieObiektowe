package agh.ics.oop;

import org.junit.Test;

import static org.junit.Assert.*;


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
        Vector2d firstVector = new Vector2d(1, 2);
        String a = "(1, 2)";
        String b = "(3, 4)";

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

        assertEquals(firstVector.upperRight(secondVector), ans);
        assertEquals(firstVector.upperRight(thirdVector), firstVector);

    }

    @Test
    public void lowerLeftTest(){
        Vector2d firstVector = new Vector2d(1, 2);
        Vector2d secondVector = new Vector2d(3, 0);
        Vector2d thirdVector = new Vector2d(1, 2);
        Vector2d ans = new Vector2d(1, 0);

        assertEquals(firstVector.lowerLeft(secondVector), ans);
        assertEquals(firstVector.lowerLeft(thirdVector), firstVector);

    }



    @Test
    public void addTest(){
        Vector2d firstVector = new Vector2d(1, 2);
        Vector2d secondVector = new Vector2d(3, 4);
        Vector2d thirdVector = new Vector2d(-1, -2);
        Vector2d ans1 = new Vector2d(4, 6);
        Vector2d ans2 = new Vector2d(0, 0);

        assertEquals(firstVector.add(secondVector), ans1);
        assertEquals(firstVector.add(thirdVector), ans2);
    }


    @Test
    public void substractTest(){
        Vector2d firstVector = new Vector2d(1, 2);
        Vector2d secondVector = new Vector2d(3, 4);
        Vector2d thirdVector = new Vector2d(-1, -2);
        Vector2d ans1 = new Vector2d(-2, -2);
        Vector2d ans2 = new Vector2d(-2, -4);
        Vector2d ans3 = new Vector2d(2, 4);

        assertEquals(firstVector.subtract(secondVector), ans1);
        assertEquals(firstVector.subtract(thirdVector), ans3);
        assertEquals(thirdVector.subtract(firstVector), ans2);

    }


    @Test
    public void oppositeTest(){
        Vector2d firstVector = new Vector2d(1, 2);
        Vector2d secondVector = new Vector2d(3, 4);
        Vector2d thirdVector = new Vector2d(-1, -2);
        Vector2d ans1 = new Vector2d(-3, -4);

        assertEquals(firstVector.opposite(), thirdVector);
        assertEquals(secondVector.opposite(), ans1);
        assertEquals(thirdVector.opposite(), firstVector);
    }



}
