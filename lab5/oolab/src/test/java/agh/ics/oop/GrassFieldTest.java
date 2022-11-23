package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    public void methodsFromIWorldMapTest(){
        GrassField GF = new GrassField(10);
        Animal animal = new Animal(GF, new Vector2d(2, 2));
        GF.place(animal);

        assertFalse(GF.canMoveTo(new Vector2d(2, 2))); //trawa nie może wejść na pole zwierzaczka
        assertTrue(GF.canMoveTo(new Vector2d(2, 8)));
        assertEquals(animal, GF.objectAt(new Vector2d(2, 2)));
    }

}
