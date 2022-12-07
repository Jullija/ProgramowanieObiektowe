package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Animal implements IMapElement{


    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;

    private final List<IPositionChangeObserver> observers;


    public Animal (IWorldMap map){
        this(map, new Vector2d(2, 2));
    }

    public Animal (IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
        this.observers = new ArrayList<IPositionChangeObserver>();
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

    public Vector2d getPosition() {
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
                positionChanged(position, newPosition);
                this.position = newPosition;
            }
        }




    void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    void positionChanged(Vector2d oldPosition, Vector2d newPosition){ //publisher to klasa animal, subscriber to mapa
        for (IPositionChangeObserver observer : observers){
            observer.positionChanged(oldPosition, newPosition);

        }
    }


}
