package agh.ics.oop;

import java.util.Objects;

public class Animal {

    private MapDirection orientation;
    private Vector2d position;



    public Animal() {
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    public Animal(MapDirection orientation, Vector2d position){
        this.orientation = orientation;
        this.position = position;
    }


    @Override
    public String toString() {
        return "%s %s".formatted(orientation, position);
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


            this.position = position.lowerLeft(World.UPPER_BOUND).upperRight(World.LOWER_BOUND);


        }


}
