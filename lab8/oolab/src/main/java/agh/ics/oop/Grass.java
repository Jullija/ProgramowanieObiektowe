package agh.ics.oop;

import java.io.File;

public class Grass implements IMapElement{
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

    @Override
    public String getImagePath(){
        return "src/main/resources/fastTravel.png";
    }

}
