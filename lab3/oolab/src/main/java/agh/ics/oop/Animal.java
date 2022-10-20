package agh.ics.oop;

public class Animal {

    private MapDirection orientation;
    private Vector2d position;



    public Animal() {
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }


    @Override
    public String toString() {
        return "%s %s".formatted(orientation, position);
    }

    public Vector2d getAnimalVector() {
        return position;
    }

    public MapDirection getAnimalDirection() {
        return orientation;
    }


    boolean isAt(Vector2d position){
        return this.position.equals(position);
    }



    public void move(MoveDirection direction){

        switch (direction){
            case RIGHT:
                orientation = orientation.next();
                break;
            case LEFT:
                orientation = orientation.previous();
                break;
            case FORWARD:
                Vector2d newPosition = position.add(orientation.toUnitVector());

                if (newPosition.follows(new Vector2d(0, 0)) && newPosition.precedes(new Vector2d(4, 4))){
                    position = newPosition;
                }

                break;

            case BACKWARD:
                newPosition = position.subtract(orientation.toUnitVector());

                if (newPosition.follows(new Vector2d(0, 0)) && newPosition.precedes(new Vector2d(4, 4))){
                position = newPosition;
                }

                break;


        }

    }
}
