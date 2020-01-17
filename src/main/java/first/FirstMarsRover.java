package first;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static first.Command.*;
import static first.Command.L;
import static first.FirstDirection.EAST;
import static first.FirstDirection.NORTH;
import static first.FirstDirection.SOUTH;
import static first.FirstDirection.WEST;
import static first.FirstDirection.values;

public class FirstMarsRover {

  private FirstRoverState state;

  private final Function<FirstMarsRover, FirstMarsRover> SUB_Y_FUNCTION =
      marsRover -> {marsRover.state = new FirstRoverState(marsRover.state.getX(), marsRover.state.getY() - 1, marsRover.state.getDirection());return marsRover;};
  private final Function<FirstMarsRover, FirstMarsRover> SUB_X_FUNCTION =
      marsRover -> {marsRover.state = new FirstRoverState(marsRover.state.getX() - 1, marsRover.state.getY(), marsRover.state.getDirection());return marsRover;};
  private final Function<FirstMarsRover, FirstMarsRover> ADD_X_FUNCTION =
      marsRover -> {marsRover.state = new FirstRoverState(marsRover.state.getX() + 1, marsRover.state.getY(), marsRover.state.getDirection());return marsRover;};
  private final Function<FirstMarsRover, FirstMarsRover> ADD_Y_FUNCTION =
      marsRover -> {marsRover.state = new FirstRoverState(marsRover.state.getX(), marsRover.state.getY() + 1, marsRover.state.getDirection());return marsRover;};

  private Map<FirstDirection, Function<FirstMarsRover, FirstMarsRover>> functionMap = new HashMap<FirstDirection, Function<FirstMarsRover, FirstMarsRover>>() {{
    put(NORTH, ADD_Y_FUNCTION);
    put(EAST, ADD_X_FUNCTION);
    put(SOUTH, SUB_Y_FUNCTION);
    put(WEST, SUB_X_FUNCTION);

  }};

  public FirstMarsRover(int x, int y, FirstDirection direction) {

    this.state = new FirstRoverState(x, y, direction);
  }

  public FirstRoverState getState() {
    return state;
  }

  public FirstMarsRover command(Command command) {
    if (command == M) {
      return functionMap.get(state.getDirection()).apply(this);
    }
    if (command == L) {
      int originalIndex = Arrays.asList(values()).indexOf(this.state.getDirection());
      int indexOfLeft = originalIndex == 0 ? 3 : originalIndex - 1;
      this.state = new FirstRoverState(this.state.getX(), this.state.getY(), values()[indexOfLeft]);
      return this;
    }
    if (command == R) {
      int originalIndex = Arrays.asList(values()).indexOf(this.state.getDirection());
      int indexOfRight = originalIndex == 3 ? 0 : originalIndex + 1;
      this.state = new FirstRoverState(this.state.getX(), this.state.getY(), values()[indexOfRight]);
      return this;
    }
    return this;
  }

}
