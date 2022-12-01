package agh.ics.oop;

import java.util.Arrays;
import java.util.Objects;

public class OptionsParser {

    public MoveDirection [] parse (String[] directions) throws IllegalArgumentException {

        return Arrays.stream(directions)
                .map(instruction -> switch (instruction) {
                    case "f", "forward" -> MoveDirection.FORWARD;
                    case "b", "backward" -> MoveDirection.BACKWARD;
                    case "l", "left" -> MoveDirection.LEFT;
                    case "r", "right" -> MoveDirection.RIGHT;
                    default -> throw new IllegalArgumentException(instruction + "is not legal move specification");
                })
                .filter(Objects::nonNull)
                .toArray(MoveDirection[]::new);

    }


}
