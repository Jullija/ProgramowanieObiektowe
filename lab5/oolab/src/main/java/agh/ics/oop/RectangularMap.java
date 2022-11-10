package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{

//    private final int width;
//    private final int height;
    private final List<Animal> animalList; //lista zwierzątek, które już są na mapie
    private final MapVisualizer mapVisualizer;
    private final Vector2d lowerBound;
    private final Vector2d upperBound;



    //konstruktor
    public RectangularMap(int width, int height){
//        this.width = width;
//        this.height = height;
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
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) { //zwracam zwierzątko, które już stoi na tym miejscu
        for (Animal animal : animalList){
            if (animal.getAnimalPosition().equals(position)){
                return animal;
            }
        }
        return null;


//        return animalList.stream()
//                .filter(animal -> animal.isAt(position))
//                .findFirst() //zwróci nam Optionala -> pudełko na coś, albo 0. coś, co ma w sobie coś albo nie ma nic
//                .orElse(null); //co zrobić, jeśli findFirst zwrói nam pustego Optionala

    }

    @Override
    public String toString(){ //rysuję mapę o moich wymiarach
        return this.mapVisualizer.draw(lowerBound, upperBound);
    }


}
