package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

//tutaj umieszczamy to, co jest we wszystkich rodzajach mapy (np trawa nie jest we wszystkich mapach)
public abstract class AbstractWorldMap implements IWorldMap {

    private final List<Animal> animalList = new ArrayList<Animal>();
    private final MapVisualizer mapVisualizer = new MapVisualizer(this);

    //nie dodawamy atrybutow, bo za każdym razem będzie nam je zmieniać
    //nie trzeba mówić o canMoveTo, bo to już jest klasa abstrakcyjna domyślnie, bo jest w interfejsie
    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())){
            animalList.add(animal);
            return true;
        }
        return false;
    }


    public List<Animal> getAnimalList(){
        return animalList;
    }



    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animalList) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return this.mapVisualizer.draw(getLowerLeftBound(), getUpperRightBound());
    }

    abstract protected Vector2d getLowerLeftBound();



    abstract protected Vector2d getUpperRightBound();

}
