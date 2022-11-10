package agh.ics.oop;

public class Grass {
    private final Vector2d grassPosition;

    public Grass(Vector2d position){
        this.grassPosition = position;
    }

    public Vector2d getPosition(){
        return this.grassPosition;
    }

    @Override
    public String toString(){
        return "*";
    }

}
