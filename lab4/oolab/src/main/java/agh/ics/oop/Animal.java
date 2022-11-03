package agh.ics.oop;

import java.util.Objects;

public class Animal {


    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;


    public Animal (IWorldMap map){
        this.map = map;
        this.position = new Vector2d(2, 2);
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

        switch (direction){
            case RIGHT -> this.orientation = this.orientation.next();

            case LEFT -> this.orientation = this.orientation.previous();

            case FORWARD -> position = position.add(orientationVector);

            case BACKWARD -> position = position.subtract(orientationVector);
            }

            if (map.canMoveTo(position)){
                this.position = position.lowerLeft(World.UPPER_BOUND).upperRight(World.LOWER_BOUND);
            }



        }


}
