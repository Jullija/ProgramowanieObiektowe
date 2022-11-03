package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{

    private final int width;
    private final int height;
    private final List<Animal> animalList; //lista zwierzątek, które już są na mapie
    private final MapVisualizer mapVisualizer;
    private final Vector2d lowerBound;
    private final Vector2d upperBound;



    //konstruktor
    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.mapVisualizer = new MapVisualizer(this);
        this.animalList = new ArrayList<Animal>();
        this.lowerBound = new Vector2d(0,0);
        this.upperBound = new Vector2d(width - 1, height - 1);//wymiary mapy to width i height. Lewy dolny róg to (0,0). Prawy górny to (width-1, height-1), bo numerujemy od 0
    }




    @Override //czy mieści się w mapie i pole nie jest zajęte
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerBound) && position.precedes(upperBound) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getAnimalPosition())){ //jeśli mogę się dostać do tego miejsca na mapie to dodaję zwierzątko (sprawdzam i dostępność, i czy się mieści w mapie)
            animalList.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {

        for (Animal animal : animalList){ //przechodzę po wszystkich zwierzątkach, które już są na mapie i sprawdzam położenie
            if(animal.getAnimalPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) { //zwracam zwierzątko, które już stoi na tym miejscu
        for (Animal animal : animalList){
            if (animal.getAnimalPosition().equals(position)){
                return animal;
            }
        }
        return null;
    }

    @Override
    public String toString(){ //rysuję mapę o moich wymiarach
        return this.mapVisualizer.draw(lowerBound, upperBound);
    }


}
