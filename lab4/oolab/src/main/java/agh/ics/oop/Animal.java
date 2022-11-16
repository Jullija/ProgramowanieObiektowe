package agh.ics.oop;

import java.util.Objects;
import java.util.Vector;

public class Animal {


    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;


    public Animal (IWorldMap map){
        this.map = map;
        this.position = new Vector2d(2, 2);
        this.orientation = MapDirection.NORTH;
    }

    public Animal (IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
    }

    @Override
    public String toString() {
        String orientationsOneCharacter = switch (this.orientation){
            case NORTH -> "N";
            case SOUTH -> "S";
            case EAST -> "E";
            case WEST -> "W";
        };
        return orientationsOneCharacter;
    }

    public MapDirection getAnimalOrientation() {
        return orientation;
    }

    public Vector2d getAnimalPosition() {
        return position;
    }


    public boolean isAt(Vector2d position){
        return Objects.equals(this.position, position); //zabezpieczamy się, aby żadna pozycja nie była nullem
    }



    public void move(MoveDirection direction){

        Vector2d orientationVector = this.orientation.toUnitVector();
        Vector2d newPosition = position;

        switch (direction){
            case RIGHT -> this.orientation = this.orientation.next();

            case LEFT -> this.orientation = this.orientation.previous();

            case FORWARD -> newPosition = position.add(orientationVector);

            case BACKWARD -> newPosition = position.subtract(orientationVector);
            }

            if (map.canMoveTo(newPosition)){
                this.position = newPosition;
            }



        }


}
