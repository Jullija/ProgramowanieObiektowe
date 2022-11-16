package agh.ics.oop;

import java.util.Arrays;
import java.util.Objects;

public class OptionsParser {

    public MoveDirection [] parse (String[] directions) {

        //mamy strumień informacji i zamieniamy to na tablicę
        return Arrays.stream(directions) //strumień, najpierw zmapowaliśmy każdą instrukcję
                .map(instruction -> switch (instruction) {
                    case "f", "forward" -> MoveDirection.FORWARD;
                    case "b", "backward" -> MoveDirection.BACKWARD;
                    case "l", "left" -> MoveDirection.LEFT;
                    case "r", "right" -> MoveDirection.RIGHT;
                    default -> null;
                })
                .filter(Objects::nonNull) //co ma z tego przejść a co nie -> nulle nam nie przechodzą move->move != null
                .toArray(MoveDirection[]::new); //:: coś w rodzaju wskaźnika na konstrultor tej tablicy

    }


//        MoveDirection[] ans = new MoveDirection[directions.length];    //tworzę tablicę, którą ma mi zwrócić metoda
//        int i = 0; //aby wiedzieć, jaka jest faktyczna długość tablicy, którą mam zwrócić -> tylko kierunki wpisuję, gdy dane są złe, jest pusta tablica
//
//        for (String direction : directions){
//
//                switch(direction){
//                    case "f", "forward" ->{ans[i] = MoveDirection.FORWARD; i++;}
//                    case "b", "backward" -> {ans[i] = MoveDirection.BACKWARD; i++;}
//                    case "l", "left" -> {ans[i] = MoveDirection.LEFT; i++;}
//                    case "r", "right" -> {ans[i] = MoveDirection.RIGHT; i++;}
//                    default ->{;}
//                }
//
//
//            }
//
//        ans = Arrays.copyOfRange(ans, 0, i); //ans to tylko tablica od 0 do momentu, gdzie są kierunki
//        return ans;
//    }

}
