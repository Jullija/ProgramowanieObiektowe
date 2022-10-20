package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {

    public MoveDirection [] parse (String[] directions){
        MoveDirection[] ans = new MoveDirection[directions.length];    //tworzę tablicę, którą ma mi zwrócić metoda
        int i = 0; //aby wiedzieć, jaka jest faktyczna długość tablicy, którą mam zwrócić -> tylko kierunki wpisuję, gdy dane są złe, jest pusta tablica

        for (String direction : directions){
            if (direction.equals("f") || direction.equals("forward") || direction.equals("b") || direction.equals("backward") ||
            direction.equals("l") || direction.equals("left") || direction.equals("r") || direction.equals("right")){

                switch(direction){
                    case "f":
                    case "forward":
                        ans[i] = MoveDirection.FORWARD;
                        break;


                    case "b":
                    case "backward":
                        ans[i] = MoveDirection.BACKWARD;
                        break;

                    case "l":
                    case "left":
                        ans[i] = MoveDirection.LEFT;
                        break;

                    case "r":
                    case "right":
                        ans[i] = MoveDirection.RIGHT;
                        break;

                }
                i++;

            }
        }
        ans = Arrays.copyOfRange(ans, 0, i); //ans to tylko tablica od 0 do momentu, gdzie są kierunki
        return ans;
    }

}
