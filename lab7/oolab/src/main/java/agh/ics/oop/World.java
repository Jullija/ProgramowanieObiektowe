package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {

    public static final Vector2d LOWER_BOUND = new Vector2d(0,0);
    public static final Vector2d UPPER_BOUND = new Vector2d(4,4);
    private static MoveDirection[] change(String[] directions){ //dostaję tablicę ze stringami i zamieniam na tablicę z enum
        MoveDirection tab[] = new MoveDirection[directions.length]; //tworzę tablicę o długości tablicy ze stringami, w której będę przechowywać wartość enum

        for(int i = 0; i < directions.length; i++){
            MoveDirection move = switch(directions[i]){
                case "f" -> MoveDirection.FORWARD;
                case "b" -> MoveDirection.BACKWARD;
                case "l" -> MoveDirection.LEFT;
                case "r" -> MoveDirection.RIGHT;
                default -> MoveDirection.OTHER;
            };

            tab[i] = move;

        }
        return tab;

    }


    private static void run(MoveDirection[] directions) {

        for(MoveDirection direction : directions){
            String text = switch(direction){
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie w tył";
                case LEFT -> "Zwierzak idzie w lewo";
                case RIGHT -> "Zwierzak idzie w prawo";
                default -> null;
            };
            System.out.println(text);
        }
    }

    public static void main (String[] args){


        GrassField GF = new GrassField(10);
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = GF;
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Application.launch(App.class, args);
    }






}