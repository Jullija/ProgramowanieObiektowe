package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {

    protected List<Animal> animalList = new ArrayList<Animal>();
    protected List<Grass> grassList = new ArrayList<Grass>();
    protected MapVisualizer mapVisualizer = new MapVisualizer(this);
    protected Vector2d lowerBound;
    protected Vector2d upperBound;
    abstract public void boundsUpdate();
    abstract public boolean canMoveTo(Vector2d position);

    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())){ //jeśli mogę się dostać do tego miejsca na mapie to dodaję zwierzątko (sprawdzam i dostępność, i czy się mieści w mapie)
            animalList.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }


    @Override
    public Object objectAt(Vector2d position) { //zwracam zwierzątko, które już stoi na tym miejscu
        for (Animal animal : animalList) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }

        for (Grass grass : grassList) {
            if (grass.getPosition().equals(position)) {
                return grass;
            }
        }

        return null;
    }

    @Override
    public String toString(){ //rysuję mapę o moich wymiarach
        boundsUpdate();
        return this.mapVisualizer.draw(lowerBound, upperBound);
    }

}
