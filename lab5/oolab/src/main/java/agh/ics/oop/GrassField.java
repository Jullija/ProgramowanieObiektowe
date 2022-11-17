package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


//    IWorldMap
//       ^
//       |
//   AbstractWorldMap
//  ^                  ^
//  |                  |
//  RectangularMap     GrassField

public class GrassField extends AbstractWorldMap{
    private final List<Grass> grassList;


    public GrassField(int howManyGrasses){
        this.grassList = new ArrayList<Grass>();

        for (int i = 0; i < howManyGrasses; i++){
            randomGenerator(howManyGrasses);
        }


    }

    protected Vector2d getLowerLeftBound(){

        Vector2d lowerBound = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);

        for (Animal animal : getAnimalList()){
            lowerBound = lowerBound.lowerLeft(animal.getPosition());
        }

        for (Grass grass : grassList){
            lowerBound = lowerBound.lowerLeft(grass.getPosition());
        }

        return lowerBound;
    };



    protected Vector2d getUpperRightBound(){
        Vector2d upperBound = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

        for (Animal animal : getAnimalList()){
            upperBound = upperBound.upperRight(animal.getPosition());
        }

        for (Grass grass : grassList){
            upperBound = upperBound.lowerLeft(grass.getPosition());
        }

        return upperBound;
    };


        @Override
    public Object objectAt(Vector2d position){
        Object mapObject = super.objectAt(position); //super to wskaźnik na rodzica -> nie muszę tutaj już pisać o animalsach, bo w AbstractWorldMap mam metodę, które sprawdza zwierzaczki
        if (mapObject == null){
            for (Grass grass : grassList){
                if (grass.getPosition().equals(position)){
                    return grass;
                }
            }
        }
        return mapObject;
    }

    public void randomGenerator(int howManyGrasses){
        Random generator = new Random();

        int x = generator.nextInt( (int) Math.sqrt(howManyGrasses*10) + 1); // nextInt(n) - losuje od 0 do n-1
        int y = generator.nextInt( (int) Math.sqrt(howManyGrasses*10) + 1);

        Vector2d grassPosition = new Vector2d(x, y);

        if (!isOccupied(grassPosition)){
            grassList.add(new Grass(grassPosition));
        }




    }



//sprawdzam, czy objekt na tej pozycji jest trawą lub pustym polem -> jeśli jest, to wtedy mogę wejść zwierzątkiem na to pole (true)
    @Override
    public boolean canMoveTo(Vector2d position) {
        Object obj = this.objectAt(position);
        return obj == null || obj instanceof Grass;
    }

}
