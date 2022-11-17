package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//tutaj umieszczamy to, co jest we wszystkich rodzajach mapy (np trawa nie jest we wszystkich mapach)
public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    private final Map<Vector2d, Animal> animals = new HashMap<>();
    private final MapVisualizer mapVisualizer = new MapVisualizer(this);

    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }


    public Map<Vector2d, Animal> getAnimalHashMap(){
        return animals;
    }



    @Override
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    abstract protected Vector2d getLowerLeftBound();
    abstract protected Vector2d getUpperRightBound();
    @Override
    public String toString(){
        return this.mapVisualizer.draw(getLowerLeftBound(), getUpperRightBound());
    }



    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition, animal);
    }




}
