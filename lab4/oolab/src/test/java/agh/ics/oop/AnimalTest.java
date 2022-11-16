//package agh.ics.oop;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class AnimalTest {
//
//    @Test
//    public void rightOrientationTest(){
//        //given
//        Animal zwierze = new Animal();
//
//        MapDirection polnoc = MapDirection.NORTH;
//        MapDirection poludnie = MapDirection.SOUTH;
//        MapDirection wschod = MapDirection.EAST;
//        MapDirection zachod = MapDirection.WEST;
//
//        //test
//        assertEquals(polnoc, zwierze.getAnimalOrientation());
//
//        //when
//        zwierze.move(MoveDirection.RIGHT);
//        //test
//        assertEquals(wschod, zwierze.getAnimalOrientation());
//
//        //when
//        zwierze.move(MoveDirection.RIGHT);
//        //test
//        assertEquals(poludnie, zwierze.getAnimalOrientation());
//
//        zwierze.move(MoveDirection.RIGHT);
//        assertEquals(zachod, zwierze.getAnimalOrientation());
//
//
//        zwierze.move(MoveDirection.LEFT);
//        assertEquals(poludnie, zwierze.getAnimalOrientation());
//
//        zwierze.move(MoveDirection.LEFT);
//        assertEquals(wschod, zwierze.getAnimalOrientation());
//
//        zwierze.move(MoveDirection.LEFT);
//        assertEquals(polnoc, zwierze.getAnimalOrientation());
//
//    }
//
//
//
//    @Test
//    public void rightPositionsTest(){
//        //given
//        Animal zwierze = new Animal();
//
//        //when
//        MoveDirection przod = MoveDirection.FORWARD;
//        MoveDirection tyl = MoveDirection.BACKWARD;
//        MoveDirection lewo = MoveDirection.LEFT;
//        MoveDirection prawo = MoveDirection.RIGHT;
//
//
//        //tests
//        Vector2d rightPosition = new Vector2d(2, 2);
//        assertEquals(rightPosition, zwierze.getAnimalPosition());
//
//        zwierze.move(przod);
//        rightPosition = new Vector2d(2, 3);
//        assertEquals(rightPosition, zwierze.getAnimalPosition());
//
//
//        zwierze.move(prawo);
//        zwierze.move(przod);
//        rightPosition = new Vector2d(3, 3);
//        assertEquals(rightPosition, zwierze.getAnimalPosition());
//
//        zwierze.move(lewo);
//        zwierze.move(tyl);
//        rightPosition = new Vector2d(3, 2);
//        assertEquals(rightPosition, zwierze.getAnimalPosition());
//
//
//    }
//
//
//
//    @Test
//    public void isOnMapTest(){
//        //given
//
//
//        //when
//        MapDirection polnoc = MapDirection.NORTH;
//        MapDirection poludnie = MapDirection.SOUTH;
//        MapDirection wschod = MapDirection.EAST;
//        MapDirection zachod = MapDirection.WEST;
//        MoveDirection przod = MoveDirection.FORWARD;
//        MoveDirection tyl = MoveDirection.BACKWARD;
//        MoveDirection lewo = MoveDirection.LEFT;
//        MoveDirection prawo = MoveDirection.RIGHT;
//
//
//        //tests
//        Animal zwierze = new Animal(polnoc, new Vector2d(2, 4));
//        zwierze.move(przod);
//        Vector2d rightPosition = new Vector2d(2, 4);
//        assertEquals(rightPosition, zwierze.getAnimalPosition());
//
//        zwierze = new Animal(wschod, new Vector2d(4, 4));
//        zwierze.move(przod);
//        rightPosition = new Vector2d(4, 4);
//        assertEquals(rightPosition, zwierze.getAnimalPosition());
//
//        zwierze = new Animal(zachod, new Vector2d(0, 0));
//        zwierze.move(przod);
//        rightPosition = new Vector2d(0, 0);
//        assertEquals(rightPosition, zwierze.getAnimalPosition());
//
//        zwierze = new Animal(poludnie, new Vector2d(4, 0));
//        zwierze.move(przod);
//        rightPosition = new Vector2d(4, 0);
//        assertEquals(rightPosition, zwierze.getAnimalPosition());
//
//
//    }
//
//
//}
