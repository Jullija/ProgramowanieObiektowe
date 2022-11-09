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

    public static void main (String[] args){
        Animal zwierzatko = new Animal();

        OptionsParser tmp = new OptionsParser();
        MoveDirection[] animalDirections = tmp.parse(args); //zamienia mi podane dane na tablicę directions

        for (MoveDirection direction : animalDirections){
            zwierzatko.move(direction);
        }

        System.out.println(zwierzatko);



    }






}