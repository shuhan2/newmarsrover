package first;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static first.FirstDirection.EAST;
import static first.FirstDirection.NORTH;
import static first.FirstDirection.SOUTH;
import static first.FirstDirection.WEST;
import static first.FirstDirection.values;

public class FirstMarsRover {

  private int x;
  private int y;
  private FirstDirection direction;

  private final Function<FirstMarsRover, FirstMarsRover> SUB_Y_FUNCTION = marsRover -> {marsRover.y--; return marsRover;};
  private final Function<FirstMarsRover, FirstMarsRover> SUB_X_FUNCTION = marsRover -> {marsRover.x--; return marsRover;};
  private final Function<FirstMarsRover, FirstMarsRover> ADD_X_FUNCTION = marsRover -> {marsRover.x++; return marsRover;};
  private final Function<FirstMarsRover, FirstMarsRover> ADD_Y_FUNCTION = marsRover -> {marsRover.y++; return marsRover;};
  private Map<FirstDirection, Function<FirstMarsRover, FirstMarsRover>> functionMap = new HashMap<FirstDirection, Function<FirstMarsRover, FirstMarsRover>>() {{
    put(NORTH, ADD_Y_FUNCTION);
    put(EAST, ADD_X_FUNCTION);
    put(SOUTH, SUB_Y_FUNCTION);
    put(WEST, SUB_X_FUNCTION);

  }};

  public FirstMarsRover(int x, int y, FirstDirection direction) {

    this.x = x;
    this.y = y;
    this.direction = direction;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public FirstDirection getDirection() {
    return direction;
  }

  public FirstMarsRover turnLeft() {

    int originalIndex = Arrays.asList(values()).indexOf(direction);
    int indexOfLeft = originalIndex == 0 ? 3 : originalIndex - 1;
    this.direction = values()[indexOfLeft];
    return this;
  }

  public FirstMarsRover turnRight() {
    int originalIndex = Arrays.asList(values()).indexOf(direction);
    int indexOfRight = originalIndex == 3 ? 0 : originalIndex + 1;
    this.direction = values()[indexOfRight];
    return this;
  }

  public FirstMarsRover goForward() {
    return functionMap.get(direction).apply(this);
  }

}
