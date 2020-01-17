package first;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static first.Command.*;
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

  private Map<FirstDirection, Function<FirstRoverState, FirstRoverState>> moveFunctionMap = new HashMap<FirstDirection, Function<FirstRoverState, FirstRoverState>>() {{
    put(NORTH, ADD_Y_FUNCTION);
    put(EAST, ADD_X_FUNCTION);
    put(SOUTH, SUB_Y_FUNCTION);
    put(WEST, SUB_X_FUNCTION);
  }};

  private final Function<FirstRoverState, FirstRoverState> MOVE_COMMAND =
      state -> moveFunctionMap.get(state.getDirection()).apply(state);

  private final Function<FirstRoverState, FirstRoverState> TURN_LEFT_COMMAND =
      state -> {
        int originalIndex = Arrays.asList(values()).indexOf(state.getDirection());
        return new FirstRoverState(this.state.getX(), state.getY(), values()[(originalIndex + 3) % 4]);
      };

  private final Function<FirstRoverState, FirstRoverState> TURN_RIGHT_COMMAND =
      state -> {
        int originalIndex = Arrays.asList(values()).indexOf(state.getDirection());
        return new FirstRoverState(state.getX(), state.getY(), values()[(originalIndex + 1) % 4]);
      };

  private Map<Command, Function<FirstRoverState, FirstRoverState>> commandFunctionMap = new HashMap<Command, Function<FirstRoverState, FirstRoverState>>() {{
    put(M, MOVE_COMMAND);
    put(L, TURN_LEFT_COMMAND);
    put(R, TURN_RIGHT_COMMAND);
    put(B, state -> state);

  }};

  public FirstMarsRover(int x, int y, FirstDirection direction) {

    this.state = new FirstRoverState(x, y, direction);
  }

  public FirstRoverState getState() {
    return state;
  }

  public void executeCommand(Command command) {
    if (command == B) {
      moveFunctionMap.put(NORTH, SUB_Y_FUNCTION);
      moveFunctionMap.put(SOUTH, ADD_Y_FUNCTION);
      commandFunctionMap.put(M, state -> moveFunctionMap.get(state.getDirection()).apply(state));
    }
    this.state = commandFunctionMap.get(command).apply(this.state);
  }

}
