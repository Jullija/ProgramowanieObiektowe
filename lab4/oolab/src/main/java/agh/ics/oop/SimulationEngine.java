package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {

    private final IWorldMap map;
    private final MoveDirection[] moveDirectionList;
    private final List<Animal> animalList;
    private final Vector2d[] animalPositions;

    public SimulationEngine(MoveDirection[] moveDirectionList, IWorldMap map, Vector2d[] animalPositions){
        this.map = map;
        this.moveDirectionList = moveDirectionList;
        this.animalList = new ArrayList<Animal>();
        this.animalPositions = animalPositions;

        for (Vector2d position : animalPositions){
            Animal animal = new Animal(map, position); //tworzę zwierzaczka z tą pozycją

            if(map.place(animal)){ //jeśli mogę umieścić zwierzaczka
                animalList.add(animal); //dodaję zwierzaczka do listy zwierzaczków
            }

        }

    }

    @Override
    public void run() {

        for (int i = 0; i < moveDirectionList.length; i++){
            animalList.get(i % animalList.size()).move(moveDirectionList[i]); //wybieram odpowiedniego zwierzaczka i go ruszam
            System.out.println(map);
        }

    }
}
