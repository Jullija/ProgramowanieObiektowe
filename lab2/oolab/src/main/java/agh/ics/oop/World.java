package agh.ics.oop;

public class World {
    private static Direction[] change(String[] directions){ //dostaję tablicę ze stringami i zamieniam na tablicę z enum
        Direction tab[] = new Direction[directions.length]; //tworzę tablicę o długości tablicy ze stringami, w której będę przechowywać wartość enum

        for(int i = 0; i < directions.length; i++){
            Direction move = switch(directions[i]){
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "l" -> Direction.LEFT;
                case "r" -> Direction.RIGHT;
                default -> Direction.OTHER;
            };

            tab[i] = move;

        }
        return tab;

    }


    private static void run(Direction[] directions) {

        for(Direction direction : directions){
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

    public static void main (String[] args){ //wystarczy wpisać main
        System.out.println("System startuje"); //wystarczy wpisać sout
        Direction[] enumArray = change(args);
        run(enumArray);
        System.out.println("System zakończył działanie");

    }






}