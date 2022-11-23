package agh.ics.oop;

import java.util.ArrayList;
import java.util.Random;

//    IWorldMap
//       ^
//       |
//   AbstractWorldMap
//  ^                  ^
//  |                  |
//  RectangularMap     GrassField

public class GrassField extends AbstractWorldMap{

    private final int howManyGrasses;


    public GrassField(int howManyGrasses){
        this.howManyGrasses = howManyGrasses;
        this.grassList = new ArrayList<Grass>();
        this.lowerBound = new Vector2d(0, 0);
        this.upperBound = new Vector2d((int)Math.sqrt(howManyGrasses*10), (int)Math.sqrt(howManyGrasses*10));

        for (int i = 0; i < howManyGrasses; i++){
            randomGenerator();
        }
        boundsUpdate();

    }

    public void randomGenerator(){
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
