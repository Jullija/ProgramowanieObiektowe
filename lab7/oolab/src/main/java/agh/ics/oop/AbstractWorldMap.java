package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap{

    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    private final MapVisualizer mapVisualizer = new MapVisualizer(this);

    protected MapBoundary mapBoundary = new MapBoundary();

    @Override
    public boolean place(Animal animal) throws IllegalArgumentException{
        if (!this.canMoveTo(animal.getPosition())){
            throw new IllegalArgumentException(animal.getPosition() + "is not legal move specification");
        }
        animals.put(animal.getPosition(), animal);
        animal.addObserver(this);
        return true;
    }


    public Map<Vector2d, Animal> getAnimalHashMap(){
        return animals;
    }



    @Override
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    public abstract Vector2d getLowerLeftBound();
    public abstract Vector2d getUpperRightBound();
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
