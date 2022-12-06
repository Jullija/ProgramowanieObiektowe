package agh.ics.oop;

import agh.ics.oop.gui.App;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable {

    private final IWorldMap map;
    private MoveDirection[] moveDirectionList;
    private final List<Animal> animalList;
    private final Vector2d[] animalPositions;
    private int moveDelay;
    private App app;

    public SimulationEngine(MoveDirection[] moveDirectionList, IWorldMap map, Vector2d[] animalPositions){
        this.map = map;
        this.moveDirectionList = moveDirectionList;
        this.animalList = new ArrayList<Animal>();
        this.animalPositions = animalPositions;

        addAnimalsOnMap();
    }

    public SimulationEngine(MoveDirection[] moveDirectionList, IWorldMap map, Vector2d[] animalPositions, int moveDelay, App app){
        this(moveDirectionList, map, animalPositions);
        this.moveDelay = moveDelay;
        this.app = app;
//        addObserverOnMap(app);
    }


    public void setMoveDirections(MoveDirection[] moveDirectionList){
        this.moveDirectionList = moveDirectionList;
    }

    public void addAnimalsOnMap(){
        for (Vector2d position : animalPositions){
            Animal animal = new Animal(map, position);

            if(map.place(animal)){
                animalList.add(animal);
                animal.addObserver(new IPositionChangeObserver() { //klasa anonimowa
                    @Override
                    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
                        System.out.println("Zwierzątko ruszyło się na pozycję " + newPosition);

                    }
                });
            }

        }
    }

    public void addObserverOnMap(App app){
        for (Vector2d position : animalPositions){
            Animal animal = new Animal(map, position);

            if(map.place(animal)){
                animal.addObserver(app);
            }
        }
    }


    @Override
    public void run() {

        try{
            Thread.sleep(moveDelay);
            for (int i = 0; i < moveDirectionList.length; i++){
                Animal animal = animalList.get(i % animalList.size());
                animal.move(moveDirectionList[i]);

                System.out.println(map);
                app.refreshMap(); //drukowanie ponowne mapy
                Thread.sleep(moveDelay);
            }
        }
        catch(InterruptedException e){
            e.getMessage();
        }



    }
}
