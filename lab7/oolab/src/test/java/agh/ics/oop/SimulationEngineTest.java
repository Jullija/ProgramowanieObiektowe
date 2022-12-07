package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimulationEngineTest {

    @Test
    public void givenTest(){
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertTrue(map.isOccupied(new Vector2d(2, 0)));
        assertTrue(map.isOccupied(new Vector2d(3, 4)));
    }

    @Test
    public void outsideMapTest(){
        String[] args = {"f", "f", "f", "f", "l", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(5, 5);
        Vector2d[] positions = { new Vector2d(1,1)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertTrue(map.isOccupied(new Vector2d(0, 4)));
    }

    @Test
    public void twoAnimalsSpawnedAtTheSameSpotTest(){
        String[] args = {"f", "f", "f", "f", "l", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(5, 5);
        Vector2d[] positions = { new Vector2d(1,1), new Vector2d(1, 1)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertTrue(map.isOccupied(new Vector2d(0, 4)));
        assertFalse(map.isOccupied(new Vector2d(0, 3)));
        assertFalse(map.isOccupied(new Vector2d(1, 4)));
    }


    @Test
    public void twoAnimalsMeetAtTheSameSpotTest(){
        String[] args = {"r", "l", "f", "f", "l", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(4, 5);
        Vector2d[] positions = { new Vector2d(0,0), new Vector2d(3, 1)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertTrue(map.isOccupied(new Vector2d(1, 0)));
        assertTrue(map.isOccupied(new Vector2d(0, 1)));
    }







}
