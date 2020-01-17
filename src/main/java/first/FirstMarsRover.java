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

  private final Function<FirstRoverState, FirstRoverState> SUB_Y_FUNCTION =
      state -> new FirstRoverState(state.getX(), state.getY() - 1, state.getDirection());
  private final Function<FirstRoverState, FirstRoverState> SUB_X_FUNCTION =
      state -> new FirstRoverState(state.getX() - 1, state.getY(), state.getDirection());
  private final Function<FirstRoverState, FirstRoverState> ADD_X_FUNCTION =
      state -> new FirstRoverState(state.getX() + 1, state.getY(), state.getDirection());
  private final Function<FirstRoverState, FirstRoverState> ADD_Y_FUNCTION =
      state -> new FirstRoverState(state.getX(), state.getY() + 1, state.getDirection());

  private Map<FirstDirection, Function<FirstRoverState, FirstRoverState>> functionMap = new HashMap<FirstDirection, Function<FirstRoverState, FirstRoverState>>() {{
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

  public FirstMarsRover executeCommand(Command command) {
    if (command == M) {
      this.state = functionMap.get(state.getDirection()).apply(this.state);
    }
    if (command == L) {
      int originalIndex = Arrays.asList(values()).indexOf(this.state.getDirection());
      int indexOfLeft = (originalIndex + 3) % 4;
      this.state = new FirstRoverState(this.state.getX(), this.state.getY(), values()[indexOfLeft]);
    }
    if (command == R) {
      int originalIndex = Arrays.asList(values()).indexOf(this.state.getDirection());
      int indexOfRight = (originalIndex + 1) % 4;
      this.state = new FirstRoverState(this.state.getX(), this.state.getY(), values()[indexOfRight]);
    }
    return this;
  }

}
