package agh.ics.oop;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapDirectionTest {

    @Test
    public void nextTest(){
        MapDirection polnoc = MapDirection.NORTH;
        MapDirection poludnie = MapDirection.SOUTH;
        MapDirection wschod = MapDirection.EAST;
        MapDirection zachod = MapDirection.WEST;

        assertEquals(polnoc.next(), wschod); //daje północ, powinno być wschód w odpowiedzi
        assertEquals(poludnie.next(), zachod);
        assertEquals(wschod.next(), poludnie);
        assertEquals(zachod.next(), polnoc);
    }



    @Test
    public void previousTest(){
        MapDirection polnoc = MapDirection.NORTH;
        MapDirection poludnie = MapDirection.SOUTH;
        MapDirection wschod = MapDirection.EAST;
        MapDirection zachod = MapDirection.WEST;

        assertEquals(polnoc.previous(), zachod); //daje północ, powinno być wschód w odpowiedzi
        assertEquals(poludnie.previous(), wschod);
        assertEquals(wschod.previous(), polnoc);
        assertEquals(zachod.previous(), poludnie);
    }



}
