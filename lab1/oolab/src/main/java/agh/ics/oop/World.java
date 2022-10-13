package agh.ics.oop;

public class World {
    //public static -> static oznacza, że coś jest niezależne od instancji obiektu - współdzieleni
    //funkcja main, która przyjmuje tablicę stringów, args w terminalu można wpisywać dane -> to argumenty, które przyjmuje metoda

//    private static void run(String[] directions) { //directions -> bo przyjmuje kierunki
//
////        for(int i = 0; i < directions.length; i++){ //wypisywanie argumentów (tablica od pierwszego do ostatniego)
////            if (i>0){
////                System.out.print(", ");
////            }
////            System.out.print(directions[i]); //println -> pod sobą, print -> po sobie
////        }
//
//        String joinedDirections = String.join(", ", directions); //czym ma nam rozdzielić, na czym pracujemy
//        System.out.println(joinedDirections);
//
//
//        for(String direction : directions){
////            switch(direction){
////                case "f" -> System.out.println("Zwierzak idzie do przodu");
////                case "b" -> System.out.println("Zwierzak idzie w tył");
////                case "l" -> System.out.println("Zwierzak idzie w lewo");
////                case "r" -> System.out.println("Zwierzak idzie w prawo");
////
////            }
//
//            //ten switch to wyrażenie -> warto tak robić!!!
//            String text = switch(direction){
//                case "f" -> "Zwierzak idzie do przodu";
//                case "b" -> "Zwierzak idzie w tył";
//                case "l" -> "Zwierzak idzie w lewo";
//                case "r" -> "Zwierzak idzie w prawo";
//                default -> null;
//            };
//            System.out.println(text);
//        }
//
//
//    }

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


            if (text != null){
                System.out.println(text);
            }


        }


    }

    public static void main (String[] args){ //wystarczy wpisać main
        System.out.println("System startuje"); //wystarczy wpisać sout
        Direction[] enumArray = change(args);
        run(enumArray);
        System.out.println("System zakończył działanie");
    }




}
