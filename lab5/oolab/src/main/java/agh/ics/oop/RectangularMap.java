package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{

    private  Vector2d lowerBound;
    private Vector2d upperBound;

    public RectangularMap(int width, int height){
        this.lowerBound = new Vector2d(0,0);
        this.upperBound = new Vector2d(width - 1, height - 1);//wymiary mapy to width i height. Lewy dolny róg to (0,0). Prawy górny to (width-1, height-1), bo numerujemy od 0
    }


    @Override //czy mieści się w mapie i pole nie jest zajęte
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerBound) && position.precedes(upperBound) && !isOccupied(position);
    }

    @Override
    protected Vector2d getLowerLeftBound(){
        return lowerBound;
    }
    @Override
    protected Vector2d getUpperRightBound(){
        return upperBound;
    }

}
