package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

//    IWorldMap
//       ^
//       |
//   AbstractWorldMap
//  ^                  ^
//  |                  |
//  RectangularMap     GrassField

public class GrassField extends AbstractWorldMap{

    private final int howManyGrasses;
    private final List<Grass> grasslList;



    public GrassField(int howManyGrasses){
        this.howManyGrasses = howManyGrasses;
        this.grasslList = new ArrayList<Grass>();
    }

    public Vector2d randomGenerator(int howManyGrasses){
        Vector2d start = new Vector2d(0, 0);
        Vector2d end = new (Vector2d(Math.sqrt(howManyGrasses * 10),Math.sqrt(howManyGrasses * 10) ));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return null;
    }
}
