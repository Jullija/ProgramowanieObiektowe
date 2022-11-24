package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    @Test
    public void methodsFromIWorldMapTest(){
        RectangularMap RM = new RectangularMap(10, 10);
        Animal animal = new Animal(RM, new Vector2d(2, 2));
        RM.place(animal);

        assertFalse(RM.canMoveTo(new Vector2d(2, 2)));
        assertTrue(RM.canMoveTo(new Vector2d(7, 8)));
        assertEquals(animal, RM.objectAt(new Vector2d(2, 2)));
    }
}
