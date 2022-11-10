package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {

    private List<Animal> animalList = new ArrayList<Animal>();
    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getAnimalPosition())){ //jeśli mogę się dostać do tego miejsca na mapie to dodaję zwierzątko (sprawdzam i dostępność, i czy się mieści w mapie)
            animalList.add(animal);
            return true;
        }
        return false;
    }
}
