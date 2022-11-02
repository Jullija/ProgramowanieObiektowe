package agh.ics.oop;

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
        return this.position.equals(position);
    }



    public void move(MoveDirection direction){

        switch (direction){
            case RIGHT -> this.orientation = this.orientation.next();

            case LEFT -> this.orientation = this.orientation.previous();

            default -> {
                Vector2d orientationVector = this.orientation.toUnitVector(); //robię wektor kierunku

                if (direction == MoveDirection.BACKWARD){ //jeśli ma iść do tyłu, to zamiast wektora (1, 0) będzie wektor (-1, 0)
                    orientationVector = orientationVector.opposite();
                }

                Vector2d newPosition = this.position.add(orientationVector);
                if (newPosition.follows(new Vector2d(0, 0)) && newPosition.precedes(new Vector2d(4, 4))){
                    this.position = newPosition;
                }

            }



        }

    }
}
