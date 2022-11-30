package agh.ics.oop;

import java.util.*;


//    IWorldMap
//       ^
//       |
//   AbstractWorldMap
//  ^                  ^
//  |                  |
//  RectangularMap     GrassField

public class GrassField extends AbstractWorldMap{
    private final Map<Vector2d, Grass> grasses = new HashMap<>();


    public GrassField(int howManyGrasses){

        int actualGrass = 0;

        while (actualGrass != howManyGrasses){
            Random generator = new Random();

            int x = generator.nextInt( (int) Math.sqrt(howManyGrasses*10) + 1);
            int y = generator.nextInt( (int) Math.sqrt(howManyGrasses*10) + 1);

            Vector2d grassPosition = new Vector2d(x, y);
            Grass newGrass = new Grass(grassPosition);

            if (!isOccupied(grassPosition)){
                grasses.put(grassPosition, newGrass);
                actualGrass += 1;
            }

        }
    }
    protected Vector2d getLowerLeftBound(){

        Vector2d lowerBound = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);

        for (Vector2d position : getAnimalHashMap().keySet()){
            lowerBound = lowerBound.lowerLeft(position);
        }

        for (Vector2d position : grasses.keySet()){
            lowerBound = lowerBound.lowerLeft(position);
        }

        return lowerBound;
    };



    protected Vector2d getUpperRightBound(){
        Vector2d upperBound = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

        for (Vector2d position : getAnimalHashMap().keySet()){
            upperBound = upperBound.upperRight(position);
        }

        for (Vector2d position : grasses.keySet()){
            upperBound = upperBound.upperRight(position);
        }

        return upperBound;
    };


    @Override
    public Object objectAt(Vector2d position){
        Object animalPosition = super.objectAt(position);
        if (animalPosition == null){
            return grasses.get(position);
        }
        return animalPosition;
    }



//sprawdzam, czy objekt na tej pozycji jest trawą lub pustym polem -> jeśli jest, to wtedy mogę wejść zwierzątkiem na to pole (true)
    @Override
    public boolean canMoveTo(Vector2d position) {
        Object obj = this.objectAt(position);
        return obj == null || obj instanceof Grass;
    }

}
