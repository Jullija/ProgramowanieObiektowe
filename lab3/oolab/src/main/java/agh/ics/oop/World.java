package agh.ics.oop;

public class World {
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

    public static void main (String[] args){ //wystarczy wpisać main
        System.out.println("System startuje"); //wystarczy wpisać sout
        MoveDirection[] enumArray = change(args);
        run(enumArray);
        System.out.println("System zakończył działanie");

        Animal zwierzatko = new Animal();
        System.out.println(zwierzatko.getAnimalVector());

        zwierzatko.move(MoveDirection.RIGHT);
        zwierzatko.move(MoveDirection.FORWARD);
        zwierzatko.move(MoveDirection.FORWARD);
        zwierzatko.move(MoveDirection.FORWARD);
        System.out.println(zwierzatko.getAnimalVector());
        System.out.println(zwierzatko.getAnimalDirection());



    }






}