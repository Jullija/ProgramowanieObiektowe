package agh.ics.oop;

public class OptionsParser {

    public MoveDirection [] parse (String[] directions){
        MoveDirection[] ans = new MoveDirection[0];    //tworzę tablicę, którą ma mi zwrócić metoda
        int i = 0;

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
        return ans;
    }

}
