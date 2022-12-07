package agh.ics.oop;
import java.util.*;

public class MapBoundary implements IPositionChangeObserver{

    //treeSet - elementy nie będą się powtarzać + będą się sortować

    TreeSet<Vector2d> xElements = new TreeSet<>(Comparator.<Vector2d>comparingInt(xVec -> xVec.x).thenComparingInt(xVec -> xVec.y));
    TreeSet<Vector2d> yElements = new TreeSet<>(Comparator.<Vector2d>comparingInt(yVec -> yVec.y).thenComparingInt(yVec -> yVec.x));

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        removePosition(oldPosition);
        addPosition(newPosition);
    }

    public void addPosition(Vector2d position){
        xElements.add(position);
        yElements.add(position);
    }

    public void removePosition(Vector2d position){
        xElements.remove(position);
        yElements.remove(position);
    }

    public Vector2d getLowerLeft(){
        int xPos = xElements.first().x;
        int yPos = yElements.first().y;
        return new Vector2d(xPos, yPos);
    }

    public Vector2d getUpperRight(){
        int xPos = xElements.last().x;
        int yPos = yElements.last().y;
        return new Vector2d(xPos, yPos);
    }

}
