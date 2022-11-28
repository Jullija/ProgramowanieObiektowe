package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {


    @Test
    public void allGood(){
        RectangularMap map = new RectangularMap(10, 10);
        Animal animal = new Animal(map, new Vector2d(2, 2));
        String[] moves = {"f", "f", "r", "b"};
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.BACKWARD);

        assertEquals(new Vector2d(1, 4), animal.getPosition());


    }

    @Test
    public void twoAnimalsSamePlaceTest(){
        RectangularMap map = new RectangularMap(10, 10);
        Animal animal1 = new Animal(map, new Vector2d(2, 2));
        Animal animal2 = new Animal(map, new Vector2d(2, 2));
        map.place(animal1);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            map.place(animal2);
        });

        assertEquals(new Vector2d(2, 2) + "is not legal move specification", exception.getMessage());
    }

    @Test
    public void outsideMapTest(){
        RectangularMap map = new RectangularMap(10, 10);
        Animal animal1 = new Animal(map, new Vector2d(20, 2));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            map.place(animal1);
        });

        assertEquals(new Vector2d(20, 2) + "is not legal move specification", exception.getMessage());
    }
}
