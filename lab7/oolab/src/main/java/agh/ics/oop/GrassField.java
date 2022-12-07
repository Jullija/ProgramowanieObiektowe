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
                mapBoundary.addPosition(grassPosition);
                actualGrass += 1;
            }

        }
    }
    @Override
    public Vector2d getLowerLeftBound(){
        return mapBoundary.getLowerLeft();
    };


    @Override
    public Vector2d getUpperRightBound(){
        return mapBoundary.getUpperRight();
    };


    @Override
    public Object objectAt(Vector2d position){
        Object animalPosition = super.objectAt(position);
        if (animalPosition == null){
            return grasses.get(position);
        }
        return animalPosition;
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        Object obj = this.objectAt(position);
        return obj == null || obj instanceof Grass;
    }

}
